import java.util.Arrays;
import java.util.Scanner;

public class RedistributingGifts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] wishlists = new int[N][N];

        int counter=0;
        for (int cow = 1; cow <= N; cow++) {
            boolean found = false;
            for (int j = 1; j <= N; j++) {
                int in = sc.nextInt();
                if(!found) wishlists[cow-1][j-1] = in;
                if (in == cow) {
                    found= true;
                }
            }
        }

        /*
        int[] gift = new int[N];
        for (int i = 0; i < N; i++) {
            if(wishlists[i][1]==0) gift[i] = wishlists[i][0];

        }
        */
        // System.out.println(Arrays.toString(gift));

        sc.close();
    }
}
