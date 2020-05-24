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


@WebServlet("/FilterByConditionServlet")
public class FilterByConditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public FilterByConditionServlet() {
        super(); //calls Object class constructor; not really needed but it does no harm to leave it
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get session object
				HttpSession session = request.getSession(true);
				
				//instantiate an ArrayList, then populate it with the vehicle objects in the session
				ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>(Inventory.filterSoldVehicles());
				ArrayList<Vehicle> filteredVehicles = new ArrayList<Vehicle>();
				
				//set a variable to hold the make property
				String condition = request.getParameter("condition");
				//System.out.println(make);
				
				if (condition.equalsIgnoreCase("All") ){
					session.setAttribute("vehicles", vehicles);
					RequestDispatcher rs = request.getRequestDispatcher("index.jsp");
					rs.forward(request, response);
				}
				else {
					for (Vehicle vehicle : vehicles) {
						if(vehicle.getCondition().contentEquals(condition)) {
							filteredVehicles.add(vehicle);
						}
					}
					//put filteredVehicles in session object
					session.setAttribute("vehicles", filteredVehicles);
					
					RequestDispatcher rs = request.getRequestDispatcher("filtered.jsp");
					rs.forward(request, response);
				}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
