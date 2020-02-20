package edu.elsmancs.creditCard;


public class CreditCard {
	
	private String owner = null;
	private String number = null;
	private double credit = 3000;
	private final String SYMBOL = "EZI"; 
	
	/**
	 * Constructor
	 */
	public CreditCard(String owner, String number) {
		this.owner = owner;
		this.number = number;
	}
	
	//este getter est� solo para que se pueda acceder desde el toString de Menu
	
	public String owner() {
		return this.owner;
	}
	public String number() {
		return this.number;
	}
	
	public double credit() {
		return this.credit;
	}
	
	public boolean pay(double amount) {
		if (this.credit >= amount) {
			this.credit -= amount;
			return true;
		}
		return false;
	}
	

	@Override
	public String toString() {
		return "owner: " + this.owner + "\nnumber: " + this.number + "\ncredit: " + this.credit + this.SYMBOL;
	}
}
