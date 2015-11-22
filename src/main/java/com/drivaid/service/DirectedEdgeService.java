package com.drivaid.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.drivaid.domain.Address;
import com.drivaid.domain.DirectedEdge;
import com.drivaid.repository.AddressRepository;
import com.drivaid.repository.DirectedEdgeRepository;
import com.drivaid.service.util.RandomUtil;

@Service
@Transactional
public class DirectedEdgeService {

	@Inject
	AddressRepository addressRepository;

	@Inject
	DirectedEdgeRepository directedEdgeRepository;

	public void generateEdges(Address freshAddress) {
		List<Address> filteredAddresses = addressRepository.findAll().stream().filter(x -> !x.equals(freshAddress))
				.collect(Collectors.toList());
		for (Address existingAddress : filteredAddresses) {
			long distance = RandomUtil.generateRandomNumber(400);
			DirectedEdge edgeFromNew = new DirectedEdge();
			edgeFromNew.setHeadAddress(freshAddress);
			edgeFromNew.setTailAddress(existingAddress);
			edgeFromNew.setDistanceInMinutes(distance);
			directedEdgeRepository.save(edgeFromNew);
			
			DirectedEdge edgeToNew = new DirectedEdge();
			edgeToNew.setHeadAddress(existingAddress);
			edgeToNew.setTailAddress(freshAddress);
			edgeToNew.setDistanceInMinutes(distance);
			directedEdgeRepository.save(edgeToNew);
		}
	}
}
