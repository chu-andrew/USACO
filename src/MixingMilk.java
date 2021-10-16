import java.io.*;
import java.util.Scanner;

public class MixingMilk {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("mixmilk.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));

        int c1 = sc.nextInt();
        int m1 = sc.nextInt();
        int c2 = sc.nextInt();
        int m2 = sc.nextInt();
        int c3 = sc.nextInt();
        int m3 = sc.nextInt();

        for (int i = 0; i < 100; i++) {
            // System.out.println(m1 + " " + m2 + " " + m3);
            if (i % 3 == 0) {
                int[] mixed = mix(m1, m2, c2);
                m1 = mixed[0];
                m2 = mixed[1];
            }
            if (i % 3 == 1) {
                int[] mixed = mix(m2, m3, c3);
                m2 = mixed[0];
                m3 = mixed[1];
            }
            if (i % 3 == 2) {
                int[] mixed = mix(m3, m1, c1);
                m3 = mixed[0];
                m1 = mixed[1];
            }
        }
        out.println(m1);
        out.println(m2);
        out.println(m3);

        sc.close();
        out.close();
    }

    public static int[] mix(int m1, int m2, int c2) {
        int empty2 = c2 - m2;
        if (m1 <= empty2) {
            m2 += m1;
            m1 = 0;
        }
        if (m1 > empty2) {
            m2 = c2;
            m1 -= empty2;
        }
        return new int[]{m1, m2};
    }
}
