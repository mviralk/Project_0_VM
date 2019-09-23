package com.mistbank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
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
		//MistUser user = new MistUser();
		
		//System.out.println("login controller call");
		Gson gson = new Gson();
		//ServletOutputStream jout = response.getOutputStream();
		response.setContentType("application/json;charset=UTF-8");
		HttpSession session = request.getSession();
		String requestData = request.getReader().lines().collect(Collectors.joining());
		//System.out.println(requestData);
		MistUser user = gson.fromJson(requestData, MistUser.class);
		//System.out.println("setting userpass");
	/*user.setUsername(request.getParameter("username"));
		user.setPassword(new SHA256Demo().sha256(request.getParameter("psw")));*/
		user.setPassword(new SHA256Demo().sha256(user.getPassword()));
		//response.setContentType("text/html");
		//System.out.println(user.getUsername());
		//System.out.println(user.getPassword());
		PrintWriter out = response.getWriter();

		MistbankService service = new MistbankServiceImpl();
		//System.out.println("service layer object");
		
		RequestDispatcher rd = null;
		
		try {
			//System.out.println("test 1");
			
			if (service.userauth(user) != null) {
				session.setAttribute("login_session", user);
				//System.out.println(" test 2");
				rd = request.getRequestDispatcher("success");
				//rd.forward(request, response);
				out.print(gson.toJson(user));
				

			}
		} catch (BusinessException e) {
			System.out.println(e);
			rd = request.getRequestDispatcher("member_login.html");
			//rd.include(request, response);
			out.print("<center><span style='color:red;'>" + e.getMessage() + "</span></center>");
		}
	}

}
