package com.example.cardsSantander.dto;

import java.time.LocalDateTime;

import com.example.cardsSantander.enums.CreditCardStatus;

public class CreditCardsResponse {

	private Long id;
	private String customName;
	private String documentNumbre;
	private String cardNumberMasked;
	private String lastFourNumber;
	private CreditCardStatus status;
	private LocalDateTime createAt;
	private LocalDateTime updateAt;
	
	public CreditCardsResponse() {
		// TODO Auto-generated constructor stub
	}

	public CreditCardsResponse(Long id, String customName, String documentNumbre, String cardNumberMasked,
			String lastFourNumber, CreditCardStatus status, LocalDateTime createAt, LocalDateTime updateAt) {
		super();
		this.id = id;
		this.customName = customName;
		this.documentNumbre = documentNumbre;
		this.cardNumberMasked = cardNumberMasked;
		this.lastFourNumber = lastFourNumber;
		this.status = status;
		this.createAt = createAt;
		this.updateAt = updateAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomName() {
		return customName;
	}

	public void setCustomName(String customName) {
		this.customName = customName;
	}

	public String getDocumentNumbre() {
		return documentNumbre;
	}

	public void setDocumentNumbre(String documentNumbre) {
		this.documentNumbre = documentNumbre;
	}

	public String getCardNumberMasked() {
		return cardNumberMasked;
	}

	public void setCardNumberMasked(String cardNumberMasked) {
		this.cardNumberMasked = cardNumberMasked;
	}

	public String getLastFourNumber() {
		return lastFourNumber;
	}

	public void setLastFourNumber(String lastFourNumber) {
		this.lastFourNumber = lastFourNumber;
	}

	public CreditCardStatus getStatus() {
		return status;
	}

	public void setStatus(CreditCardStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreateAt() {
		return createAt;
	}

	public void setCreateAt(LocalDateTime createAt) {
		this.createAt = createAt;
	}

	public LocalDateTime getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}


}