package com.example.cardsSantander.services;

import java.security.SecureRandom;

import org.springframework.stereotype.Service;

import com.example.cardsSantander.entity.CreditCards;
import com.example.cardsSantander.enums.CreditCardStatus;
import com.example.cardsSantander.repository.CreditCardRepository;
import com.example.cardsSantander.dto.CreateCreditCardRequest;
import com.example.cardsSantander.dto.CreditCardsResponse;

import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditCardService {
	
	private final CreditCardRepository creditCardRepository;
	private final SecureRandom secureRandom = new SecureRandom();
	
	
	public CreditCardService(CreditCardRepository creditCardRepository) {
		super();
		this.creditCardRepository = creditCardRepository;
	}


	public CreditCardsResponse  createCard(CreateCreditCardRequest request) {
		
        String lastFourDigits = generateLastFourDigits();
        String maskedNumber = "**** **** **** " + lastFourDigits;

        CreditCards card = new CreditCards();
        card.setCustomName(request.getCustomName());
        card.setDocumentNumber(request.getDocumentNumber());
        card.setLastFourDigit(lastFourDigits);
        card.setCardNumberMasked(maskedNumber);
        card.setStatus(CreditCardStatus.CREATED);

        CreditCards savedCard = creditCardRepository.save(card);

        return mapToResponse(savedCard);		
		
	}
	
	public List<CreditCardsResponse> getAllCards() {
        return creditCardRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public CreditCardsResponse activateCard(Long id) {
        CreditCards card = creditCardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarjeta no encontrada"));

        if (card.getStatus() == CreditCardStatus.BLOCKED) {
            throw new RuntimeException("No se puede activar una tarjeta bloqueada");
        }

        card.setStatus(CreditCardStatus.ACTIVE);

        CreditCards updatedCard = creditCardRepository.save(card);

        return mapToResponse(updatedCard);
    }

    public CreditCardsResponse blockCard(Long id) {
        CreditCards card = creditCardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarjeta no encontrada"));

        card.setStatus(CreditCardStatus.BLOCKED);

        CreditCards updatedCard = creditCardRepository.save(card);

        return mapToResponse(updatedCard);
    }

    private String generateLastFourDigits() {
        int number = secureRandom.nextInt(9000) + 1000;
        return String.valueOf(number);
    }

    private CreditCardsResponse mapToResponse(CreditCards card) {
        return new CreditCardsResponse(
                card.getId(),
                card.getCustomName(),
                card.getDocumentNumber(),
                card.getCardNumberMasked(),
                card.getLastFourDigit(),
                card.getStatus(),
                card.getCreatedAt(),
                card.getUpdatedAt()
        );
    }
    
    public CreditCardsResponse getCardById(Long id) {
        CreditCards card = creditCardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarjeta no encontrada con ID: " + id));

        return mapToResponse(card);
    }

}
