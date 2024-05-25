package com.jsonstreaming.writer;

import java.io.FileNotFoundException;

public class ParcelTest {
	public static void main(String[] args) throws FileNotFoundException {
		Parcel parcel = new Parcel();
		parcel.setParcelNo("p3839");
		parcel.setDescription("medicine supplies");
		parcel.setWeight(2);
		parcel.setSource("Hyderabad");
		parcel.setDestination("Chennai");
		parcel.setContents(new String[] { "10 sheet tablets", "2 syrups" });
		ParcelWriter parcelWriter = new ParcelWriter();
		parcelWriter.writeParcel(parcel);
	}
}
