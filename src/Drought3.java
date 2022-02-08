import java.util.Arrays;
import java.util.Scanner;

public class Drought3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        // int T = 1;
        for (int t = 0; t < T; t++) {
            int N = sc.nextInt();
            long[] h = new long[N];
            for (int i = 0; i < N; i++) {
                h[i] = sc.nextInt();
            }
            int mode = h[0] < 1000 ? 1 : 2;

            int bags = 0;
            boolean solved = true;
            int counter = 0;
            while (!same(h)) {
                long[] stored = h;
                long min = h[0];
                int minIndex = -1;
                for (int i = 1; i < N; i++) {
                    if (h[i] < min) {
                        min = h[i];
                        minIndex = i;
                    }
                }
                for (int i = 0; i < N - 1; i++) {
                    if (h[i] > min && i + 1 != minIndex && h[i + 1] - h[i] + min >= 0) {
                        long diff = h[i] - min;
                        h[i] -= diff;
                        h[i + 1] -= diff;
                        bags += diff * 2;
                        break;
                    }
                }
                if (Arrays.equals(h, stored)) counter++;
                else counter = 0;
                if (mode == 1) {
                    if (counter == 1000) {
                        solved = false;
                        break;
                    }
                } else {
                    if (counter == 100000) {
                        solved = false;
                        break;
                    }
                }
            }
            if (solved) System.out.println(bags);
            else System.out.println("-1");
        }
        sc.close();
    }

    public static boolean same(long[] a) {
        long x = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] != x) return false;
        }
        return true;
    }
}
