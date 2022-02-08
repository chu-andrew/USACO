import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Drought {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] h = new Integer[N];
        for (int i = 0; i < N; i++) {
            h[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(h));
        int min = h[0];
        int minIndex = -1;
        for (int i = 1; i < N; i++) {
            if (h[i] < min) min = h[i];
            minIndex = i; // last index of min
        }
        int target = min;
        for (int i = 0; i < N - 1; i++) {
            if (h[i] > target && h[i + 1] > target) {
                int diff = Math.max(h[i], h[i + 1]) - target;
                h[i] -= diff;
                h[i + 1] -= diff;
            }
        }
        sc.close();
    }

    public static boolean same(int[] a) {
        int x = a[0];
        for (int i = 0; i < a.length; i++) {
            if (a[i] != x) return false;
        }
        return true;
    }
}