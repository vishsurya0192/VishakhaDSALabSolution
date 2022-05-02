package com.greatlearning.lab3.bst;

import java.util.HashSet;

public class FindSumPairBst {
	//creating BST
	static class Node{
		int data;
		Node leftNode, rightNode;
	}
	
	static Node NewNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.leftNode = null;
		temp.rightNode = null;
		return temp;
	}
	
	public Node insert(Node root, int key) {
		if(root == null)
			return NewNode(key);
		if(key < root.data)
			root.leftNode = insert(root.leftNode, key);
		else
			root.rightNode = insert(root.rightNode, key);
		return root;
	}
	
	public boolean findPair(Node root, int sum, HashSet<Integer> set) {
		if(root == null)
			return false;
		if(findPair(root.leftNode, sum, set))
			return true;
		if(set.contains(sum - root.data)) {
			System.out.println("Pair is found (" +(sum - root.data)+", "+root.data+" )");
			return true;
		}
		else
			set.add(root.data);
		return findPair(root.rightNode, sum, set);
		
		
	}
	
	public void findPairWithGivenSum(Node root, int sum) {
		HashSet<Integer> set = new HashSet<Integer>();
		if(!findPair(root,sum,set))
			System.out.println("Nodes are not found");
	}

	public static void main(String[] args) {
		Node root = null;
		FindSumPairBst findSPB = new FindSumPairBst();
		root = findSPB.insert(root, 40);
		root = findSPB.insert(root, 20);
		root = findSPB.insert(root, 60);
		root = findSPB.insert(root, 10);
		root = findSPB.insert(root, 30);
		root = findSPB.insert(root, 50);
		root = findSPB.insert(root, 70);
		
		int sum = 130;
		findSPB.findPairWithGivenSum(root, sum);
		
	}

}
