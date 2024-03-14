package belgrad;

import java.util.Arrays;
import java.util.Scanner;

public class Tree {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        char[] charArr = scan.next().toCharArray();
        int[][] inArr = new int[n][2];
        for (int i = 0; i < n - 1; i++) {
            inArr[i][0] = scan.nextInt();
            inArr[i][1] = scan.nextInt();
        }
        scan.close();
        int[][] tree = new int[n][2];
        tree[n - 1][0] = 0;
        tree[n - 1][1] = 0;
        for (int i = 0; i < n - 1; i++) {
            if (inArr[i][0] == i) {
                for (int j = 0; j < 2; j++) {
                    if (tree[i][j] == 0) {
                        tree[i][j] = inArr[i][1];
                    }
                }
            }

        }
        System.out.println(Arrays.deepToString(tree));
    }
}
