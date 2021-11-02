// http://www.usaco.org/index.php?page=viewproblem2&cpid=735

import java.io.*;
import java.util.Scanner;

public class LostCow {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("lostcow.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));

        int x = sc.nextInt();
        int y = sc.nextInt();

        int distance = 0;
        int pos = x;
        int multiplier = 1;

        while (true) {
            int oldPos = pos;
            pos = x + multiplier;
            if (oldPos <= y && y < pos) {
                distance += y - oldPos;
                break;
            } else if (pos <= y && y < oldPos) {
                distance += oldPos - y;
                break;
            } else {
                if (multiplier > 0) {
                    distance += pos - oldPos;
                } else if (multiplier < 0) {
                    distance += oldPos - pos;
                }
            }
            multiplier *= -2;
        }

        out.println(distance);

        sc.close();
        out.close();
    }
}
