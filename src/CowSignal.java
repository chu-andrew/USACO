// http://www.usaco.org/index.php?page=viewproblem2&cpid=665

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CowSignal {

	public static void main(String[] args) throws IOException {
		File in = new File("cowsignal.in");

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowsignal.out")));

		Scanner sc = new Scanner(in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();

		sc.nextLine();

		String[] pic = new String[m];
		for (int i = 0; i < m; i++) { // lines
			String line = sc.nextLine();

			String lineMult = "";
			for (int j = 0; j < n; j++) {
				for (int l = 0; l < k; l++) {
					lineMult += line.substring(j, j + 1);
				}
			}
			pic[i] = lineMult;
		}

		for (int i = 0; i < m; i++) {
			for (int l = 0; l < k; l++) {
				out.println(pic[i]);
			}
		}

		sc.close();
		out.close();
	}

}
