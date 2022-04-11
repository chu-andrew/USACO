// http://www.usaco.org/index.php?page=viewproblem2&cpid=1084

// unsolved

import java.util.Arrays;
import java.util.Scanner;

public class EvenMoreOddPhotos {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        // int[] nums = new int[N];
        int even = 0;
        int odd = 0;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            // nums[i] = x % 2;
            if (x % 2 == 0) even++;
            else odd++;
        }
        // System.out.println(Arrays.toString(nums));

        boolean numTurnEven = true;
        int groups = 0;
        while (even > 0 || odd > 0) {
            System.out.println(!numTurnEven + " " + even + " " + odd);

            if (numTurnEven) {
                if (even > 0) {
                    even--;
                } else if (odd > 1) {
                    odd -= 2;
                } else {
                    break;
                }
                numTurnEven = false;
                groups++;
            } else {
                if (odd > 0) {
                    odd--;
                    numTurnEven = true;
                    groups++;
                } else {
                    break;
                }
            }
        }
        System.out.println(!numTurnEven + " " + even + " " + odd);

        System.out.println(groups);
        // System.out.println(even);
        // System.out.println(odd);
        sc.close();
    }
}
