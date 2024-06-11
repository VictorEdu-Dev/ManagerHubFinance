package org.vedu.managerhubfinance.persistence.model.financialblock;

public enum FinPaymentTypeEnum {
	CASH("01"),
	CHECK("02"),
	DEBIT_CARD("03"),
	CREDIT_CARD("04"),
	NET_BANKING("05"),
	OTHERS("06");
	
	private final String value;
	
	FinPaymentTypeEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
