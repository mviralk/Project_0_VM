package com.mistbank.service;

import com.mistbank.exceptions.BusinessException;
import com.mistbank.model.MistUser;

public interface MistbankService {
	
	public MistUser useraccountcreate(MistUser mistUser) throws BusinessException;

}
