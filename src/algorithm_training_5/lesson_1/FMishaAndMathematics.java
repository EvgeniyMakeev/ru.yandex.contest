package algorithm_training_5.lesson_1;

import java.util.Scanner;


/**
 * Миша сидел на занятиях математики в Высшей школе экономики и решал следующую задачу:
 * дано n целых чисел и нужно расставить между ними знаки + и × так,
 * чтобы результат полученного арифметического выражения был нечётным
 * (например, между числами 5, 7, 2, можно расставить арифметические знаки следующим образом:
 * 5×7+2=37). Так как примеры становились все больше и больше,
 * а Миша срочно убегает в гости, от вас требуется написать программу решающую данную задачу.
 */

//WA

public class FMishaAndMathematics {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int countOfNumbers = scanner.nextInt();
            int[] numbers = new int[countOfNumbers];
            for (int i = 0; i < countOfNumbers; i++) {
                numbers[i] = scanner.nextInt();

            }
            char[] result = new char[countOfNumbers];
            int count = 0;
            int index = -1;
            int x = Integer.MAX_VALUE;
            for (int i = 0; i < countOfNumbers; i++) {
                if (numbers[i]  % 2 != 0 && numbers[i] < x && numbers[i] != 0) {
                    x = numbers[i];
                    index = i;
                }
                result[i] = '+';
                count += numbers[i];
            }
            if (count % 2 == 0) {
                result[index] = 'x';
                count = (count - x) * x;
            }

            System.out.println(count);

            for (int i = 0; i < countOfNumbers - 1; i++) {
                System.out.print(result[i]);
            }
        }
    }
}
