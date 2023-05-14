package six;

import java.util.Scanner;

public class Diploms {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println(leftBinarySearch(scan.nextInt(), scan.nextInt(), scan.nextInt()));

        scan.close();
    }

    public static int leftBinarySearch(int w, int h, int n) {
        int l = 0;
        int r = 20;
        while (l < r) {
            int m = (l + r) / 2;
            if (n < m) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}
