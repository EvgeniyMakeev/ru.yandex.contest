package two;

import java.util.Scanner;

public class SymmetricSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int length = scan.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scan.nextInt();
        }

        scan.close();

        int[] ans = howManyAddNumbers(arr);
        System.out.println(ans.length);
        for (int i : ans) {
            System.out.print(ans[i - 1] + " ");
        }
    }

    private static int[] howManyAddNumbers(int[] arr) {
        int[] ans = new int[0];
        for (int start = 0; start < arr.length; start++) {
            int i = start;
            int j = arr.length - 1;
            while (i < arr.length && j >= 0 && arr[i] == arr[j] && i <= j) {
                i++;
                j--;
            }
            if (i > j) {
                int[] result = new int[start];
                for (int k = start - 1; k >= 0; k--) {
                    result[k] = arr[k];
                }
                return result;
            }
        }
        return ans;
    }
}
//    private static void howManyAddNumbers(int[] arr) {
////        int indexCenter = 0;
////        int max = 0;
////        for (int i = arr.length - 1; i >= 0; i--) {
////            int count = 0;
////            int start = i - 1;
////
////            while (start > 0) {
////                if (arr[start] == arr[i]) {
////                    count++;
////                    if (count > max) {
////                        max = count;
////                        indexCenter = i;
////                    }
////                }
////                start--;
////            }
////        }
////
////        int howMany = max > 0 ? indexCenter - 1: arr.length - 1;
////        System.out.println(howMany);
////        System.out.println(max);
////        System.out.println(indexCenter);
////        for (int i = 0; i < howMany; i++) {
////            System.out.print(arr[i] + " ");
////        }
////    }
////}
////        int indexCenter = 0;
////        int max = 0;
////
////        for (int i = 1; i < arr.length; i++) {
////            int end = i;
////            int start = 0;
////            while (end < arr.length-1) {
////                int count = 0;
////                if (arr[start] == arr[end]){
////                    count++;
////                    if (count > max) {
////                        max = count;
////                        indexCenter = i;
////                    }
////                }
////                start++;
////                end++;
////            }
////        }
////
////        int howMany = max > 0 ? arr.length - indexCenter : 0;
////        System.out.println(indexCenter);
////        System.out.println(howMany);
////        System.out.println(max);
////        for (int i = howMany - 1; i >= 0; i--) {
////            System.out.print(arr[i] + " ");
////        }
////    }
////}
//        int indexCenter = arr.length - 1;
//        int max = 0;
//        if (arr[0] == arr[arr.length - 1]) {
//            max += 1;
//        }
//        for (int i = arr.length - 2; i >= 0; i--) {
//            int count = 0;
//            int start = i;
//            int end = arr.length - 1;
//
//            while (arr[start] == arr[end] && start > 0) {
//                count++;
//                if (count >= max) {
//                    max = count;
//                    indexCenter = arr.length - i;
//                }
//                start--;
//                end--;
//            }
//        }
//
//        int howMany = (arr.length - 1) - indexCenter;
//        if (indexCenter == arr.length - 1 && max > 0) {
//            howMany = 0;
//        } else if (max > 0) {
//            howMany = indexCenter;
//        }
//        System.out.println(howMany);
//        System.out.println(max);
//        System.out.println(indexCenter);
//        for (int i = 0; i < howMany; i++) {
//            System.out.print(arr[i] + " ");
//        }
//    }
//}
