// http://www.usaco.org/index.php?page=viewproblem2&cpid=989:wq

// unsolved

import java.io.*;
import java.util.Scanner;

public class Race {
    public static void main(String[] args) throws IOException {
        File in = new File("src//race.in");

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("src//race.out")));

        Scanner sc = new Scanner(in);
        int k = sc.nextInt();
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            out.println(race(k, x));
        }
        sc.close();
        out.close();
    }

    public static int race(int k, int x) {
        // k is total length
        // x is max final speed
        int v = 0;
        int s = 0;
        for (int t = 0; t < 10000; t++) {
            if (v < x || s + v + v + 1 < k) v++;
            else if (s + v + v + 1 > k) v--;

            s += v;
            System.out.println("time:" + t + "velocity:" + v);

            if (s > k) return t;
        }
        return -1;
    }
}
