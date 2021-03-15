package csc131.junit;

import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.text.DecimalFormat;

import org.junit.rules.ExpectedException;

public class GiftCardTest {

	@Test
	public void getIssuingStore() {
		double balance;
		GiftCard card;
		int issuingStore;
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		//constructor_IncorrectID_Low(issuingStore);
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
	}
	@Test
	public void getBalance() {
		double balance;
		GiftCard card;
		int issuingStore;
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getBalance()", balance, card.getBalance(), 0.001);
	}
	@Test
	public void equalCalls() { //String Named, String say, getIssuingStore()
		//assertEquals(java.lang.String message, java.lang.Object expected, java.lang.Object actual)
		double balance;
		GiftCard card;
		int issuingStore;
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
		assertEquals("getBalance()", balance, card.getBalance(), 0.001);
	}
	@Test
	public void deductRemainingBalance() {
		double balance, balanceUsed;
		String newBalance;
		GiftCard card;
		int issuingStore;
		issuingStore = 1337;
		balance = 100.00;
		balanceUsed = 30.00;
		
		
		card = new GiftCard(issuingStore, balance);
		newBalance = card.deduct(balanceUsed);
		String balanceComparison = "Remaining Balance: " + String.format("%6.2f",
                Math.abs(card.getBalance()));
		
		assertEquals("newBalance",newBalance,balanceComparison);
		String greaterBalance = card.deduct(500.00);
		String lesserBalance = card.deduct(-20.00);
	}

	
	@Test 
	public void constructor_IncorrectID_Low() {
		double balance;
		GiftCard card;
		int issuingStore;
		issuingStore = -5;
		balance = 500;
		card = new GiftCard(issuingStore, balance);
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
		//constructor_IncorrectID_Low(issuingStore);
		//assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
	}
	@Test
	public void constructor_IncorrectID_High() {
		double balance;
		GiftCard card;
		int issuingStore;
		issuingStore = 200;
		balance = -50;
		card = new GiftCard(issuingStore, balance);
		assertEquals("getIssuingStore()", issuingStore, card.getIssuingStore());
		//constructor_IncorrectID_Low(issuingStore);
		//assertThrows(IllegalArgumentException.class, () -> {new GiftCard(1,-100.00);});
	}
}
