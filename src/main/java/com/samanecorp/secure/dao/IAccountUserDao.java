package com.samanecorp.secure.dao;

import java.util.Optional;

import com.samanecorp.secure.entities.AccountUserEntity;



public interface IAccountUserDao extends Repository<AccountUserEntity> {
	
	Optional<AccountUserEntity> login(String email, String password);

}
