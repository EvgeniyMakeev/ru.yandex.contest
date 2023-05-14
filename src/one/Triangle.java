package one;

import java.util.Scanner;

/**Даны три натуральных числа. Возможно ли построить треугольник с такими сторонами.
 * Если это возможно, выведите строку YES, иначе выведите строку NO.

 Треугольник — это три точки, не лежащие на одной прямой.

 Формат ввода
 Вводятся три натуральных числа.

 Формат вывода
 Выведите ответ на задачу.
 **/

public class Triangle {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        doesTheTriangleExist(a, b, c);
        
        scan.close();
    }
    
    public static void doesTheTriangleExist(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            System.out.println("NO");
        } else {
            System.out.println(a + b <= c || a + c <= b || b + c <= a ? "NO" : "YES");
        }
    }
}
