package com.isidro.ejercicio2;

import java.math.BigDecimal;

public enum Tax {
	
	NORMAL(new BigDecimal("0.21")),
	REDUCED(new BigDecimal(0.10)),
	SUPERREDUCED(new BigDecimal(0.21));

	public BigDecimal percent;

	// Constructor
	private Tax(BigDecimal percent) {
		this.percent = percent;
	}

	// Getter
	public BigDecimal getPercent() {
		return percent;
	}
}