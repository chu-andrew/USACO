// http://usaco.org/index.php?page=viewproblem2&cpid=1060

import java.util.Scanner;

public class DaisyChains {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] p = new int[N];
        for (int i = 0; i < N; i++) {
            p[i] = sc.nextInt();
        }
        sc.close();

        int totalNumHasAve = 0;
        for (int j = 0; j < N; j++) {
            for (int i = 0; i <= j; i++) {
                int summed = sum(i, j, p);
                boolean hasAve = hasAverage(i,j,p,summed);
                if(hasAve) totalNumHasAve++;
            }
        }
        System.out.println(totalNumHasAve);
    }

    public static int sum(int i, int j, int[] p) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += p[k];
        }
        return sum;
    }

    public static boolean hasAverage(int i, int j, int[] p, int sum) {
        boolean hasAve = false;
        for (int k = i; k <= j; k++) {
            // x * (length of subarray) = (sum of subarray) [akin to seeing if ave is in subarray]
            // do not just search for actual average to avoid dealing with non-integer averages
            if (p[k] * (j-i+1) == sum) {
                hasAve = true;
                break;
            }
        }
        return hasAve;
    }

}
