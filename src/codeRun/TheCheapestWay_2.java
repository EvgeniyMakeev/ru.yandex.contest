//package codeRun;
//
//import java.util.Scanner;
//
//public class TheCheapestWay_2 {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        int m = scan.nextInt();
//        int[][] field = new int[n][m];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//                field[i][j] = scan.nextInt();
//            }
//        }
//        scan.close();
//        System.out.println(findCheapestWay(n, m, field));
//    }
//
//    private static int findCheapestWay(int n, int m, int[][] field) {
//        if (n == 1 && m == 1) {
//            return field[0][0];
//        } else {
//            int total = field[0][0];
//            int horizon = 0;
//            int vertical = 0;
//            while (horizon != n - 1 && vertical != m - 1) {
//                int currMin = field[0][0];
//                if (field[horizon][vertical] + field[horizon][vertical + 1] )
//            }
//            return minWeight[n - 1][m - 1];
//        }
//    }
//}
