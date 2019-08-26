package self.aviral.datastructures.recursion;

import java.util.ArrayList;
import java.util.List;


// helper logif  - terminal cond size is smae
//for all
//if !exisits in cur , add to cur and explore( explore is recursive) 
//remove from cur the last one

public class Permutation {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		helper(new ArrayList<Integer>(), nums, ans);
		return ans;
	}

	private void helper(List<Integer> cur, int[] nums, List<List<Integer>> ans) {
		if (cur.size() == nums.length) {
			ans.add(new ArrayList<>(cur));
		}

		for (int i = 0; i < nums.length; i++) { // numbers to choose from
			if (cur.contains(nums[i]))
				continue; 
			cur.add(nums[i]);              // choose a not chosen number
			helper(cur, nums, ans);        // explore with that
			cur.remove(cur.size() - 1);    // remove it
		}

	}

	public static void main(String[] args) {
		int nums[] = new int[] { 1, 2, 3 };
		System.out.println(new Permutation().permute(nums));
	}
	
	
}
