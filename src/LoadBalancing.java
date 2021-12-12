// http://www.usaco.org/index.php?page=viewproblem2&cpid=617

// unsolved

import java.io.*;
import java.util.Scanner;

public class LoadBalancing {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("balancing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));

        int N = sc.nextInt();
        int B = sc.nextInt() + 2;
        boolean[][] grid = new boolean[B][B];
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            grid[x][y] = true;
        }

        //TODO try to optimize time by checking biggest area of grid first, then smaller ones when passed

        int M = N + 1;
        for (int a = 0; a < B; a += 2) {
            for (int b = 0; b < B; b += 2) {
                //top left
                int q1 = 0;
                for (int r = 1; r < b; r += 2) {
                    for (int c = 1; c < a; c += 2) {
                        if (grid[r][c]) q1++;
                    }
                }
                if (q1 > M) continue;

                //top right
                int q2 = 0;
                for (int r = 1; r < b; r += 2) {
                    for (int c = a + 1; c < B; c += 2) {
                        if (grid[r][c]) q2++;
                    }
                }
                if (q2 > M) continue;

                //bottom left
                int q3 = 0;
                for (int r = b + 1; r < B; r += 2) {
                    for (int c = 1; c < a; c += 2) {
                        if (grid[r][c]) q3++;
                    }
                }
                if (q3 > M) continue;

                //bottom right
                int q4 = 0;
                for (int r = b + 1; r < B; r += 2) {
                    for (int c = a + 1; c < B; c += 2) {
                        if (grid[r][c]) q4++;
                    }
                }
                if (q4 > M) continue;

                // System.out.printf("a:%d, b:%d, q: %d,%d,%d,%d%n", a, b, q1, q2, q3, q4);
                int maxM = Math.max(Math.max(q1, q2), Math.max(q3, q4));
                M = Math.min(maxM, M);
            }
        }

        out.println(M);

        sc.close();
        out.close();
    }
    /*
    public static int sumQuadrant(boolean[][] grid, int a, int b, int B, int q) {
        switch (q) {
            case (1): //top left
                int sum1 = 0;
                for (int r = 1; r < b; r += 2) {
                    for (int c = 1; c < a; c += 2) {
                        if (grid[r][c]) sum1++;
                    }
                }
                return sum1;
            case (2): //top right
                int sum2 = 0;
                for (int r = 1; r < b; r += 2) {
                    for (int c = a + 1; c < B; c += 2) {
                        if (grid[r][c]) sum2++;
                    }
                }
                return sum2;
            case (3): //bottom left
                int sum3 = 0;
                for (int r = b + 1; r < B; r += 2) {
                    for (int c = 1; c < a; c += 2) {
                        if (grid[r][c]) sum3++;
                    }
                }
                return sum3;

            case (4): //bottom right
                int sum4 = 0;
                for (int r = b + 1; r < B; r += 2) {
                    for (int c = a + 1; c < B; c += 2) {
                        if (grid[r][c]) sum4++;
                    }
                }
                return sum4;
        }
        return 0;
    }
    */

}
