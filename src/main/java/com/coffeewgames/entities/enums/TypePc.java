package com.coffeewgames.entities.enums;

public enum TypePc {

	LOW(1), MEDIUM(2), HIGH(3), ULTRA(4);

	private int code;

	private TypePc(int code) {
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public static TypePc valueOf(int code) {
		for (TypePc value : TypePc.values()) {
			if (value.getCode() == code)
				return value;
		}
		throw new IllegalArgumentException("Invalid code");
	}
}
