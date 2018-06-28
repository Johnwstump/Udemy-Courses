package com.johnwstump.aopdemo.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.johnwstump.aopdemo.Member;

@Component
public class MembershipDAO {

	public void addAccount() {
		System.out.println(getClass() + ": PLACEHOLDER : ADDING AN MEMBERSHIP ACCOUNT");
	}

	public List<Member> findMembers() throws Exception{
		// Simulates failure
		throw new Exception("Not yet implemented.");
	}
	
}
