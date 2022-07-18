package org.janbogdziewicz.tabu.service;

import org.janbogdziewicz.tabu.exceptions.CardNotFoundException;
import org.janbogdziewicz.tabu.model.Card;
import org.janbogdziewicz.tabu.repo.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CardService {
  private final CardRepo cardRepo;

  @Autowired
  public CardService(CardRepo cardRepo) {
    this.cardRepo = cardRepo;
  }

  public Card findCardById(Long id) throws CardNotFoundException {
    return cardRepo.findCardById(id).orElseThrow(() -> new CardNotFoundException("Card by id " + id + " was not found"));
  }

  public Card findCardByWord(String word) throws CardNotFoundException {
    return cardRepo.findCardByWord(word).orElseThrow(() -> new CardNotFoundException("Card by name " + word + " was not found"));
  }

  public Card addCard(Card card) {
    return cardRepo.save(card);
  }

  public void deleteCard(Long id) {
    cardRepo.deleteCardById(id);
  }

  public void updateCard(Card card) {
    cardRepo.save(card);
  }
}
