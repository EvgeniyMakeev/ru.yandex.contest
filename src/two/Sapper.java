package two;

/**
 * Вам необходимо построить поле для игры "Сапер" по его конфигурации –
 * размерам и координатам расставленных на нем мин.
 *
 * Вкратце напомним правила построения поля для игры "Сапер":
 *
 * Поле состоит из клеток с минами и пустых клеток
 * Клетки с миной обозначаются символом *
 * Пустые клетки содержат число ki,j, 0≤ ki, j ≤ 8 –
 * количество мин на соседних клетках.
 * Соседними клетками являются восемь клеток, имеющих смежный угол или сторону.
 */

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Sapper {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();
        int k = scan.nextInt();

        int[][] mines = new int[k][2];
        for (int i = 0; i < mines.length; i++) {
            mines[i][0] = scan.nextInt();
            mines[i][1] = scan.nextInt();
        }

        fieldPrint(n, m, mines);
        scan.close();

    }

    private static void fieldPrint(int n, int m, int[][] mines) {
        int[][] dxy = {{-1, -1, -1, 0, 0, 1, 1, 1},{-1, 0, 1, -1, 1, -1, 0, 1}};
        String[][] field = new String[n + 2][m + 2];
        for (String[] strings : field) {
            Arrays.fill(strings, "0");
        }
        for (int x = 0; x < field.length; x++) {
            for (int y = 0; y < field[x].length; y++) {
                for (int[] mine : mines) {
                    if (x == mine[0] && y == mine[1]) {
                        for (int i = 0; i < dxy[0].length; i++) {
                            if (!Objects.equals(field[x + dxy[0][i]][y + dxy[1][i]], "*"))
                                field[x + dxy[0][i]][y + dxy[1][i]] =
                                    String.valueOf(Integer.parseInt(field[x + dxy[0][i]][y + dxy[1][i]]) + 1);
                            }
                        field[x][y] = "*";
                    }
                }
            }

        }
        printArr(field);
    }
    private static void printArr(String[][] field) {
        for (int i = 1; i < field.length - 1; i++) {  //идём по строкам
            for (int j = 1; j < field[i].length - 1; j++) { //идём по столбцам
                System.out.print(field[i][j] + " "); //вывод элемента
            }
            System.out.println();
        }
    }
}
