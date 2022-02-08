import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Drought2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int T = sc.nextInt();
        int T = 1;
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            int[] h = new int[N];
            for (int i = 0; i < N; i++) {
                h[i] = sc.nextInt();
            }
            int hSum = 0;
            for (int value : h) {
                hSum += value;
            }
            int[] diff = new int[N - 1];

            // System.out.println(Arrays.toString(h));
            boolean solution = true;
            try {
                while (!same(h)) {
                    for (int i = 0; i < N - 1; i++) {
                        diff[i] = Math.abs(h[i] - h[i + 1]);
                    }
                    // System.out.println(Arrays.toString(diff));

                    int max = maxIndex(diff);
                    if (h[max] >= h[max + 1]) {
                        h[max] -= diff[max];
                        h[max - 1] -= diff[max];
                    } else {
                        h[max + 1] -= diff[max];
                        h[max + 2] -= diff[max];
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                solution = false;
            }

            int target = h[0];
            if (solution && target >= 0) System.out.println(hSum - target * N);
            else System.out.println("-1");
        }
        sc.close();
    }

    public static int maxIndex(int[] a) {
        int maxInd = 0;
        for (int i = 0; i < a.length; i++) {
            maxInd = a[i] > a[maxInd] ? i : maxInd;
        }
        return maxInd;
    }

    public static boolean same(int[] a) {
        int x = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] != x) return false;
        }
        return true;
    }
}