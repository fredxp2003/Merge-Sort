import java.util.Arrays;
import java.util.Random;

public class Sort {

    public static int[] createRandomArray(int arrayLength) {
        int[] array = new int[arrayLength];
        Random random = new Random();
        for (int i = 0; i < arrayLength; i++) {
            array[i] = random.nextInt(10, 100);
        }
        return array;
    }

    public static int[] bubbleSort(int[] array) {
        int temp;
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        int arrayLength1 = array.length / 2;
        int[] array1 = Arrays.copyOfRange(array, 0, arrayLength1);
        int[] array2 = Arrays.copyOfRange(array, arrayLength1, array.length);
        array1 = mergeSort(array1);
        array2 = mergeSort(array2);
        int[] mergedArray = merge(array1, array2);

        return mergedArray;

    }

    public static int[] merge(int[] array1, int[] array2) {
        int[] mergedArray = new int[array1.length + array2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                mergedArray[k] = array1[i];
                i++;
            } else {
                mergedArray[k] = array2[j];
                j++;
            }
            k++;
        }
        while (i < array1.length) {
            mergedArray[k] = array1[i];
            i++;
            k++;
        }
        while (j < array2.length) {
            mergedArray[k] = array2[j];
            j++;
            k++;
        }
        return mergedArray;
    }

    public static int[] shuffle(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndex = random.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
        return array;
    }

    public static int[] bogoSort(int[] array) {
        boolean run = true;
        while (run == true) {
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    array = shuffle(array);
                    bogoSort(array);
                } else {
                    run = false;
                }
            }
        }
        return array;
    }}
