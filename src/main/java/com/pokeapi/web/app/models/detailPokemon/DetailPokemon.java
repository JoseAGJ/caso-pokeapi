package com.pokeapi.web.app.models.detailPokemon;

public class DetailPokemon {

	private String name;
	private Sprites sprites;
	private String id;
	private Types types[];
	private String color;
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sprites getSprites() {
		return sprites;
	}

	public void setSprites(Sprites sprites) {
		this.sprites = sprites;
	}

	public Types[] getTypes() {
		return types;
	}

	public void setTypes(Types[] types) {
		this.types = types;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
