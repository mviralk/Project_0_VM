package com.mistbank.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import com.mistbank.dao.MistbankDAO;
import com.mistbank.dbutil.OracleConnection;
import com.mistbank.exceptions.BusinessException;
import com.mistbank.model.MistUser;
import com.mistbank.model.SavingAccounts;

public class MistbankDaoImpl implements MistbankDAO {

	@Override
	public SavingAccounts useraccountcreatesavings(SavingAccounts savingaccounts) throws BusinessException {
		try(Connection connection = OracleConnection.getConnection()){
			String sql = "call REGISTERSAVINSUSER(?,?,?,?,?,?,?,?,?,?,?)";
			CallableStatement callablestatement = connection.prepareCall(sql);
			callablestatement.setString(1, savingaccounts.getUsername());
			callablestatement.setString(2, savingaccounts.getPassword());
			callablestatement.registerOutParameter(3, java.sql.Types.NUMERIC);
			callablestatement.setDouble(4, savingaccounts.getSavingavailablebalance());
			callablestatement.setFloat(5, savingaccounts.getSavinginterest());
			callablestatement.setString(6, savingaccounts.getFirstname());
			callablestatement.setString(7, savingaccounts.getLastname());
			callablestatement.setDate(8, new java.sql.Date(savingaccounts.getDob().getTime()));
			callablestatement.setLong(9, savingaccounts.getSsn());
			callablestatement.setLong(10, savingaccounts.getPhonenumber());
			callablestatement.registerOutParameter(11, java.sql.Types.NUMERIC);
			
			callablestatement.execute();
			savingaccounts.setSerialnum(callablestatement.getLong(11));
			savingaccounts.setSavingaccountnumber(callablestatement.getLong(3));
			
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occured");
		}
		return savingaccounts;
	}

	

}
