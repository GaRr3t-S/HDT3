package uvg.edu.gt;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        Random rand = new Random();
        int[] arr = new int[3000];
        PrintWriter writer = new PrintWriter("numbers.txt", "UTF-8");

        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(10000);
            writer.println(arr[i]);
        }
        writer.close();

        Scanner scanner = new Scanner(new File("numbers.txt"));
        int[] numbers = new int[3000];
        int index = 0;
        while (scanner.hasNextInt()) {
            numbers[index++] = scanner.nextInt();
        }
        scanner.close();

        // Gnome Sort
        GnomeSort.sort(numbers);

        // Merge Sort
        MergeSort.sort(numbers, 0, numbers.length - 1);

        // Quick Sort
        QuickSort.sort(numbers, 0, numbers.length - 1);

        // Radix Sort
        RadixSort.sort(numbers);

        // Bubble Sort
        BubbleSort.sort(numbers);
    }
}

