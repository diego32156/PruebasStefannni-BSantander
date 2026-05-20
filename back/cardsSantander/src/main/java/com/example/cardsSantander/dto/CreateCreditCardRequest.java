package com.example.cardsSantander.dto;

public class CreateCreditCardRequest {
	
	private String customName; 
	private String documentNumber;
	
	public CreateCreditCardRequest() {}

	public CreateCreditCardRequest(String customName, String documentNumber) {
		super();
		this.customName = customName;
		this.documentNumber = documentNumber;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	
}