// http://www.usaco.org/index.php?page=viewproblem2&cpid=568

import java.io.*;
import java.util.Scanner;

public class SpeedingTicket {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("speeding.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] road = new int[100];
        int[] cow = new int[100];

        int mile = 0;
        for (int i = 0; i < n; i++) {
            int length = sc.nextInt();
            int speed = sc.nextInt();

            for (int j = 0; j < length; j++) {
                road[mile] = speed;
                mile++;
            }
        }

        mile = 0;
        for (int i = 0; i < m; i++) {
            int length = sc.nextInt();
            int speed = sc.nextInt();

            for (int j = 0; j < length; j++) {
                cow[mile] = speed;
                mile++;
            }
        }

        int max = cow[0] - road[0];
        for (int i = 0; i < 100; i++) {
            if (cow[i] - road[i] > max) {
                max = cow[i] - road[i];
            }
        }
        if (max < 0) max = 0;
        out.println(max);

        sc.close();
        out.close();
    }
}
