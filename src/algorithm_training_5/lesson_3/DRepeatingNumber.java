package algorithm_training_5.lesson_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 Вам дана последовательность измерений некоторой величины.
 Требуется определить, повторялась ли какое-либо число,
 причём расстояние между повторами не превосходило k.

 Формат ввода
 В первой строке задаются два числа n и k (1 ≤ n, k ≤ 105).

 Во второй строке задаются n чисел, по модулю не превосходящих 109.

 Формат вывода
 Выведите YES, если найдется повторяющееся число и
 расстояние между повторами не превосходит k и NO в противном случае.
 */

public class DRepeatingNumber {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int countOfNumber = scanner.nextInt();
            if (countOfNumber > 1) {
                int range = scanner.nextInt();
                Map<Integer, Integer> numbers = new HashMap<>();
                int n;
                for (int i = 0; i < countOfNumber; i++) {
                    n = scanner.nextInt();
                    if (numbers.containsKey(n) && i - range <= numbers.get(n)) {
                        System.out.println("YES");
                        return;
                    } else {
                        numbers.put(n, i);
                    }
                }
                System.out.println("NO");
            } else {
                System.out.println("NO");
            }
        }
    }
}
