package algorithm_training_5.lesson_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 Раунд плей-офф между двумя командами состоит из двух матчей.
 Каждая команда проводит по одному матчу «дома» и «в гостях».
 Выигрывает команда, забившая большее число мячей.
 Если же число забитых мячей совпадает,
 выигрывает команда, забившая больше мячей «в гостях».
 Если и это число мячей совпадает,
 матч переходит в дополнительный тайм или серию пенальти.
 Вам дан счёт первого матча, а также счёт текущей игры (которая ещё не завершилась).
 Помогите комментатору сообщить, сколько голов необходимо забить первой команде,
 чтобы победить, не переводя игру в дополнительное время.

 Формат ввода
 В первой строке записан счёт первого мачта в формате G1:G2,
 где G1 — число мячей, забитых первой командой, а G2 — число мячей, забитых второй командой.
 Во второй строке записан счёт второго (текущего) матча в аналогичном формате.
 Все числа в записи счёта не превышают 5.
 В третьей строке записано число 1, если первую игру первая команда провела «дома», или 2, если «в гостях».
 */

//WA

public class BFootballCommentator {
    public static void main(String[] args) {
        int[] firstMatch = new int[2];
        int[] currentMatch = new int[2];
        boolean homeOrNot = true;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String s1 = bufferedReader.readLine();
            String[] s1Arr = s1.split(":");
            firstMatch[0] = Integer.parseInt(s1Arr[0]);
            firstMatch[1]  = Integer.parseInt(s1Arr[1]);
            String s2 = bufferedReader.readLine();
            String[] s2Arr = s2.split(":");
            currentMatch[0] = Integer.parseInt(s2Arr[0]);
            currentMatch[1]  = Integer.parseInt(s2Arr[1]);
            String s3 = bufferedReader.readLine();
            homeOrNot = Integer.parseInt(s3) == 1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        int goalsOfFirstCommand = firstMatch[0] + currentMatch[0];
        int goalsOfSecondCommand = firstMatch[1] + currentMatch[1];

        if (goalsOfFirstCommand > goalsOfSecondCommand) {
            System.out.println(0);
        } else if (firstMatch[0] == firstMatch[1] && currentMatch[0] == currentMatch[1]){
            if (homeOrNot) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        } else {
            if (homeOrNot) {
                if (firstMatch[0] == currentMatch[1] && currentMatch[0] == firstMatch[1]) {
                    System.out.println(0);
                } else if (firstMatch[0] == currentMatch[1]) {
                    System.out.println((firstMatch[1] - currentMatch[0]) + 1);
                } else {
                    System.out.println((firstMatch[1] + currentMatch[1]) - (firstMatch[0] + currentMatch[0]));
                }
            } else {
                if (firstMatch[0] == currentMatch[1] && currentMatch[0] == firstMatch[1]) {
                    System.out.println(1);
                } else if (firstMatch[0] == currentMatch[1]) {
                    System.out.println(firstMatch[1] - currentMatch[0]);
                } else {
                    if (goalsOfFirstCommand == goalsOfSecondCommand && firstMatch[0] >= currentMatch[1]) {
                        System.out.println(0);
                    } else {
                        System.out.println(1 + (firstMatch[1] + currentMatch[1]) - (firstMatch[0] + currentMatch[0]));
                    }
                }
            }
        }
    }
}
