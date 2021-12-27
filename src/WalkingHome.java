// 2021 december USACO bronze in contest

import java.util.Arrays;
import java.util.Scanner;

public class WalkingHome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

            boolean[][] grid = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String s = sc.next();
                for (int j = 0; j < N; j++) {
                    grid[i][j] = s.charAt(j) == '.';
                }
            }

            // System.out.println(Arrays.deepToString(grid));

            if (K == 1) System.out.println(k1(N, grid));
            if (K == 2) System.out.println(k2(N, grid));
            if (K == 3) System.out.println(k3(N, grid));
        }


        sc.close();
    }

    public static int k1(int N, boolean[][] grid) {
        int sum = 0;

        for (int i = 0; i < 2; i++) {
            boolean down;
            down = i == 0;

            for (int turn = 1; turn < (N - 1) * 2; turn++) {
                int x = 0;
                int y = 0;
                for (int j = 0; j < (N - 1) * 2; j++) {
                    if (j == turn) down = !down;
                    if (down) {
                        if (y + 1 >= N) break;
                        else if (grid[x][y + 1]) {
                            y++;
                        }
                    }
                    if (!down) {
                        if (x + 1 >= N) break;
                        else if (grid[x + 1][y]) {
                            x++;
                        }
                    }
                    if (x == N - 1 && y == N - 1) {
                        sum++;
                    }
                }
            }
        }
        return sum;
    }

    public static int k2(int N, boolean[][] grid) {
        int sum = 0;

        for (int i = 0; i < 2; i++) {
            boolean down;
            down = i == 0;

            for (int turn = 1; turn < (N - 1) * 2; turn++) {
                for (int turn2 = turn + 1; turn2 < (N - 1) * 2; turn2++) {

                    int x = 0;
                    int y = 0;
                    for (int j = 0; j < (N - 1) * 2; j++) {
                        if (j == turn || j == turn2) down = !down;
                        if (down) {
                            if (y + 1 >= N) break;
                            else if (grid[x][y + 1]) {
                                y++;
                            }
                        }
                        if (!down) {
                            if (x + 1 >= N) break;
                            else if (grid[x + 1][y]) {
                                x++;
                            }
                        }
                        if (x == N - 1 && y == N - 1) {
                            sum++;
                        }
                    }
                }
            }
        }
        return sum;
    }

    public static int k3(int N, boolean[][] grid) {
        int sum = 0;

        for (int i = 0; i < 2; i++) {
            boolean down;
            down = i == 0;

            for (int turn = 1; turn < (N - 1) * 2; turn++) {
                for (int turn2 = turn + 1; turn2 < (N - 1) * 2; turn2++) {
                    for (int turn3 = turn2 + 1; turn3 < (N - 1) * 2; turn3++) {

                        int x = 0;
                        int y = 0;
                        for (int j = 0; j < (N - 1) * 2; j++) {
                            if (j == turn || j == turn2 || j == turn3) down = !down;
                            if (down) {
                                if (y + 1 >= N) break;
                                else if (grid[x][y + 1]) {
                                    y++;
                                }
                            }
                            if (!down) {
                                if (x + 1 >= N) break;
                                else if (grid[x + 1][y]) {
                                    x++;
                                }
                            }
                            if (x == N - 1 && y == N - 1) {
                                sum++;
                            }
                        }
                    }
                }
            }
        }
        return sum;
    }

}
