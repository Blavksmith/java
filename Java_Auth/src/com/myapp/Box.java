package com.myapp;

public class Box<Thing> {
	Thing item;

	public void setItem(Thing item) {
		this.item = item;
	}
	
	public Thing getItem() {
		return this.item;
	}
	
	
	public static void main(String args[]) {
		Box<Integer> box = new Box<>();
	}
}
