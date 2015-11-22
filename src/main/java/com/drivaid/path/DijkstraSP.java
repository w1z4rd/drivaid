package com.drivaid.path;

import java.util.Stack;

import com.drivaid.domain.Address;
import com.drivaid.domain.DirectedEdge;

public class DijkstraSP {
	private long[] distTo; // distTo[v] = distance of shortest s->v path
	private DirectedEdge[] edgeTo; // edgeTo[v] = last edge on shortest s->v path
	private IndexMinPQ<Long> pq; // priority queue of vertices

	public DijkstraSP(Graph G, Address s) {
		for (DirectedEdge e : G.edges()) {
			if (e.weight() < 0)
				throw new IllegalArgumentException("edge " + e + " has negative weight");
		}

		distTo = new long[G.V() + 1];
		edgeTo = new DirectedEdge[G.V() + 1];
		for (int v = 0; v <= G.V(); v++)
			distTo[v] = Long.MAX_VALUE;
		distTo[s.getNumber()] = 0;

		// relax vertices in order of distance from s
		pq = new IndexMinPQ<Long>(G.V());
		pq.insert(s.getNumber(), distTo[s.getNumber()]);
		while (!pq.isEmpty()) {
			int v = pq.delMin();
			for (DirectedEdge e : G.adj(v))
				relax(e);
		}
	}

	// relax edge e and update pq if changed
	private void relax(DirectedEdge e) {
		int v = e.from(), w = e.to();
		if (distTo[w] > distTo[v] + e.weight()) {
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = e;
			if (pq.contains(w))
				pq.decreaseKey(w, distTo[w]);
			else
				pq.insert(w, distTo[w]);
		}
	}

	public long distTo(Address v) {
		return distTo[v.getNumber()];
	}

	public boolean hasPathTo(Address v) {
		return distTo[v.getNumber()] < Long.MAX_VALUE;
	}

	public Iterable<DirectedEdge> pathTo(Address v) {
		if (!hasPathTo(v))
			return null;
		Stack<DirectedEdge> path = new Stack<DirectedEdge>();
		for (DirectedEdge e = edgeTo[v.getNumber()]; e != null; e = edgeTo[e.from()]) {
			path.push(e);
		}
		return path;
	}

}
