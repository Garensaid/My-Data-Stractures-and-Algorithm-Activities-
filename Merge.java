
import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
	public static void main(String [] args){
	Scanner sc = new Scanner(System.in);

		System.out.print("Enter size of the number: ");
		int number = sc.nextInt();

	int[] array = new int[number];

 System.out.println("Numbers to be be sorted: ");

for (int i = 0; i < number; i++) {
array[i] = sc.nextInt();
        }


mergeSort(array, 0, array.length - 1);


    System.out.print("Sorted arrays in Ascending Order: ");
    for (int i = 0; i < array.length; i++) {
	System.out.print(array[i] + " ");
        }

}

//Method sa insertionSort
public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
			
            int mid = left + (right - left) / 2;

            mergeSort(array, left, mid);
            	mergeSort(array, mid + 1, right);

            		merge(array, left, mid, right);
        }
    }

    public static void merge(int[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];


        System.arraycopy(array, left, L, 0, n1);
        	System.arraycopy(array, mid + 1, R, 0, n2);

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }


    }

}
