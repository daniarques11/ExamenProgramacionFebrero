package edu.elsmancs.UfosPark;


import java.util.HashMap;

import edu.elsmancs.creditCard.CreditCard;

public class UfosPark {

	private HashMap<Ufo, CreditCard> flota = new HashMap<>(); 
	private double fee = 500;
	/*
	 * Constructor
	 * */
	public UfosPark() {	}
	
	int size() {
		return this.flota.size();
	}
	
	public void add(String ufoID) {
		Ufo ufo = new Ufo(ufoID);
		flota.put(ufo, null);
	}
	
	public void dispatch(CreditCard user) {
		if (!flota.containsValue(user) && freeUfos() > 0) {
			if(user.pay(this.fee)) {
				flota.put(getFreeUfo(), user);
			} else {
				
			}
		} else {
			// falla silenciosamente
		}
	}
	
	Ufo getFreeUfo() {
		for(Ufo ufo : flota.keySet()) {
			if(flota.get(ufo) == null) {
				return ufo;
			}
		}
		return null;
	}
	
	int freeUfos() {
		int freeUfoCount = 0;
		for (Ufo ufo : flota.keySet()) {
			if(flota.get(ufo) == null ) {
				freeUfoCount++;
			}
		}	
		return freeUfoCount;
	}

	public Ufo getUfoOf(String creditCardNum) {
		for (Ufo ufo : flota.keySet()) {
			if(flota.get(ufo) != null && flota.get(ufo).number() == creditCardNum) {
				return ufo;
			}
		}
		return null;
	}
	 
	@Override
	public String toString() {
		return flota.keySet().toString();
	}
}
