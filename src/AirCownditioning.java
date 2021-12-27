// 2021 december USACO bronze in contest

import java.util.Arrays;
import java.util.Scanner;

public class AirCownditioning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] pref = new int[N];
        for (int i = 0; i < N; i++) {
            pref[i] = sc.nextInt();
        }
        int[] cur = new int[N];
        for (int i = 0; i < N; i++) {
            cur[i] = sc.nextInt();
        }
        sc.close();

        int[] diff = new int[N];
        for (int i = 0; i < N; i++) {
            diff[i] = pref[i] - cur[i];
        }

        int x;
        int y = N - 1;
        int sum = 0;
        for (x = 0; x < N; x++) {
            // System.out.println(Arrays.toString(diff) + x + y);
            while (true) {
                if (diff[x] == 0) break;
                else {
                    if (diff[x] > 0) {
                        for (int i = x; i <= y; i++) {
                            diff[i]--;
                        }
                    } else if (diff[x] < 0) {
                        for (int i = x; i <= y; i++) {
                            diff[i]++;
                        }
                    }
                    sum++;
                }
            }

            while (true) {
                if (diff[y] == 0 && y > 0) y--;
                else break;
            }
        }
        System.out.println(sum);

    }
}
