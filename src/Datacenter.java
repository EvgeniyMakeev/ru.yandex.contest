import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Datacenter {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("input.txt"));
        int n = input.nextInt();
        int m = input.nextInt();
        int q = input.nextInt();
        List<String> listQ = new ArrayList<>();
        for (int i = 0; i <= q; i++) {
            listQ.add(input.nextLine());
        }
        listQ.remove(0);
        input.close();
        answer(n, m, q, listQ);
    }
    private static void answer(int n, int m, int q, List<String> listQ) {
        boolean[][] servers = new boolean[n][m];
        int[] reset = new int[n];
        for (boolean[] booleans : servers) {
            Arrays.fill(booleans, true);
        }
        int max = 0;
        int min = n;
        int indexMax = 0;
        int indexMin = 0;
        for (int i = 0; i < q; i++) {
            String[] lineArr = listQ.get(i).split(" ");
            if (Objects.equals(lineArr[0], "DISABLE")) {
                servers[Integer.parseInt(lineArr[1]) - 1][Integer.parseInt(lineArr[2]) - 1] = false;
            }
            if (Objects.equals(lineArr[0], "RESET")) {
                int x = Integer.parseInt(lineArr[1]) - 1;
                reset[x] += 1;
                for (int j = 0; j < m; j++) {
                    servers[x][j] = true;
                }
            }
            if (Objects.equals(lineArr[0], "GETMAX")) {
                System.out.println(Arrays.deepToString(servers));
                System.out.println(Arrays.toString(reset));
                for (int d = n - 1; d >= 0; d--) {
                    int server = 0;
                    for (int s = 0; s < m; s++) {
                        if (servers[d][s]) {
                            server++;
                        }
                    }
                    int maxS = reset[d] > 0 ? server * reset[d] : server;
                    if (max <= maxS) {
                        max = maxS;
                        indexMax = d;
                    }
                }
                System.out.println(indexMax + 1);
            }
            if (Objects.equals(lineArr[0], "GETMIN")) {
                System.out.println(Arrays.deepToString(servers));
                System.out.println(Arrays.toString(reset));
                for (int d = n - 1; d >= 0; d--) {
                    int server = m;
                    for (int s = 0; s < m; s++) {
                        if (!servers[d][s]) {
                            server--;
                        }
                    }
                    int minS = reset[d] > 0 ? server * reset[d] : server;
                    if (min >= minS) {
                        min = minS;
                        indexMin = d;
                    }
                }
                System.out.println(indexMin + 1);
            }
        }
    }
}
