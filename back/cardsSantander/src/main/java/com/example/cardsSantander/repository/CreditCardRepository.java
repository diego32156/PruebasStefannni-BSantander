package com.example.cardsSantander.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cardsSantander.entity.CreditCards;

public interface CreditCardRepository extends JpaRepository<CreditCards, Long> {

}
