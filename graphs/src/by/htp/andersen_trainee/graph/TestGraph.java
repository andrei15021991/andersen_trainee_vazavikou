package by.htp.andersen_trainee.graph;

public class TestGraph {

	public static void main(String[] args) {

		Node nA = new Node('A');
		Node nB = new Node('B');
		Node nC = new Node('C');
		Node nD = new Node('D');
		Node nE = new Node('E');
		Node nF = new Node('F');

		Graph g = new Graph();
		g.addNode(nA);
		g.addNode(nB);
		g.addNode(nC);
		g.addNode(nD);
		g.addNode(nE);
		g.addNode(nF);
		g.setRootNode(nA);

		g.connectNode(nA, nB);
		g.connectNode(nA, nC);
		g.connectNode(nA, nD);

		g.connectNode(nB, nE);
		g.connectNode(nB, nF);
		g.connectNode(nC, nF);

		System.out.println("DFS Traversal of a tree is ------------->");
		g.dfs();

		System.out.println("\nBFS Traversal of a tree is ------------->");
		g.bfs();
	}

}
