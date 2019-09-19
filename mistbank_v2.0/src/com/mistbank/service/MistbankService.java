package com.mistbank.service;

import com.mistbank.exceptions.BusinessException;
import com.mistbank.model.CheckingAccounts;
import com.mistbank.model.MistUser;
import com.mistbank.model.SavingAccounts;
import com.mistbank.model.Transactions;

public interface MistbankService {
	
	public SavingAccounts useraccountcreatesavings(SavingAccounts savingaccounts) throws BusinessException;
	public CheckingAccounts useraccountcreatechecking(CheckingAccounts checkingaccounts) throws BusinessException;
	public MistUser userauth(MistUser auth) throws BusinessException;
	public Transactions checkingtrans(Transactions checktransaction) throws BusinessException;
	public Transactions savingtrans(Transactions savingtransaction) throws BusinessException;
	public double getCheckingAvailableBalance(String username) throws BusinessException;

}
