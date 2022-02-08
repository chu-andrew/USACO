import java.lang.reflect.Array;
import java.util.*;

public class NonTransitiveDice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        // T = 1;
        for (int t = 1; t <= T; t++) {
            ArrayList<Integer> a = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                a.add(sc.nextInt());
            }
            ArrayList<Integer> b = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                b.add(sc.nextInt());
            }
            // System.out.println(a);
            // System.out.println(b);
            // System.out.println(aWins(a, b));
            if (!aWins(a, b)) {
                ArrayList<Integer> temp = a;
                a = b;
                b = temp;
                // System.out.println(a);
                // System.out.println(b);
            }
            Collections.sort(a);
            Collections.sort(b);

            boolean solved = false;
            int start = 1;
            for (int i = start; i <= 10; i++) {
                if (solved) break;
                for (int j = start; j <= 10; j++) {
                    if (solved) break;
                    for (int k = start; k <= 10; k++) {
                        if (solved) break;
                        for (int l = start; l <= 10; l++) {
                            ArrayList<Integer> c = new ArrayList<>();
                            c.add(i);
                            c.add(j);
                            c.add(k);
                            c.add(l);
                            if (aWins(b, c) && aWins(c, a)) solved = true;
                        }
                    }
                }
            }

            if(solved) System.out.println("yes");
            else System.out.println("no");
        }
        sc.close();
    }

    public static boolean aWins(ArrayList<Integer> a, ArrayList<Integer> b) {
        int[][] aWinChart = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (Objects.equals(a.get(i), b.get(j))) aWinChart[i][j] = 0;
                else aWinChart[i][j] = a.get(i) > b.get(j) ? 1 : -1;
            }
        }
        int sum = 0;
        for (int[] arr : aWinChart)
            for (int i : arr)
                sum += i;

        return sum > 0;
    }
}
