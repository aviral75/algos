package self.aviral.datastructures.trees;

import self.aviral.datastructures.trees.common.TreeNode;

/*
 * https://leetcode.com/problems/count-complete-tree-nodes/
				 * Input: 
				    1
				   / \
				  2   3
				 / \  /
				4  5 6
				
				Output: 6
 * 
 * The idea is to recursively count left and right pair and if both are good add to parent
 * To keep count and state a Pair class is used.
 * so we count for 4 we get 1 we count for 5 we get 1  so for 2 we have left m right + 2 so 3
 * similarly for 6 is 1 so for 3 is 2 so for 1 is 3(from 2) + 2 (from 3) and 1 of its own so 6. 
 */

public class CountTreeNodes {

	public int countNodes(TreeNode root) {
		Pair rootPair = countHelper(root, new Pair(0, false));
		if (rootPair.flag) {
			return rootPair.count;
		}
		return 0;
	}

	
	private Pair countHelper(TreeNode node, Pair p) {
		if (node == null) {
			return new Pair(0, true);
		}

		Pair left = countHelper(node.left, p);
		Pair right = countHelper(node.right, p);

		if (left.flag && right.flag) {
			return new Pair(left.count + right.count + 1, true);
		}

		return new Pair(0, false);
	}

	private class Pair {
		int count;
		boolean flag;

		Pair(int i, boolean b) {
			this.count = i;
			this.flag = b;
		}

		@Override
		public String toString() {
			return "" + count + "->" + String.valueOf(flag);
		}
	}

	public static void main(String[] args) {
		TreeNode six = new TreeNode(6);
		TreeNode five = new TreeNode(5);
		TreeNode four = new TreeNode(4);
		TreeNode three = new TreeNode(3);
		TreeNode two = new TreeNode(2);
		TreeNode one = new TreeNode(1);
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;

		System.out.println(new CountTreeNodes().countNodes(one));
	}
}
