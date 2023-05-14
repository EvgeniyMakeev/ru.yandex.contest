package three;

/**
 * Дан список чисел, который может содержать до 100000 чисел. Определите, сколько в нем встречается различных чисел.
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NumberOfDifferentNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        String[] strArr = str.split(" ");
        Set<Integer> set = new HashSet<>();
        for (String s : strArr) {
            set.add(Integer.valueOf(s));
        }

        System.out.println(set.size());
    }
}
