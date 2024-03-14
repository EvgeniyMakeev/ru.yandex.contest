package belgrad;

/**
 * Даны две строки, состоящие из строчных латинских букв.
 * Требуется определить, являются ли эти строки анаграммами,
 * т. е. отличаются ли они только порядком следования символов.
 */

import java.util.*;

public class Four {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String j = scan.nextLine();
        String s = scan.nextLine();
        scan.close();
        System.out.println(isAnagram(j,s));
    }

    private static int isAnagram(String j, String s) {
        if (j.length() == s.length()) {
            Map<Character, Integer> mapJ = new HashMap<>();
            for (int i = 0; i < j.length(); i++) {
                if (!mapJ.containsKey(j.charAt(i))) {
                mapJ.put(j.charAt(i),1);
                } else {
                    mapJ.put(j.charAt(i),mapJ.get(j.charAt(i)) + 1);
                }
            }
            Map<Character, Integer> mapS = new HashMap<>();
            for (int i = 0; i < j.length(); i++) {
                if (!mapS.containsKey(s.charAt(i))) {
                    mapS.put(s.charAt(i),1);
                } else {
                    mapS.put(s.charAt(i),mapS.get(s.charAt(i)) + 1);
                }
            }
            return mapJ.equals(mapS) ? 1 : 0;
        } else {
            return 0;
        }
    }
}
