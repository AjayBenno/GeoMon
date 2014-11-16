package com.hackerjacks.geomon;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class PokemonView extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pokemon_view);
		ImageView image = (ImageView)findViewById(R.id.imageView1);
		TextView name = (TextView)findViewById(R.id.name);
		TextView description = (TextView)findViewById(R.id.description);
		TextView type = (TextView)findViewById(R.id.type);
		TextView weight = (TextView)findViewById(R.id.weight);
		TextView height = (TextView)findViewById(R.id.height);
		
		Pokemond pikachu = P.getPokemon();
		if(pikachu.Number == 1)
		{
			image.setImageResource(R.drawable.bigpikachu);
		}
		if(pikachu.Number == 2)
		{
			image.setImageResource(R.drawable.charmander);
		}
		if(pikachu.Number == 3)
		{
			image.setImageResource(R.drawable.raichu);
		}
		if(pikachu.Number == 4) 
		{
			image.setImageResource(R.drawable.bulbasaur);
		}
		if(pikachu.Number == 5) 
		{
			image.setImageResource(R.drawable.charizard);
		}
		if(pikachu.Number == 6) 
		{
			image.setImageResource(R.drawable.squirtle);
		}
		if(pikachu.Number == 7) 
		{
			image.setImageResource(R.drawable.jigglypuff);
		}
		if(pikachu.Number == 8) 
		{
			image.setImageResource(R.drawable.ninetales);
		}
		if(pikachu.Number == 9) 
		{
			image.setImageResource(R.drawable.electrode);
		}
		if(pikachu.Number == 10) 
		{
			image.setImageResource(R.drawable.electabuzz);
		}

		name.setText(pikachu.Name);
		description.setText("Description: " + pikachu.Description);
		type.setText("Type: " + pikachu.Type);
		weight.setText("Weight: " + pikachu.Weight);
		height.setText("Height: " + pikachu.Height);
		
		
	}

}
