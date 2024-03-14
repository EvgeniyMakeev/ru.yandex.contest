package algorithm_training_5.lesson_1;

import java.math.BigInteger;
import java.util.Scanner;


/**
 Петя - начинающий программист. Сегодня он написал код из n строк.
 К сожалению оказалось, что этот код трудно читать. Петя решил исправить это,
 добавив в различные места пробелы. А точнее, для i-й строки ему нужно добавить ровно ai пробелов.
 Для добавления пробелов Петя выделяет строку и нажимает на одну из трёх клавиш: Space, Tab, и Backspace.
 При нажатии на Space в строку добавляется один пробел.
 При нажатии на Tab в строку добавляются четыре пробела.
 При нажатии на Backspace в строке удаляется один пробел.
 Ему хочется узнать, какое наименьшее количество клавиш придётся нажать,
 чтобы добавить необходимое количество пробелов в каждую строку. Помогите ему!

 Формат ввода
 Первая строка входных данных содержит одно целое положительное число n(1≤n≤105) – количество строк в файле.
 Каждая из следующих n строк содержит одно целое неотрицательное число ai(0≤ai≤109)– количество пробелов,
 которые нужно добавить вi-ю строку файла.

 Формат вывода
 Выведите одно число – минимальное количество нажатий,
 чтобы добавить в каждой строке необходимое количество пробелов.
 */

public class CFileFormatting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = scanner.nextInt();
        BigInteger totalPushOnButtons = BigInteger.valueOf(0);
        int[] arrLine = new int[lines];
        int notTab = 0;
        for (int i : arrLine) {
            arrLine[i] = scanner.nextInt();
            notTab = arrLine[i] % 4;
            if (notTab <= 2) {
                totalPushOnButtons = totalPushOnButtons.add(BigInteger.valueOf(arrLine[i] / 4));
                totalPushOnButtons = totalPushOnButtons.add(BigInteger.valueOf(notTab));
            } else {
                totalPushOnButtons = totalPushOnButtons.add(BigInteger.valueOf(1 + ((arrLine[i] + 1) / 4)));
            }
        }
        scanner.close();
        System.out.println(totalPushOnButtons);
    }
}
