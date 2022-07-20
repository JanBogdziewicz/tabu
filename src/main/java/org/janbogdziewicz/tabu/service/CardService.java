package org.janbogdziewicz.tabu.service;

import org.janbogdziewicz.tabu.exception.CardNotFoundException;
import org.janbogdziewicz.tabu.model.Card;
import org.janbogdziewicz.tabu.repo.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CardService {
  private final CardRepo cardRepo;

  @Autowired
  public CardService(CardRepo cardRepo) {
    this.cardRepo = cardRepo;
  }
  public Card findCardByWord(String word) throws CardNotFoundException {
    return cardRepo.findCardByWord(word).orElseThrow(() -> new CardNotFoundException("Card by name " + word + " was not found"));
  }

  public List<Card> findAllCards() {
    return cardRepo.findAll();
  }

  public Card addCard(Card card) {
    return cardRepo.save(card);
  }

  public void deleteCard(String word) {
    cardRepo.deleteCardByWord(word);
  }

  public void updateCard(Card card) {
    cardRepo.save(card);
  }
}
