package com.smalwe;

public class CommonAlgos {
    public static void main(String[] args) {
        int[] bsInput = {2,4,10, 50, 70, 80, 100};
        System.out.println(binarySearchInSortedArray(bsInput, 80));
    }

    /**
     * Method to find the index of the search element in the sorted array. If element not found the method returns 0
     * @param input
     * @param w
     * @return
     */
    public static int binarySearchInSortedArray(int[] input, int w) {
        int start = 0;
        int end = input.length - 1;
        int mid = 0;
        while(start <= end) {
            mid = (start + end ) / 2;
            System.out.println("Start:" + start + " End:" + end + " Mid:" + mid);

            if(w < input[mid]) {
                end = mid-1;
            } else if (w > input[mid]) {
                start = mid+1;
            } else {
                return mid;
            }
        }
        System.out.println("Element not found");
        return 0;
    }
}
