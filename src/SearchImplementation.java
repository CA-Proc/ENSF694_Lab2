import java.util.Arrays;

public class SearchImplementation {

	public static void main(String[] args) {
		
		InteractiveCLI cli = new InteractiveCLI();
		
		cli.prompt("Enter the number of elements in the array: ");
		int inputSize = cli.getKeyboardInteger();
		cli.prompt("Enter the elements in the array:");
		int[] values = new int[inputSize];
		for(int i=0; i< inputSize; i++) {
			values[i] = cli.getKeyboardInteger();
		}
		cli.prompt("Enter the search key: ");
		int key = cli.getKeyboardInteger();
		
		long startTime;
		int index;
		long endTime;
		
	


		// Throwaway Linear Search
		int[] v = Arrays.copyOf(values, values.length);
		index = optimizedLinearSearch(v,key);
		
		// Optimized Linear Search
		int[] x = Arrays.copyOf(values, values.length);
		startTime = System.nanoTime();
		index = optimizedLinearSearch(x, key);
		endTime = System.nanoTime();
		
		System.out.println("\nOptimized Linear Search - elapsed time: " + (endTime-startTime) + " ns");
		if (index >= 0) {
			System.out.println("Search key FOUND at index " + index);
		}else {
			System.out.println("Search key NOT FOUND.");
		}
		
		// Linear Search
		startTime = System.nanoTime();
		index = linearSearch(values, key);
		endTime = System.nanoTime();
		
		System.out.println("\nLinear Search - elapsed time: " + (endTime-startTime) + " ns");
		if (index >= 0) {
			System.out.println("Search key FOUND at index " + index);
		}else {
			System.out.println("Search key NOT FOUND.");
		}
		
		// Interpolation Search
		bubbleSort(values);
		
		startTime = System.nanoTime();
		index = interpolationSearch(values, key);
		endTime = System.nanoTime();
		
		System.out.println("\nInterpolation Search - elapsed time: " + (endTime-startTime) + " ns");
		if (index >= 0) {
			System.out.println("Search key FOUND at index " + index);
		}else {
			System.out.println("Search key NOT FOUND.");
		}
		
	}
	
	public static int linearSearch(int[] values, int key) {
		for(int i=0; i<values.length; i++) {
			if (values[i] == key) {
				return i;
			}
		}
		// Not found
		return -1;
	}
	
	public static int optimizedLinearSearch(int[] v, int key) {
		
		// Check if key is last element, if not, replace element with the key.
		if (v[v.length - 1]==key) {
			return (v.length - 1);
		}else {
			v[v.length-1] = key;
		}
		
		// Search through the array - will no longer do a comparison 
		int i=0;
		while (v[i] != key) {
			i++;
		}
		
		if (i==v.length-1) {
			return -1;
		}else {
			return i;
		}
	}
	
	public static int interpolationSearch(int[] values, int key) {
		int low = 0;
		int mid;
		int high = values.length-1;
		double pos;
		
		// Outside of bounds
		if((key > values[high])||(key < values[low])) {
			return -1;
		}
		
		while (low <= high) {
			pos = (double)(key - values[low])/(double)(values[high] - values[low]);
			mid = low + (int)Math.ceil(((high-low)*pos));
			
			if (key < values[mid]) {
				high = mid-1;
			} else if (key > values[mid]) {
				low = mid+1;
			} else {
				return values[mid];
			}
		}
		
		return -1;
	}
	
	public static void bubbleSort(int[] values) {
		for(int i=0; i<values.length; i++) {
			for(int j = 0; j<values.length-1; j++) {
				if (values[j]>values[j+1]) {
					int temp = values[j];
					values[j] = values[j+1];
					values[j+1] = temp;
				}
			}
		}
	}
}
