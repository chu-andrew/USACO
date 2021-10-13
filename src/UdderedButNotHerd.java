// http://www.usaco.org/index.php?page=viewproblem2&cpid=1083
import java.util.Scanner;

public class UdderedButNotHerd {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String az = sc.nextLine();
		String word = sc.nextLine();

		int times = 0;
		int indexOff = 27;
		for (int i = 0; i < word.length(); i++) {
			for (int a = 0; a < az.length(); a++) {
				if(word.substring(i, i+1).equals(az.substring(a,a+1))) {
					if(indexOff>=a) times++;
					indexOff= a;
				}
			}
		}
		System.out.println(times);
		sc.close();
	}
}