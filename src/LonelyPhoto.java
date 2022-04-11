// 2021 december USACO bronze in contest

import java.util.Scanner;

public class LonelyPhoto {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        String s = sc.next();
        sc.close();

        // O(N^2) solution
        long sum = 0;

        for (int i = 0; i < N; i++) {
            int H = 0;
            int G = 0;

            for (int j = i; j < N; j++) {
                if (s.charAt(j) == 'H') H++;
                else G++;
                if (j >= i + 2) {
                    // System.out.print(s.substring(i, j + 1));
                    if (H == 1 || G == 1) {
                        sum++;
                        // System.out.println(" sum++");
                    } else {
                        // System.out.println();
                        if (!(H == 0 || G == 0)) break;
                    }
                }
            }
        }
        System.out.println(sum);
    }
}
