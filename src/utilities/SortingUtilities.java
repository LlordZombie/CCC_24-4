package utilities;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;


public class SortingUtilities {

    public void bubbleSort(int[] a) {
        int l = a.length, temp;
        boolean swapped;
        for (int i = 0; i < l - 1; i++) {
            swapped = false;
            for (int j = 0; j < l - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

    public void insertionSort(int[] a) {
        int n = a.length, key, c;
        for (int i = 1; i < n; i++) {
            key = a[i];
            c = i - 1;
            while (c >= 0 && a[c] > key) {
                a[c + 1] = a[c];
                c--;
            }
            a[c + 1] = key;
        }
    }

    public void selectionSort(int[] a) {
        int n = a.length, minIndex, temp;
        for (int i = 0; i < n - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[minIndex]) minIndex = j;
            }
            temp = a[minIndex];
            a[minIndex] = a[i];
            a[i] = temp;
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

}
