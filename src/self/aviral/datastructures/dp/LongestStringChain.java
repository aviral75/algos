package self.aviral.datastructures.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 * https://leetcode.com/problems/longest-string-chain/
*	 Input: ["a","b","ba","bca","bda","bdca"]
	 Output: 4
	 Explanation: one of the longest word chain is "a","ba","bda","bdca".
	 
* Take a word and find where its max one letter away substring is ,put it in current
* for a given word we store its cur as its best for one letter ways
* for all word we then compare and store in max from their currents giving max count.
*
*/
public class LongestStringChain {

	public int longestStrChain(String[] words) {

		Objects.requireNonNull(words);

		Arrays.sort(words, (a, b) -> a.length() - b.length()); // {} on lambda need return where more logic else not
																// reqd

		Map<String, Integer> store = new HashMap<>();

		int max = 0;
		for (int i = 0; i < words.length; i++) {
			String w = words[i];
			int  cur = 1;
			for (int j = 0; j < w.length(); j++) {
				String tmp = w.substring(0, j) + w.substring(j + 1);
				cur = Math.max(cur, store.getOrDefault(tmp, 0) + 1);
			}
			store.put(words[i], cur);
			max = Math.max(max, cur);
		}
		return max;
	}
	
	
	public static void main(String[] args) {


		String words[]= new String[]{"a","b","ba","bca","bda","bdca"};
//		{"ks", "gr", "kss", "gru", "czvh", "gruj", "kssq", 
//				"zczvh", "ksqsq", "grukj", "zcpzvh", 
//				"grukmj", "ksqvsq", "ksqvsyq", "zczpzvh", "grukkmj", "zczpzvhx", "zczpzvdhx", "zczpzfvdhx"};

		System.out.println(new LongestStringChain().longestStrChain(words));
	}
}
