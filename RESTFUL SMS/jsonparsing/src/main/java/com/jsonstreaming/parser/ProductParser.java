package com.jsonstreaming.parser;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;

public class ProductParser {
	public static void main(String[] args) {
		String keyName = null;
		JsonParser jsonParser = Json
				.createParser(ProductParser.class.getClassLoader().getResourceAsStream("product.json"));
		while (jsonParser.hasNext()) {
			Event e = jsonParser.next();
			if (e == Event.KEY_NAME) {
				keyName = jsonParser.getString();
				if (keyName.equals("price")) {
					jsonParser.next();
					double price = jsonParser.getBigDecimal().doubleValue();
					System.out.println("price : " + price);
				}

			}
		}
	}
}
