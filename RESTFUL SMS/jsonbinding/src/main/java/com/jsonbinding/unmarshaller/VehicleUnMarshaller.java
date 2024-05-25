package com.jsonbinding.unmarshaller;

import com.jsonbinding.beans.Vehicle;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

public class VehicleUnMarshaller {
	public static void main(String[] args) {
		Jsonb jsonb = JsonbBuilder.create();
		Vehicle vehicle = jsonb.fromJson(VehicleUnMarshaller.class.getClassLoader().getResourceAsStream("vehicle.json"),
				Vehicle.class);
		System.out.println(vehicle);
	}
}
