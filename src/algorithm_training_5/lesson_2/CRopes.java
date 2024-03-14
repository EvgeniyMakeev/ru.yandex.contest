package algorithm_training_5.lesson_2;

import java.util.Scanner;


/**
 На столе лежали две одинаковые верёвочки целой положительной длины.

 Петя разрезал одну из верёвочек на N частей,
 каждая из которых имеет целую положительную длину,
 так что на столе стало N+1 верёвочек.
 Затем в комнату зашла Маша и взяла одну из лежащих на столе верёвочек.
 По длинам оставшихся на столе N верёвочек определите,
 какую наименьшую длину может иметь верёвочка, взятая Машей.

 Формат ввода
 Первая строка входных данных содержит одно целое число N — количество верёвочек,
 оставшихся на столе (2 ≤ N ≤ 1000). Во второй строке содержится N целых чисел li —
 длины верёвочек (1 ≤ li ≤ 1000).

 Формат вывода
 Выведите одно целое число — наименьшую длину,
 которую может иметь верёвочка, взятая Машей.
 */

public class CRopes {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfPeaces = scanner.nextInt();
            int[] peaces = new int[numberOfPeaces];
            int maxLength = 0;
            int totalLength = 0;
            for (int i = 0; i < numberOfPeaces; i++) {
                peaces[i] = scanner.nextInt();
                totalLength += peaces[i];
                if (maxLength < peaces[i]) {
                    maxLength = peaces[i];
                }
            }
            int result = 0;
            if (totalLength/2 < maxLength) {
                result = maxLength - (totalLength - maxLength);
            } else {
                result = totalLength;
            }
            System.out.println(result);
        }
    }
}
