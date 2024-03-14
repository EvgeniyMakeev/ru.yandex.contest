package belgrad;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Six {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Set<Long> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            long x = scan.nextLong();
            if (!set.contains(x)) {
                set.add(x);
                count++;
            } else {
                if (count > 0) {
                    count--;
                }
            }
        }
        scan.close();
        System.out.println(count);
    }
}


//    A B = (x B - x A) 2 + (y B - y A) 2