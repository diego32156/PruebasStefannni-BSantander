package com.example.cardsSantander.entity;

import java.time.LocalDateTime;

import com.example.cardsSantander.enums.CreditCardStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumeratedValue;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name="credits_cards")
public class CreditCards {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String customName;
	private String documentNumber;
	private String cardNumberMasked;
	private String lastFourDigit;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
	
	
	@Enumerated(EnumType.STRING)
	private CreditCardStatus status;
	
	public CreditCards() {}

	public CreditCards(long id, String customName, String documentNumber, String cardNumberMasked, String lastFourDigit,
			CreditCardStatus status,  LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.customName = customName;
		this.documentNumber = documentNumber;
		this.cardNumberMasked = cardNumberMasked;
		this.lastFourDigit = lastFourDigit;
		this.status = status;
	    this.createdAt = createdAt;
        this.updatedAt = updatedAt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getCardNumberMasked() {
		return cardNumberMasked;
	}

	public void setCardNumberMasked(String cardNumberMasked) {
		this.cardNumberMasked = cardNumberMasked;
	}

	public String getLastFourDigit() {
		return lastFourDigit;
	}

	public void setLastFourDigit(String lastFourDigit) {
		this.lastFourDigit = lastFourDigit;
	}

	public CreditCardStatus getStatus() {
		return status;
	}

	public void setStatus(CreditCardStatus status) {
		this.status = status;
	}
	
    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.status = CreditCardStatus.CREATED;
    }
	
    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
    
    
	
}
