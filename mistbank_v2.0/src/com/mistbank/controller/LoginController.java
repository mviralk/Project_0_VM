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
import com.mistbank.model.MistUser;
import com.mistbank.service.MistbankService;
import com.mistbank.service.SHA256Demo;
import com.mistbank.service.impl.MistbankServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MistUser user = new MistUser();
		
		
		//System.out.println("setting userpass");
		user.setUsername(request.getParameter("username"));
		user.setPassword(new SHA256Demo().sha256(request.getParameter("psw")));
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		MistbankService service = new MistbankServiceImpl();
		//System.out.println("service layer object");
		
		RequestDispatcher rd = null;
		
		try {
			//System.out.println("test 1");
			
			if (service.userauth(user) != null) {
				
				//System.out.println(" test 2");
				rd = request.getRequestDispatcher("success");
				rd.forward(request, response);

			}
		} catch (BusinessException e) {
			//System.out.println(e);
			rd = request.getRequestDispatcher("member_login.html");
			rd.include(request, response);
			out.print("<center><span style='color:red;'>" + e.getMessage() + "</span></center>");
		}
	}

}
