package uvg.edu.gt;

import java.io.*;
import java.util.*;

class MergeSort {
    public static void sort(int[] arr, int left, int right) {
        if (right <= left) return;
        int mid = (left+right)/2;
        sort(arr, left, mid);
        sort(arr, mid+1, right);
        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] leftArray = Arrays.copyOfRange(arr, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(arr, mid + 1, right + 1);
        int leftIndex = 0, rightIndex = 0;
        for (int i = left; i < right + 1; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    arr[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    arr[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length) {
                arr[i] = leftArray[leftIndex];
                leftIndex++;
            } else if (rightIndex < rightArray.length) {
                arr[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }
}