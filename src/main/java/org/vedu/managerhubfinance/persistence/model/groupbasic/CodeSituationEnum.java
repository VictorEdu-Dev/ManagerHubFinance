package org.vedu.managerhubfinance.persistence.model.groupbasic;

public enum CodeSituationEnum {
	ICMS("Imposto sobre Circulação de Mercadorias e Serviços"),
	IPI("Imposto sobre Produtos Industrializados"),
	PIS("Programa de Integração Social"),
	COFINS("Contribuição para o Financiamento da Seguridade Social"),
	CSLL("Contribuição Social sobre o Lucro Líquido"),
	CSOSN("Código de Situação da Operação no Simples Nacional"),
	CFOP("Código Fiscal de Operações e Prestações"),
	CNAE("Classificação Nacional de Atividades Econômicas"),
	NCM("Nomenclatura Comum do Mercosul");

	private final String description;

	private CodeSituationEnum(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
