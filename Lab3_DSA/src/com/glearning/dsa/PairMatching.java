/* Program to find pair with given sum by Hashing */

package com.glearning.dsa;

import java.util.HashSet;

public class PairMatching {

	static class Node {
		int data;
		Node left, right;
	}

	static Node newNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.left = null;
		temp.right = null;
		return temp;

	}

	static Node insert(Node root, int value) {
		if (root == null) {
			return newNode(value);
		}
		if (value < root.data) {
			root.left = insert(root.left, value);
		} else {
			root.right = insert(root.right, value);
		}
		return root;

	}

	static boolean findpair(Node root, int sum, HashSet<Integer> set) {

		if (root == null) {
			return false;
		}
		if (findpair(root.left, sum, set)) {
			return true;
		}
		if (set.contains(sum - root.data)) {
			System.out.println("Sum = " + sum);
			System.out.println("Pair is (" + (sum - root.data) + "," + (root.data) + ")");
			return true;
		} else {
			set.add(root.data);
		}
		return findpair(root.right, sum, set);

	}

	static void findPairWithSum(Node root, int sum) {

		HashSet<Integer> set = new HashSet<Integer>();
		if (!findpair(root, sum, set)) {
			System.out.print("No such nodes exist!");
		}
	}

	// Driver Code
	public static void main(String[] args) {
		Node root = null;
		root = insert(root, 40);
		root = insert(root, 20);
		root = insert(root, 60);
		root = insert(root, 10);
		root = insert(root, 30);
		root = insert(root, 50);
		root = insert(root, 70);

		int sum = 130;
		findPairWithSum(root, sum);

	}

}
