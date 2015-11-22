package com.drivaid.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drivaid.domain.Address;
import com.drivaid.domain.DirectedEdge;
import com.drivaid.path.DijkstraSP;
import com.drivaid.path.Graph;
import com.drivaid.repository.AddressRepository;
import com.drivaid.repository.DirectedEdgeRepository;

@Service
@Transactional
public class ShortestPathService {

	@Inject
	AddressRepository addressRepository;

	@Inject
	DirectedEdgeRepository directedEdgeRepository;

	public Iterable<DirectedEdge> computeShortestPath(long fromId, long toId) {
		Address from = addressRepository.findOne(fromId);
		Address to = addressRepository.findOne(toId);

		Iterable<DirectedEdge> result = null;
		int nodeCount = (int) addressRepository.count();
		List<DirectedEdge> edges = directedEdgeRepository.findAll().stream().filter(x -> x.weight() <= 270)
				.collect(Collectors.toList());

		Graph G = new Graph(nodeCount, edges.size(), edges);
		DijkstraSP dsp = new DijkstraSP(G, from);

		result = dsp.pathTo(to);

		return result;
	}
}
