package school2024.contest_1;

import java.util.Scanner;

/**
 * Зимние каникулы... Чудесное время, полное ощущения волшебства,
 * веселых игр на улице в снегу и прочих детских радостей.
 * Но не для Васи. Вася — стартапер. И вот его осенила новая идея — сделать собственный клавиатурный тренажер!
 *
 * Сел Вася и принялся писать код.
 *
 * Дни и ночи напролет Вася усердно трудился.
 * И вот, прототип уже почти дописан, за исключением одной маленькой детали.
 *
 * Тренажер представляет из себя серию заданий: запрос к пользователю набрать некоторую строку a.
 *
 * После этого пользователь должен как можно быстрее набрать на экране строку a,
 * используя только латинские буквы и клавиши управления.
 *
 * Вася решил записывать все нажатия клавиш пользователя в отдельный лог.
 * В нем присутствуют маленькие латинские буквы а также управляющие конструкции
 *
 * <delete> Удаление символа после текущей позиции курсора.
 * <bspace> Удаление символа перед текущей позицией курсора.
 * <left> Курсор перемещается влево на один символ.
 * <right> Курсор перемещается вправо на один символ.
 * Если управляющая конструкция перемещает курсор за границы текущей строки
 * или пытается удалить несуществующий символ, то ничего не происходит.
 *
 * Теперь у Васи есть строчка, которую должен был набрать пользователь,
 * и последовательность нажатий клавиш, считанная из лога. Помогите Васе выяснить, справился ли пользователь с заданием!
 *
 * Формат ввода
 * Даны две строки a и b, разделённые переводом строки, — задание пользователя
 * и последовательность нажатий клавиш (1 ≤ |a|, |b| ≤ 1000).
 *
 * Формат вывода
 * Если пользователь справился с заданием, выведите "Yes" (без кавычек),
 * в противном случае выведите "No".
 */

public class BCheckingThePrint {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.nextLine();
        String b = scan.nextLine();
        scan.close();
        String answer = "No";
        int bLength = b.length();
        if (bLength >= a.length()) {
            StringBuilder typedString = new StringBuilder();
            int cursorPosition = 0;
            String delete = "<delete>";
            String bspace = "<bspace>";
            String left = "<left>";
            String right = "<right>";

            for (int i = 0; i < b.length(); i++) {
                char currentChar = b.charAt(i);

                if (Character.isLetter(currentChar)) {
                    if (cursorPosition < typedString.length()) {
                        typedString.insert(cursorPosition, currentChar);
                    } else {
                        typedString.append(currentChar);
                    }
                    cursorPosition++;
                } else if (b.startsWith(delete, i)) {
                    if (cursorPosition < typedString.length()) {
                        typedString.deleteCharAt(cursorPosition);
                    }
                    i += delete.length() - 1;
                } else if (b.startsWith(bspace, i)) {
                    if (cursorPosition > 0) {
                        typedString.deleteCharAt(cursorPosition - 1);
                        cursorPosition--;
                    }
                    i += bspace.length() - 1;
                } else if (b.startsWith(left, i)) {
                    if (cursorPosition > 0) {
                        cursorPosition--;
                    }
                    i += left.length() - 1;
                } else if (b.startsWith(right, i)) {
                    if (cursorPosition < typedString.length()) {
                        cursorPosition++;
                    }
                    i += right.length() - 1;
                }
            }
            if (typedString.toString().equals(a)) {
                answer = "Yes";
            }
        }
        System.out.println(answer);
    }
}