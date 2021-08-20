package com.pokeapi.web.app.models.Species;

import java.util.List;

public class PokemonSpecies {

	private String name;

	private EvolutionChain evolution_chain;
	
	private List<FlavorTextEntries>flavor_text_entries;
	
	private List<Genera>genera;
	
	private List<EggGroups> egg_groups;
	
	private Habitat habitat;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FlavorTextEntries> getFlavor_text_entries() {
		return flavor_text_entries;
	}

	public void setFlavor_text_entries(List<FlavorTextEntries> flavor_text_entries) {
		this.flavor_text_entries = flavor_text_entries;
	}

	public List<Genera> getGenera() {
		return genera;
	}

	public void setGenera(List<Genera> genera) {
		this.genera = genera;
	}

	public Habitat getHabitat() {
		return habitat;
	}

	public void setHabitat(Habitat habitat) {
		this.habitat = habitat;
	}

	public List<EggGroups> getEgg_groups() {
		return egg_groups;
	}

	public void setEgg_groups(List<EggGroups> egg_groups) {
		this.egg_groups = egg_groups;
	}

	public EvolutionChain getEvolution_chain() {
		return evolution_chain;
	}

	public void setEvolution_chain(EvolutionChain evolution_chain) {
		this.evolution_chain = evolution_chain;
	}
}
