package com.pokeapi.web.app.utils;

import java.util.HashMap;
import java.util.List;

import com.pokeapi.web.app.models.detailPokemon.DetailPokemon;

public class Utilitario {


	public static HashMap<String, String> hash_map(){
		HashMap<String, String> hash_map = new HashMap<String, String>();
	    hash_map.put("fire", "#FDDFDF");
		hash_map.put("grass", "#DEFDE0");
		hash_map.put("electric", "#FCF7DE");
		hash_map.put("water", "#DEF3FD");
		hash_map.put("ground", "#f4e7da");
		hash_map.put("rock", "#d5d5d4");
		hash_map.put("fairy", "#fceaff");
		hash_map.put("poison", "#98d7a5");
		hash_map.put("bug", "#f8d5a3");
		hash_map.put("dragon", "#97b3e6");
		hash_map.put("psychic", "#eaeda1");
		hash_map.put("flying", "#F5F5F5");
		hash_map.put("fighting", "#E6E0D4");
		hash_map.put("normal","#F5F5F5");
		
		return hash_map;
	}
	
	
	public static void  AsignaColores (List<DetailPokemon>pokemonDT ) {						
		  for (String clave:hash_map().keySet()) {
	            String valor = hash_map().get(clave);	            
	            for(int i=0;i<pokemonDT.size();i++) {	            	
	            	if(pokemonDT.get(i).getTypes()[0].getType().getName().equals(clave)) {
	            		pokemonDT.get(i).setColor(valor);
	            	}
	            }
	        }
	        
	}
	
	public static void  AsignaColor (DetailPokemon dtP) {						
		   for (String clave:hash_map().keySet()) {
	            String valor = hash_map().get(clave);	            
	            if(dtP.getTypes()[0].getType().getName().equals(clave)) {
	            	dtP.setColor(valor);
	            }
	        }
	        
	}
}
