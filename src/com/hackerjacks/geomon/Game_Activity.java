package com.hackerjacks.geomon;

import java.util.ArrayList;
import java.util.Random;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game_Activity extends Activity {
	int hp1INT;
	int hp2INT;
	Pokemon po = MapActivity.pk; // MapActivity.pk;
	Player pl = MapActivity.pl;
	ArrayList<Pokemon> playerpokemons;
	Pokemon current;
	TextView hp1;
	Context context = this;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.gameactivity);
		playerpokemons = pl.getPokemons();
		current = playerpokemons.get(0);
		// Player p = new Player(); //in actual main method, Player will be
		// passed in// passed in
		ImageView img = (ImageView) findViewById(R.id.pokemon1); // image of
		ImageView img2 = (ImageView) findViewById(R.id.pokemon2); // this
		// pokemon
		TextView txt = (TextView) findViewById(R.id.textView2);
		if (po.getName() == "Pikachu") {
			img2.setImageResource(R.raw.pikachumap);
		}
		if (po.getName() == "Raichu") {
			img2.setImageResource(R.raw.raichumap);
		}
		if (po.getName() == "Bulbasaur") {
			img2.setImageResource(R.raw.bulbasaurmap);
		}
		if (po.getName() == "Charmander") {
			img2.setImageResource(R.raw.charmandermap);
		}
		if (po.getName() == "Charizard") {
			img2.setImageResource(R.raw.charizardmap);
		}
		if (po.getName() == "Squirtle") {
			img2.setImageResource(R.raw.squirtlemap);
		}
		if (po.getName() == "Jigglypuff") {
			img2.setImageResource(R.raw.jigglypuffmap);
		}
		if (po.getName() == "Ninetales") {
			img2.setImageResource(R.raw.ninetalesmap);
		}
		if (po.getName() == "Electrode") {
			img2.setImageResource(R.raw.electrodemap);
		}
		if (po.getName() == "Electabuzz") {
			img2.setImageResource(R.raw.electabuzzmap);

		}

		txt.setText(po.getName());
	

		Button move1 = (Button) findViewById(R.id.button1);
		Button move2 = (Button) findViewById(R.id.button2);
		Button move3 = (Button) findViewById(R.id.button3);
		Button move4 = (Button) findViewById(R.id.button4);

		hp1 = (TextView) findViewById(R.id.hp1); // hp of ours
		final TextView hp2 = (TextView) findViewById(R.id.hp2); // hp of theirs

		String[][] temp = current.getMoves();

		move1.setText(temp[0][0]);
		move2.setText(temp[1][0]);
		move3.setText("Kick");
		move4.setText("Tackle");
		final int damage1 = Math.abs((int) (Double.parseDouble(temp[0][1]))); // damage
																				// of
																				// 1st
		// move (top
		// left)
		final int damage2 = Math.abs((int) (Double.parseDouble(temp[1][1]))); // damage
																				// of
																				// 2st
		// move
		Random r = new Random();
		final int damage3 = Math.abs((int) (r.nextGaussian() * 10 + 15));
		final int damage4 = Math.abs((int) (r.nextGaussian() * 10 + 15)); // damage
																			// of
																			// 4st
																			// move

		hp1INT = Moves.map.get(current.getName());
		hp2INT = Moves.map.get(po.getName());

		hp1.setText("" + hp1INT);
		hp2.setText("" + hp2INT);

		move1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				hp2INT -= damage1;
				hp2.setText("" + hp2INT);
				if (isGameOver()) {
					endGame();
				}
				pokeMove();
			}
		});

		move2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				hp2INT -= damage2;
				hp2.setText("" + hp2INT);
				if (isGameOver()) {
					endGame();
				}
				pokeMove();
			}
		});

		move3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				hp2INT -= damage3;
				hp2.setText("" + hp2INT);
				if (isGameOver()) {
					endGame();
				}
				pokeMove();
			}
		});

		move4.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				hp2INT -= damage4;
				hp2.setText("" + hp2INT);
				if (isGameOver()) {
					endGame();
				}
				pokeMove();
			}
		});

		if (current.getName() == "Pikachu") {
			img.setImageResource(R.raw.pikachumap);

		}
		if (current.getName() == "Raichu") {
			img.setImageResource(R.raw.raichumap);

		}
		if (current.getName() == "Bulbasaur") {
			img.setImageResource(R.raw.bulbasaurmap);

		}
		if (current.getName() == "Charmander") {
			img.setImageResource(R.raw.charmandermap);

		}
		if (current.getName() == "Charizard") {
			img.setImageResource(R.raw.charizardmap);

		}
		if (current.getName() == "Squirtle") {
			img.setImageResource(R.raw.squirtlemap);

		}
		if (current.getName() == "Jigglypuff") {
			img.setImageResource(R.raw.jigglypuffmap);

		}
		if (current.getName() == "Ninetales") {
			img.setImageResource(R.raw.ninetalesmap);

		}
		if (current.getName() == "Electrode") {
			img.setImageResource(R.raw.electrodemap);

		}
		if (current.getName() == "Electabuzz") {
			img.setImageResource(R.raw.electabuzzmap);

		}
		TextView tv = (TextView) findViewById(R.id.textView1);
		tv.setText(current.getName());
		hp1.setText("" + hp1INT);
		hp2.setText("" + hp2INT);

		/*
		 * if( po.getName() == "vinay")
		 * img.setImageResource(R.drawable.pikachu); if( po.getName() ==
		 * "vinay") img.setImageResource(R.drawable.pikachu); if( po.getName()
		 * == "pikachu") img.setImageResource(R.drawable.pikachu); if(
		 * po.getName() == "pikachu") img.setImageResource(R.drawable.pikachu);
		 * if( po.getName() == "pikachu")
		 * img.setImageResource(R.drawable.pikachu); if( po.getName() ==
		 * "pikachu") img.setImageResource(R.drawable.pikachu); if( po.getName()
		 * == "pikachu") img.setImageResource(R.drawable.pikachu); if(
		 * po.getName() == "pikachu") img.setImageResource(R.drawable.pikachu);
		 * if( po.getName() == "pikachu")
		 * img.setImageResource(R.drawable.pikachu);
		 */

	}

	public boolean isGameOver() {
		if (hp1INT < 0 || hp2INT < 0) {
			return true;
		}
		return false;

	}

	public void endGame() {
		// Change static variable of main method such that it indiicates
		// hwerether you won or lost.
		// exit();
		if (hp1INT < hp2INT) {
			MapActivity.playerwon = false;
		} else {
			MapActivity.playerwon = true;
		}
		;
		finish();

	}

	public void pokeMove() {
		String[][] temp = po.getMoves();
		final int damage1 = Math.abs((int) (Double.parseDouble(temp[0][1]))); // damage
																				// of
																				// 1st
		// move (top
		// left)
		final int damage2 = Math.abs((int) (Double.parseDouble(temp[1][1]))); // damage
																				// of
																				// 2st
		// move
		Random r = new Random();
		final int damage3 = Math.abs((int) (r.nextGaussian() * 10 + 15));
		final int damage4 = Math.abs((int) (r.nextGaussian() * 10 + 15)); // damage
																			// of
																			// 4st
																			// move
		int move = (int) (4 * Math.random());
		if (move == 0) {
			hp1INT -= damage1;
		} else if (move == 1) {
			hp1INT -= damage2;
		} else if (move == 2) {
			hp1INT -= damage3;
		} else {
			hp1INT -= damage4;
		}
		hp1.setText("" + hp1INT);
		if (isGameOver()) {
			endGame();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
