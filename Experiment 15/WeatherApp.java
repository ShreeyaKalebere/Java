import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import org.json.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

public class WeatherApp extends JFrame {

    private JTextField cityField;
    private JPanel mainPanel;
    private String apiKey = "7656a7806816ef7b5ac4c0acf2fd60d6"; // Replace with your own API key

    public WeatherApp() {
        setTitle("Weather App");
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(400, 250)); // Adjust size as needed
        mainPanel.setMaximumSize(new Dimension(400, 250));

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(0, 0, 0, 180));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JLabel title = new JLabel("Weather App");
        title.setFont(new Font("Arial", Font.BOLD, 30));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        cityField = new JTextField();
        cityField.setPreferredSize(new Dimension(400, 40));
        cityField.setMaximumSize(new Dimension(400, 40));
        cityField.setFont(new Font("Arial", Font.PLAIN, 18));
        cityField.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton getWeatherBtn = new JButton("Get Weather");
        getWeatherBtn.setFont(new Font("Arial", Font.BOLD, 18));
        getWeatherBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
        getWeatherBtn.addActionListener(e -> fetchWeather());

        mainPanel.add(title);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(cityField);
        mainPanel.add(Box.createVerticalStrut(20));
        mainPanel.add(getWeatherBtn);

        setContentPane(new JLabel(new ImageIcon("background.jpeg")));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(mainPanel, gbc);


        setVisible(true);
    }

    private void fetchWeather() {
        String city = cityField.getText().trim();
        if (city.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter a city name.");
            return;
        }

        try {
            String urlStr = String.format(
                "https://api.openweathermap.org/data/2.5/weather?q=%s&units=metric&appid=%s",
                URLEncoder.encode(city, "UTF-8"), apiKey);
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder jsonStr = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) jsonStr.append(line);
            br.close();

            JSONObject json = new JSONObject(jsonStr.toString());
            showWeatherData(json, city);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Could not retrieve weather data. " + ex.getMessage());
        }
    }

    private void showWeatherData(JSONObject json, String city) {
        String cityName = json.getString("name");
        String country = json.getJSONObject("sys").getString("country");
        String description = json.getJSONArray("weather").getJSONObject(0).getString("description");
        double temp = json.getJSONObject("main").getDouble("temp");
        int humidity = json.getJSONObject("main").getInt("humidity");
        double windSpeed = json.getJSONObject("wind").getDouble("speed");

        JFrame resultFrame = new JFrame();
        resultFrame.setSize(900, 700);
        resultFrame.setLocationRelativeTo(null);
        resultFrame.setLayout(new BorderLayout());

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setBackground(new Color(0, 0, 0, 180));
        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel location = new JLabel("Weather in " + cityName + ", " + country);
        location.setFont(new Font("Arial", Font.BOLD, 26));
        location.setForeground(Color.WHITE);
        location.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel descLabel = new JLabel("Description: " + description);
        JLabel tempLabel = new JLabel("Temperature: " + temp + "°C");
        JLabel humidityLabel = new JLabel("Humidity: " + humidity + "%");
        JLabel windLabel = new JLabel("Wind Speed: " + windSpeed + " m/s");

        for (JLabel lbl : new JLabel[]{descLabel, tempLabel, humidityLabel, windLabel}) {
            lbl.setFont(new Font("Arial", Font.PLAIN, 18));
            lbl.setForeground(Color.WHITE);
            lbl.setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        infoPanel.add(location);
        infoPanel.add(Box.createVerticalStrut(10));
        infoPanel.add(descLabel);
        infoPanel.add(tempLabel);
        infoPanel.add(humidityLabel);
        infoPanel.add(windLabel);
        infoPanel.add(Box.createVerticalStrut(20));

        // Chart
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        try {
            String forecastUrl = String.format(
                "https://api.openweathermap.org/data/2.5/forecast?q=%s&units=metric&appid=%s",
                URLEncoder.encode(city, "UTF-8"), apiKey);
            URL url = new URL(forecastUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) response.append(line);
            br.close();

            JSONObject forecastJson = new JSONObject(response.toString());
            JSONArray list = forecastJson.getJSONArray("list");

            for (int i = 0; i < 5; i++) {
                JSONObject entry = list.getJSONObject(i);
                JSONObject main = entry.getJSONObject("main");
                double forecastTemp = main.getDouble("temp");
                String time = entry.getString("dt_txt").split(" ")[1].substring(0, 5);
                dataset.addValue(forecastTemp, "Temperature", time);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        JFreeChart chart = ChartFactory.createBarChart(
            "Hourly Forecast", "Time", "Temp (°C)", dataset,
            PlotOrientation.VERTICAL, false, true, false);

        ChartPanel chartPanel = new ChartPanel(chart);
        resultFrame.add(infoPanel, BorderLayout.NORTH);
        resultFrame.add(chartPanel, BorderLayout.CENTER);

        resultFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WeatherApp::new);
    }
}