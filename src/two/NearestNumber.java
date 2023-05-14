package two;

import java.util.Arrays;
import java.util.Scanner;

public class NearestNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int length = scan.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = scan.nextInt();
        }
        int x = scan.nextInt();

        scan.close();

        System.out.println(whatNearestNumber(arr, x));
    }

    private static int whatNearestNumber(int[] arr, int x) {
        int left = 0;
        int right = arr.length - 1;
        int result = 0;

        Arrays.sort(arr);

        while (right - left >= 2)
        {
            if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            }
            else {
                right--;
            }
        }
        if (x == arr[left]) {
            return arr[left];
        } else if (x == arr[right]) {
            return arr[right];
        } else if (x > 0) {
            if (arr[left] == 0 || arr[right] == 0) {
                if (arr[left] < 0 || arr[right] < 0) {
                    result = (-x - arr[left]) < (-x - arr[right]) ? arr[left] : arr[right];
                } else {
                    result = (-x - arr[left]) > (x - arr[right]) ? arr[left] : arr[right];
                }
            } else {
                result = (x - arr[left]) < (x - arr[right]) ? arr[left] : arr[right];
            }
        } else {
            if (arr[left] == 0 || arr[right] == 0) {
                if (arr[left] < 0 || arr[right] < 0) {
                    result = (x - arr[left]) < (-x - arr[right]) ? arr[left] : arr[right];
                } else {
                    result = (x - arr[left]) < (x - arr[right]) ? arr[left] : arr[right];
                }
            } else {
                result = (x + arr[left]) < (x + arr[right]) ? arr[left] : arr[right];
            }
        }

        return result;
    }
//        int nearestNumber = arr[0];
//        for (int i = 0; i < arr.length; i++) {
//
//            if (arr[i] == x) {
//                return arr[i];
//            }
//            if (arr[i] == 0) {
//                if (x < 0) {
//                    if (nearestNumber <= x + arr[i]) {
//                        nearestNumber = arr[i];
//                        break;
//                    }
//                } else {
//                    if (nearestNumber >= x - (arr[i] - 1)) {
//                        nearestNumber = arr[i];
//                        break;
//                    }
//                }
//                break;
//            }
//            if (x < 0) {
//                if (arr[i] < 0) {
//                    if (nearestNumber >= -x + arr[i]) {
//                        nearestNumber = arr[i];
//                    }
//                } else {
//                    if (nearestNumber <= x - arr[i]) {
//                        nearestNumber = arr[i];
//                    }
//                }
//            } else {
//                if (arr[i] < 0) {
//                    if (nearestNumber >= x - arr[i]) {
//                        nearestNumber = arr[i];
//                    }
//                } else {
//                    if (nearestNumber <= x - arr[i]) {
//                        nearestNumber = arr[i];
//                    }
//                }
//            }
//
//        }
//        return nearestNumber;
}
