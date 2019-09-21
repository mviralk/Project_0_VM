package com.mistbank.service.impl;

import java.text.ParseException;
import java.util.Date;

import com.mistbank.dao.impl.MistbankDaoImpl;
import com.mistbank.exceptions.BusinessException;
import com.mistbank.model.CheckingAccounts;
import com.mistbank.model.MistUser;
import com.mistbank.model.SavingAccounts;
import com.mistbank.model.Transactions;
import com.mistbank.service.MistbankService;

public class MistbankServiceImpl implements MistbankService{

	@Override
	public SavingAccounts useraccountcreatesavings(SavingAccounts savingaccounts) throws BusinessException {
		if(savingaccounts == null) {
			throw new BusinessException("Internal error registration failed");
		}
		
		SavingAccounts userdetails = new SavingAccounts();
		MistbankDaoImpl dao = new MistbankDaoImpl();
		savingaccounts = dao.useraccountcreatesavings(userdetails);
		
		
		if(!((savingaccounts.getSsn())+"").matches("[0-9]{9}")){
			throw new BusinessException("Please enter 9 Digits only with no dashes or spaces.");
		}
		if(!(savingaccounts.getPhonenumber()+"").matches("[0-9]{3}-[0-9]{3}-[0-9]{4}")) {
			throw new BusinessException("Invalid phone number format.");
		}


		return null;
	}

	@Override
	public CheckingAccounts useraccountcreatechecking(CheckingAccounts checkingaccounts) throws BusinessException {	
		
		MistUser userdetails1 = new MistUser();
		MistbankDaoImpl dao = new MistbankDaoImpl();
		if(userdetails1 != null) {
		userdetails1 = dao.useraccountcreatechecking(checkingaccounts);
		}
		//checkingaccounts = dao.useraccountcreatechecking(userdetails1);
		
		
		
		return checkingaccounts;
	}

	@Override
	public MistUser userauth(MistUser auth) throws BusinessException {
		MistbankDaoImpl dao = new MistbankDaoImpl();
		auth = dao.userauth(auth);
		if(auth == null) {
			throw new BusinessException("Internal error occured contact admin");
		}
		return auth;
	}

	@Override
	public Transactions checkingtrans(Transactions checktransaction) throws BusinessException {
		//Transactions transac = new Transactions();
		if(checktransaction.getDeposit()<0 || checktransaction.getWithdraw() < 0) {
			throw new BusinessException("Withdrawl/Deposit amount cannot be negative");
		}
		if(checktransaction.getWithdraw() < checktransaction.getCheckingavailablebalance()) {
			throw new BusinessException("Withdrawl Denied amount is too large");
		}
		MistbankDaoImpl dao = new MistbankDaoImpl();
		checktransaction = dao.checkingtrans(checktransaction);
		
		return checktransaction;
	}

	@Override
	public Transactions savingtrans(Transactions savingtransaction) throws BusinessException {
		Transactions transac = new Transactions();
		MistbankDaoImpl dao = new MistbankDaoImpl();
		savingtransaction = dao.checkingtrans(transac);
		if(savingtransaction == null) {
			throw new BusinessException("Internal error transaction failed");
		}
		return savingtransaction;
	}
	
	public long getAccountID(String username) throws BusinessException {
		MistbankDaoImpl dao = new MistbankDaoImpl();
		return dao.getAccountId(username);
		
	}

	@Override
	public double getCheckingAvailableBalance(String username) throws BusinessException {
		MistbankDaoImpl dao = new MistbankDaoImpl();
		return dao.getCheckingAvailableBalance(username);
	}
	

	

	

}
