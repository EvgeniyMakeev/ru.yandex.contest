package intern_backend_meetup_2024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
    public static void main(String[] args){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String s = bufferedReader.readLine();
            bufferedReader.close();
            String[] s2 = s.split(" ");
            int x1 = Integer.parseInt(s2[0]);
            int x2 = Integer.parseInt(s2[1]);
            System.out.println(x1+x2);
        } catch (IOException e) {
            e.printStackTrace();
        }}
}
