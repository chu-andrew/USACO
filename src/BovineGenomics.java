// http://www.usaco.org/index.php?page=viewproblem2&cpid=736

import java.io.*;
import java.util.Scanner;

public class BovineGenomics {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("cownomics.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
        int N = sc.nextInt();
        int M = sc.nextInt();

        char[][] spotty = new char[N][M];
        char[][] plain = new char[N][M];

        for (int r = 0; r < N; r++) {
            spotty[r] = sc.next().toCharArray();
        }
        for (int r = 0; r < N; r++) {
            plain[r] = sc.next().toCharArray();
        }

        // condense same genes that exist throughout
        // A C G T
        boolean[][] condensedSpotty = new boolean[M][4];
        boolean[][] condensedPlain = new boolean[M][4];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (spotty[r][c] == 'A') condensedSpotty[c][0] = true;
                if (spotty[r][c] == 'C') condensedSpotty[c][1] = true;
                if (spotty[r][c] == 'G') condensedSpotty[c][2] = true;
                if (spotty[r][c] == 'T') condensedSpotty[c][3] = true;

                if (plain[r][c] == 'A') condensedPlain[c][0] = true;
                if (plain[r][c] == 'C') condensedPlain[c][1] = true;
                if (plain[r][c] == 'G') condensedPlain[c][2] = true;
                if (plain[r][c] == 'T') condensedPlain[c][3] = true;
            }
        }


        // System.out.println(Arrays.deepToString(condensedSpotty));
        // System.out.println(Arrays.deepToString(condensedPlain));

        int sum = 0;
        for (int c = 0; c < M; c++) {
            boolean gene = true;
            for (int i = 0; i < 4; i++) {
                if (condensedSpotty[c][i] && condensedPlain[c][i]) {
                    gene = false;
                    break;
                }
            }
            if (gene) sum++;
        }

        out.println(sum);
        sc.close();
        out.close();
    }
}
