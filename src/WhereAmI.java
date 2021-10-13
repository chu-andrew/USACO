// http://www.usaco.org/index.php?page=viewproblem2&cpid=964

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class WhereAmI {

	public static void main(String[] args) throws IOException {
		// File in = new File("src\\whereami.in");
		File in = new File("whereami.in");

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));

		Scanner sc = new Scanner(in);
		int n = sc.nextInt();
		sc.nextLine();

		
		String mail = sc.nextLine();

		for (int size = 2; size <= n; size++) {
			boolean good = true;
			for (int i = 0; i <= n - size; i++) {
				String seq = mail.substring(i, i + size);
				for (int j = i + 1; j <= n - size; j++) {
					if (mail.substring(j, j + size).equals(seq)) {
						good = false;
					}
				}
			}

			if (good) {
				out.println(size);
				break;
			}
		}
		sc.close();
		out.close();

	}

}
