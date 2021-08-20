package com.pokeapi.web.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pokeapi.web.app.models.detailPokemon.DetailPokemon;
import com.pokeapi.web.app.models.pokemon.Pokemon;
import com.pokeapi.web.app.services.PokemonService;
import com.pokeapi.web.app.utils.Utilitario;

@Controller
public class PokemonController {

	@Autowired
	private PokemonService service;	
	
	static int numero=0;
	
	@GetMapping({"/","/index"})
	public String index(Model model) {
			
		String pagina= String.valueOf(20 * numero);

		Pokemon pokemon=service.getPokemon(pagina);
		List<DetailPokemon>pokemonDT=pokemon.getResults().parallelStream().map(p->service.getDetailPokemon(p.getName()))
				.collect(Collectors.toList()); 
		
		double paginasSnRedondeo= (float) pokemon.getCount()/20;
		int totalPaginas = (int) Math.round(paginasSnRedondeo);
		
		Utilitario.AsignaColores(pokemonDT);
       
		
		model.addAttribute("pokemon",pokemonDT);
		model.addAttribute("totalPaginas",totalPaginas);
		model.addAttribute("numero",numero);

		return "index";
	}
	
	@GetMapping({"/siguiente"})
	public String siguiente() {
		numero++;
		return "redirect:index";
	}
	
	
	@GetMapping({"/atras"})
	public String atras() {		
		numero--;
	
		if(numero<0) {
			numero=0;
		}
		
		return "redirect:index";
	}
	
}