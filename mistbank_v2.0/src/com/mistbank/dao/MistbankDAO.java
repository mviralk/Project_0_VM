package com.mistbank.dao;

import com.mistbank.exceptions.BusinessException;
import com.mistbank.model.CheckingAccounts;
import com.mistbank.model.MistUser;
import com.mistbank.model.SavingAccounts;
import com.mistbank.model.Transactions;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public interface MistbankDAO {
	
	public SavingAccounts useraccountcreatesavings(SavingAccounts savingaccounts) throws BusinessException;
	public CheckingAccounts useraccountcreatechecking(CheckingAccounts checkingaccounts) throws BusinessException;
	public MistUser userauth(MistUser auth) throws BusinessException;
	public Transactions checkingtrans(Transactions checktransaction) throws BusinessException;
	public Transactions checkingwithdraw(Transactions withdraw) throws BusinessException;
	public Transactions savingtrans(Transactions savingtransaction) throws BusinessException;
	public long getAccountId(String username) throws BusinessException;
	public double getCheckingAvailableBalance(String username) throws BusinessException;
	public java.util.List<Transactions> getTransactions(String username) throws BusinessException;
}
