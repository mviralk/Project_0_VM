package com.mistbank.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.mistbank.exceptions.BusinessException;
import com.mistbank.model.CheckingAccounts;
import com.mistbank.model.MistUser;
import com.mistbank.model.Transactions;
import com.mistbank.service.MistbankService;
import com.mistbank.service.impl.MistbankServiceImpl;

/**
 * Servlet implementation class TransactionController
 */
@WebServlet("/transaction")
public class TransactionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String requestData = request.getReader().lines().collect(Collectors.joining());
		//System.out.println(requestData);
		CheckingAccounts checkacct = gson.fromJson(requestData, CheckingAccounts.class);
		Transactions transaction = gson.fromJson(requestData, Transactions.class);
		MistUser user = new MistUser();
		user = (MistUser) session.getAttribute("login_session");
		System.out.println(checkacct.getCheckingaccountnumber());
		System.out.println(checkacct);
		transaction.setUsername(user.getUsername());
		
		MistbankService service = new MistbankServiceImpl();
		System.out.println("service layer object");
		System.out.println(request.getParameter("depositamount"));
		RequestDispatcher rd = null;
		
		try {
			Transactions t = service.checkingtrans(transaction);
			System.out.println("checking transactions"+ t);
			if (t != null) {
				System.out.println(" test 2");
				//String s = new Gson().toJson(new MistbankDaoImpl().getCheckingAvailableBalance(request.getParameter("username")));
				//System.out.println(s);
				//out.print(s);
				//System.out.println(" test 2");
				rd = request.getRequestDispatcher("balance");
				//rd.forward(request, response);
				out.print(gson.toJson(transaction));
				

			}
		} catch (BusinessException e) {
			System.out.println(e);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
		MistbankService service = new MistbankServiceImpl();
		List<Transactions> transactions = null;
		
		
		try {
			if((transactions = service.getTransactions(username))!=null) {
				System.out.println(gson.toJson(transactions));
				out.print(gson.toJson(transactions));
			}
		} catch (BusinessException e) {
			System.out.println(e);
		}
	}

}
