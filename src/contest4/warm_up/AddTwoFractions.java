package contest4.warm_up;

// Даны две рациональные дроби: a/b и c/d. Сложите их и результат представьте в виде несократимой дроби m/n.

import java.util.Scanner;

public class AddTwoFractions {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int d = input.nextInt();
        input.close();

        int n = (a * d) + (b * c);
        int m = b * d;

        int nod = findNOD(n, m);

        System.out.println(n / nod);
        System.out.println(m / nod);

    }

    private static int findNOD(int n, int m) {
        int nod = n % m;
        if (nod == 0) {
            return m;
        } else {
            return findNOD(m, nod);
        }
    }
}
