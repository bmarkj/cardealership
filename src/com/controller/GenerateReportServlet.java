package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Vehicle;



@WebServlet("/GenerateReportServlet")
public class GenerateReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public GenerateReportServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		
		@SuppressWarnings("unchecked")
		ArrayList<Vehicle> masterInventory = (ArrayList<Vehicle>) session.getAttribute("masterInventory");
		ArrayList<Vehicle> soldVehicles = new ArrayList<Vehicle>();
		ArrayList<Vehicle> discountedVehicles = new ArrayList<Vehicle>();
		
		Comparator<Vehicle> compareByDateSold = new Comparator<Vehicle>() {
			
			@Override
			public int compare(Vehicle arg0, Vehicle arg1) {
					
				return arg0.getDateSold().compareTo(arg1.getDateSold());
			}
		};
		
		Comparator<Vehicle> compareByDateAdded = new Comparator<Vehicle>() {
			
			@Override
			public int compare(Vehicle arg0, Vehicle arg1) {
					
				return arg0.getDateAdded().compareTo(arg1.getDateAdded());
			}
		};
		

		String message = "";
		session.setAttribute("message", message);
		String report = request.getParameter("report");
		session.setAttribute("report", report);
		
		if(report == "" || report == null) {
			System.out.println("Report was empty or null");
			message = "Please select a report";
			session.setAttribute("message", message);
			session.setAttribute("soldVehicles", "");
			session.setAttribute("discountedVehicles", "");
			
			RequestDispatcher rs = request.getRequestDispatcher("reports.jsp");
			rs.forward(request, response);
		}
		else if (report.equalsIgnoreCase("vehSales")) {
			for(Vehicle vehicle : masterInventory) {
				if(vehicle.isSold()) {
					soldVehicles.add(vehicle);
				}
			}
			if (soldVehicles.isEmpty()) {
				message = "There are no sold vehicles to report";
				session.setAttribute("message", message);
				session.setAttribute("soldVehicles", "");
				session.setAttribute("discountedVehicles", "");

			}
			else {
				message = "";
				session.setAttribute("message", message);
				Collections.sort(soldVehicles, compareByDateSold.reversed());
				session.setAttribute("soldVehicles", soldVehicles);
				session.setAttribute("discountedVehicles", "");
				
			}

			RequestDispatcher rs = request.getRequestDispatcher("reports.jsp");
			rs.forward(request, response);
		}
		else {
			for(Vehicle vehicle : masterInventory) {
				if(vehicle.isOver120() && !vehicle.isSold()) {
					discountedVehicles.add(vehicle);
				}
			}
			if (discountedVehicles.isEmpty()) {
				message = "There are no discounted vehicles in inventory";
				session.setAttribute("message", message);
				session.setAttribute("soldVehicles", "");
				session.setAttribute("discountedVehicles", "");
			}
			else {
				message = "";
				Collections.sort(discountedVehicles, compareByDateAdded);
				session.setAttribute("message", message);
				session.setAttribute("soldVehicles", "");
				session.setAttribute("discountedVehicles", discountedVehicles);
			}
					
			RequestDispatcher rs = request.getRequestDispatcher("reports.jsp");
			rs.forward(request, response);
		}
	}//end doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
