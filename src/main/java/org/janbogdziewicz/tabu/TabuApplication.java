package org.janbogdziewicz.tabu;

import org.janbogdziewicz.tabu.model.Card;
import org.janbogdziewicz.tabu.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
//@EntityScan("org.janbogdziewicz.model")
public class TabuApplication {
	private final CardService cardService;

	@Autowired
	public TabuApplication(CardService cardService) {
		this.cardService = cardService;
	}
	public static void main(String[] args) {
		SpringApplication.run(TabuApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
//			List<String> stopWords = new ArrayList<>();
//			stopWords.add("raz");
//			stopWords.add("dwa");
//			stopWords.add("trzy");
//			stopWords.add("cztery");
//			stopWords.add("piec");
//			Card card = new Card("Word", stopWords);
//			cardService.addCard(card);
			Card card = cardService.findCardByWord("Word");
			System.out.println(card.getWord());
		};
	}
}
