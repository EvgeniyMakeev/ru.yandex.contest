package belgrad;

/**
 * Дано целое число n. Требуется вывести все правильные скобочные последовательности длины 2 ⋅ n,
 * упорядоченные лексикографически (см. https://ru.wikipedia.org/wiki/Лексикографический_порядок).
 *
 * В задаче используются только круглые скобки.
 *
 * Желательно получить решение, которое работает за время,
 * пропорциональное общему количеству правильных скобочных последовательностей в ответе,
 * и при этом использует объём памяти, пропорциональный n.
 */

import java.util.Scanner;

public class Bracket {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        brackets(n, "", 0, 0);
    }

    private static void brackets(int count, String s, int left, int right) {
        if (left == count && right == count) {
            System.out.println(s);
        } else {
            if (left < count) {
                brackets(count, s + "(", left + 1, right);
            }
            if (right < left) {
                brackets(count, s + ")", left, right + 1);
            }
        }
    }
}