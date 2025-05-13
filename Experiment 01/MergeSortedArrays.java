class MergeSortedArrays {
	public static void main(String args[]){
		int a[] = {1, 3, 5, 7};
		int b[] = {2, 4, 6, 8};
		int m = a.length, n = b.length;
		int c[] = new int[m+n];
		int i = 0, j = 0, k = 0;

		while (i < m && j < n){
			if (a[i] <= b[j]) {
				c[k] = a[i];
				i++;
				k++;
			} else {
				c[k] = b[j];
				k++;
				j++;
			}
		}
		
		while (i < m) {
            		c[k] = a[i];
			k++;
			i++;
        	}
        
        	while (j < n) {
            		c[k] = b[j];
			k++;
			j++;
        	}
        
        	System.out.println("Merged Sorted Array:");
        	for (int p = 0; p < c.length; p++) {
            		System.out.print(c[p] + " ");
        	}
    	}
}	
