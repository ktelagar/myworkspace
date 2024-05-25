package com.jsonstreaming.writer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import jakarta.json.Json;
import jakarta.json.stream.JsonGenerator;

public class ParcelWriter {

	public void writeParcel(Parcel parcel) throws FileNotFoundException {
		JsonGenerator jsonGenerator = Json.createGenerator(new FileOutputStream(new File(
				"D:\\work\\master\\restfulservices\\20220901\\jsonparsing\\src\\main\\resources\\parcel.json")));

		jsonGenerator.writeStartObject();
		jsonGenerator.write("parcelNo", parcel.getParcelNo());
		jsonGenerator.write("description", parcel.getDescription());
		jsonGenerator.write("weight", parcel.getWeight());
		jsonGenerator.write("source", parcel.getSource());
		jsonGenerator.write("destination", parcel.getDestination());
		jsonGenerator.writeStartArray("contents");
		for (String content : parcel.getContents()) {
			jsonGenerator.write(content);
		}
		jsonGenerator.writeEnd();
		jsonGenerator.writeEnd();
		jsonGenerator.close();
	}
}
