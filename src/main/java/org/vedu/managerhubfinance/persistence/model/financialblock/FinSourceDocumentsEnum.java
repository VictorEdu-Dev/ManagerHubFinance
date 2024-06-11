package org.vedu.managerhubfinance.persistence.model.financialblock;

public enum FinSourceDocumentsEnum {
	INVOICE("Nota fiscal"),
	RECEIPT("Recibo"),
	BOLETO("Boleto"),
	CONTRACT("Contrato"),
	OTHER("Outro"),
	NOT_APPLICABLE("Não se aplica"),
	NF("Nota fiscal"),
	CHQ("Cheque"),
	NFe("Nota fiscal eletrônica"),
	DP("Duplicata"),
	NP("Nota promissória"),
	CTe("Conhecimento de transporte eletrônico"),
	CT("Conhecimento de transporte"),
	CF("Cupom fiscal"),
	CFe("Cupom fiscal eletrônico");
	
	private String value;
	
	FinSourceDocumentsEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
