package edu.elsmancs.creditCard;

import static org.junit.Assert.*;

import org.junit.Test;

public class CreditCardTest {

	@Test
	public void crearCreditCardeTest() {
		CreditCard daniel = new CreditCard("Daniel Arqu�s", "9214921492524");
		assertNotNull(daniel);
	}

}
