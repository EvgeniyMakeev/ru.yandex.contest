package algorithm_training_5.lesson_2;

import java.util.Scanner;


/**
 * Недавно один известный художник-абстракционист произвел на свет новый шедевр —
 * картину «Два черных непересекающихся прямоугольника».
 * Картина представляет собой прямоугольник m× n, разбитый на квадраты 1× 1,
 * некоторые из которых закрашены любимым цветом автора — черным.
 * Федя — не любитель абстрактных картин, однако ему стало интересно,
 * действительно ли на картине изображены два непересекающихся прямоугольника.
 * Помогите ему это узнать. Прямоугольники не пересекаются в том смысле,
 * что они не имеют общих клеток.
 *
 * Формат ввода
 * Первая строка входного файла содержит числа m и n (1 ≤ m, n ≤ 200).
 * Следующие m строк содержат описание рисунка.
 * Каждая строка содержит ровно n символов.
 * Символ «.» обозначает пустой квадрат, а символ «#» — закрашенный.
 *
 * Формат вывода
 * Если рисунок можно представить как два непересекающихся прямоугольника,
 * выведите в первой строке «YES», а в следующих m строках выведите рисунок в том же виде,
 * в каком он задан во входном файле, заменив квадраты,
 * соответствующие первому прямоугольнику на символ «a», а второму — на символ «b».
 * Если решений несколько, выведите любое.
 *
 * Если же этого сделать нельзя, выведите в выходной файл «NO».
 */

//WA

public class JTwoRectangles {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int high = scanner.nextInt();
            int length = scanner.nextInt();
            char[][] art = new char[high][length];
            int filledCells = 0;
            int inRowWithA = 0;
            int inColonWithA = 0;
            int iA = -1;
            int jA = -1;
            for (int i = 0; i < high; i++) {
                art[i] = scanner.next().toCharArray();
                for (int j = 0; j < length; j++) {
                    if (art[i][j] == '#') {
                        if (filledCells == 0) {
                            art[i][j] = 'a';
                            iA = i;
                            jA = j;
                        } else {
                            art[i][j] = 'b';
                            if (i == iA) {
                                inRowWithA++;
                            }
                            if (j == jA) {
                                inColonWithA++;
                            }
                        }
                        filledCells++;
                    }
                }
            }
            if (filledCells < 2) {
                System.out.println("NO");
            } else if (filledCells == 2){
                System.out.println("YES");
                printArr(art);
            } else if (inColonWithA >= 1 && inRowWithA >= 1) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                if (inColonWithA < filledCells - 1) {
                    for (int i = iA + 1; i < high; i++) {
                        if (art[i][jA] == 'b') {
                            art[i][jA] = 'a';
                        }
                    }
                    printArr(art);
                } else if (inRowWithA < filledCells - 1){
                    for (int j = jA + 1; j < length; j++) {
                        if (art[iA][j] == 'b') {
                            art[iA][j] = 'a';
                        }
                    }
                    printArr(art);
                } else {
                    printArr(art);
                }
            }
        }
    }
    private static void printArr(char[][] art) {
        for (int i = 0; i < art.length; i++) {
            for (int j = 0; j < art[i].length; j++) {
                System.out.print(art[i][j]);
            }
            System.out.println();
        }
    }
}
