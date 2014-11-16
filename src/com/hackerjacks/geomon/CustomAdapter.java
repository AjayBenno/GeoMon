package com.hackerjacks.geomon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<Pokemond>{
	
	private Pokemond[] pokemon;
	private final Context context;

	public CustomAdapter(Context context, Pokemond[] pokemon)
	{
		super(context, R.layout.c_adapter, pokemon);
		this.context = context;
		this.pokemon = pokemon;
	}
	
	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position, View ContentView, ViewGroup parent)
	{
		LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.c_adapter, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.name);
		ImageView image = (ImageView)rowView.findViewById(R.id.imageView1);

		
		textView.setText(pokemon[position].Name);
		
		if(pokemon[position].Number == 1) 
		{
			image.setImageResource(R.drawable.pikachu);
		}
		if(pokemon[position].Number == 2) 
		{
			image.setImageResource(R.drawable.charmander);
		}
		if(pokemon[position].Number == 3) 
		{
			image.setImageResource(R.drawable.raichu);
		}
		if(pokemon[position].Number == 4) 
		{
			image.setImageResource(R.drawable.bulbasaur);
		}
		if(pokemon[position].Number == 5) 
		{
			image.setImageResource(R.drawable.charizard);
		}
		if(pokemon[position].Number == 6) 
		{
			image.setImageResource(R.drawable.squirtle);
		}
		if(pokemon[position].Number == 7) 
		{
			image.setImageResource(R.drawable.jigglypuff);
		}
		if(pokemon[position].Number == 8) 
		{
			image.setImageResource(R.drawable.ninetales);
		}
		if(pokemon[position].Number == 9) 
		{
			image.setImageResource(R.drawable.electrode);
		}
		if(pokemon[position].Number == 10) 
		{
			image.setImageResource(R.drawable.electabuzz);
		}
		
		return rowView;
	}

}
