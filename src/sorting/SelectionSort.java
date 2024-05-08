package sorting;

public class SelectionSort {

    public static void selectionSort(int[] arr) {

        for( int i = 0; i <arr.length; i++) {
            int mininumIndex =  i;
            for( int j = i+1 ; j < arr.length; j++) {
                if(arr[j] < arr[mininumIndex] ) {
                    mininumIndex = j;
                }
            }
            if( mininumIndex != i) {
                int temp = arr[i];
                arr[i] = arr[mininumIndex];
                arr[mininumIndex] = temp;
            }
        }
    }

    static void printArray(int[] arr, int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 64, 34, 25, 12, 22, 11, 90 };
        int n = arr.length;
        selectionSort(arr);
        System.out.println("Sorted array: ");
        printArray(arr, n);
    }
}
