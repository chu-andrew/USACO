// http://www.usaco.org/index.php?page=viewproblem2&cpid=1131

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class AcowdemiaOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        Integer[] citations = new Integer[N];
        for (int i = 0; i < N; i++) {
            citations[i] = sc.nextInt();
        }

        Arrays.sort(citations, Collections.reverseOrder());
        // System.out.println(Arrays.toString(citations));

        /*

        failed with testcase 4: 2 1 1 1
        bc incorrectly assumed that array would stay sorted after incrementing by one

        int h = 0;
        for (int i = 0; i < N; i++) {
            if (citations[i] >= i + 1) {
                h = i + 1;
            } else {
                int x = Math.min((i + L), N); // make sure no out of bound
                for (int j = i; j < x; j++) {
                    citations[j]++;
                    if (citations[j] >= j + 1) {
                        h = j + 1;
                    }
                }
                break;
            }
        }

        */

        int h1 = hIndex(citations, N);

        // for loop copied from USACO solution
        // increment values in [h-L+2,h+1]
        if (h1 != N) {
            for (int j = h1; j >= 0 && j > h1 - L; j--) {
                citations[j]++;
            }
        }

        Arrays.sort(citations, Collections.reverseOrder());
        int h2 = hIndex(citations, N);

        System.out.println(h2);
    }

    public static int hIndex(Integer[] citations, int N) {
        int h = 0;
        for (int i = 0; i < N; i++) {
            if (citations[i] >= i + 1) {
                h = i + 1;
            }
        }
        return h;
    }
}
