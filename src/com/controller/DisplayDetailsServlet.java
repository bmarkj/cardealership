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

import com.bean.Vehicle;


@WebServlet("/DisplayDetailsServlet")
public class DisplayDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DisplayDetailsServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String thisVehId = request.getParameter("vehId");
		//System.out.println(thisVehId);
		
		HttpSession session = request.getSession(true);
		
		@SuppressWarnings("unchecked")
		ArrayList<Vehicle> vehicles = (ArrayList<Vehicle>) session.getAttribute("vehicles");
		for(Vehicle vehicle : vehicles) {
			if (vehicle.getVehId().equals(thisVehId)) {
				session.setAttribute("thisVehicle", vehicle);
				session.setAttribute("test120", vehicle.isOver120());
				//System.out.println(vehicle.isOver120());
			}
		}
	
		RequestDispatcher rs = request.getRequestDispatcher("details.jsp");
		rs.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
