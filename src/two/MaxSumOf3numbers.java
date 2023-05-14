package two;

import java.util.Scanner;

public class MaxSumOf3numbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String scanStr = scan.nextLine();
        String[] numbersArr = scanStr.split(" ");
        int[] arr = new int[numbersArr.length];
        for (int i = 0; i < numbersArr.length; i++) {
            arr[i] = Integer.parseInt(numbersArr[i]);
        }

        scan.close();
        kth_rearrange(arr, 0, arr.length, arr.length - 1);
        kth_rearrange(arr, 0, arr.length - 1, arr.length - 2);
        kth_rearrange(arr, 0, arr.length - 3, 2);
        if (arr[arr.length - 1] * arr[arr.length - 2] * arr[arr.length - 3] >= arr[0] * arr[1] * arr[arr.length - 1]) {
            System.out.println(arr[arr.length - 1]  + " " + arr[arr.length - 2] + " " + arr[arr.length - 3]);
        } else {
            System.out.println(arr[arr.length - 1]  + " " + arr[0]  + " " + arr[1]);
        }
    }

    private static int[] kth_rearrange(int[] arr, int left, int right, int k) {
        left = left;
        right = right;
        while (left < right) {
            int x = arr[(left + right) / 2];
            int eqxFirst = left;
            int gtxFirst = left;
            for (int i = left; i < right; i++) {
                int now = arr[i];
                if (now == x) {
                    arr[i] = arr[gtxFirst];
                    arr[gtxFirst] = now;
                    gtxFirst++;
                } else if (now < x) {
                    arr[i] = arr[gtxFirst];
                    arr[gtxFirst] = arr[eqxFirst];
                    arr[eqxFirst] = now;
                    gtxFirst++;
                    eqxFirst++;
                }
            }
            if (k < eqxFirst) {
                right = eqxFirst - 1;
            } else if (k >= gtxFirst) {
                left = gtxFirst;
            } else {
                return arr;
            }
        }
        return arr;
    }
}
