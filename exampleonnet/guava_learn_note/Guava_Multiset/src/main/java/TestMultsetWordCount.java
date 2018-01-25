import java.util.ArrayList;
import java.util.List;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class TestMultsetWordCount {
	public static void main(String[] args) {
		String strWorld = "wer|dfd|dd|dfd|dda|de|dr";
		String[] words = strWorld.split("\\|");
		List<String> wordList = new ArrayList<String>();

		for (String word : words) {
			wordList.add(word);
		}
		Multiset<String> wordsMultiset = HashMultiset.create();
		wordsMultiset.addAll(wordList);

		for (String key : wordsMultiset.elementSet()) {
			System.out.println(key + " count: " + wordsMultiset.count(key));
		}

		if (!wordsMultiset.contains("peida")) {
			wordsMultiset.add("peida", 2);
		}

		System.out.println("============================================");

		for (String key : wordsMultiset.elementSet()) {
			System.out.println(key + " count: " + wordsMultiset.count(key));
		}

		if (wordsMultiset.contains("peida")) {
			wordsMultiset.setCount("peida", 23);
		}

		System.out.println("============================================");

		for (String key : wordsMultiset.elementSet()) {
			System.out.println(key + " count: " + wordsMultiset.count(key));
		}

		if (wordsMultiset.contains("peida")) {
			wordsMultiset.setCount("peida", 23, 45);
		}

		System.out.println("============================================");

		for (String key : wordsMultiset.elementSet()) {
			System.out.println(key + " count：" + wordsMultiset.count(key));
		}

		if (wordsMultiset.contains("peida")) {
			wordsMultiset.setCount("peida", 44, 67);
		}

		System.out.println("============================================");

		for (String key : wordsMultiset.elementSet()) {
			System.out.println(key + " count：" + wordsMultiset.count(key));
		}
	}
}
