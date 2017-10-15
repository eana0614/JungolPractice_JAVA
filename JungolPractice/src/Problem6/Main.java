package Problem6;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {

	static ArrayList<String> result = new ArrayList<>();

	/*
	 * Problem 6. Word Matching.
	 * 
	 * Sort the words that can be created by combining the characters of the input
	 * words in a lexicographic manner.
	 * 
	 * Input : word Output : Print one word after the input word. If input word is
	 * the last word, print the input word.
	 * 
	 */

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		String word = scanner.nextLine();

		perm(word, word.length(), word.length());

		Collections.sort(result); //result.sort(null);
		
		int inputIndex = result.indexOf(word);

		if (inputIndex == result.size() - 1) {
			System.out.println(word);
		} else {
			System.out.println(result.get(inputIndex + 1));
		}

	}

	private static void perm(String word, int n, int r) {

		if (r == 0) {
			addWord(word.length(), word);
		}

		for (int i = n - 1; i >= 0; i--) {
			word = swap(word, i, n - 1);
			perm(word, n - 1, r - 1);
			word = swap(word, i, n - 1);
		}

	}

	private static String swap(String word, int i, int j) {

		char temp1 = word.charAt(i);
		char temp2 = word.charAt(j);

		StringBuilder words = new StringBuilder(word);
		words.setCharAt(i, temp2);
		words.setCharAt(j, temp1);

		return words.toString();
	}

	private static void addWord(int n, String w) {

		String temp = "";
		for (int i = n - 1; i >= 0; i--) {
			temp += w.charAt(i);
		}

		if(!result.contains(temp)) {
			result.add(temp);
		}
	}
}
