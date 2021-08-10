package driver;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.left.left.left = new Node(7);
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		printLevelOrder(q);
	}
	
	public static void printLevelOrder(Queue<Node> q) {
		Node curNode = q.remove();
		if (curNode != null) {
			q.add(curNode.left);
			q.add(curNode.right);
			System.out.println(curNode.value);
			printLevelOrder(q);
		}
	}
	
	public static void printCurrentLevel() {
		
	}
	
}
