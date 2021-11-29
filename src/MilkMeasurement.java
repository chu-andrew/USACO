import java.io.*;
import java.util.Scanner;

public class MilkMeasurement {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("measurement.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));

        int N = sc.nextInt();

        int[] day = new int[N];
        String[] name = new String[N];
        int[] change = new int[N];

        for (int i = 0; i < N; i++) {
            day[i] = sc.nextInt();
            name[i]= sc.next();
            change[i] = sc.nextInt();
        }
        printIntArr(day);
        printStringArr(name);
        printIntArr(change);

        sc.close();
        out.close();
    }
    private static void printIntArr(int[] x){
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]);
        }
        System.out.println();
    }
    private static void printStringArr(String[] x){
        for (int i = 0; i < x.length; i++) {
            System.out.print(x[i]);
        }
        System.out.println();
    }
}
