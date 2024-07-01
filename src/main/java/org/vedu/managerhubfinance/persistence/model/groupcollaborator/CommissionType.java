package org.vedu.managerhubfinance.persistence.model.groupcollaborator;

public enum CommissionType {
	CAF("Comissão com alíquota fixa"),
	CACDII("Comissão com alíquota conforme descontos individuais dos itens");
	
	private String commissionType;
	
	CommissionType(String commissionType) {
		this.commissionType = commissionType;
	}
	
	public String getCommissionType() {
		return commissionType;
	}
}
