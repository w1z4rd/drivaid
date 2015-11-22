package com.drivaid.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drivaid.domain.DirectedEdge;

public interface DirectedEdgeRepository extends JpaRepository<DirectedEdge,Long>  {

}
