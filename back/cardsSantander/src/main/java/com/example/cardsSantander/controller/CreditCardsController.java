package com.example.cardsSantander.controller;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardsSantander.dto.CreateCreditCardRequest;
import com.example.cardsSantander.services.CreditCardService;
import com.example.cardsSantander.dto.CreditCardsResponse;

@RestController
@RequestMapping("/api/cards")
@CrossOrigin(origins = "*")
public class CreditCardsController {

	private  CreditCardService creditCardService ;


	public CreditCardsController(CreditCardService creditCardService) {
	    this.creditCardService = creditCardService;
	}
	
	
    /**
     * Crear una nueva tarjeta de crédito
     */
    @PostMapping("/create")
    public ResponseEntity<CreditCardsResponse> createCard(
            @RequestBody CreateCreditCardRequest request
    ) {
    	CreditCardsResponse response = creditCardService.createCard(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     * Consultar todas las tarjetas
     */
    @GetMapping("/list")
    public ResponseEntity<?> getAllCards() {
        return ResponseEntity.ok(creditCardService.getAllCards());
    }

    /**
     * Consultar tarjeta por ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getCardById(@PathVariable Long id) {
        return ResponseEntity.ok(creditCardService.getCardById(id));
    }

    /**
     * Activar tarjeta por ID
     */
    @PutMapping("/{id}/activate")
    public ResponseEntity<CreditCardsResponse> activateCard(@PathVariable Long id) {
    	CreditCardsResponse response = creditCardService.activateCard(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Bloquear tarjeta por ID
     */
    @PutMapping("/{id}/block")
    public ResponseEntity<CreditCardsResponse> blockCard(@PathVariable Long id) {
    	CreditCardsResponse response = creditCardService.blockCard(id);
        return ResponseEntity.ok(response);
    }
}
