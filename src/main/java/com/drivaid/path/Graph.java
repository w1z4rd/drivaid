package com.drivaid.path;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Graph {
	private int V;
	private int E;
	private List<DirectedEdge>[] adj;

	public Graph(int V, int E, List<DirectedEdge> edges) {
		this.V = V;
		this.E = E;
		adj = (List<DirectedEdge>[]) new LinkedList[V + 1];
		for (int i = 0; i <= V; i++) {
			adj[i] = new LinkedList<DirectedEdge>();
		}
		for (DirectedEdge edge : edges) {
			addEdge(edge);
		}
	}

	private void addEdge(DirectedEdge edge) {
		adj[edge.from()].add(edge);
	}

	public int V() {
		return V;
	}

	public int E() {
		return E;
	}

	public List<DirectedEdge> adj(int from) {
		return adj[from];
	}

	public List<DirectedEdge> edges() {
		List<DirectedEdge> edges = new ArrayList<DirectedEdge>();
		for (int i = 1; i <= V; i++) {
			edges.addAll(adj[i]);
		}
		return edges;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("V: " + V + " E: " + E + "\n");
		for (int i = 1; i <= V; i++) {
			sb.append(adj[i]);
			sb.append("\n");
		}
		return sb.toString();
	}
}
