package by.htp.less15.sort;

public class Sort {
	
	public static void main(String[] args) {
		int[] a;
		int[] b;
		
		a = new int[] {2, 4, 6, 12, 1, 3, 7};
		b = new int[] {4, 3, 1, 7, 8, 2, 5};
		print(bubbleSort(a));
		print(insertionSort(b));
		
	}

	public static int[] bubbleSort(int[] x) {
		int t = 0;
		
		for (int i = 0; i < x.length; i++) {
			for (int j = x.length - 1; j >= i + 1; j--) {
				if (x[j] < x[j -1]) {
					t = x[j];
					x[j] = x[j - 1];
					x[j - 1] = t;
				}
			}
		}
		
		return x;
	}
	
	public static int[] insertionSort(int[] x) {
		int key = 0;
		int i = 0;
		
		for (int j = 1; j < x.length; j++) {
			key = x[j];
			i = j - 1;
			while ((i >= 0) && x[i] > key) {
				x[i + 1] = x[i];
				i = i - 1;
				x[i + 1] = key;
			}
		}
		
		return x;
	}
	
	public static void print(int[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.println("");
	}
}



