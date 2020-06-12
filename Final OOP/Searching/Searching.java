import java.lang.annotation.Target;
import java.util.Arrays;

public class Searching {
    public static void main(String[] args) {
        int arr[] = {18,34,89,2,0,-10,15,23};
        LinearSearch(arr,23);

    }
    public static int LinearSearch(int[] arr,int target) {
        for(int i = 0 ; i < arr.length ; i++)
            if(arr[i] == target) return i;

        //if not found
        return -1;
    }
    public static int BinarySearch(int[] arr,int target) {
        Arrays.sort(arr);
        int high = arr.length-1;
        int low = 0;
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid] == target) return mid;
            if(arr[mid] > target) high = mid -1;
            else low = mid + 1;
        }
        //if not found
        return -1;
    }
    public static int BinarySearch(int[] array, int low, int high, int target) {
        // base case if not found.
        if (high < low) return -1;
        // find mid index of array.
        int mid = (low + high) / 2;
        // if found return index at mid position.
        if (array[mid] == target)
            return mid;
        // if element at index mid > target. Ignore left side of array.
        if (array[mid] > target) return BinarySearch(array, low, mid - 1, target);
        // else ignore right side.
        else return BinarySearch(array, mid + 1, high, target);
    }
}