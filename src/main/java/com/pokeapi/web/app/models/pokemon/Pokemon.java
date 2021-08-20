package com.pokeapi.web.app.models.pokemon;

import java.util.List;

public class Pokemon {

	private int count;
	private String next;
	private List<PokemonResult>results;
				
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public List<PokemonResult> getResults() {
		return results;
	}
	public void setResults(List<PokemonResult> results) {
		this.results = results;
	}
	
}
