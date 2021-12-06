// http://www.usaco.org/index.php?page=viewproblem2&cpid=617

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

        // x
        int[] colSum = new int[B];
        for (int r = 0; r < B; r++) {
            for (int c = 0; c < B; c++) {
                if (grid[r][c]) colSum[c]++;
            }
        }
        int a = findMinA(colSum, B);

        // y
        int[] rowSum = new int[B];
        for (int i = 0; i < B; i++) {
            boolean[] row = grid[i];
            for (boolean x : row) {
                if (x) rowSum[i]++;
            }
        }
        int b = findMinA(rowSum, B);

        // System.out.println(a);
        // System.out.println(b);

        int sum1 = sumQuadrant(grid, a, b, B, 1);
        int sum2 = sumQuadrant(grid, a, b, B, 2);
        int sum3 = sumQuadrant(grid, a, b, B, 3);
        int sum4 = sumQuadrant(grid, a, b, B, 4);

        int M = Math.max(Math.max(sum1, sum2), Math.max(sum3, sum4));
        out.println(M);

        sc.close();
        out.close();
    }

    public static int sumSubArray(int[] arr, int j, int k) {
        int sum = 0;
        for (int i = j; i < k; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static int findMinA(int[] rowSum, int B) {
        int a = B;
        int minDiff = 100000;
        for (int i = 0; i < B; i += 2) {
            int sideDiff = Math.abs(sumSubArray(rowSum, 0, i) - sumSubArray(rowSum, i, B));
            if (sideDiff <= minDiff) {
                a = i;
                minDiff = sideDiff;
            }
        }
        return a;
    }

    public static int sumQuadrant(boolean[][] grid, int a, int b, int B, int q) {
        switch (q) {
            case (1): //top left
                int sum1 = 0;
                for (int r = 0; r < b; r++) {
                    for (int c = 0; c < a; c++) {
                        if (grid[r][c]) sum1++;
                    }
                }
                return sum1;
            case (2): //top right
                int sum2 = 0;
                for (int r = 0; r < b; r++) {
                    for (int c = a; c < B; c++) {
                        if (grid[r][c]) sum2++;
                    }
                }
                return sum2;
            case (3): //bottom left
                int sum3 = 0;
                for (int r = b; r < B; r++) {
                    for (int c = 0; c < a; c++) {
                        if (grid[r][c]) sum3++;
                    }
                }
                return sum3;

            case (4): //bottom right
                int sum4 = 0;
                for (int r = b; r < B; r++) {
                    for (int c = a; c < B; c++) {
                        if (grid[r][c]) sum4++;
                    }
                }
                return sum4;
        }
        return 0;
    }


}
