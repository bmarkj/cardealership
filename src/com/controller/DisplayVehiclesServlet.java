package com.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Inventory;
import com.bean.Vehicle;

//"called" by the "include" statement on line 95 in index.jsp

@WebServlet("/DisplayVehiclesServlet") 
public class DisplayVehiclesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DisplayVehiclesServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		HttpSession session = request.getSession(true);
		
		//@SuppressWarnings("unchecked")
		ArrayList<Vehicle> masterInventory = Inventory.readDataFile();
		session.setAttribute("masterInventory", masterInventory);
		
		ArrayList<Vehicle> unsoldInventory = Inventory.filterSoldVehicles();
		session.setAttribute("vehicles", unsoldInventory);
		
		ArrayList<String> allMakes = Inventory.listAllMakes(unsoldInventory);
		Collections.sort(allMakes);
		session.setAttribute("vehMakes", allMakes);
		
		ArrayList<String> allConditions = Inventory.listAllConditions(unsoldInventory);
		Collections.sort(allConditions);
		session.setAttribute("vehConditions",  allConditions);
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
