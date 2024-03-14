package contest4.warm_up;

/*
Задано две строки, нужно проверить, является ли одна анаграммой другой.
Анаграммой называется строка, полученная из другой перестановкой букв.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Anagram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String j = scan.nextLine();
        String s = scan.nextLine();
        scan.close();

        int jLength = j.length();
        int sLength = s.length();
        String result = "NO";

        if (jLength != sLength) {
            System.out.println(result);
        } else {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < jLength; i++) {
                Character key = j.charAt(i);
                if (map.containsKey(j.charAt(i))) {
                    Integer value = map.get(key);
                    map.replace(key, value, value + 1);
                } else {
                    map.put(key, 1);
                }
            }
            for (int i = 0; i < sLength; i++) {
                Character key = s.charAt(i);
                if (map.containsKey(s.charAt(i))) {
                    Integer value = map.get(key);
                    if (value == 0) {
                        System.out.println(result);
                        return;
                    } else {
                        map.replace(key, value, value - 1);
                    }
                } else {
                    System.out.println(result);
                    return;
                }
            }
            result = "YES";
            System.out.println(result);
        }
    }
}
