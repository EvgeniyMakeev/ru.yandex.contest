package one;

import java.util.Scanner;

/**
 * За многие годы заточения узник замка Иф проделал в стене прямоугольное отверстие размером D × E.
 * Замок Иф сложен из кирпичей, размером A × B × C. Определите, сможет ли узник выбрасывать кирпичи в море через это отверстие,
 * если стороны кирпича должны быть параллельны сторонам отверстия.
 *
 * Формат ввода
 * Программа получает на вход числа A, B, C, D, E.
 *
 * Формат вывода
 * Программа должна вывести слово YES или NO.
 */

public class PrisonerOfIf {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int d = scan.nextInt();
        int e = scan.nextInt();

        System.out.println(isItPossible(a, b, c, d, e));

        scan.close();
    }

    public static String isItPossible(int a, int b, int c, int d, int e) {
        int minABC = Math.min(Math.min(a, b), c);
        int medianABC = Math.max(Math.min(a, b), Math.min(Math.max(a, b), c));
        int minDE = Math.min(d, e);
        int maxDE = Math.max(d, e);

        String result = minABC <= minDE && medianABC <= maxDE ? "YES" : "NO";

        return result;
    }
}
