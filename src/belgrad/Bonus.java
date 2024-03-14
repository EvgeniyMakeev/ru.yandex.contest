package belgrad;

import java.util.Scanner;

public class Bonus {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int bonus = 500;
        int[] arr = new int[n + 2];
        arr[0] = Integer.MAX_VALUE;
        arr[n + 1] = Integer.MAX_VALUE;
        for (int i = 1, size = arr.length; i < size - 1; i++) {
            arr[i] = scan.nextInt();
        }
        scan.close();
        int result = bonus * n;
        if (n == 3) {
            System.out.println(result);
        } else {
            int start = 1;
            int end = arr.length - 1;
            while (start < end) {
                for (int i = start; i < end; i++) {
                    if (arr[i] > arr[i + 1] || arr[i] > arr[i - 1]) {
                        result += bonus;
                        System.out.println("Значение - " + arr[i] + " i - " + i + " start - " + " " + result);
                        break;
                    }
                }
                start++;
            }
            System.out.println(result);
        }
    }
}
