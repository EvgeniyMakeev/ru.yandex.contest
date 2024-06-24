package sre_week;

import java.util.*;

/**
 * У вас есть запись сессий на неком вымышленном сервисе. Каждая сессия описывается моментом начала и конца,
 * обозначаемыми si и fi, причем все эти моменты уникальны.
 * Вам нужно найти начало отрезка времени, t, на котором было активно максимальное число сессий.
 * Иными словами, найдите такой момент времени t, для которого максимально количество индексов i,
 * для которых выполняется условие si ≤ t ≤ fi.
 * Если есть несколько отрезков времени с одинаковой максимальной нагрузкой, выбирайте самый ранний из них.
 */

public class AHighLoad {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] arrOfTimes = new int[n][2];
        int minStart = Integer.MAX_VALUE;
        int maxFinish = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int nextStart = scan.nextInt();
            if (nextStart < minStart) {
                minStart = nextStart;
            }
            arrOfTimes[i][0] = nextStart;

            int nextFinish = scan.nextInt();
            if (nextFinish > maxFinish) {
                maxFinish = nextFinish;
            }
            arrOfTimes[i][1] = nextFinish;
        }
        scan.close();

        int[] timeLine = new int[maxFinish];
        for (int i = 0; i < n; i++) {
            int start = arrOfTimes[i][0];
            int finish = arrOfTimes[i][1];
            for (int j = start; j < finish; j++) {
                timeLine[j]++;
            }
        }

        int firstMax = 0;
        for (int i = minStart; i < maxFinish; i++) {
            if (timeLine[i] > timeLine[firstMax]) {
                firstMax = i;
            }
        }
        System.out.println(firstMax);
    }
}
