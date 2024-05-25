package com.jsonparsing.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import jakarta.json.JsonWriter;

public class AccountWriter {
	public static void main(String[] args) throws FileNotFoundException {
		JsonWriter jsonWriter = Json.createWriter(new FileOutputStream(new File(
				"D:\\work\\master\\restfulservices\\20220901\\jsonparsing\\src\\main\\resources\\account.json")));
		
		JsonObjectBuilder accountObjectBuilder = Json.createObjectBuilder();
		accountObjectBuilder.add("accountNo", "ac03893");
		accountObjectBuilder.add("accountHolderName", "Ruby");
		accountObjectBuilder.add("accountType", "savings");
		accountObjectBuilder.add("ifscCode", "SBI000019");
		accountObjectBuilder.add("balance", 9349);

		JsonObjectBuilder addressObjectBuilder = Json.createObjectBuilder();
		addressObjectBuilder.add("addressLine1", "83-93/1 Arunodhaya Complex");
		addressObjectBuilder.add("addressLine2", "Kormandal road");
		addressObjectBuilder.add("city", "Chennai");
		addressObjectBuilder.add("state", "TN");
		addressObjectBuilder.add("zip", 93838);
		addressObjectBuilder.add("country", "India");
		JsonObject addressObject = addressObjectBuilder.build();

		JsonArrayBuilder nomineesArrayBuilder = Json.createArrayBuilder();
		nomineesArrayBuilder.add("Alex");
		nomineesArrayBuilder.add("Sophi");
		JsonArray nomineesArray = nomineesArrayBuilder.build();

		accountObjectBuilder.add("address", addressObject);
		accountObjectBuilder.add("nominees", nomineesArray);
		JsonObject accountObject = accountObjectBuilder.build();

		jsonWriter.writeObject(accountObject);
		jsonWriter.close();
	}
}
