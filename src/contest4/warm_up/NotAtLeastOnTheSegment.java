package contest4.warm_up;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Задана последовательность целых чисел a1, a2, …, an.
Задаются запросы: сказать любой элемент последовательности на отрезке от L до R включительно,
не равный минимуму на этом отрезке.
 */
public class NotAtLeastOnTheSegment {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = input.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int l = input.nextInt();
            int r = input.nextInt();
            int min = Integer.MAX_VALUE;
            boolean find = false;
            String notFound = "NOT FOUND";

            for (int j = l; j <= r; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                }
            }
            for (int j = r; j >= l; j--) {
                if (arr[j] != min) {
                    System.out.println(arr[j]);
                    find = true;
                    break;
                }
            }
            if (!find) {
                System.out.println(notFound);
            }
        }
        input.close();
    }
}
