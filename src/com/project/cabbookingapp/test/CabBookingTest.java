package com.project.cabbookingapp.test;

import com.project.cabbookingapp.service.CabBookingApp;

public class CabBookingTest {

	
	 public static void main(String[] args) {
	        CabBookingApp app = new CabBookingApp();

	        // Add users
	        app.addUser("Abhishek, M, 23");
	        app.addUser("Rahul, M, 29");
	        app.addUser("Nandini, F, 22");
	        
	        
	        // Add drivers with vehicles and current locations
	        app.addDriver("Driver1, M, 22", "Swift, KA-01-12345", new int[]{10, 1});
	        app.addDriver("Driver2, M, 29", "Swift, KA-01-12345", new int[]{11, 10});
	        app.addDriver("Driver3, M, 24", "Swift, KA-01-12345", new int[]{5, 3});

	        // Find rides for different users
	        app.findRide("Abhishek", new int[]{0, 0}, new int[]{20, 1}); 
	        app.findRide("Rahul", new int[]{10, 0}, new int[]{15, 3}); 
	        app.findRide("Nandini", new int[]{15, 6}, new int[]{20, 4}); 
	        
	        // Choose a ride
	        app.chooseRide("Rahul", "Driver1");
	        app.chooseRide("Nandini", "Driver1");

	    }

}
