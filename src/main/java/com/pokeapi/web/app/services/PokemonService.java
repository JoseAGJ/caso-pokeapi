package com.pokeapi.web.app.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.pokeapi.web.app.models.Species.PokemonSpecies;
import com.pokeapi.web.app.models.detailPokemon.DetailPokemon;
import com.pokeapi.web.app.models.evolution.PokemonEvolution;
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
	
	public PokemonSpecies getSpecies(String id) {
		return  webClient.get().uri("https://pokeapi.co/api/v2/pokemon-species/"+id)
		.retrieve()
		.bodyToMono(PokemonSpecies.class)
		.block();	
	}
	
	

	public PokemonEvolution getEvolution(String url) {
		return  webClient.get().uri(url)
		.retrieve()
		.bodyToMono(PokemonEvolution.class)
		.block();	
	}
	
	public  HashMap<String, String> getEvolutionImage (PokemonEvolution pokeEv) {
		
		HashMap<String, String> hash_mapL = new HashMap<String, String>();
        for(int i=0;i<pokeEv.getChain().getEvolves_to().size();i++) {	        	
        	String primero=pokeEv.getChain().getSpecies().getName();	        	
        	DetailPokemon nuevoImgen=getDetailPokemon(primero);	        	
        	hash_mapL.put("primero",nuevoImgen.getSprites().getOther().getDream_world().getFront_default());	     
        	
        	if(pokeEv.getChain().getEvolves_to().size()>0) {
        		String segundo=pokeEv.getChain().getEvolves_to().get(i).getSpecies().getName();	  
	        	nuevoImgen=getDetailPokemon(segundo);	        	
        		hash_mapL.put("segundo",nuevoImgen.getSprites().getOther().getDream_world().getFront_default());
        	}
        		        	
        	if(pokeEv.getChain().getEvolves_to().get(i).getEvolves_to().size()>0) {
        		String tercero=pokeEv.getChain().getEvolves_to().get(i).getEvolves_to().get(i).getSpecies().getName();	  
	        	nuevoImgen=getDetailPokemon(tercero);	  
        		hash_mapL.put("tercero",nuevoImgen.getSprites().getOther().getDream_world().getFront_default());
        	}
        }
        return  hash_mapL;
	   
	}
	
	
}
