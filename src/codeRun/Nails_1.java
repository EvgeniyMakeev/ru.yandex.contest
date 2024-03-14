package codeRun;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Гвоздики.
 * В дощечке в один ряд вбиты гвоздики.
 * Любые два гвоздика можно соединить ниточкой.
 * Требуется соединить некоторые пары гвоздиков ниточками так,
 * чтобы к каждому гвоздику была привязана хотя бы одна ниточка,
 * а суммарная длина всех ниточек была минимальна.
 */

public class Nails_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] nails = new int[n];
        for (int i = 0; i < n; i++) {
            nails[i] = scan.nextInt();
        }
        scan.close();
        System.out.println(minimumThreadLength(n, nails));
    }

    private static int minimumThreadLength(int n, int[] nails) {
        if (n == 2) {
            return Math.abs(nails[0] - nails[1]);
        }
        Arrays.sort(nails);
        if (n == 3) {
            return Math.abs(nails[0] - nails[n - 1]);
        } else if (n == 4) {
            return Math.abs(nails[0] - nails[1]) + Math.abs(nails[2] - nails[3]);
        } else {
            int[] lengthsThreads = new int[n];
            lengthsThreads[1] = nails[1] - nails[0];
            lengthsThreads[2] = nails[2] - nails[0];
            for (int i = 3; i < n; i++) {
                lengthsThreads[i] = Math.min(lengthsThreads[i - 2], lengthsThreads[i - 1])  + (nails[i] - nails[i - 1]);
            }
            return lengthsThreads[n - 1];
        }
    }
}
