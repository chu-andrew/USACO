// http://www.usaco.org/index.php?page=viewproblem2&cpid=784

import java.io.*;
import java.util.Scanner;

public class Lifeguard {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("lifeguards.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));

        int N = sc.nextInt();

        int[][] shifts = new int[N][2];
        for (int i = 0; i < N; i++) {
            shifts[i][0] = sc.nextInt();
            shifts[i][1] = sc.nextInt();
        }
        // System.out.println(Arrays.deepToString(shifts));

        int maxCovered = 0;
        for (int skip = 0; skip < N; skip++) {
            boolean[] covered = new boolean[1000];
            for (int shift = 0; shift < N; shift++) {
                if (shift != skip) {
                    for (int time = shifts[shift][0]; time < shifts[shift][1]; time++) {
                        covered[time] = true;
                    }
                }
            }
            int sum = 0;
            for (boolean b : covered) {
                if (b) sum++;
            }
            maxCovered = Math.max(sum, maxCovered);
        }

        out.println(maxCovered);

        sc.close();
        out.close();
    }
}
