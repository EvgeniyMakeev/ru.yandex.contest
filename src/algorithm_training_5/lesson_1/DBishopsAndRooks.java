package algorithm_training_5.lesson_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Миша сидел на занятиях математики в Высшей школе экономики и решал следующую задачу:
 * дано n целых чисел и нужно расставить между ними знаки + и × так,
 * чтобы результат полученного арифметического выражения был нечётным
 * (например, между числами 5, 7, 2, можно расставить арифметические знаки следующим образом:
 * 5×7+2=37). Так как примеры становились все больше и больше,
 * а Миша срочно убегает в гости, от вас требуется написать программу решающую данную задачу.
 */


public class DBishopsAndRooks {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int size = 8;
            char[][] table = new char[size][size];
            List<int[]> coordinatesOfR = new ArrayList<>();
            List<int[]> coordinatesOfB = new ArrayList<>();
            int totalTabs = size * size;
            int minusTabs = 0;
            for (int i = 0; i < size; i++) {
                table[i] = scanner.nextLine().toCharArray();
                for (int j = 0; j < size; j++) {
                    if (table[i][j] == 'R') {
                        coordinatesOfR.add(new int[]{i, j});
                    }
                    if (table[i][j] == 'B') {
                        coordinatesOfB.add(new int[]{i, j});
                    }
                }
            }
            if (!coordinatesOfR.isEmpty() || !coordinatesOfB.isEmpty()) {
                minusTabs += coordinatesOfB.size() + coordinatesOfR.size();
                for (int[] r : coordinatesOfR) {
                    for (int i = r[0] + 1; i < size; i++) {
                        if (table[i][r[1]] == '*') {
                            table[i][r[1]] = 'r';
                            minusTabs += 1;
                        } else if (table[i][r[1]] == 'R' || table[i][r[1]] == 'B') {
                            break;
                        }
                    }

                    for (int i = r[0] - 1; i >= 0; i--) {
                        if (table[i][r[1]] == '*') {
                            table[i][r[1]] = 'r';
                            minusTabs += 1;
                        } else if (table[i][r[1]] == 'R' || table[i][r[1]] == 'B') {
                            break;
                        }
                    }

                    for (int j = r[1] + 1; j < size; j++) {
                        if (table[r[0]][j] == '*') {
                            table[r[0]][j] = 'r';
                            minusTabs += 1;
                        } else if (table[r[0]][j] == 'R' || table[r[0]][j] == 'B') {
                            break;
                        }
                    }

                    for (int j = r[1] - 1; j >= 0; j--) {
                        if (table[r[0]][j] == '*') {
                            table[r[0]][j] = 'r';
                            minusTabs += 1;
                        } else if (table[r[0]][j] == 'R' || table[r[0]][j] == 'B') {
                            break;
                        }
                    }
                }
                for (int[] b : coordinatesOfB) {
                    //вниз вправо
                    for (int i = 1; i < Math.min((size - b[0]), (size - b[1])); i++) {
                        if (table[b[0] + i][b[1] + i] == '*') {
                            table[b[0] + i][b[1] + i] = 'b';
                            minusTabs += 1;
                        } else if (table[b[0] + i][b[1] + i] == 'R' || table[b[0] + i][b[1] + i] == 'B') {
                            break;
                        }
                        printArr(table);
                        System.out.println();
                    }
                    //вверх влево
                    for (int i = 1; i < Math.min(b[0], b[1]) + 1; i++) {
                        if (table[b[0] - i][b[1] - i] == '*') {
                            table[b[0] - i][b[1] - i] = 'b';
                            minusTabs += 1;
                        } else if (table[b[0] - i][b[1] - i] == 'R' || table[b[0] - i][b[1] - i] == 'B') {
                            break;
                        }
                        printArr(table);
                        System.out.println();
                    }

                    //вниз влево
                    for (int i = 1; i <= Math.min((size - (b[0] + 1)), b[1]); i++) {
                        if (table[b[0] + i][b[1] - i] == '*') {
                            table[b[0] + i][b[1] - i] = 'b';
                            minusTabs += 1;
                        } else if (table[b[0] + i][b[1] - i] == 'R' || table[b[0] + i][b[1] - i] == 'B') {
                            break;
                        }
                        printArr(table);
                        System.out.println();
                    }
                    //вверх право
                    for (int i = 1; i <= Math.min(b[0], (size - (b[1] + 1))); i++) {
                        if (table[b[0] - i][b[1] + i] == '*') {
                            table[b[0] - i][b[1] + i] = 'b';
                            minusTabs += 1;
                        } else if (table[b[0] - i][b[1] + i] == 'R' || table[b[0] - i][b[1] + i] == 'B') {
                            break;
                        }
                        printArr(table);
                        System.out.println();
                    }
                }
            }

            printArr(table);
            System.out.println(totalTabs - minusTabs);
        }
    }
    private static void printArr(char[][] field) {
        for (int i = 0; i < field.length; i++) {  //идём по строкам
            for (int j = 0; j < field[i].length; j++) { //идём по столбцам
                System.out.print(field[i][j] + " "); //вывод элемента
            }
            System.out.println();
        }
    }
}
