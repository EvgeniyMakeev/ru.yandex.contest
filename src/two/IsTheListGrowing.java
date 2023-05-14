package two;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Дан список. Определите, является ли он монотонно возрастающим
 * (то есть верно ли, что каждый элемент этого списка больше предыдущего).
 *
 * Выведите YES, если массив монотонно возрастает и NO в противном случае.
 */

public class IsTheListGrowing {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        List<Integer> numbers = new ArrayList<>();
        while (scan.hasNextInt()) {
            numbers.add(scan.nextInt());
        }


        scan.close();

        System.out.println(isTheListGrowing(numbers));
    }

    public static String isTheListGrowing(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) <= numbers.get(i - 1)) {
                return "NO";
            }
        }
        return "YES";
    }
}
