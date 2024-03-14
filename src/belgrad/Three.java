package belgrad;

/**
 * Дан упорядоченный по неубыванию массив целых 32-разрядных чисел.
 * Требуется удалить из него все повторения.
 * Желательно получить решение, которое не считывает входной файл целиком в память,
 * т.е., использует лишь константный объем памяти в процессе работы.
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Three {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            if (!set.contains(x)) {
                set.add(x);
                System.out.println(x);
            }
        }
        scan.close();
    }
}