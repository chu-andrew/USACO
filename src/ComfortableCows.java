// http://www.usaco.org/index.php?page=viewproblem2&cpid=1110

// unsolved

import java.util.Scanner;

public class ComfortableCows {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] cows = new int[n][2];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            cows[i] = new int[]{x, y};
            System.out.println(check(cows));
        }
        sc.close();

    }

    public static int check(int[][] cows) {
        int comfortable = 0;
        for (int i = 0; i < cows.length; i++) {
            int adjacent = 0;
            int x = cows[i][0];
            int y = cows[i][1];

            for (int j = i + 1; j < cows.length; j++) {
                if (cows[j][0] == x) {
                    if (cows[j][1] == y + 1 || cows[j][1] == y - 1) {
                        adjacent++;
                    }
                }
                if (cows[j][1] == y) {
                    if (cows[j][0] == x + 1 || cows[j][0] == x - 1) {
                        adjacent++;
                    }
                }
            }
            if (adjacent == 3) comfortable++;
        }
        return comfortable;
    }
}