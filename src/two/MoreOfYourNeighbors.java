package two;

import java.util.Scanner;

public class MoreOfYourNeighbors {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] strArr = str.split(" ");

        System.out.println(howManyMore(strArr));
    }

    public static int howManyMore(String[] strArr) {
        int count = 0;
        for (int i = 1; i < strArr.length - 1; i++) {
            if (Integer.parseInt(strArr[i]) > Integer.parseInt(strArr[i - 1])
                    && Integer.parseInt(strArr[i]) > Integer.parseInt(strArr[i + 1])) {
                count++;
            }
        }
        return count;
    }
}
