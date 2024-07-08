package bank.service;

import java.util.ArrayList;
import java.util.Collection;


public class AccountDto {
	private long accountnumber;
	private double balance;
	private Collection<AccountEntryDto> entryList = new ArrayList<AccountEntryDto>();
	private CustomerDto customer;

	public AccountDto() {
	}

	public AccountDto(long accountnr){
		this.accountnumber = accountnr;
	}
	public long getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(long accountnumber) {
		this.accountnumber = accountnumber;
	}
	public CustomerDto getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerDto customer) {
		this.customer = customer;
	}
	public Collection<AccountEntryDto> getEntryList() {
		return entryList;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
}
