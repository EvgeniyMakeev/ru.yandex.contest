package contest4.warm_up;

/*
- В сторону точки начала координат или от неё.
При этом из точки начала координат разрешено двигаться в любом направлении.
- Вдоль окружности с центром в начале координат и радиусом,
который равен текущему расстоянию до начала координат.

Двигаться вдоль такой окружности разрешается в любом направлении (по или против часовой стрелки).
Вам, как ведущему программисту ответственной инстанции поручено разработать модуль,
который будет определять кратчайший путь из точки A, с координатами (xA, yA)
в точку B с координатами (xB, yB). Считайте, что менять направление движения
можно произвольное количество раз, но оно должно всегда соответствовать
одному из двух описанных выше вариантов.
 */

import java.util.Scanner;

public class Navigator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x1 = input.nextInt();
        int y1 = input.nextInt();
        int x2 = input.nextInt();
        int y2 = input.nextInt();
        input.close();



    }
}
