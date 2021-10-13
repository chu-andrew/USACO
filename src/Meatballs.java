// wv csc original problem

public class Meatballs {
	public static void main(String[] args) {
		int[] one = { 1, 3, 2 };
		int[] two = { 1, 5, 1 };
		int[] three = { 4, 4, 3 };
		int[][] orders = { one, two, three };
		System.out.println(meatballs(5, 3, orders));
	}

	public static String meatballs(int n, int k, int[][] orders) {
		int[] plates = new int[n];

		for (int order = 0; order < orders.length; order++) {
			int begin = orders[order][0]-1;
			int end = orders[order][1]-1;
			int num = orders[order][2];
			for (int i = begin; i <= end; i++) {
				plates[i] += num;
			}
		}
		return arrayToString(plates);
	}

	public static String arrayToString(int[] plates) {
		String answer = "";
		for (int i = 0; i < plates.length; i++) {
			answer += plates[i] + "_";
		}
		return answer.substring(0, answer.length() - 1);
	}
}
