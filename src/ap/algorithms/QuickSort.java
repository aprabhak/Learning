package ap.algorithms;

public class QuickSort {

    public void quicksort(int[] array) {
        quicksort(array,0,array.length - 1);
    }

    public void quicksort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = array[(left + right) / 2];
        int index = partition(array,left,right,pivot);
        quicksort(array,left,index-1);
        quicksort(array,index,right);
    }

    public int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while (array[left] <= pivot) {
                left = left + 1;
            }
            while (array[right] > pivot) {
                right = right - 1;
            }
            if (left <= right) {
                swap(array,left,right);
                left = left + 1;
                right = right - 1;
            }
        }
        return left;
    }

    public void swap(int[] array,int left,int right) {
        int temp = 0;
        temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
