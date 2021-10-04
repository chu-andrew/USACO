// http://usaco.org/index.php?page=viewproblem2&cpid=1059

import java.util.Arrays;
import java.util.Scanner;

public class DoYouKnowYourABCs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Integer[] in = new Integer[7];
		for (int i = 0; i <= 6; i++) {
			in[i] = sc.nextInt();
		}

		Integer[] out = ABCs(in);
		for (int i = 0; i < out.length; i++) {
			System.out.print(out[i]);
			if (i < out.length - 1)
				System.out.print(" ");
		}
		System.out.println();
	}

	public static Integer[] ABCs(Integer[] nums) {
		Arrays.sort(nums);
		int a = nums[0];

		int max = nums[nums.length - 1];

		int diff = max - a;
		int b = -1;
		int c = -1;

		for (int i = 1; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == diff) {
					b = nums[i];
					c = nums[j];
				}
			}
		}
		Integer[] list = { a, b, c };
		return list;
	}
}
