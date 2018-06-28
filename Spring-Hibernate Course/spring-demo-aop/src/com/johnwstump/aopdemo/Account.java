package com.johnwstump.aopdemo;

public class Account {

	private Member member;
	private String level;
	
	public Account() {}
	
	public Account(Member member, String level) {
		this.member = member;
		this.level = level;
	}
	
	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getLevel() {
		return level;
	}
	
	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "Account [Member=" + member + ", level=" + level + "]";
	}
}
