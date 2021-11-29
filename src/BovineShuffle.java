// http://www.usaco.org/index.php?page=viewproblem2&cpid=760

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class BovineShuffle {
    public static void main(String[] args) throws IOException {
        // (ID -> transform -> new order ) *3
        Scanner sc = new Scanner(new File("shuffle.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));

        int N = sc.nextInt();

        ArrayList<Integer> order = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            order.add(sc.nextInt());
        }
        System.out.println(order);
        ArrayList<Integer> oldOrder = new ArrayList<>();

        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < N; i++) {
                oldOrder.add(order.indexOf(i + 1) + 1);
            }

            System.out.println(oldOrder);

            order = new ArrayList<>(oldOrder);
            if (j != 2) oldOrder.clear();
        }

        ArrayList<Integer> ID = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            ID.add(sc.nextInt());
        }

        for (int i = 0; i < N; i++) {
            out.println(ID.get(oldOrder.get(i) - 1));
        }

        sc.close();
        out.close();
    }
}
