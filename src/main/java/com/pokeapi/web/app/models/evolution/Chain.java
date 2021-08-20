package com.pokeapi.web.app.models.evolution;

import java.util.List;

public class Chain {

	private List<Chain> evolves_to;
	private Species species;
	
	
	public List<Chain> getEvolves_to() {
		return evolves_to;
	}
	public void setEvolves_to(List<Chain> evolves_to) {
		this.evolves_to = evolves_to;
	}
	public Species getSpecies() {
		return species;
	}
	public void setSpecies(Species species) {
		this.species = species;
	}
	
}
