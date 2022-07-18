package org.janbogdziewicz.tabu.repo;

import org.janbogdziewicz.tabu.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CardRepo extends JpaRepository<Card, Long> {
  Optional<Card> findCardById(Long id);
  Optional<Card> findCardByWord(String word);
  void deleteCardById(Long id);
}
