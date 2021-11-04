import java.io.*;
import java.util.Scanner;

public class _FileIOTemplate {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("filename.in"));
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("filename.out")));

        sc.close();
        out.close();
    }
}
