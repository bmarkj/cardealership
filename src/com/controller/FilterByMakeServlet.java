package com.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Inventory;
import com.bean.Vehicle;


@WebServlet("/FilterByMakeServlet")
public class FilterByMakeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FilterByMakeServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get session object
		HttpSession session = request.getSession(true);
		
		//instantiate an ArrayList, then populate it with the vehicle objects in the session
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>(Inventory.filterSoldVehicles());
		ArrayList<Vehicle> filteredVehicles = new ArrayList<Vehicle>();
		
		//set a variable to hold the make property
		String make = request.getParameter("make");
		//System.out.println(make);
		
		if (make.equalsIgnoreCase("All") ){
			session.setAttribute("vehicles", vehicles);
			RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
			rs.forward(request, response);
		}
		else {
			for (Vehicle vehicle : vehicles) {
				if(vehicle.getMake().contentEquals(make)) {
					filteredVehicles.add(vehicle);
				}
			}
			//put filteredVehicles in session object
			session.setAttribute("vehicles", filteredVehicles);
			
			RequestDispatcher rs = request.getRequestDispatcher("filtered.jsp");
			rs.forward(request, response);
		}
		
	}//end doGet


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
