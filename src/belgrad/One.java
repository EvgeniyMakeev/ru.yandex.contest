package belgrad;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Даны две строки строчных латинских символов: строка J и строка S.
 * Символы, входящие в строку J, — «драгоценности», входящие в строку S — «камни».
 * Нужно определить, какое количество символов из S одновременно являются «драгоценностями».
 * Проще говоря, нужно проверить, какое количество символов из S входит в J.
 */

public class One {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String j = scan.nextLine();
        String s = scan.nextLine();
        scan.close();

        Set<Character> set = new HashSet<>();
        for (int i = 0, n = j.length(); i < n; i++) {
            set.add(j.charAt(i));
        }

        int count = 0;
        for (int i = 0, n = s.length(); i < n; i++) {
            if (set.contains(s.charAt(i))) {
                count++;
            }
        }
        System.out.println(count);
    }
}
