package belgrad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arithmetics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long[][] arr = new long[n][4];
        for (int i = 0; i < n; i++) {
            long first = scan.nextInt();
            if (first == 1) {
                arr[i][0] = first;
                arr[i][1] = scan.nextLong();
                arr[i][2] = scan.nextLong();
                arr[i][3] = scan.nextLong();
            } else if (first == 2) {
                arr[i][0] = first;
                arr[i][1] = scan.nextLong();
            } else {
                arr[i][0] = first;
            }
        }

        for (long[] i : arr) {
            if (i[0] == 1) {
                Progress.addProgress(new Progress(i[1], i[2], i[3]));
            } else if (i[0] == 2) {
                Progress.removeProgress(i[1]);
            } else {
                System.out.println(Progress.getMinFirst());
            }
        }
        scan.close();
    }
}

class Progress {
    private long first;

    private long d;
    private long id;
    private static List<Progress> list = new ArrayList<>();


    public Progress(long first, long d, long id) {
        this.first = first;
        this.d = d;
        this.id = id;
    }

    public long getFirst() {
        return first;
    }

    public void setFirst(long first) {
        this.first = first;
    }

    public long getId() {
        return id;
    }

    public long getD() {
        return d;
    }


    public static void addProgress(Progress progress) {
        list.add(progress);
    }

    public static void removeProgress(long id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).id == id) {
                list.remove(i);
            }
        }
    }
    public static long getMinFirst() {
        long min = Long.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getFirst() < min) {
                min = list.get(i).getFirst();
                minIndex = i;
            } else if (list.get(i).getFirst() == min && list.get(i).getId() < list.get(minIndex).getId()) {
                minIndex = i;
            }
        }
        list.get(minIndex).setFirst(list.get(minIndex).getFirst() + list.get(minIndex).getD());
        return min;
    }
}
