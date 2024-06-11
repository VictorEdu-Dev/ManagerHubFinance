package org.vedu.managerhubfinance.persistence.model.financialblock;

public enum FinReceiptTypeEnum {
	BOLETO("01"), 
	CHECK("02"), 
	CASH("03"), 
	DEPOSIT("04"),
	DEBIT_CARD("05"),
	CREDIT_CARD("06"),
	NET_BANKING("07"),
	OTHERS("08");
	
	private final String value;
	
	FinReceiptTypeEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
