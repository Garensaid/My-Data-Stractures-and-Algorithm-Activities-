import java.util.Arrays;
import java.util.Scanner;

public class Quicksort {
	public static void main(String [] args){

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter size of the number: ");
		int number = sc.nextInt();

		int[] array = new int[number];

		        System.out.println("Numbers to be be sorted: ");

		       for (int i = 0; i < number; i++) {
		            array[i] = sc.nextInt();
        }

quickSort(array, 0, array.length - 1);


        System.out.print("Sorted arrays in Ascending Order: ");
        for (int i = 0; i < array.length; i++) {
		            System.out.print(array[i] + " ");
        }

}

//Method sa quickSort
public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);

            quickSort(array, low, pi - 1);
            	quickSort(array, pi + 1, high);
        }
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        	int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;

                int temp = array[i];
                	array[i] = array[j];
                		array[j] = temp;
            }
        }

        int temp = array[i + 1];
        	array[i + 1] = array[high];
        		array[high] = temp;

        return i + 1;
    }
}