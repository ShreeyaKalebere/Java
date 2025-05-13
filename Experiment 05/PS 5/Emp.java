package employee;

public class Emp {
    String name, category;
    int empid;
    double bpay, hra, da, pf, allowance, grosspay, incometax, npay;

    public void setData(String n, int id, String cat, double bp) {
        name = n;
        empid = id;
        category = cat;
        bpay = bp;
    }

    public void calculate() {
        da = 0.05 * bpay;
        hra = 0.09 * bpay;
        pf = 0.11 * bpay;
        allowance = 0.10 * bpay;
        grosspay = bpay + da + hra + allowance;
        incometax = 0.10 * grosspay;
        npay = grosspay - (pf + incometax);
    }

    public void display() {
        System.out.println("\n--- Payroll Details ---");
        System.out.println("Employee ID: " + empid);
        System.out.println("Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Basic Pay: Rs." + bpay);
        System.out.println("DA (5%): Rs." + da);
        System.out.println("HRA (9%): Rs." + hra);
        System.out.println("PF (11%): Rs." + pf);
        System.out.println("Allowance (10%): Rs." + allowance);
        System.out.println("Gross Pay: Rs." + grosspay);
        System.out.println("Income Tax (10%): Rs." + incometax);
        System.out.println("Net Pay: Rs." + npay);
    }
}
