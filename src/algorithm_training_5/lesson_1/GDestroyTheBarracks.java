package algorithm_training_5.lesson_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Вы играете в интересную стратегию.
 * У вашего соперника остались всего одна казарма — здание,
 * в котором постоянно появляются новые солдаты.
 * Перед атакой у вас есть x солдат.
 * За один раунд каждый солдат может убить одного из солдат противника
 * или нанести 1 очко урона казарме (вычесть единицу здоровья у казармы).
 * Изначально у вашего оппонента нет солдат. Тем не менее,
 * его казарма имеет y единиц здоровья и производит p солдат за раунд.
 *
 * Ход одного раунда:
 *
 * Каждый солдат из вашей армии либо убивает одного из солдат вашего противника,
 * либо наносит 1 очко урона казарме. Каждый солдат может выбрать своё действие.
 * Когда казарма теряет все свои единицы здоровья, она разрушается.
 * Ваш противник атакует. Он убьет k ваших солдат, где k — количество оставшихся у противника солдат.
 * Если казармы еще не разрушены, ваш противник производит p новых солдат.
 * Ваша задача — разрушить казарму и убить всех солдат противника. Если это возможно,
 * посчитайте минимальное количество раундов, которое вам нужно для этого.
 * В противном случае выведите -1.
 *
 * Формат ввода
 * На вход подаётся три целых числа x, y, p (1 ≤ x, y, p ≤ 5000) — количество ваших солдат на старте игры,
 * количество очков здоровья казармы и количество производимых за раунд казармой солдат,
 * соответственно. Каждое число расположено в новой строке.
 *
 * Формат вывода
 * Если возможно убить всех вражеских солдат и разрушить казарму,
 * выведите минимальное количество раундов, необходимых для этого.
 * В противном случае выведите -1.
 */

//WA

public class GDestroyTheBarracks {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int solders = Integer.parseInt(bufferedReader.readLine());
            int barracksLives = Integer.parseInt(bufferedReader.readLine());
            int newEnemySoldersForRound = Integer.parseInt(bufferedReader.readLine());
            int rounds = 0;
            int enemySolders = 0;
            do {
                if (barracksLives > 0) {
                    if (barracksLives > solders) {
                        barracksLives -= solders;
                        solders -= enemySolders;
                    } else {
                        enemySolders += barracksLives - solders;
                        solders -= enemySolders;
                        barracksLives = 0;
                    }
                    if (barracksLives > 0) {
                        enemySolders += newEnemySoldersForRound;
                    }
                } else {
                    enemySolders -= solders;
                    solders -= enemySolders;
                }
                rounds++;
            }
            while ((barracksLives > 0 || enemySolders > 0) && solders > 0);
            if (solders > 0) {
                System.out.println(rounds);
            } else {
                System.out.println(-1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
