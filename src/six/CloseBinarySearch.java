package six;

import java.util.Scanner;

public class CloseBinarySearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arrN = new int[n];
        for (int i = 0; i < n; i++) {
            arrN[i] = scan.nextInt();
        }
        for (int i = 0; i < k; i++) {
            System.out.println(leftBinarySearch(0, arrN.length - 1, arrN, scan.nextInt()));
        }
        scan.close();
    }

    public static int leftBinarySearch(int l, int r, int[] arr, int x) {
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] > x) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if (l > 0 && Math.abs(x - arr[l-1]) <= Math.abs(x - arr[l])){
            return arr[l-1];
        }
        return arr[l];
    }
}