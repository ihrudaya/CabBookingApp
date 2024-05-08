package com.project.cabbookingapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.cabbookingapp.exception.CustomException;
import com.project.cabbookingapp.model.DriverDetails;
import com.project.cabbookingapp.model.UserDetails;
import com.project.cabbookingapp.model.VehicleDetails;

public class CabBookingApp {

	private List<UserDetails> users = new ArrayList<>();
	private List<DriverDetails> drivers = new ArrayList<>();
	private Map<String, List<DriverDetails>> matchedUserDriver = new HashMap<>();

	public Map<String, List<DriverDetails>> getMatchedUserDriver() {
		return matchedUserDriver;
	}

	public void setMatchedUserDriver(Map<String, List<DriverDetails>> matchedUserDriver) {
		this.matchedUserDriver = matchedUserDriver;
	}

	public List<UserDetails> getUsers() {
		return users;
	}

	public void setUsers(List<UserDetails> users) {
		this.users = users;
	}

	public List<DriverDetails> getDrivers() {
		return drivers;
	}

	public void setDrivers(List<DriverDetails> drivers) {
		this.drivers = drivers;
	}

	// Add a new user
	public void addUser(String userDetails) {
		try {
			String[] parts = userDetails.split(", ");
			if (parts.length != 3) {
				throw new CustomException("Invalid user details format");
			}
			String name = parts[0];
			String gender = parts[1];
			int age = Integer.parseInt(parts[2]);
			UserDetails newUser = new UserDetails(name, gender, age);
			users.add(newUser);
			System.out.println("User added: " + newUser);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Add a new driver with vehicle details
	public void addDriver(String driverDetails, String vehicleDetails, int[] location) {
		try {
			String[] driverParts = driverDetails.split(", ");
			if (driverParts.length != 3) {
				throw new CustomException("Invalid driver details format");
			}
			String driverName = driverParts[0];
			String driverGender = driverParts[1];
			int driverAge = Integer.parseInt(driverParts[2]);

			String[] vehicleParts = vehicleDetails.split(", ");
			if (vehicleParts.length != 2) {
				throw new CustomException("Invalid vehicle details format");
			}
			String vehicleModel = vehicleParts[0];
			String licensePlate = vehicleParts[1];

			VehicleDetails vehicle = new VehicleDetails(vehicleModel, licensePlate);
			DriverDetails newDriver = new DriverDetails(driverName, driverGender, driverAge, vehicle, location);
			drivers.add(newDriver);
			System.out.println("Driver added: " + newDriver);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// Find available rides based on source and destination
	public List<DriverDetails> findRide(String username, int[] source, int[] destination) {
		List<DriverDetails> availableDrivers = new ArrayList<>();
		// Find drivers within a 5 unit radius of the source
		for (DriverDetails driver : drivers) {
			double distance = calculateDistance(source, driver.getLocation());
			if (distance <= 5) {
				availableDrivers.add(driver);
			}
		}

		if (availableDrivers.isEmpty()) {
			System.out.println("No ride found for " + username);
		} else {
			matchedUserDriver.put(username, availableDrivers);
			System.out.println("Available rides for " + username + ": " + availableDrivers);
		}

		return availableDrivers;
	}

	// Select a ride from available drivers
	public void chooseRide(String username, String driverName) {
		DriverDetails chosenDriver = null;
		List<DriverDetails> availableDrivers = matchedUserDriver.get(username);
		if (availableDrivers == null || availableDrivers.size() == 0) {
			System.out.println("No driver found with name: " + driverName + " for user: " + username);
			return;
		}
		for (DriverDetails driver : availableDrivers) {
			if (driver.getName().equals(driverName)) {
				chosenDriver = driver;
				break;
			}
		}

		if (chosenDriver == null) {
			System.out.println("No driver found with name: " + driverName + " for user: " + username);
		} else {
			System.out.println("User: " + username + " chose driver: " + chosenDriver);
		}
	}

	// Calculate distance
	private double calculateDistance(int[] point1, int[] point2) {
		int dx = point1[0] - point2[0];
		int dy = point1[1] - point2[1];
		return Math.sqrt(dx * dx + dy * dy);
	}

}
