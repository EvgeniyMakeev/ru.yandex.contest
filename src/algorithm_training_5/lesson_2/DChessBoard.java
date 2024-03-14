package algorithm_training_5.lesson_2;

import java.util.Scanner;


/**
 * Из шахматной доски по границам клеток выпилили связную (не распадающуюся на части) фигуру без дыр.
 * Требуется определить ее периметр.
 *
 * Формат ввода
 * Сначала вводится число N (1 ≤ N ≤ 64) – количество выпиленных клеток.
 * В следующих N строках вводятся координаты выпиленных клеток,
 * разделенные пробелом (номер строки и столбца – числа от 1 до 8).
 * Каждая выпиленная клетка указывается один раз.
 *
 * Формат вывода
 * Выведите одно число – периметр выпиленной фигуры (сторона клетки равна единице).
 */


public class DChessBoard {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int perimeter = 0;
            int countOfCells = scanner.nextInt();
            if (countOfCells == 1) {
                perimeter = 4;
            } else if (countOfCells == 2) {
                perimeter = 6;
            } else {
                int size = 8 + 2;
                char[][] table = new char[size][size];
                int[] shifts = {0, -1, -1, 0, 0, 1, 1, 0};
                for (int n = 0; n < countOfCells; n++) {
                    int i = scanner.nextInt();
                    int j = scanner.nextInt();
                    table[i][j] = '#';
                    perimeter += 4;
                    for (int s = 0; s < 8; s += 2) {
                        if (table[i + shifts[s]][j + shifts[s + 1]] == '#') {
                            perimeter -= 2;
                        }
                    }
                }
            }
            System.out.println(perimeter);
        }
    }
}
