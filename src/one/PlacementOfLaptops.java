package one;

import java.util.Scanner;

/**
 * В школе решили на один прямоугольный стол поставить два прямоугольных ноутбука.
 * Ноутбуки нужно поставить так, чтобы их стороны были параллельны сторонам стола.
 * Определите, какие размеры должен иметь стол, чтобы оба ноутбука на него поместились, и площадь стола была минимальна.
 *
 * Формат ввода
 * Вводится четыре натуральных числа, первые два задают размеры одного ноутбука, а следующие два — размеры второго.
 * Числа не превышают 1000.
 *
 * Формат вывода
 * Выведите два числа — размеры стола. Если возможно несколько ответов, выведите любой из них (но только один).
 */

public class PlacementOfLaptops {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();

        isItPossible(a, b, c, d);

        scan.close();
    }

    public static void isItPossible(int a, int b, int c, int d) {
        int minX = Math.min(Math.min(a + c, a + d), Math.min(b + c, b + d));
        int minY = 0;
        if (a + c < a + d) {
            minY = b + d;
        } else {
            minY = b + c;
        }
        System.out.println(minX + " " + minY);
    }
}
