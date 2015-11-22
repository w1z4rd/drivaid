package com.drivaid.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "directed_edge")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class DirectedEdge implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="head_id")
	private Address headAddress;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="tail_id")
	private Address tailAddress;

	@NotNull
	@Column(name="distance_in_minutes")
	private long distanceInMinutes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int from() {
		return headAddress.getNumber();
	}

	public Address getHeadAddress() {
		return headAddress;
	}

	public void setHeadAddress(Address headAddress) {
		this.headAddress = headAddress;
	}

	public int to() {
		return tailAddress.getNumber();
	}

	public Address getTailAddress() {
		return tailAddress;
	}

	public void setTailAddress(Address tailAddress) {
		this.tailAddress = tailAddress;
	}

	public long weight() {
		return distanceInMinutes;
	}

	public void setDistanceInMinutes(long distanceInMinutes) {
		this.distanceInMinutes = distanceInMinutes;
	}

	@Override
	public String toString() {
		return "headAddress=" + headAddress + ", tailAddress=" + tailAddress + ", distanceInMinutes="
				+ distanceInMinutes;
	}
}
