package com.project.cabbookingapp.model;

public class VehicleDetails {

	private String model;
	private String licensePlate;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public VehicleDetails(String model, String licensePlate) {
		this.model = model;
		this.licensePlate = licensePlate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("VehicleDetails [model=");
		builder.append(model);
		builder.append(", licensePlate=");
		builder.append(licensePlate);
		builder.append("]");
		return builder.toString();
	}

	

}
