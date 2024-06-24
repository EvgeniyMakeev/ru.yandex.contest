package school2024.contest_2;

import java.util.Scanner;


/**
 Вася решил питаться рыбой.
 Он решил, что в течение N дней он должен съедать по одной рыбе каждый день.
 К сожалению, рыба — товар скоропортящийся и может храниться не более K дней,
 включая день покупки. С помощью методов машинного обучения Вася предсказал цены на рыбу на N дней вперёд.

 Помогите Васе определить, в какие дни и сколько рыбы нужно покупать,
 чтобы потратить как можно меньше денег.

 Формат ввода
 В первой строке вводится два целых числа N и K (1 ≤ N, K ≤ 100 000) —
 количество дней, в течение которых нужно питаться рыбой, и срок хранения рыбы соответственно.

 Во второй строке вводится N чисел, разделенных пробелами:
 стоимость рыбы в этот день Ci (1 ≤ Ci ≤ 106).

 Формат вывода
 В первой строке выведите минимальную сумму, потраченную на рыбу.

 Во второй строке выведите N чисел — количество купленных рыб в каждый из дней.

 Если правильных ответов несколько — выведите любой из них.
 */

public class BFishBuyer {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int days = scanner.nextInt();
            int purchaseAmount = 0;
            int price;
            int bestBefore = scanner.nextInt();
            int[] pricesOfFishAtDays = new int[days];
            int[] fishBoughtAtDay = new int[days];
            int needToBay = days;
            for (int i = 0; i < days; i++) {
                price = scanner.nextInt();
                pricesOfFishAtDays[i] = price;
            }

            if (days <= 1) {
                System.out.println(pricesOfFishAtDays[0]);
                System.out.println(fishBoughtAtDay[0]);
            } else if (bestBefore == 1) {
                for (int i = 0; i < days; i++) {
                    purchaseAmount += pricesOfFishAtDays[i];
                }
                System.out.println(purchaseAmount);
                for (int i = 0; i < days; i++) {
                    System.out.print(1 + " ");
                }
            } else {
                int indexOfMinPrice = 0;
                int minPrice = pricesOfFishAtDays[indexOfMinPrice];
                int range = bestBefore;
                for (int i = 0; i <= days - 1; i++) {
                    i = indexOfMinPrice;
                    if (range > days - i - 1) {
                        range = days - i - 1;
                    }
                    purchaseAmount += pricesOfFishAtDays[i];
                    fishBoughtAtDay[i]++;
                    needToBay--;
                    if (needToBay == 0) {
                        break;
                    }
                    for (int j = i; j <= i + range; j++) {
                        if(minPrice > pricesOfFishAtDays[j]) {
                            if (j >= days - range) {
                                fishBoughtAtDay[j] += needToBay;
                                purchaseAmount += pricesOfFishAtDays[j] * needToBay;
                                System.out.println(purchaseAmount);
                                for (int fish : fishBoughtAtDay) {
                                    System.out.print(fish + " ");
                                }
                                return;
                            }
                            purchaseAmount -= pricesOfFishAtDays[j];
                            minPrice = pricesOfFishAtDays[j];
                            fishBoughtAtDay[j]++;
                            indexOfMinPrice = j;
                        }
                    }
                }
                System.out.println(purchaseAmount);
                for (int fish : fishBoughtAtDay) {
                    System.out.print(fish + " ");
                }
            }
        }
    }
}
