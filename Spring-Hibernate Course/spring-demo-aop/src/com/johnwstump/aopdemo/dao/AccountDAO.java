package com.johnwstump.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

	public void addAccount() {
		System.out.println(getClass() + ": PLACEHOLDER : ADDING AN ACCOUNT");
	}
}
