package org.vedu.managerhubfinance.controller;

import java.io.IOException;

import org.vedu.managerhubfinance.persistence.model.persongroup.Person;
import org.vedu.managerhubfinance.persistence.repository.PersonDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/personServlet")
public class PersonServlet extends HttpServlet {
	private static final long serialVersionUID = 7718788711864047538L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	

}
