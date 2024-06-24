package algorithm_training_5.lesson_3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


/**
 Вам даны три списка чисел.
 Найдите все числа, которые встречаются хотя бы в двух из трёх списков.

 Формат ввода
 Во входных данных описывается три списка чисел.
 Первая строка каждого описания списка состоит из длины списка n (1 ≤ n ≤ 1000).
 Вторая строка описания содержит список натуральных чисел, записанных через пробел.
 Числа не превосходят 109.

 Формат вывода
 Выведите все числа, которые содержатся хотя бы в двух списках из трёх,
 в порядке возрастания. Обратите внимание, что каждое число необходимо выводить только один раз.
 */


public class ETwoOutOfThree {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Set<Integer> result = new HashSet<>();
            int n;
            int countOfNumber1 = scanner.nextInt();
            Set<Integer> set1 = new HashSet<>();
            for (int i = 0; i < countOfNumber1; i++) {
                set1.add(scanner.nextInt());
            }
            int countOfNumber2 = scanner.nextInt();
            Set<Integer> set2 = new HashSet<>();
            for (int i = 0; i < countOfNumber2; i++) {
                n = scanner.nextInt();
                set2.add(n);
                if (set1.contains(n)) {
                    result.add(n);
                }
            }
            int countOfNumber3 = scanner.nextInt();
            for (int i = 0; i < countOfNumber3; i++) {
                n = scanner.nextInt();
                if (set1.contains(n) || set2.contains(n)) {
                    result.add(n);
                }
            }
            if (!result.isEmpty()) {
                result.stream()
                        .sorted()
                        .forEach(x -> System.out.print(x + " "));
            }
        }
    }
}