package algorithm_training_5.lesson_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * На клетчатой плоскости закрашено K клеток.
 * Требуется найти минимальный по площади прямоугольник,
 * со сторонами, параллельными линиям сетки, покрывающий все закрашенные клетки.
 *
 * Формат ввода
 * Во входном файле, на первой строке, находится число K (1 ≤ K ≤ 100).
 * На следующих K строках находятся пары чисел Xi и Yi — координаты закрашенных клеток (|Xi|, |Yi| ≤ 109).
 *
 * Формат вывода
 * Выведите в выходной файл координаты левого нижнего и правого верхнего углов прямоугольника.
 */

public class AMinimumRectangle {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int countOfCell = Integer.parseInt(bufferedReader.readLine());
            int x;
            int y;
            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;
            int maxX = Integer.MIN_VALUE;
            int maxY = Integer.MIN_VALUE;
            for (int i = 0; i < countOfCell; i++) {
                String s = bufferedReader.readLine();
                String[] sArr = s.split(" ");
                x = Integer.parseInt(sArr[0]);
                y = Integer.parseInt(sArr[1]);

                if (x < minX) {
                    minX = x;
                }
                if (y < minY) {
                    minY = y;
                }
                if (x > maxX) {
                    maxX = x;
                }
                if (y > maxY) {
                    maxY = y;
                }
            }
            System.out.println(minX + " " + minY + " " + maxX + " " + maxY);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
