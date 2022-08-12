package com.binarysearchtree;

import java.util.ArrayList;
import java.util.Scanner;

class BinarySearchTree {

	Node root;
	BinarySearchTree() {
		root = null;
	}

	void inorder() {
		inorderUtil(this.root);
	}

	void inorderUtil(Node node) {
		if (node == null) {
			return;
		}

		inorderUtil(node.left);
		System.out.print(node.data + " ");
		inorderUtil(node.right);
	}

	void insert(int key) {
		root = insertRec(root, key);
	}

	Node insertRec(Node root, int data) {

		if (root == null) {
			root = new Node(data);
			return root;
		}

		if (data < root.data)
			root.left = insertRec(root.left, data);
		else if (data > root.data)
			root.right = insertRec(root.right, data);

		return root;
	}

	ArrayList<Integer> treeToList(Node node, ArrayList<Integer> list) {
		if (node == null) {
			return list;
		}

		treeToList(node.left, list);
		list.add(node.data);
		treeToList(node.right, list);

		return list;
	}

	boolean isPairPresent(Node node, int target) {
		ArrayList<Integer> a1 = new ArrayList<>();
		ArrayList<Integer> a2 = treeToList(node, a1);

		int start = 0;
		int end = a2.size() - 1;

		while (start < end) {
			if (a2.get(start) + a2.get(end) == target) {
				System.out.println("Pair Found: " + a2.get(start) + " + " + a2.get(end) + " " + "= " + target);
				return true;
			}
			if (a2.get(start) + a2.get(end) > target) {
				end--;
			}
			if (a2.get(start) + a2.get(end) < target) {
				start++;
			}
		}
		System.out.println("No such values are found!");
		return false;
	}

    public static void main(String[] args) {
    	int numberofElements = 0;
    	boolean retry = true;
        BinarySearchTree tree = new BinarySearchTree();

    	// take input from user for number of elements he want's to create a tree with
    	
        System.out.printf("Enter the number of elements : ");
        Scanner scanner = new Scanner(System.in);
        
        numberofElements = scanner.nextInt();
        
        // read all inputs from user console
        System.out.println("Enter the elements one after the other : ");
        for(int i = 0; i <numberofElements; i++ ) {
            tree.insert(scanner.nextInt());
        }
        
        // prompt user to search tree for new number until found
        do {
            System.out.printf("Enter the number to find summation numbers for : ");
            retry = tree.isPairPresent(tree.root, scanner.nextInt());
            if (!retry) {
            	System.out.println("Let us try a different number : ");
            }
        } while(!retry);

        scanner.close();
    }
}