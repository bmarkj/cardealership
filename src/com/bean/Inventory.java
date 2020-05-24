package com.bean;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Inventory {
	
	//DATA FIELDS
	private ArrayList<Vehicle> inventory;

	
	//CONSTRUCTORS
	public Inventory(ArrayList<Vehicle> inventory) {}
	
	
	//METHODS
	public static ArrayList<Vehicle> readDataFile() {
		String fileName = "C:\\Users\\Mark\\Code\\Java\\ClaimAcademy\\MainCoursework\\CarDealership\\inventory.txt";
		ArrayList<Vehicle> vehFromDataFile = new ArrayList<Vehicle>();
		
		try {
			Scanner scanner = new Scanner(new File(fileName));
			
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parsedLine = line.split(",");
				
				String imgSrc = parsedLine[0];
				String vehId = parsedLine[1];
				String year = parsedLine[2];
				String make = parsedLine[3];
				String model = parsedLine[4];
				String bodyStyle = parsedLine[5];
				String color = parsedLine[6];
				String miles = parsedLine[7];
				String condition = parsedLine[8];
				String isSold = parsedLine[9];
				String isOver120 = parsedLine[10];
				String dateAdded = parsedLine[11];
				String dateSold = parsedLine[12];
				String priceSticker = parsedLine[13];
				String priceSold = parsedLine[14];
				String description = parsedLine[15];
				String buyer = parsedLine[16];
				
				Vehicle vehicle = new Vehicle(imgSrc, vehId, year, make, model, bodyStyle, color, miles, condition, 
						isSold, isOver120, dateAdded, dateSold, priceSticker, priceSold, description, buyer);
				vehFromDataFile.add(vehicle);
			}
			scanner.close();
		}catch (FileNotFoundException e) {
			System.out.println("Error reading from file.");
		}
		return vehFromDataFile;
	}//end readDataFile
	
	
	public static ArrayList<Vehicle> filterSoldVehicles () {
		ArrayList<Vehicle> masterInventory = readDataFile();
		ArrayList<Vehicle> unsoldInventory = new ArrayList<Vehicle>();
		
		for (Vehicle vehicle : masterInventory) {
			if (vehicle.isSold() == false) {
				unsoldInventory.add(vehicle);
			}
		}
		return unsoldInventory;
	}
	
	
	public static void addToDataFile(String newVehicle) {
		File file = new File("C:\\Users\\Mark\\Code\\Java\\ClaimAcademy\\MainCoursework\\CarDealership\\inventory.txt");
		
		try {
			if(!file.exists()){
		    	   file.createNewFile();
		    }
			
			FileWriter fw = new FileWriter(file,true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			bw.write(newVehicle);
			bw.write("\r\n");//add carriage return so next entry goes on a new line
	    	
	    	//Closing BufferedWriter Stream
	    	bw.close();
	    	
	    	//System.out.println("Data successfully appended at the end of file");
			
		}
		catch (IOException ioe) {
	         System.out.println("File exception occurred:");
	    	 ioe.printStackTrace();
	    }
	}//end addToDataFile
	
	
	public static void updateDataFile (ArrayList<Vehicle> vehicles) {
		
		ArrayList<Vehicle> inventory = vehicles;
		
		File file = new File("C:\\Users\\Mark\\Code\\Java\\ClaimAcademy\\MainCoursework\\CarDealership\\inventory.txt"); 

		if(file.exists()) {
			file.delete();
		}

		try {
			file.createNewFile();
		}
		catch (IOException e){
			System.out.println("New file not created");
			e.printStackTrace();
		}
		
		for (Vehicle vehicle : inventory) {
			String thisVehicle = vehicle.toString();
			//System.out.println(thisVehicle);
			try {
				FileWriter fw = new FileWriter(file,true);
				BufferedWriter bw = new BufferedWriter(fw);
				
				bw.write(thisVehicle);
				bw.write("\r\n");//add carriage return so next entry goes on a new line
				bw.close();
			}
			catch (IOException e) {
				System.out.println("Unable to write to file.");
				e.printStackTrace();
			}
		}
	}//end updateDataFile

	
	public static ArrayList<String> listAllMakes (ArrayList<Vehicle> vehicles) {
		
		ArrayList<String> allMakes = new ArrayList<String>();
		
		for (Vehicle vehicle : vehicles) {
			if (!allMakes.contains(vehicle.getMake())) {
				allMakes.add(vehicle.getMake());
			}
		}
		return allMakes;
	}
	
	
	public static ArrayList<String> listAllConditions (ArrayList<Vehicle> vehicles) {
		
		ArrayList<String> allConditions = new ArrayList<String>();
		
		for (Vehicle vehicle : vehicles) {
			if (!allConditions.contains(vehicle.getCondition())) {
				allConditions.add(vehicle.getCondition());
			}
		}
		return allConditions;
	}
	

	//GET-SET
	public ArrayList<Vehicle> getInventory() {
		return inventory;
	}
	public void setInventory(ArrayList<Vehicle> inventory) {
		this.inventory = inventory;
	}
	

}//end Class
