package com.bean;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;

public class Vehicle implements Comparable<Vehicle>{
	
	//DATA FIELDS
	private String imgSrc;
	private String vehId;
	private String year;
	private String make;
	private String model;
	private String bodyStyle;
	private String color;
	private String miles;
	private String condition;
	private boolean isSold;
	private boolean isOver120;
	private String dateAdded;
	private String dateSold;
	private String priceSticker;
	private String priceSold;
	private String description;
	private String buyer;
	
	
	//CONSTRUCTORS
	public Vehicle() {	}
	
	public Vehicle (String imgSrc, String vehId, String year, String make, String model, String bodyStyle, String color, String miles, 
					String condition, String isSold, String isOver120, String dateAdded, String dateSold, String priceSticker, 
					String priceSold, String description, String buyer) {
		this.imgSrc = imgSrc;
		this.vehId = vehId;
		this.year = year;
		this.make = make; 
		this.model = model;
		this.bodyStyle = bodyStyle;
		this.color= color;
		this.miles = miles;
		this.condition = condition;
		this.isSold = Boolean.parseBoolean(isSold);
		//isOver120 initialized below
		this.dateAdded = dateAdded;
		this.dateSold = dateSold;
		this.priceSticker = priceSticker;
		this.priceSold = priceSold;
		this.description = description;
		this.buyer = buyer;
		
		long numDays = checkAge(dateAdded);
		if (Boolean.parseBoolean(isOver120) == true || (Boolean.parseBoolean(isOver120) == false && numDays > 120)) {
			this.isOver120 = true;
		}else {
			this.isOver120 = false;
		}
		
	}
	
	
	//METHODS	
	public static long checkAge(String date) {
//		String[] parsedDate = date.split("/");
//		String formattedDate = parsedDate[2] + "-" + parsedDate[0] + "-" + parsedDate[1];
		
		LocalDate currentDate = LocalDate.now();
		LocalDate addedDate = LocalDate.parse(date);
		long days = ChronoUnit.DAYS.between(addedDate, currentDate);
		
		return days;
		
	}
	

	@Override
	public int compareTo(Vehicle o) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public String toString() {
		return imgSrc + "," + vehId + "," + year + "," + make + "," + model + "," + bodyStyle + "," + color +
				"," + miles + "," + condition + "," + isSold + "," + isOver120 + "," + dateAdded + "," + dateSold + "," + priceSticker + 
				"," + priceSold + "," + description + "," + buyer;
	}
	
	//GET-SET
	public String getImgSrc() {
		return imgSrc;
	}
	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}
	
	public String getVehId() {
		return vehId;
	}
	public void setVehId(String vehId) {
		this.vehId = vehId;
	}

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public String getBodyStyle() {
		return bodyStyle;
	}
	public void setBodyStyle(String bodyStyle) {
		this.bodyStyle = bodyStyle;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

	public String getMiles() {
		return miles;
	}
	public void setMiles(String miles) {
		this.miles = miles;
	}
	
	public String getCondition() {
		return condition;
	}
	public void setCondition(String condition) {
		this.condition = condition;
	}

	public boolean isSold() {
		return isSold;
	}
	public void setSold(boolean isSold) {
		this.isSold = isSold;
	}

	public boolean isOver120() {
		return isOver120;
	}
	public void setOver120(boolean isOver120) {
		this.isOver120 = isOver120;
	}

	public String getDateAdded() {
		return dateAdded;
	}
	public void setDateAdded(String dateAdded) {
		this.dateAdded = dateAdded;
	}

	public String getDateSold() {
		return dateSold;
	}
	public void setDateSold(String dateSold) {
		this.dateSold = dateSold;
	}

	public String getPriceSticker() {
		return priceSticker;
	}
	public void setPriceSticker(String priceForSale) {
		this.priceSticker = priceForSale;
	}

	public String getPriceSold() {
		return priceSold;
	}
	public void setPriceSold(String priceSold) {
		this.priceSold = priceSold;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getBuyer() {
		return buyer;
	}
	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}


	
	
}//end Class
