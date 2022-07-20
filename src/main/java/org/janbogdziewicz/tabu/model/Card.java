package org.janbogdziewicz.tabu.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Card implements Serializable {
  @Id
  @Column(nullable = false, updatable = false)
  private String word;
  @ElementCollection
  private List<String> stopWords;

  public Card(String word, List<String> stopWords) {
    this.word = word;
    this.stopWords = new ArrayList<>(stopWords);
  }
}
