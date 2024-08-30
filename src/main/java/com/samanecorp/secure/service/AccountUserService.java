package com.samanecorp.secure.service;

import java.util.List;
import java.util.Optional;

import com.samanecorp.secure.dao.AccountUserDao;
import com.samanecorp.secure.dao.IAccountUserDao;
import com.samanecorp.secure.dto.AccountUserDto;
import com.samanecorp.secure.entities.AccountUserEntity;
import com.samanecorp.secure.mapper.AccountUserMapper;


public class AccountUserService implements IAccountUserService{

	private IAccountUserDao accountUserDao = new AccountUserDao();
	
	/**
	 * Cette méthode permet de vérifier les identifiants d'un utilisateur à partir de son mail et de son mot de passe.
	 * @email : représente l'email de l'utilisateur.
	 * @password : représente le mot de passe de l'utilisateur.
	 * La fonction retourne un Optional de AccountUserDto qui peut être vide ou pas.
	 */
	@Override
	public Optional<AccountUserDto> login(String email, String password) {
		
		if(email.isBlank() || password.isBlank()) {
			return Optional.empty();
		}
		else {
			return testLogin(email, password);
		}
	}

	private Optional<AccountUserDto> testLogin(String email, String password) {
		
		
		
		return accountUserDao.login(email, password)
							 .map(user -> Optional.of(AccountUserMapper.toAccountUserDto(user)))
							 .orElse(Optional.empty());
	}

	@Override
	public Optional<List<AccountUserDto>> findAll() {
		List<AccountUserEntity> accountUserEntityList = accountUserDao.list(new AccountUserEntity());
		
		return Optional.of(AccountUserMapper.toListAccountUserDto(accountUserEntityList));
	}

	public void setAccountUserDao(IAccountUserDao accountUserDao) {
		this.accountUserDao = accountUserDao;
	}

	@Override
	public boolean save(AccountUserDto accountUserDto) {
		return accountUserDao.save(AccountUserMapper.toAccountUserEntity(accountUserDto));
	}
	
	

}
