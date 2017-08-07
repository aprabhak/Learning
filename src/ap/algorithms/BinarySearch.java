package ap.algorithms;

import java.util.Arrays;

public class BinarySearch {

    int[] arr = {3,4,1,5,2};

    public boolean iterativeWay(int find) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length - 1;
        int middle;
        while (low <= high) {
            middle = (low+high)/2;
            if (find < arr[middle]) {
                high = middle - 1;
            } else if (find > arr[middle]) {
                low = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public boolean recursiveWay(int[] array,int x, int left, int right) {
        if (left > right) {
            return false;
        }
        int mid = (left+right)/2;
        if (array[mid] == x) {
            return true;
        } else if(x < array[mid]) {
            return recursiveWay(array,x,left,mid-1);
        } else {
            return recursiveWay(array,x,mid+1,right);
        }
    }

    public boolean recursiveWay(int[] array,int x) {
        return recursiveWay(array,x,0,array.length-1);
    }

}
