package contest4.lesson_1_sorting;
/**
 * Базовый алгоритм для сортировки слиянием —
 * алгоритм слияния двух упорядоченных массивов в один упорядоченный массив.
 * Эта операция выполняется за линейное время с линейным потреблением памяти.
 * Реализуйте слияние двух массивов в качестве первого шага для написания сортировки слиянием.
 */

import java.util.Scanner;

public class Merge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int l = input.nextInt();
        int[] arrL = new int[l];
        for (int i = 0; i < l; i++) {
            arrL[i] = input.nextInt();
        }
        int r = input.nextInt();
        int[] arrR = new int[r];
        for (int i = 0; i < r; i++) {
            arrR[i] = input.nextInt();
        }
        input.close();
        printArr(merge(arrL, arrR));
    }

    private static void printArr(int[] merge) {
        for (int i : merge) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static int[] merge(int[] arrL, int[] arrR) {
        int lengthL = arrL.length;
        int lengthR = arrR.length;
        int lengthResult = lengthL + lengthR;
        int[] result = new int[lengthResult];
        int l = 0;
        int r = 0;
        for (int i = 0; i < lengthResult; i++) {
            if (l < lengthL && r < lengthR) {
                if (arrL[l] <= arrR[r]) {
                    result[i] = arrL[l];
                    l++;
                } else {
                    result[i] = arrR[r];
                    r++;
                }
            } else if (l < lengthL) {
                result[i] = arrL[l];
                l++;
            } else {
                result[i] = arrR[r];
                r++;
            }
        }
        return result;
    }
}
