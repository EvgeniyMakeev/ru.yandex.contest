package algorithm_training_5.lesson_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * Вася и Маша участвуют в субботнике и красят стволы деревьев в белый цвет.
 * Деревья растут вдоль улицы через равные промежутки в 1 метр.
 * Одно из деревьев обозначено числом ноль,
 * деревья по одну сторону занумерованы положительными числами 1,2
 * и т.д., а в другую — отрицательными −1, −2 и т.д.
 * Ведро с краской для Васи установили возле дерева P, а для Маши — возле дерева Q.
 * Ведра с краской очень тяжелые и Вася с Машей не могут их переставить,
 * поэтому они окунают кисть в ведро и уже с этой кистью идут красить дерево.
 * Краска на кисти из ведра Васи засыхает, когда он удаляется от ведра более чем на V метров,
 * z из ведра Маши — на M метров. Определите, сколько деревьев может быть покрашено.
 */

public class APaintingTrees {
    public static void main(String[] args) {
        int[] vasyaRange = new int[2];
        int[] mashaRange = new int[2];
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String s = bufferedReader.readLine();
            String[] s2 = s.split(" ");
            vasyaRange[0] = Integer.parseInt(s2[0]);
            vasyaRange[1]  = Integer.parseInt(s2[1]);
            String s3 = bufferedReader.readLine();
            String[] s4 = s3.split(" ");
            mashaRange[0] = Integer.parseInt(s4[0]);
            mashaRange[1]  = Integer.parseInt(s4[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }

        int vasyasTrees = (vasyaRange[1] * 2) + 1;
        int mashasTrees = (mashaRange[1] * 2) + 1;
        int total = vasyasTrees + mashasTrees;
        int min = Math.min((vasyaRange[0] - vasyaRange[1]), (mashaRange[0] - mashaRange[1]));
        int max = Math.max((vasyaRange[0] + vasyaRange[1]), (mashaRange[0] + mashaRange[1]));

        int result = Math.min(total, (max - min) + 1);

        System.out.println(result);
    }
}
