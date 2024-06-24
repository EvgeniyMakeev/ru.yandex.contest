package algorithm_training_5.lesson_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BAnagram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine();
        String s2 = scan.nextLine();
        scan.close();

        int s1Length = s1.length();
        int s2Length = s2.length();
        String result = "NO";

        if (s1Length != s2Length) {
            System.out.println(result);
        } else {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s1Length; i++) {
                Character key = s1.charAt(i);
                if (map.containsKey(s1.charAt(i))) {
                    Integer value = map.get(key);
                    map.replace(key, value, value + 1);
                } else {
                    map.put(key, 1);
                }
            }
            for (int i = 0; i < s2Length; i++) {
                Character key = s2.charAt(i);
                if (map.containsKey(s2.charAt(i))) {
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
