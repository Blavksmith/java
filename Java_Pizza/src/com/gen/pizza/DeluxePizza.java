package com.gen.pizza;

public class DeluxePizza extends Pizza {

	public DeluxePizza(boolean veg) {
		super(veg);
		super.addExtraCheese(); // lgsg include
		super.addExtraTopping(); // lgsgg inclde
		// Deluxe Pizza udah ada extra cheese sama topping jadi otomatis ditambah
	}

	@Override
	public void addExtraCheese() {
		// TODO Auto-generated method stub
		System.out.println("Already Include in Pizza");
		
	}

	@Override
	public void addExtraTopping() {
		// TODO Auto-generated method stub
		System.out.println("Already Include in Pizza");
	}
	
	@Override
    public void getBill() {
        System.out.println("Total Price must be paid: " + this.getPrice());
    }
	
	
}
