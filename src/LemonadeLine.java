// http://www.usaco.org/index.php?page=viewproblem2&cpid=835

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class LemonadeLine {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("lemonade.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lemonade.out")));
        int N = sc.nextInt();
        Integer[] cows = new Integer[N];
        for (int i = 0; i < N; i++) {
            cows[i] = sc.nextInt();
        }
        Arrays.sort(cows, Collections.reverseOrder());


        for (int i = 0; i < N; i++) {
            if (cows[i] < i) {
                out.println(i);
                break;
            }
            if (i == N - 1) { // last cow, and no condition in previous if statement has been met yet
                out.println(N);
            }
        }

        sc.close();
        out.close();
    }
}
