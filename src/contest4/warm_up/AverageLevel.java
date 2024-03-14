package contest4.warm_up;

import java.util.Scanner;

public class AverageLevel {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int x = 0;
            for (int j = 0; j < n; j++) {
                x += Math.abs(arr[j] - arr[i]);
            }
            result.append(x + " ");
        }

        System.out.println(result);
    }
}
