package org.janbogdziewicz.tabu;

import org.janbogdziewicz.tabu.model.Card;
import org.janbogdziewicz.tabu.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
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

		};
	}
}
