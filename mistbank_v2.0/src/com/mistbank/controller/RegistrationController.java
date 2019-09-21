package com.mistbank.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mistbank.exceptions.BusinessException;
import com.mistbank.model.CheckingAccounts;
import com.mistbank.service.MistbankService;
import com.mistbank.service.SHA256Demo;
import com.mistbank.service.impl.MistbankServiceImpl;

/**
 * Servlet implementation class RegistrationController
 */
@WebServlet("/register")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CheckingAccounts createuser = new CheckingAccounts();
		
		createuser.setUsername(request.getParameter("username"));
		createuser.setPassword(new SHA256Demo().sha256(request.getParameter("psw")));
		createuser.setFirstname(request.getParameter("fname"));
		createuser.setLastname(request.getParameter("lname"));	
		//System.out.println(java.sql.Date.valueOf(request.getParameter("dob")));
		createuser.setDob(java.sql.Date.valueOf(request.getParameter("dob")));
		//System.out.println(Long.parseLong(request.getParameter("ssn")));
		createuser.setSsn(Long.parseLong(request.getParameter("ssn")));		
		createuser.setPhonenumber(Long.parseLong(request.getParameter("phno")));
		
		PrintWriter out = response.getWriter();
		
		MistbankService service = new MistbankServiceImpl();
		
		RequestDispatcher rd = null;
		
		try {
			if(service.useraccountcreatechecking(createuser) != null) {
				
				rd = request.getRequestDispatcher("registrationsuccessful");
				rd.forward(request, response);
				
			}
		} catch (BusinessException e) {
			rd = request.getRequestDispatcher("registerPage.html");
			rd.include(request, response);
			out.print("<center><span style='color:red;'>" + e.getMessage() + "</span></center>");
		}
	}

}
