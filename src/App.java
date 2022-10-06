// Logan Pizzurro
// 10-5-2022
// Prof. Ma & TA. Sa

public class App {

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        long startTime; // time of the algorithm
        int arrayLength = 5; 
        int[] array = Sort.createRandomArray(arrayLength);
        startTime = System.currentTimeMillis();
        printArray(array);
        System.out.println();

        // Run bubble sort
        int[] sortedArray = Sort.bubbleSort(array);
        printArray(sortedArray);
        System.out.printf("Bubble sort took %d ms%n", System.currentTimeMillis() - startTime);
        System.out.printf(isSorted(sortedArray) ? "Array 1 is Sorted\n" : "Array 1 is Not sorted\n");

        // Run merge sort
        startTime = System.currentTimeMillis();
        int[] sortedArray2 = Sort.mergeSort(array);
        printArray(sortedArray2);
        System.out.printf("Merge sort took %d ms%n", System.currentTimeMillis() - startTime);
        System.out.printf(isSorted(sortedArray2) ? "Array 2 is Sorted\n" : "Array 2 is Not sorted\n");
    }

    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
