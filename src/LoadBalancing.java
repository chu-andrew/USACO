// http://www.usaco.org/index.php?page=viewproblem2&cpid=617

import java.io.*;
import java.util.Scanner;

public class LoadBalancing {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("balancing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));

        int N = sc.nextInt();
        int B = sc.nextInt() + 2;
        int[][] grid = new int[N][2];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            grid[i] = new int[]{x, y};
        }
        //System.out.println(Arrays.deepToString(grid));

        /* had to view solution to solve
        * previously had a B*B solution because two nested loops were checking every possible a,b
        * however, only had to check the a,b adjacent to the pairs of x,y
        */

        int M = N * N;
        // for (int a = 0; a < B; a += 2) {
        //    for (int b = 0; b < B; b += 2) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                int a = grid[x][0] + 1;
                int b = grid[y][1] + 1;

                int q1 = 0;
                int q2 = 0;
                int q3 = 0;
                int q4 = 0;

                for (int i = 0; i < N; i++) {
                    if (grid[i][0] < a && grid[i][1] < b) {
                        q1++;
                        if (q1 > M) break;
                    }
                    if (grid[i][0] > a && grid[i][1] < b) {
                        q2++;
                        if (q2 > M) break;
                    }
                    if (grid[i][0] < a && grid[i][1] > b) {
                        q3++;
                        if (q3 > M) break;
                    }
                    if (grid[i][0] > a && grid[i][1] > b) {
                        q4++;
                        if (q4 > M) break;

                    }
                }
                int Mi = Math.max(Math.max(q1, q2), Math.max(q3, q4));
                M = Math.min(M, Mi);
            }
        }

        out.println(M);

        sc.close();
        out.close();
    }
}
