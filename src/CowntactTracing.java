// http://www.usaco.org/index.php?page=viewproblem2&cpid=1037

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class CowntactTracing {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("tracing.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("tracing.out")));

        int N = sc.nextInt();
        int T = sc.nextInt();
        String dataIN = sc.next();
        boolean[] sickCurrent = new boolean[N];
        for (int i = 0; i < N; i++) {
            if (dataIN.charAt(i) == '1') sickCurrent[i] = true;
        }
        // System.out.println(Arrays.toString(sickCurrent));

        int[][] txy = new int[T][3];
        for (int i = 0; i < T; i++) {
            txy[i][0] = sc.nextInt();
            txy[i][1] = sc.nextInt();
            txy[i][2] = sc.nextInt();
        }
        Arrays.sort(txy, Comparator.comparingInt(a -> a[0]));
        // System.out.println(Arrays.deepToString(txy));


        int numConfirmedPtZero = 0;
        int minK = 255;
        int maxK = -1;
        for (int ptzero = 0; ptzero < N; ptzero++) {
            boolean ptConfirmed = false;
            for (int K = 0; K < 255; K++) { // max T is 250

                int[] remainingK = new int[N]; // remaining time of transmission
                for (int i = 0; i < N; i++) {
                    remainingK[i] = K + 1;
                }

                boolean[] sick = new boolean[N];
                sick[ptzero] = true;
                remainingK[ptzero] = K;

                for (int[] data : txy) {
                    int x = data[1] - 1;
                    int y = data[2] - 1;
                    boolean currentSickX = sick[x];
                    boolean currentSickY = sick[y];

                    if (currentSickX && remainingK[x] > 0) { // if x or y is sick
                        sick[y] = true;
                        if (remainingK[y] == K + 1) remainingK[y] = K;
                    }
                    if (currentSickY && remainingK[y] > 0) {
                        sick[x] = true;
                        if (remainingK[x] == K + 1) remainingK[x] = K;
                    }

                    if (currentSickX) remainingK[x]--;
                    if (currentSickY) remainingK[y]--;
                }
                if (Arrays.equals(sick, sickCurrent)) {
                    minK = Math.min(minK, K);
                    maxK = Math.max(maxK, K);
                    ptConfirmed = true;
                }
            }
            if (ptConfirmed) numConfirmedPtZero++;
        }

        out.print(numConfirmedPtZero + " "); // zero indexed
        out.print((minK < 251) ? minK + " " : "Infinity ");
        out.println((maxK > 250) ? "Infinity" : maxK);

        sc.close();
        out.close();
    }
}
