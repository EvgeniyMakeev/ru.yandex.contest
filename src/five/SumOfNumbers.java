package five;

/**
 * Вася очень любит везде искать своё счастливое число K.
 * Каждый день он ходит в школу по улице, вдоль которой припарковано N машин.
 * Он заинтересовался вопросом, сколько существует наборов машин, стоящих подряд на местах с L до R,
 * что сумма их номеров равна K. Помогите Васе узнать ответ на его вопрос.
 * Например, если число N = 5, K = 17 , а номера машин равны 17, 7, 10, 7, 10, то существует 4 набора машин:
 */

import java.util.*;

public class SumOfNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }


        scan.close();

        System.out.println(howManySum(arr, k));
    }

    // метод О(n)
//    private static int howManySum(int[] arr, int k) {
//        int count = 0;
//        int left = 0;
//        int right = 0;
//        int nowSum = 0;
//        while (left < arr.length) {
//            nowSum += arr[right];
//            if (nowSum == k) {
//                count++;
//                nowSum -= k;
//                if (left < arr.length - 1) {
//                    left++;
//                    right = left;
//                }
//            } else {
//                right = right == arr.length - 1 ? left : right + 1;
//                left = right == arr.length - 1 ? left + 1 : left;
//            }
//        }
//        return count;
//    }
//}

    private static int howManySum(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int right = i;
            int nowSum = 0;
            while (right < arr.length && nowSum <= k) {
                nowSum += arr[right];
                right++;
                if (nowSum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
    // метод О(n^2)

//    private static int howManySum(int[] arr, int k) {
//        int count = 0;
//        for (int i = 0; i < arr.length; i++) {
//            int rangeSum = 0;
//            for (int j = i; j < arr.length; j++) {
//                rangeSum += arr[j];
//                if (rangeSum == k) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//}

//    private static int[] makePrefixSum(int[] arr) {
//        int[] prefixsum = new int[arr.length + 1];
//        prefixsum[0] = 0;
//        for (int i = 1; i < prefixsum.length; i++) {
//            prefixsum[i] = prefixsum[i - 1] + arr[i - 1];
//        }
//        return prefixsum;
//    }
//
//    private static int rsq(int[] prefixsum, int l, int r) {
//        return prefixsum[r] - prefixsum[l];
//    }
//}
