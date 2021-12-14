// http://www.usaco.org/index.php?page=viewproblem2&cpid=1012

import java.io.*;
import java.util.Scanner;

public class MadScientist {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("breedflip.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));

        int N = sc.nextInt();
        boolean[] a = new boolean[N];
        boolean[] b = new boolean[N];
        String A = sc.next();
        String B = sc.next();

        for (int i = 0; i < N; i++) {
            a[i] = (A.charAt(i) == 'H');
            b[i] = (B.charAt(i) == 'H');
        }

        int bits = 0;
        for (int i = 0; i < N; i++) {
            if (a[i] != b[i]) {
                bits++;
                for (int j = i; j < N; j++) {
                    if (a[j] == b[j]) {
                        i = j;
                        break;
                    }
                }
            }
        }

        out.println(bits);
        sc.close();
        out.close();
    }
}
