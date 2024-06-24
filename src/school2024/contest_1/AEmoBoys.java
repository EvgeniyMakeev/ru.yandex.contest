package school2024.contest_1;

import java.util.Scanner;

/**
 * При регистрации на портале каждый эмо бой обязан придумать себе никнейм.
 * Никнейм должен быть не короче восьми символов, содержать в себе хотя бы одну цифру,
 * и хотя бы по одной заглавной и прописной английской букве.
 *
 * Формат ввода
 * Вводится никнейм — последовательность букв и цифр без пробелов.
 * Длина строки не превосходит 100 символов.
 *
 * Формат вывода
 * Выведите «YES», если ник подходит для эмо боя,
 * и «NO» — в противном случае.
 */

public class AEmoBoys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String nikName = scan.next();
        scan.close();
        int length = nikName.length();
        String answer = "NO";
        if (length >= 8) {
            boolean haveDigit = false;
            boolean haveCapitalLater = false;
            boolean haveSmallLater = false;
            for (int i = 0; i < length; i++) {
                if (!haveDigit) {
                    if (Character.isDigit(nikName.charAt(i))) {
                        haveDigit = true;
                        continue;
                    }
                }
                if (!haveCapitalLater) {
                    if (Character.isUpperCase(nikName.charAt(i))
                            && Character.isLetter(nikName.charAt(i))
                            && nikName.charAt(i) >= 'A' && nikName.charAt(i) <= 'Z') {
                        haveCapitalLater = true;
                        continue;
                    }
                }
                if (!haveSmallLater) {
                    if (Character.isLowerCase(nikName.charAt(i))
                            && Character.isLetter(nikName.charAt(i))
                            && nikName.charAt(i) >= 'a' && nikName.charAt(i) <= 'z') {
                        haveSmallLater = true;
                    }
                }
            }
            if (haveDigit && haveCapitalLater && haveSmallLater) {
                answer = "YES";
            }
        }
        System.out.println(answer);
    }
}
