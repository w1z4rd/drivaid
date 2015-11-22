package com.drivaid.web.rest;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codahale.metrics.annotation.Timed;
import com.drivaid.domain.DirectedEdge;
import com.drivaid.service.ShortestPathService;

@RestController
@RequestMapping("/api")
public class ShortestPathResource {

	@Inject
	ShortestPathService shortestPathService;

	@RequestMapping(value = "/shortestPath", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@Timed
	public ResponseEntity<Iterable<DirectedEdge>> getShortestPath(@RequestParam("source") long sourceId,
			@RequestParam("target") long targetId) {
		if (sourceId == targetId) {
			return new ResponseEntity<Iterable<DirectedEdge>>(HttpStatus.OK);
		}
		return new ResponseEntity<Iterable<DirectedEdge>>(shortestPathService.computeShortestPath(sourceId, targetId),
				HttpStatus.OK);
	}
}
