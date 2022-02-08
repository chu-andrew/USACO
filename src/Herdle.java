import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class Herdle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Character> answer = new ArrayList<Character>();
        for (int i = 0; i < 3; i++) {
            String word = sc.next();
            char[] wordSplit = word.toCharArray();

            for (int j = 0; j < 3; j++) {
                answer.add(wordSplit[j]);
            }
        }
        ArrayList<Character> guess = new ArrayList<Character>();
        for (int i = 0; i < 3; i++) {
            String word = sc.next();
            char[] wordSplit = word.toCharArray();

            for (int j = 0; j < 3; j++) {
                guess.add(wordSplit[j]);
            }
        }
        /*
        System.out.println();
        System.out.println(answer);
        System.out.println(guess);
        */
        int green = 0;
        ArrayList<Integer> greenIndex = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            if (answer.get(i) == guess.get(i)) {
                green++;
                greenIndex.add(i);
            }
        }

        Collections.reverse(greenIndex);

        for (int x : greenIndex) {
            answer.remove(x);
            guess.remove(x);
        }

        System.out.println(green);
        /*
        System.out.println();
        System.out.println(answer);
        System.out.println(guess);
        */
        int yellow = 0;

        for (int i = 0; i < answer.size(); i++) {
            for (int j = 0; j < guess.size(); j++) {
                if (answer.get(i) == guess.get(j)) {
                    yellow++;
                    guess.set(j, null);
                    break;
                }
            }
        }

        System.out.println(yellow);
        /*
        System.out.println();
        System.out.println(answer);
        System.out.println(guess);
        */

        sc.close();
    }
}