package org.vedu.managerhubfinance.persistence.model.groupcollaborator;

public enum Commissioning {
	LPVPP("Liberação parcial vinculada ao pagamento das parcelas"),
	LIF("Liberação integral do fatiamento (lançamento de contas)"),
	LIPPP("Liberação integral após pagamento da primeira parcela"),
	LIPUP("Liberação integral após pagamento da última parcela");
	
	private String commissioning;
	
	Commissioning(String commissioning) {
		this.commissioning = commissioning;
    }
	
	public String getCommissioning() {
		return commissioning;
    }

}
