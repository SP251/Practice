import java.util.Iterator;
import java.util.LinkedList;

public class GraphPractice {
	private static int V;
	private static LinkedList<Integer> adj[];

	static class Graph {

		Graph(int v) {
			V = v;
			adj = new LinkedList[v];
			for (int i = 0; i < v; i++) {
				adj[i] = new LinkedList<>();
			}
		}
	}
	// void addEdge(Graph graph, int src, int dest) {
	// graph.adj[src].add(dest);
	// graph.adj[dest].add(src);
	// }

	static void addEdgeAdj(int src, int dest) {
		adj[src].add(dest);
	}

	static void printGraph(Graph graph) {
		for (int i = 0; i < V; i++) {
			System.out.println("adjacent Vertex:::: " + i);
			System.out.println("Head");
			for (Integer adjValue : adj[i]) {
				System.out.println("->" + adjValue);
			}
			System.out.println("\n");
		}
	}

	static void BFS(int v) {
		boolean visited[] = new boolean[V];
		LinkedList<Integer> queue = new LinkedList<>();

		visited[v] = true;
		queue.add(v);

		while (queue.size() != 0) {
			v = queue.poll();
			System.out.println(v);

			Iterator<Integer> i = adj[v].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}

	}
	
	static void DFSUtil(int v, boolean visited[]) {
		visited[v] = true;
		System.out.println(v + " ");
		Iterator<Integer> i = adj[v].listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if(!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}
	
	static void DFS(int v) {
		boolean visited[] = new boolean[V];
		DFSUtil(v, visited);
	}
	
	static boolean isCyclicUtil(int v, boolean visited[], boolean recStack[] ) {
		if (recStack[v])
			return true;
		if (visited[v]) 
			return false;
		visited[v] = true;
		recStack[v] = true;
		
		Iterator<Integer> i = adj[v].listIterator();
		while(i.hasNext()) {
			int n = i.next();
			if (isCyclicUtil(n, visited, recStack)) {
				return true;
			}
			recStack[n] = false;
		}
		return false;
	}
	
	static boolean isCyclic() {
		boolean visited[] = new boolean[V];
		boolean recStack[] = new boolean[V];
		
		for(int i = 0; i < V; i++) {
			if(isCyclicUtil(i, visited, recStack)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 4;
		Graph graph = new Graph(V);
		addEdgeAdj(0, 1);
		addEdgeAdj(0, 2);
		addEdgeAdj(1, 2);
		addEdgeAdj(2, 0);
		addEdgeAdj(2, 3);
		addEdgeAdj(3, 3);

		// printGraph(graph);
//		BFS(2);
//		DFS(2);
		
		if(isCyclic()) {
			System.out.println("Graph is Cyclic");
		} else {
			System.err.println("Graph is not cyclic");
		}

	}

}
