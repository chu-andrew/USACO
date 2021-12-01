// http://www.usaco.org/index.php?page=viewproblem2&cpid=1011

import java.io.*;
import java.util.Scanner;

public class Triangles {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("triangles.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("triangles.out")));

        int N = sc.nextInt();
        int[][] points = new int[N][2];

        for (int i = 0; i < N; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        int area = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int[][] tri = {points[i], points[j], points[k]};
                    area = Math.max(findArea(tri), area);
                }
            }
        }

        pw.println(area);

        sc.close();
        pw.close();
    }

    public static int findArea(int[][] tri) {
        boolean parallelX = false;
        int w = 0;
        boolean parallelY = false;
        int h = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                int[] a = tri[i];
                int[] b = tri[j];
                if (a[0] == b[0]) { // parallel to y axis
                    parallelY = true;
                    h = Math.abs(a[1] - b[1]);
                } else if (a[1] == b[1]) { //parallel to x axis
                    parallelX = true;
                    w = Math.abs(a[0] - b[0]);
                }
            }
        }
        return (parallelX && parallelY) ? (h * w) : -1;
    }
}