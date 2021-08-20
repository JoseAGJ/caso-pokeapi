package com.pokeapi.web.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.pokeapi.web.app.models.detailPokemon.DetailPokemon;
import com.pokeapi.web.app.models.pokemon.Pokemon;

@Service
public class PokemonService {

	
	@Autowired
	private WebClient webClient;
	
	public Pokemon getPokemon(String offset) {
		return  this.webClient.get().uri("https://pokeapi.co/api/v2/pokemon?offset="+offset+"&limit=20")
		.retrieve()
		.bodyToMono(Pokemon.class)
		.block();	
		
	}
	
	public DetailPokemon getDetailPokemon(String url) {
		return  webClient.get().uri("/pokemon/"+url)
		.retrieve()
		.bodyToMono(DetailPokemon.class)
		.block();	
		
	}
	
	
}
