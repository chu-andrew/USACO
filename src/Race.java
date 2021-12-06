// http://www.usaco.org/index.php?page=viewproblem2&cpid=989

// unsolved

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Race {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("race.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("race.out")));

        int K = sc.nextInt();
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            out.println(race(K, x));
        }

        sc.close();
        out.close();
    }

    public static int race(int k, int vf) {
        // k is total length
        // vf is max final speed
        int v = 0;
        int distance = 0;

        int time = 0;

        ArrayList<Integer> distances = new ArrayList<>();
        ArrayList<Integer> speeds = new ArrayList<>();

        boolean decreaseSpeed = false;
        while (distance < k) {

        }
        System.out.println(distances + " " + speeds + " " + k);
        return time;
    }
}
