package by.htp.andersen_trainee.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

	public Node rootNode;
	public ArrayList<Node> nodes = new ArrayList<Node>();
	public int[][] adjMatrix;
	int size;

	public void setRootNode(Node n) {
		this.rootNode = n;
	}

	public Node getRootNode() {
		return this.rootNode;
	}

	public void addNode(Node n) {
		nodes.add(n);
	}

	public void connectNode(Node start, Node end) {
		if (adjMatrix == null) {
			size = nodes.size();
			adjMatrix = new int[size][size];
		}

		int startIndex = nodes.indexOf(start);
		int endIndex = nodes.indexOf(end);
		adjMatrix[startIndex][endIndex] = 1;
		adjMatrix[endIndex][startIndex] = 1;
	}

	private Node getUnvisitedChildNode(Node n) {

		int index = nodes.indexOf(n);
		int j = 0;
		while (j < size) {
			if (adjMatrix[index][j] == 1 && ((Node) nodes.get(j)).visited == false) {
				return (Node) nodes.get(j);
			}
			j++;
		}
		return null;
	}

	public void bfs() {

		Queue<Node> q = new LinkedList<Node>();
		q.add(this.rootNode);
		printNode(this.rootNode);
		rootNode.visited = true;
		while (!q.isEmpty()) {
			Node n = (Node) q.remove();
			Node child = null;
			while ((child = getUnvisitedChildNode(n)) != null) {
				child.visited = true;
				printNode(child);
				q.add(child);
			}
		}

		clearNodes();
	}

	public void dfs() {

		Stack<Node> s = new Stack<Node>();
		s.push(this.rootNode);
		rootNode.visited = true;
		printNode(rootNode);
		while (!s.isEmpty()) {
			Node n = (Node) s.peek();
			Node child = getUnvisitedChildNode(n);
			if (child != null) {
				child.visited = true;
				printNode(child);
				s.push(child);
			} else {
				s.pop();
			}
		}

		clearNodes();
	}

	private void clearNodes() {
		int i = 0;
		while (i < size) {
			Node n = (Node) nodes.get(i);
			n.visited = false;
			i++;
		}
	}

	private void printNode(Node n) {
		System.out.print(n.label + " ");
	}
}
