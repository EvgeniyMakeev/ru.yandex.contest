package algorithm_training_5.lesson_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * С целью экономии чернил в картридже принтера было принято решение укоротить некоторые слова в тексте.
 * Для этого был составлен словарь слов, до которых можно сокращать более длинные слова.
 * Слово из текста можно сократить, если в словаре найдется слово, являющееся началом слова из текста.
 * Например, если в списке есть слово "лом", то слова из текста "ломбард", "ломоносов" и другие слова,
 * начинающиеся на "лом", можно сократить до "лом".
 *
 * Если слово из текста можно сократить до нескольких слов из словаря,
 * то следует сокращать его до самого короткого слова.
 *
 * Формат ввода
 * В первой строке через пробел вводятся слова из словаря, слова состоят из маленьких латинских букв.
 * Гарантируется, что словарь не пуст и количество слов в словаре не превышет 1000,
 * а длина слов — 100 символов.
 *
 * Во второй строке через пробел вводятся слова текста (они также состоят только из маленьких латинских букв).
 * Количество слов в тексте не превосходит 105, а суммарное количество букв в них — 106.
 *
 * Формат вывода
 * Выведите текст, в котором осуществлены замены.
 */

//WA

public class FReplacingWords {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String str1 = bufferedReader.readLine();
            String[] sArr1 = str1.split(" ");
            Map<Character, String> dictionary = new HashMap<>();
            char key;
            for (String s : sArr1) {
                key = s.charAt(0);
                if (dictionary.containsKey(key)) {
                    if (s.length() < dictionary.get(key).length()
                            || dictionary.get(key).startsWith(s)) {
                        dictionary.put(key,s);
                    }
                } else {
                    dictionary.put(key,s);
                }
            }
            String str2 = bufferedReader.readLine();
            String[] sArr2 = str2.split(" ");
            for (String s : sArr2) {
                key = s.charAt(0);
                if (dictionary.containsKey(key)) {
                    if (s.length() == 1) {
                        System.out.print(s + " ");
                    } else if (s.startsWith(dictionary.get(key))) {
                        System.out.print(dictionary.get(key) + " ");
                    } else {
                        System.out.print(s + " ");
                    }
                } else {
                    System.out.print(s + " ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
