package com.controller;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Inventory;


@WebServlet("/AddVehServlet")
public class AddVehServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddVehServlet() {
        super();  
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String imgSrc = request.getParameter("imgSrc");
		String vehId = Integer.toString(ThreadLocalRandom.current().nextInt(100000, 999999));
		String year = request.getParameter("year");
		String make = request.getParameter("make");
		String model = request.getParameter("model");
		String bodyStyle = request.getParameter("bodyStyle");
		String color = request.getParameter("color");
		String miles = request.getParameter("miles");
		String condition = request.getParameter("condition");
		String isSold = "false";
		String isOver120 = "false";
		String dateAdded = request.getParameter("dateAdded");
		String dateSold = null;
		String priceSticker = request.getParameter("priceSticker");
		String priceSold = null;
		String description = request.getParameter("description");
		String buyer = null;
		
		//write to inventory.txt using addInventory method of Class Inventory
		String newVehicle = imgSrc + "," + vehId + "," + year + "," + make + "," + model + "," + bodyStyle + "," + color +
				"," + miles + "," + condition + "," + isSold + "," + isOver120 + "," + dateAdded + "," + dateSold + "," + priceSticker + 
				"," + priceSold + "," + description + "," + buyer;
		Inventory.addToDataFile(newVehicle);
		
		RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
		rs.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
