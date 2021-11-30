// http://www.usaco.org/index.php?page=viewproblem2&cpid=760

import java.io.*;
import java.util.Scanner;

public class BovineShuffle {
    public static void main(String[] args) throws IOException {
        // (ID -> transform -> new order ) *3
        Scanner sc = new Scanner(new File("shuffle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));

        int N = sc.nextInt();

        int[] order = new int[N];
        for (int i = 0; i < N; i++) {
            order[i] = sc.nextInt();
        }

        int[] id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = sc.nextInt();
        }

        int[] oldID = shuffle(N, order, id); // first loop
        for (int i = 0; i < 2; i++) { //other 2 loops
            oldID = shuffle(N, order, oldID);
        }

        for (int x : oldID) {
            out.println(x);
        }

        sc.close();
        out.close();
    }

    public static int[] shuffle(int N, int[] order, int[] id) {
        int[] oldID = new int[N];
        for (int i = 0; i < order.length; i++) {
            // init position is the index of order
            // final position is the number at that index

            // int initPos = i;
            int finalPos = order[i];

            oldID[i] = id[finalPos - 1]; // 1-indexed input
        }
        return oldID;
    }
}
