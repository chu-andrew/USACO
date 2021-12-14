// http://www.usaco.org/index.php?page=viewproblem2&cpid=963

import java.io.*;
import java.util.Scanner;

public class Gymnastics {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("gymnastics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));

        int K = sc.nextInt();
        int N = sc.nextInt();

        int[][] rankings = new int[K][N];
        for (int k = 0; k < K; k++) {
            for (int n = 0; n < N; n++) {
                rankings[k][n] = sc.nextInt();
            }
        }
        // System.out.println(Arrays.deepToString(rankings));

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int[] relativeRankings = new int[K];

                // System.out.print((i + 1) + "," + (j + 1) + ": ");

                for (int k = 0; k < K; k++) {
                    int rankingsI = indexOf(rankings[k], i);
                    int rankingsJ = indexOf(rankings[k], j);
                    relativeRankings[k] = Integer.compare(rankingsI, rankingsJ);
                    // System.out.print(rankingsI + "," + rankingsJ + " ");
                }

                // System.out.println(Arrays.toString(relativeRankings));
                boolean goodPair = true;
                int rel = relativeRankings[0];
                for (int k = 1; k < K; k++) {
                    if (relativeRankings[k] != rel) {
                        goodPair = false;
                        break;
                    }
                }
                if (goodPair) sum++;
            }
        }

        out.println(sum);

        sc.close();
        out.close();
    }

    public static int indexOf(int[] k, int x) {
        for (int i = 0; i < k.length; i++) {
            if (k[i] == x) return i;
        }
        return -1;
    }
}
