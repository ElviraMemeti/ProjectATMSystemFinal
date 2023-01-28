package com.example.ProjectATMSystem;

import com.example.ProjectATMSystem.pojo.Account;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProjectAtmSystemApplicationTests {



	@Test
	void testWithdrawal() {
		Account account = new Account();
		account.makeDeposit(1,100.0);
		account.makeWithdrawal(1,50.0);
		double amount=50;
		assertEquals(50, amount);
		assertEquals(50, account.checkBalance(1));
	}

	@Test
	void testWithdrawalLargerThanBalance()
	{
		Account account=new Account();
		account.makeDeposit(1,100.0);


		account.makeWithdrawal(1,101.0);
		double amount=0;
		assertEquals(0, amount);

	}

	@Test
	void testDeposit(){
		Account account=new Account();
		account.makeDeposit(1,100.0);
		assertEquals(100, account.checkBalance(1));
	}

	@Test
	void testDifferentAmountsOfDeposit(){
		Account account=new Account();
		account.makeDeposit(1,20.0);
		account.makeDeposit(1,30.0);
		assertEquals(50,account.checkBalance(1));
	}


	@Test
	void testCheckBalance()
	{
		Account account=new Account();

		account.makeDeposit(1,100.0);
		assertEquals(100,account.checkBalance(1));

		account.makeWithdrawal(1,50.0);
		assertEquals(50,account.checkBalance(1));
	}

	@Test
	void testCheckBalanceWithZeroAmount()
	{
		Account account=new Account();
		assertEquals(0, account.checkBalance(1));

	}

}
