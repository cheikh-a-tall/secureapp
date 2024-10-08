package com.samanecorp.secure.mapper;

import java.util.List;

import com.samanecorp.secure.dto.AccountUserDto;
import com.samanecorp.secure.entities.AccountUserEntity;


public class AccountUserMapper {
private AccountUserMapper() {
		
	}

	public static AccountUserEntity toAccountUserEntity(AccountUserDto accountUserDto) {
		
		AccountUserEntity accountUserEntity = new AccountUserEntity();

		accountUserEntity.setId(accountUserDto.getId());
		accountUserEntity.setEmail(accountUserDto.getEmail());
		accountUserEntity.setPassword(accountUserDto.getPassword());
		accountUserEntity.setState(accountUserDto.isState());
		
		return accountUserEntity;	
	}
	
	public static AccountUserDto toAccountUserDto(AccountUserEntity accountUserEntity) {
		
		AccountUserDto accountUserDto = new AccountUserDto();
		
		accountUserDto.setId(accountUserEntity.getId());
		accountUserDto.setEmail(accountUserEntity.getEmail());
		accountUserDto.setPassword(accountUserEntity.getPassword());
		accountUserDto.setState(accountUserEntity.isState());
		
		return accountUserDto;	
	}
	
	public static List<AccountUserDto> toListAccountUserDto(List<AccountUserEntity> accountUserEntities) {
		return accountUserEntities.stream()
							.map(AccountUserMapper::toAccountUserDto)
							.toList();		
	}	
}
