package com.jsonbinding.marshaller;

import com.jsonbinding.beans.Vehicle;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

public class VehicleMarshaller {
	public static void main(String[] args) {
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleNo(878);
		vehicle.setChasisNo("CH93839");
		vehicle.setRtaRegistrationNo("KT09BO3938");
		vehicle.setEngineNo("E0333");
		vehicle.setFuelType("Diesel");
		vehicle.setColor("Red");
		vehicle.setManufacturer("Kia");
		vehicle.setModel("Seltos");
		vehicle.setSeatingCapacity(7);
		vehicle.setYear(2023);
		vehicle.setPrice(3493933);
		vehicle.setFeatures(new String[] { "Airbags", "Steering mounted controls" });
		Jsonb jsonb = JsonbBuilder.create();
		String vehicleJson = jsonb.toJson(vehicle);
		System.out.println(vehicleJson);
	}
}
