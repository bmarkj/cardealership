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


@WebServlet("/SalesContractServlet")
public class SalesContractServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public SalesContractServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		String message;
		session.setAttribute("message", "");
		
		String dateSold = request.getParameter("dateSold");
		String buyer = request.getParameter("buyer");
		String thisVehId = request.getParameter("vehId");
		String buyersOffer = request.getParameter("priceOffered");
		
		if(dateSold.equals("") || buyer.equals("") || buyersOffer.equals("")) {
			
			message="The 'Date Sold', 'Buyer' and 'Buyer's Offer fields are required!";
			session.setAttribute("message", message);
			
			RequestDispatcher rs = request.getRequestDispatcher("contract.jsp");
			rs.forward(request, response);
		}
		
		int priceSticker;
		int offer = Integer.parseInt(buyersOffer);
		
		
		@SuppressWarnings("unchecked")
		ArrayList<Vehicle> masterInventory = (ArrayList<Vehicle>) session.getAttribute("masterInventory");
		for(Vehicle vehicle : masterInventory) {
			if (vehicle.getVehId().equals(thisVehId)) {
				priceSticker = Integer.parseInt(vehicle.getPriceSticker());
				if(vehicle.isOver120()) {
					if (offer >= (priceSticker * .90) ) {
						vehicle.setSold(true);
						vehicle.setDateSold(dateSold);
						vehicle.setBuyer(buyer);
						vehicle.setPriceSold(String.valueOf(offer));
						session.setAttribute("masterInventory", masterInventory);
						Inventory.updateDataFile(masterInventory);
						
						message = "Congratulations, your offer has been accepted and the sale has been recorded.";
						session.setAttribute("message",  message);
						
						RequestDispatcher rs = request.getRequestDispatcher("sold.jsp");
						rs.forward(request, response);
					}//end (offer >= (priceSticker * .90) )
					else {
						message = "Unfortunately we are unable to sell the vehicle for that amount. Please consider making another offer.";
						session.setAttribute("message",  message);
						RequestDispatcher rs = request.getRequestDispatcher("contract.jsp");
						rs.forward(request, response);
					}
				}//end if(vehicle.isOver120())
				else {
					if (offer >= (priceSticker * .97) ) {
						vehicle.setSold(true);
						vehicle.setDateSold(dateSold);
						vehicle.setBuyer(buyer);
						vehicle.setPriceSold(String.valueOf(offer));
						session.setAttribute("masterInventory", masterInventory);
						Inventory.updateDataFile(masterInventory);
						
						message = "Congratulations, your offer has been accepted and the sale has been recorded.";
						session.setAttribute("message",  message);
						
						RequestDispatcher rs = request.getRequestDispatcher("sold.jsp");
						rs.forward(request, response);
					}//end if (offer >= (priceSticker * .97) )
					else {
						message = "Unfortunately we are unable to sell the vehicle for that amount. Please consider making another offer.";
						session.setAttribute("message",  message);
						
						RequestDispatcher rs = request.getRequestDispatcher("contract.jsp");
						rs.forward(request, response);
					}//end else for if (offer >= (priceSticker * .97) )
				}//end else for if(vehicle.isOver120())
			}//end if (vehicle.getVehId == ...
		}//end for (Vehicle vehicle : vehicles)		
		
	}//end doGet

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
