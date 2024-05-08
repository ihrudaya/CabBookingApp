package com.project.cabbookingapp.model;

import java.util.Arrays;

public class DriverDetails {

	    private String name;
	    private String gender;
	    private int age;
	    private VehicleDetails vehicle;
	    private int[] location; 
//
	    public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public VehicleDetails getVehicle() {
			return vehicle;
		}

		public void setVehicle(VehicleDetails vehicle) {
			this.vehicle = vehicle;
		}

		public int[] getLocation() {
			return location;
		}

		public void setLocation(int[] location) {
			this.location = location;
		}

		public DriverDetails(String name, String gender, int age, VehicleDetails vehicle, int[] location) {
	        this.name = name;
	        this.gender = gender;
	        this.age = age;
	        this.vehicle = vehicle;
	        this.location = location;
	    }

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("DriverDetails [name=");
			builder.append(name);
			builder.append(", gender=");
			builder.append(gender);
			builder.append(", age=");
			builder.append(age);
			builder.append(", vehicle=");
			builder.append(vehicle);
			builder.append(", location=");
			builder.append(Arrays.toString(location));
			builder.append("]");
			return builder.toString();
		}
}
