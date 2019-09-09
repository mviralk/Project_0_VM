package com.mistbank.service.impl;

import com.mistbank.dao.impl.MistbankDaoImpl;
import com.mistbank.exceptions.BusinessException;
import com.mistbank.model.CheckingAccounts;
import com.mistbank.model.MistUser;
import com.mistbank.model.SavingAccounts;
import com.mistbank.service.MistbankService;

public class MistbankServiceImpl implements MistbankService{

	@Override
	public SavingAccounts useraccountcreatesavings(SavingAccounts savingaccounts) throws BusinessException {
		SavingAccounts userdetails = new SavingAccounts();
		MistbankDaoImpl dao = new MistbankDaoImpl();
		savingaccounts = dao.useraccountcreatesavings(userdetails);
		if(savingaccounts == null) {
			throw new BusinessException("Internal error registration failed");
		}


		return null;
	}

	@Override
	public CheckingAccounts useraccountcreatechecking(CheckingAccounts checkingaccounts) throws BusinessException {
		CheckingAccounts userdetails1 = new CheckingAccounts();
		MistbankDaoImpl dao = new MistbankDaoImpl();
		checkingaccounts = dao.useraccountcreatechecking(userdetails1);
		if(checkingaccounts == null) {
			throw new BusinessException("Internal error registration failed");
		}
		
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

	

	

	

}
