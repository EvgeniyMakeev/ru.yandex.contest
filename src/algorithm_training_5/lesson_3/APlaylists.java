package algorithm_training_5.lesson_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 Костя успешно прошел собеседование и попал на стажировку в отдел разработки сервиса «Музыка».
 Конкретно ему поручили такое задание — научиться подбирать плейлист для группы друзей, родственников или коллег. При этом нужно подобрать такой плейлист, в который входят исключительно нравящиеся всем членам группы песни.
 Костя очень хотел выполнить это задание быстро и качественно, но у него не получается. Помогите ему написать программу, которая составляет плейлист для группы людей.

 Формат ввода
 В первой строке расположено одно натуральное число n(1≤n≤2⋅105),
 где n – количество человек в группе.
 В следующих 2⋅n строках идет описание любимых плейлистов членов группы.
 По 2 строки на каждого участника.
 В первой из этих 2-х строк расположено число ki — количество любимых треков i-го члена группы.
 В следующей строке расположено ki строк через пробел — названия любимых треков i-го участника группы.
 Каждый трек в плейлисте задан в виде строки, все строки уникальны,
 сумма длин строк не превосходит 2⋅106.
 Строки содержат большие и маленькие латинские буквы и цифры.

 Формат вывода
 Выведите количество, а затем сам список песен через пробел — список треков,
 которые нравятся каждому участнику группы.
 Ответ необходимо отсортировать в лексикографическом порядке!
 */


public class APlaylists {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            Set<String> result = new HashSet<>();
            int countOfPeople = Integer.parseInt(bufferedReader.readLine());
            for (int i = 0; i < countOfPeople; i++) {
                bufferedReader.readLine();
                if (i == 0) {
                    result.addAll(List.of(bufferedReader.readLine().split(" ")));
                } else {
                    result.retainAll(List.of(bufferedReader.readLine().split(" ")));
                }
            }
            if (!result.isEmpty()) {
                System.out.println(result.size());
                result.stream()
                        .sorted()
                        .forEach(x -> System.out.print(x + " "));
            } else {
                System.out.println(0);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}