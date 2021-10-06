package co.tushar.graph;

import java.util.ArrayList;

public class GraphDemo {

	static class Graph_Node {

		int dest = 0;
		int weight = 0;

		public Graph_Node(int dest, int weight) {

			this.dest = dest;
			this.weight = weight;
		}

	}

	public static void main(String[] args) {

		ArrayList<Graph_Node> graph[] = new ArrayList[7];

		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<Graph_Node>();
		}

		addEdge(graph, 1, 2, 0);
		addEdge(graph, 2, 3, 0);
		addEdge(graph, 3, 4, 0);
		addEdge(graph, 5, 6, 0);
		

		display(graph);
		//System.out.println(findEdge(graph, 3, 5));

		// removeEdge(graph, 1, 6);
		// removeNode(graph, 1);

		//System.out.println(hasPath(graph, 0, 4, new boolean[graph.length]));

		//display(graph);
		//System.out.println(allPath(graph, 0, 6, new boolean[graph.length]));
		
	//	hamiltonPath(graph, 0, 0, 0, new boolean[graph.length]);
		
		System.out.println(GCC(graph));

	}

	public static void addEdge(ArrayList<Graph_Node>[] graph, int parent, int dest, int weight) {

		graph[parent].add(new Graph_Node(dest, weight));
		graph[dest].add(new Graph_Node(parent, weight));

	}

	public static void display(ArrayList<Graph_Node>[] graph) {

		for (int i = 0; i < graph.length; i++) {
			System.out.print(i + " -> ");

			for (Graph_Node nd : graph[i]) {
				System.out.print("(" + nd.dest + " " + nd.weight + ")");
			}
			System.out.println();
		}

	}

	// given two nodes find that wheather there exist direct edge bw these node or
	// not.
	public static int findEdge(ArrayList<Graph_Node>[] graph, int node1, int node2) {

		for (int i = 0; i < graph[node1].size(); i++) {
			if (graph[node1].get(i).dest == node2) {
				return i;
			}
		}
		return -1;

	}

	public static void removeEdge(ArrayList<Graph_Node>[] graph, int node1, int node2) {

		int indx1 = findEdge(graph, node1, node2);
		int indx2 = findEdge(graph, node2, node1);

		graph[node1].remove(indx1);
		graph[node2].remove(indx2);

	}

	public static void removeEdge2(ArrayList<Graph_Node>[] graph, int node1, int node2) {

		for (int i = 0; i < graph[node1].size(); i++) {
			if (graph[node1].get(i).dest == node2) {
				graph[node1].remove(i);
				break;
			}
		}
		for (int i = 0; i < graph[node2].size(); i++) {
			if (graph[node2].get(i).dest == node1) {
				graph[node2].remove(i);
				break;
			}
		}

	}

	public static void removeNode(ArrayList<Graph_Node>[] graph, int node) {

		for (int i = graph[node].size() - 1; i >= 0; i--) {
			removeEdge(graph, node, graph[node].get(i).dest);
		}

	}

	// DFS
	public static boolean hasPath(ArrayList<Graph_Node>[] graph, int start, int end, boolean[] vis) {

		if (start == end) {
			return true;
		}

		vis[start] = true;
		boolean res = false;

		for (Graph_Node nd : graph[start]) {
			if (!vis[nd.dest]) {
				res = res || hasPath(graph, nd.dest, end, vis);
			}
		}

		return res;
	}

	public static int allPath(ArrayList<Graph_Node>[] graph, int start, int end, boolean vis[]) {

		if (start == end) {
			return 1;
		}

		vis[start] = true;
		int count = 0;

		for (Graph_Node nd : graph[start]) {
			if (!vis[nd.dest]) {
				count += allPath(graph, nd.dest, end, vis);
			}
		}

		vis[start] = false;
		return count;

	}

	public static void hamiltonPath(ArrayList<Graph_Node>[] graph, int src, int osrc, int count, boolean[] vis) {

		if (count == graph.length - 1) {
			int indx = findEdge(graph, src, osrc);
			if (indx != -1) {
				System.out.println("Cycle");
			} else {
				System.out.println("Path");
			}

			return;
		}

		vis[src] = true;

		for (Graph_Node nd : graph[src]) {
			if (!vis[nd.dest]) {
				hamiltonPath(graph, nd.dest, osrc, count + 1, vis);
			}
		}
		
		vis[src]=false;
		

	}
	
	public static int GCC(ArrayList<Graph_Node>[] graph) {
		
		boolean[] vis=new boolean[graph.length];
		
		int noOfComponents=0;
		int largest=0;
		
		for (int i = 0; i < vis.length; i++) {
			if(!vis[i]) {
				noOfComponents++;
				largest=Math.max(dfs_gcc(graph,i,vis),largest);
			}
		}
		System.out.println("Component with largest nodes is "+largest);
		return noOfComponents;
		
	}

	public static int dfs_gcc(ArrayList<Graph_Node>[] graph, int i, boolean[] vis) {
		
		vis[i]=true;
		int c=0;
		for(Graph_Node nd:graph[i]) {
			if(!vis[nd.dest]) {
				c+=dfs_gcc(graph, nd.dest, vis);
			}
		}
		return c+1;
		
	}

}
