package org.janbogdziewicz.tabu.controller;

import org.janbogdziewicz.tabu.model.Card;
import org.janbogdziewicz.tabu.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {
  private final CardService cardService;

  @Autowired
  public CardController(CardService cardService) {
    this.cardService = cardService;
  }

  @GetMapping("/all/shuffled")
  public ResponseEntity<List<Card>> getAllCards() {
    List<Card> cards = cardService.findAllCards();
    Collections.shuffle(cards);
    return new ResponseEntity<>(cards, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<Card> addNewCard(@RequestBody Card card) {
    Card newCard = cardService.addCard(card);
    return new ResponseEntity<>(newCard, HttpStatus.CREATED);
  }

  @DeleteMapping("/{word}")
  public ResponseEntity<?> deleteCard(@PathVariable("word") String word) {
    cardService.deleteCard(word);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
