package algorithm_training_5.lesson_3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


/**
 Дан массив a из n чисел. Найдите минимальное количество чисел,
 после удаления которых попарная разность оставшихся чисел по модулю не будет превышать 1,
 то есть после удаления ни одно число не должно отличаться от какого-либо другого более чем на 1.
 Формат ввода
 Первая строка содержит одно целое число n(1≤n≤2⋅105) — количество элементов массива a.
 Вторая строка содержит n целых чисел a1,a2,…,an(0≤ai≤105) — элементы массива a.

 Формат вывода
 Выведите одно число — ответ на задачу.
 */

//TL

public class CRemovingNumbers {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int countOfNumber = scanner.nextInt();
            int key;
            int minNumbersForDelete = countOfNumber;
            int maxCount = 0;
            int temp;
            Map<Integer, Integer> numbers = new HashMap<>();
            for (int i = 0; i < countOfNumber; i++) {
                key = scanner.nextInt();
                if (numbers.containsKey(key)) {
                    Integer value = numbers.get(key);
                    numbers.replace(key, value, value + 1);
                } else {
                    numbers.put(key, 1);
                }
            }

            for (int i : numbers.keySet()) {
                if (numbers.containsKey(i - 1)) {
                    temp = numbers.get(i - 1);
                    if (numbers.get(i) + temp > maxCount) {
                        maxCount = numbers.get(i) + temp;
                    }
                } else {
                    if (numbers.get(i) > maxCount) {
                        maxCount = numbers.get(i);
                    }
                }
            }
            System.out.println(minNumbersForDelete - maxCount);
        }
    }
}