package one;

import java.util.Scanner;

/**
 * Бригада скорой помощи выехала по вызову в один из отделенных районов.
 * К сожалению, когда диспетчер получил вызов,
 * он успел записать только адрес дома и номер квартиры K1,
 * а затем связь прервалась. Однако он вспомнил,
 * что по этому же адресу дома некоторое время назад скорая помощь выезжала в квартиру K2,
 * которая расположена в подъезда P2 на этаже N2. Известно,
 * что в доме M этажей и количество квартир на каждой лестничной площадке одинаково.
 * Напишите программу, которая вычилсяет номер подъезда P1 и номер этажа N1 квартиры K1.
 *
 * Формат ввода
 * Во входном файле записаны пять положительных целых чисел K1, M, K2, P2, N2. Все числа не превосходят 106.
 *
 * Формат вывода
 * Выведите два числа P1 и N1. Если входные данные не позволяют однозначно определить P1 или N1,
 * вместо соответствующего числа напечатайте 0. Если входные данные противоречивы, напечатайте два числа –1 (минус один).
 */

public class Ambulance {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int flatA = scan.nextInt();
        int numberOfFloors = scan.nextInt();
        int flatB = scan.nextInt();
        int entranceB = scan.nextInt();
        int floorNumberB = scan.nextInt();

        System.out.println(whatEntranceAndFloor(flatA, numberOfFloors, flatB, entranceB, floorNumberB));

        scan.close();
    }

    public static String whatEntranceAndFloor(int flatA, int numberOfFloors, int flatB, int entranceB, int floorNumberB) {
        if (floorNumberB < 1 || entranceB < 1) {
            if (entranceB != (floorNumberB / numberOfFloors) + 1) {
                return "-1" + "-1";
            } else {
                return "-1" + "0";
            }
        }

        int flatsOnFloor = flatB / floorNumberB;
        int floorNumberA = (flatA / flatsOnFloor) + 1;
        int entranceA = floorNumberA / numberOfFloors;
        floorNumberA = floorNumberA - (numberOfFloors * (entranceA - 1));

        System.out.println(floorNumberA);
        System.out.println(flatsOnFloor);
        System.out.println(entranceA);

//        if (((numberOfFloors * entranceB) - floorNumberB) < 1) {
//            return -1 + " " + -1;
//        }
//        int numberOfFlatOnFloor = flatB / ((numberOfFloors * entranceB) - floorNumberB);
//        int numberOfFlatsInEntrance = numberOfFloors * numberOfFlatOnFloor;
//        for (int i = 1; i <= flatA; i++) {
//            if (i % numberOfFlatsInEntrance == 0) {
//                entranceA = entranceA + 1;
//                }
//            if (floorNumberA > numberOfFloors) {
//                floorNumberA = floorNumberA - numberOfFloors;
//            }
//            if (i % numberOfFlatOnFloor == 0) {
//                floorNumberA = floorNumberA + 1;
//                }
//            }
        return entranceA + " " + floorNumberA;
    }
}
