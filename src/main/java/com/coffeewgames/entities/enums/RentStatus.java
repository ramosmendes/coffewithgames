package com.coffeewgames.entities.enums;

public enum RentStatus {

	PENDING(1), PAID(2), CANCELED(3);

	private int code;

	private RentStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static RentStatus valueOf(int code) {
		for (RentStatus value : RentStatus.values()) {
			if (value.getCode() == code)
				return value;
		}
		throw new IllegalArgumentException("Invalid code");
	}
}
