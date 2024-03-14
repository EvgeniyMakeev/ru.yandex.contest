package algorithm_training_5.lesson_2;

import java.math.BigInteger;
import java.util.Scanner;


/**
 Вася решил заняться торговлей рыбой.
 С помощью методов машинного обучения он предсказал цены на рыбу на N дней вперёд.
 Он решил, что в один день он купит рыбу, а в один из следующих дней — продаст
 (то есть совершит или ровно одну покупку и продажу или вообще не совершит покупок и продаж,
 если это не принесёт ему прибыли). К сожалению, рыба — товар скоропортящийся и
 разница между номером дня продажи и номером дня покупки не должна превышать K.

 Определите, какую максимальную прибыль получит Вася.

 Формат ввода
 В первой строке входных данных задаются числа N и K (1 ≤ N ≤ 10000, 1 ≤ K ≤ 100).

 Во второй строке задаются цены на рыбу в каждый из N дней. Цена — целое число,
 которое может находится в пределах от 1 до 109.

 Формат вывода
 Выведите одно число — максимальную прибыль, которую получит Вася.
 */

public class BFishSeller {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int days = scanner.nextInt();
            int maxProfit = 0;
            if (days <= 1) {
                System.out.println(maxProfit);
            } else {
                int bestBefore = scanner.nextInt();
                int[] pricesAtDays = new int[days];
                for (int i = 0; i < days; i++) {
                    pricesAtDays[i] = scanner.nextInt();
                }
                int range = bestBefore;
                for (int i = 0; i < days - 1; i++) {
                    if (range > days - i - 1) {
                        range = days - i - 1;
                    }
                    for (int j = i; j <= i + range; j++) {
                        if (pricesAtDays[j] - pricesAtDays[i] > maxProfit) {
                            maxProfit = pricesAtDays[j] - pricesAtDays[i];
                        }
                    }
                }
                System.out.println(maxProfit);
            }
        }
    }
}
