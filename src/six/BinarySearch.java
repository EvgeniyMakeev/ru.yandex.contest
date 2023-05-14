package six;

import java.util.*;

public class BinarySearch {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        Set<Integer> setN = new HashSet<>();
        for (int i = 0; i < n; i++) {
            setN.add(scan.nextInt());
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < k; i++) {
            stringBuilder.append(setN.contains(scan.nextInt()) ? "YES\n" : "NO\n");
        }
        System.out.println(stringBuilder);

//        int[] arrN = new int[n];
//        for (int i = 0; i < n; i++) {
//            arrN[i] = scan.nextInt();
//        }
//        for (int i = 0; i < k; i++) {
//            int x = scan.nextInt();
//            if (x < arrN[0] || x > arrN[arrN.length - 1]) {
//                System.out.println("NO");
//            } else {
//                System.out.println(binarySearch(arrN, x) != -1 ? "YES" : "NO");
//            }
        scan.close();
    }

    public static int binarySearch(int[] arrayToSearch, int element) {
        int elementPos = -1;
        int lowIndex = 0;
        int highIndex = arrayToSearch.length - 1;
        while (lowIndex <= highIndex) {
            int midIndex = (lowIndex + highIndex) / 2;
            if (element == arrayToSearch[midIndex]) {
                elementPos = midIndex;
                break;
            } else if (element < arrayToSearch[midIndex]) {
                highIndex = midIndex - 1;
            } else if (element > arrayToSearch[midIndex]) {
                lowIndex = midIndex + 1;
            }
        }
        return elementPos;
    }
}