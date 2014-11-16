package com.hackerjacks.geomon;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class CustomList extends ListActivity {

	private Pokemond[] pokemon;
	private int pikachu = 1;
	private int charmander = 2;
	private int raichu = 3;
	private int bulbasaur = 4;
	private int charizard = 5;
	private int squirtle = 6;
	private int jigglypuff = 7;
	private int ninetales = 8;
	private int electrode = 9;
	private int electabuzz = 10;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		
		pokemon = new Pokemond[10];
		pokemon[0] = new Pokemond("Pikachu", pikachu, "It evolves from Pichu when leveled up with high friendship and evolves into Raichu when exposed to a Thunder Stone. However, the starter Pikachu in Pokémon Yellow will refuse to evolve into Raichu unless it is traded and evolved on another save file.", "Electric", "1'4\"", "13.2");
		pokemon[1] = new Pokemond("Charmander", charmander, "It evolves into Charmeleon starting at level 16, which evolves into Charizard starting at level 36.", "Fire", "2'0\"", "18.7");
		pokemon[2] = new Pokemond("Raichu", raichu, "It evolves from Pikachu when exposed to a Thunder Stone. It is the final form of Pichu.", "Electric", "2'7\"", "66.1");
		pokemon[3] = new Pokemond("Bulbasaur", bulbasaur, "It evolves into Ivysaur starting at level 16, which evolves into Venusaur starting at level 32.", "Grass", "2'4\"", "15.2");
		pokemon[4] = new Pokemond("Charizard", charizard, "It evolves from Charmeleon starting at level 36. It is the final form of Charmander. It can Mega Evolve into two forms: Mega Charizard X using Charizardite X and Mega Charizard Y using Charizardite Y.", "Fire", "5'7\"", "199.5");
		pokemon[5] = new Pokemond("Squirtle", squirtle, "It evolves into Wartortle starting at level 16, which evolves into Blastoise starting at level 36.", "Water", "1'8\"", "19.8");
		pokemon[6] = new Pokemond("Jigglypuff", jigglypuff, "It evolves from Igglybuff when leveled up with high friendship and evolves into Wigglytuff when exposed to a Moon Stone.", "Fairy", "1'8\"", "12.1");
		pokemon[7] = new Pokemond("Ninetales", ninetales, "It evolves from Vulpix when exposed to a Fire Stone.", "Fire", "3'7\"", "43.9");
		pokemon[8] = new Pokemond("Electrode", electrode, "It evolves from Voltorb starting at level 30.", "Electric", "3'11\"", "146.8");
		pokemon[9] = new Pokemond("Electabuzz", electabuzz, "It evolves from Elekid starting at level 30 and evolves into Electivire when traded holding an Electirizer.", "Electric", "3'7\"", "66.1");
		
		ArrayAdapter<Pokemond> adapter = new CustomAdapter(this, pokemon);
		setListAdapter(adapter);
		
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) 
	{	
		super.onListItemClick(l, v, position, id);	
		String name = pokemon[position].Name;
		Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
		setPokemon(position);
		startActivity(new Intent(getApplicationContext(), PokemonView.class));
	}

	private void setPokemon(int pos) {
		P.Name = pokemon[pos].Name;
		P.Number = pokemon[pos].Number;
		P.Description = pokemon[pos].Description;
		P.Type = pokemon[pos].Type;
		P.Weight = pokemon[pos].Weight;
		P.Height = pokemon[pos].Height;
		
		
	}
	
}
