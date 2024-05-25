package com.jsonstreaming.parser;

import jakarta.json.Json;
import jakarta.json.stream.JsonParser;
import jakarta.json.stream.JsonParser.Event;

public class ProductRepository {

	public int getNoOfProducts() {
		int nProducts = 0;
		String keyName = null;
		JsonParser jsonParser = null;

		jsonParser = Json.createParser(this.getClass().getClassLoader().getResourceAsStream("products.json"));
		while (jsonParser.hasNext()) {
			Event e = jsonParser.next();
			if (e == Event.KEY_NAME) {
				keyName = jsonParser.getString();
				if (keyName.equals("productNo")) {
					nProducts++;
				}
			}
		}

		return nProducts;
	}

	public int getNoOfProducts(String category) {
		int nProducts = 0;
		String keyName = null;
		String keyValue = null;
		JsonParser jsonParser = null;

		jsonParser = Json.createParser(this.getClass().getClassLoader().getResourceAsStream("products.json"));
		while (jsonParser.hasNext()) {
			Event e = jsonParser.next();
			if (e == Event.KEY_NAME) {
				keyName = jsonParser.getString();
				if (keyName.equals("category")) {
					jsonParser.next();
					keyValue = jsonParser.getString();
					if (keyValue.equals(category)) {
						nProducts++;
					}
				}
			}
		}

		return nProducts;
	}
}
