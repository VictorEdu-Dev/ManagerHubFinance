package org.vedu.managerhubfinance.persistence.model.financialblock;

public enum FinNatureFinEnum {
	R1001("Vendas de produtos"),
	R1002("Prestações de serviços"),
	R1003("Receita de juros"),
	R1004("Receita de aluguel"),
	R1005("Outras receitas operacionais"),
	D2001("Salários e encargos"),
	D2002("Aluguel"),
	D2003("Despesas de energia"),
	D2004("Despesas de água"),
	D2005("Matéria-prima e insumos"),
	D2006("Outras despesas operacionais");
	

	private String value;

	FinNatureFinEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
