package algorithm_training_5.lesson_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


/**
 * k друзей организовали стартап по производству укулеле для кошек.
 * На сегодняшний день прибыль составила n рублей.
 * Вы, как главный бухгалтер компании,
 * хотите в каждый из ближайших d дней приписывать по одной цифре в конец числа,
 * выражающего прибыль. При этом в каждый из дней прибыль должна делиться на k.
 * Формат ввода
 * В единственной строке входных данных через пробел записаны три числа:
 * n, k, d — изначальная прибыль, количество учредителей компании и количество дней,
 * которое вы собираетесь следить за прибылью (1≤n,k≤109,1≤d≤105).
 * НЕ гарантируется, что n делится на k.
 * Формат вывода
 * Выведите одно целое число x — прибыль компании через d дней.
 * Первые цифры числа x должны совпадать с числом n.
 * Все префиксы числа x, которые длиннее числа n на 1, 2,…,d цифр,
 * должны делиться на k. Если возможных ответов несколько,
 * выведите любой из них. Если ответа не существует,
 * выведите −1.
 */

//WA

public class EProfitableStartup {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = bufferedReader.readLine();
            String[] sArr = s.split(" ");
            String n = sArr[0];
            int k = Integer.parseInt(sArr[1]);
            int d = Integer.parseInt(sArr[2]);
            BigInteger result = BigInteger.valueOf(Integer.parseInt(n + 9));
            System.out.println(result);
            if (result.mod(BigInteger.valueOf(k)).equals(BigInteger.valueOf(0)) || result.mod(BigInteger.valueOf(k)).intValue() < 9) {
                result = result.subtract(result.mod(BigInteger.valueOf(k)));
                StringBuilder resultStr = new StringBuilder().append(result);
                for (int i = 0; i < d - 1; i++) {
                    resultStr.append(0);
                }
                System.out.println(resultStr);
            } else {
                System.out.println(-1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
