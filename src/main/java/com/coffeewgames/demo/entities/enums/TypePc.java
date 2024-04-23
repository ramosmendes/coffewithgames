package com.coffeewgames.demo.entities.enums;

public enum TypePc {

	LOW(100), MEDIUM(150), HIGH(250), ULTRA(300);

	private final int price;

	private TypePc(int price) {
		this.price = price;
	}

	public Integer getPrice() {
		return price;
	}
}
