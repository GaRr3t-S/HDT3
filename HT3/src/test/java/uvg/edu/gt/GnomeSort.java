import java.io.*;
import java.util.*;

public class GnomeSort {
    void gnomeSort(int arr[], int n) {
        int index = 0;
        while (index < n) {
            if (index == 0)
                index++;
            if (arr[index] >= arr[index - 1])
                index++;
            else {
                int temp = 0;
                temp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = temp;
                index--;
            }
        }
        return;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] arr = new int[3000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);
        }
        try {
            PrintWriter out = new PrintWriter(new FileWriter("numeros.txt"));
            for (int i : arr) {
                out.println(i);
            }
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        GnomeSort obj = new GnomeSort();
        int n = arr.length;
        long startTime = System.currentTimeMillis();
        obj.gnomeSort(arr, n);
        long endTime = System.currentTimeMillis();
        System.out.println("Sorted secuencia ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.println("\nTiempo de sorting " + (endTime - startTime) + "ms");
    }
}
