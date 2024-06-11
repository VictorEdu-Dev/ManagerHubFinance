package org.vedu.managerhubfinance.persistence.model.financialblock;

public enum FinInstallmentStatusEnum {
	PENDING("01"),
	PAID("02"),
	CANCELLED("03"),
	PARTIALLY_PAID("04"),
	OVERDUE("05"),
	DUE("06"),
	INACTIVE("07");
	
	private String str;
	
	FinInstallmentStatusEnum(String str) {
		this.str = str;
	}
	
	public String getValue() {
		return str;
	}

}
