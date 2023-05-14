package one;

/**
 * Телефонные номера в адресной книге мобильного телефона имеют один из следующих форматов:
 * +7<код><номер>, 8<код><номер>, <номер>, где <номер> — это семь цифр,
 * а <код> — это три цифры или три цифры в круглых скобках. Если код не указан, то считается,
 * что он равен 495. Кроме того, в записи телефонного номера может стоять знак “-”
 * между любыми двумя цифрами (см. пример). На данный момент в адресной книге телефона Васи
 * записано всего три телефонных номера, и он хочет записать туда еще один. Но он не может понять,
 * не записан ли уже такой номер в телефонной книге. Помогите ему! Два телефонных номера совпадают,
 * если у них равны коды и равны номера.
 * Например, +7(916)0123456 и 89160123456 — это один и тот же номер.
 */

import java.util.*;

public class PhoneNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String wantAddNumber = scan.nextLine();
        String have1 = scan.nextLine();
        String have2 = scan.nextLine();
        String have3 = scan.nextLine();

        scan.close();

        List<Integer> listWantAddNumber = new ArrayList<>();
        for (int i = wantAddNumber.length() - 1 ; i >= 0; i--) {
            if (Character.isDigit(wantAddNumber.charAt(i))) {
                listWantAddNumber.add(Integer.valueOf(String.valueOf(wantAddNumber.charAt(i))));
            }
        }
        if (listWantAddNumber.size() < 8){
            listWantAddNumber.add(5);
            listWantAddNumber.add(9);
            listWantAddNumber.add(4);
        }

        System.out.println(haveOrNot(listWantAddNumber, have1));
        System.out.println(haveOrNot(listWantAddNumber, have2));
        System.out.println(haveOrNot(listWantAddNumber, have3));
    }

    private static String haveOrNot(List<Integer> wantAdd, String have) {
        List<Integer> haveNumber = new ArrayList<>();
        for (int i = have.length() - 1 ; i >= 0; i--) {
            if (Character.isDigit(have.charAt(i))) {
                haveNumber.add(Integer.valueOf(String.valueOf(have.charAt(i))));
            }
        }
        if (haveNumber.size() < 8){
            haveNumber.add(5);
            haveNumber.add(9);
            haveNumber.add(4);
        }

        int count = 0;
        while (count < Math.min(haveNumber.size(), wantAdd.size()) && count < 10) {
            if (wantAdd.get(count) != haveNumber.get(count)) {
                return "NO";
            } else {
                count++;
            }
        }
        return "YES";
    }
}