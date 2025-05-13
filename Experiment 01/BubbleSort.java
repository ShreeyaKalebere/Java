import java.util.Scanner;

class BubbleSort {
    public static void main (String args[]){
	Scanner sc = new Scanner(System.in);
	int a[] = new int[10];
		
	System.out.println("Enter 10 Numbers: ");
	for (int i = 0; i< 10; i++){
		a[i] = sc.nextInt();
	}
		
	    for(int i=0; i<9; i++){
			for(int j=0; j<(9-i); j++){
		    	if(a[j] > a[j+1]){
				int temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
		    	}
			}
	    }

	System.out.println("Sorted Array: ");
	for(int i=0; i<10; i++){
	    System.out.print(a[i] + "  ");
	}
    }
} 