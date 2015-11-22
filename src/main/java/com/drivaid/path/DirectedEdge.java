package com.drivaid.path;

import com.drivaid.domain.Address;

public class DirectedEdge {
	private Address headAddress;
	private Address tailAddress;
	private long distanceInMinutes;

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
