package com.jsonstreaming.writer;

public class Parcel {
	String parcelNo;
	String description;
	int weight;
	String source;
	String destination;
	String[] contents;

	public String getParcelNo() {
		return parcelNo;
	}

	public void setParcelNo(String parcelNo) {
		this.parcelNo = parcelNo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String[] getContents() {
		return contents;
	}

	public void setContents(String[] contents) {
		this.contents = contents;
	}

}
