package contest4.warm_up;

import java.util.Scanner;

/**
 * Тридцатого декабря все сотрудники известной IT-компании отправляются праздновать Новый год!
 * На парковке офиса сотрудников уже ожидают автобусы, чтобы отвезти их в ресторан.
 * Известно, что наi-м этаже работает a i сотрудников, а парковка расположена на нулевом этаже.
 * Изначально лифт расположен на этаже с парковкой.
 * Какое минимальное количество времени лифт будет перевозить всех людей на парковку?
 * Известно, что лифт движется со скоростью один этаж в секунду, а посадка и высадка происходит мгновенно.
 */
public class Lift {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int maxPeople = input.nextInt();
        int levels = input.nextInt();
        int[] peoplesOnLevel = new int[levels];

        int higherLevelWithPeople = 0;

        for (int i = 0; i < levels; i++) {
            peoplesOnLevel[i] = input.nextInt();
            if (peoplesOnLevel[i] != 0) {
                higherLevelWithPeople = i;
            }
        }
        input.close();

        int totalSec = 0;

        while (higherLevelWithPeople > 0) {
            int peopleCanEnter = maxPeople;
            totalSec += higherLevelWithPeople;
            for (int i = higherLevelWithPeople; i > 0; i--) {
                if (peoplesOnLevel[i] - peopleCanEnter == 0) {
                    
                }
                totalSec++;
            }
        }

        System.out.println(totalSec);
    }
}
