package com.johnwstump.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.johnwstump.aopdemo.Account;
import com.johnwstump.aopdemo.Member;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	
	public List<Account> findAccounts(){
		List<Account> accounts = new ArrayList<>();
		Account account = new Account(new Member("John", "Test"), "Silver");
		Account account2 = new Account(new Member("Madhu", "Test"), "Platinum");
		Account account3 = new Account(new Member("Luca", "Test"), "Gold");
		
		accounts.add(account);
		accounts.add(account2);
		accounts.add(account3);
		
		return accounts;
	}

	public void addAccount(Account account) {
		System.out.println("Method called. Adding Account.");
	}
}
