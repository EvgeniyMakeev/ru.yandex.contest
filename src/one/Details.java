package one;

import java.util.Scanner;

/**
 * Имеется N кг металлического сплава. Из него изготавливают заготовки массой K кг каждая.
 * После этого из каждой заготовки вытачиваются детали массой M кг каждая
 * (из каждой заготовки вытачивают максимально возможное количество деталей).
 * Если от заготовок после этого что-то остается, то этот материал возвращают
 * к началу производственного цикла и сплавляют с тем, что осталось при изготовлении заготовок.
 * Если того сплава, который получился, достаточно для изготовления хотя бы одной заготовки,
 * то из него снова изготавливают заготовки, из них – детали и т.д. Напишите программу,
 * которая вычислит, какое количество деталей может быть получено по этой технологии из имеющихся исходно N кг сплава.
 *
 * Формат ввода
 * Вводятся N, K, M. Все числа натуральные и не превосходят 200.
 *
 * Формат вывода
 * Выведите одно число — количество деталей, которое может получиться по такой технологии.
 */

public class Details {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int k = scan.nextInt();
        int m = scan.nextInt();

        System.out.println(howManyDetails(n, k, m));

        scan.close();
    }

    public static int howManyDetails(int n, int k, int m) {
        int result = 0;
        int kilogramLeft = n;
        while (kilogramLeft >= k) {
            int countOfBlanks =  kilogramLeft / k;
            int countOfDetails = k / m;
            result += countOfDetails * countOfBlanks;
            kilogramLeft = (kilogramLeft % (k * countOfBlanks)) + ((k % m) * countOfBlanks);
        }
        return result;
    }
}

// не проходит по времени