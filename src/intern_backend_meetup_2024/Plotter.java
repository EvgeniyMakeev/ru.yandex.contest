package intern_backend_meetup_2024;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Plotter {
    public static void main(String[] args){
        int maxH = 0;
        int maxV = 0;
        int countOfCommands = 0;
        String commands = "";

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))){
            String s = bufferedReader.readLine();
            String[] s2 = s.split(" ");
            maxH = Integer.parseInt(s2[0]);
            maxV  = Integer.parseInt(s2[1]);
            s = bufferedReader.readLine();
            countOfCommands = Integer.parseInt(s);
            commands = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        int result = countOfCommands;
        Set<PointOfDraw> points = new HashSet<>();
        int xCurrent = 0;
        int yCurrent = 0;
        int xNext = 0;
        int yNext = 0;
        for (int i = 0; i < countOfCommands; i++) {
            char currentCommand = commands.charAt(i);
            switch (currentCommand) {
                case 'R' -> ++xNext;
                case 'L' -> --xNext;
                case 'U' -> ++yNext;
                case 'D' -> --yNext;
            }

            if (points.contains(new PointOfDraw(xCurrent, yCurrent))
                    && points.contains(new PointOfDraw(xCurrent, yNext))) {
                result -= 1;
                System.out.println(result);
            } else {
                points.add(new PointOfDraw(xCurrent, yNext));
            }
            xCurrent = xNext;
            yCurrent = yNext;
        }
        System.out.println(result);
    }

    public static class PointOfDraw {
        int x;
        int y;
        public PointOfDraw(int x, int y) {
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PointOfDraw that)) return false;
            return getX() == that.getX() && getY() == that.getY();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getX(), getY());
        }
    }
}
