// http://usaco.org/index.php?page=viewproblem2&cpid=1107

import java.util.Arrays;
import java.util.Scanner;

public class YearOfTheCow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        String[][] rel = new String[N][4];
        for (int i = 0; i < N; i++) {
            rel[i][0] = sc.next();
            sc.next();
            sc.next();
            rel[i][1] = sc.next();
            rel[i][2] = sc.next();
            sc.next();
            sc.next();
            rel[i][3] = sc.next();
        }
        // System.out.println(Arrays.deepToString(rel));


    }
}
