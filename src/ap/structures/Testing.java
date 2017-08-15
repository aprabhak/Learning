package ap.structures;

import ap.algorithms.BinarySearch;
import ap.algorithms.MergeSort;
import ap.algorithms.QuickSort;
import ap.algorithms.QuickSortV2;

import java.util.Arrays;

public class Testing {
    public static void main(String[] args) {
        int[] arr = {38,27,43,3,9,82,10};
        //QuickSort qs = new QuickSort();
        //qs.quicksort(arr);
        MergeSort ms = new MergeSort();
        ms.sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
