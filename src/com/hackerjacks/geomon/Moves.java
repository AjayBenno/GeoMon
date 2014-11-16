package com.hackerjacks.geomon;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Moves {
	private final static String[][] inventory = new String[32][3];
	public static Map<String, Integer> map = new HashMap<String, Integer>();

	public Moves() {
		createMoves();
		map.put("Pikachu", 35);
		map.put("Raichu", 60);
		map.put("Bulbasaur", 45);
		map.put("Charmander", 39);
		map.put("Charizard", 78);
		map.put("Squirtle", 44);
		map.put("Jigglypuff", 115);
		map.put("Ninetales", 73);
		map.put("Electrode", 60);
		map.put("Electabuzz", 65);
		map.put("Ditto", 48);
		map.put("Mew", 100);
		map.put("Empoleon", 84);
		map.put("Lucario", 70);
		map.put("Articuno", 90);
	}

	public String[][] setMoves(String name) {
		String[][] ret = new String[4][2];
		int count = 0;
		for (int row = 0; row < 32; row++) {
			if (inventory[row][0].equals(name)) {
				ret[count][0] = inventory[row][1];
				ret[count][1] = inventory[row][2];

				count++;
			}
		}
		return ret;
	}

	public void populateHash() {
		

	}

	// based on the name, it will create an array of 4 moves. it will then
	// return this array
	private void createMoves() {
		Random r = new Random();
		inventory[0][0] = "Universal";
		inventory[0][1] = "Punch";
		inventory[0][2] = Double.toString(r.nextGaussian() * 10 + 15);
		inventory[1][0] = "Universal";
		inventory[1][1] = "Tackle";
		inventory[1][2] = Double.toString(r.nextGaussian() * 10 + 15);
		for (int i = 2; i < 4; i++)
			inventory[i][0] = "Pikachu";
		for (int i = 4; i < 6; i++)
			inventory[i][0] = "Raichu";
		for (int i = 6; i < 8; i++)
			inventory[i][0] = "Bulbasaur";
		for (int i = 8; i < 10; i++)
			inventory[i][0] = "Charmander";
		for (int i = 10; i < 12; i++)
			inventory[i][0] = "Charizard";
		for (int i = 12; i < 14; i++)
			inventory[i][0] = "Squirtle";
		for (int i = 14; i < 16; i++)
			inventory[i][0] = "Jigglypuff";
		for (int i = 16; i < 18; i++)
			inventory[i][0] = "Ninetales";
		for (int i = 18; i < 20; i++)
			inventory[i][0] = "Electrode";
		for (int i = 20; i < 22; i++)
			inventory[i][0] = "Electabuzz";
		for (int i = 22; i < 24; i++)
			inventory[i][0] = "Ditto";
		for (int i = 24; i < 26; i++)
			inventory[i][0] = "Mew";
		for (int i = 26; i < 28; i++)
			inventory[i][0] = "Empoleon";
		for (int i = 28; i < 30; i++)
			inventory[i][0] = "Lucario";
		for (int i = 30; i < 32; i++)
			inventory[i][0] = "Articuno";

		inventory[12][1] = "Mouth Close!";
		inventory[12][2] = Double.toString(r.nextGaussian() * 10 + 15);
		inventory[13][1] = "Flash Attack";
		inventory[13][2] = Double.toString(r.nextGaussian() * 10 + 15);

		inventory[14][1] = "Green Swag Attack";
		inventory[14][2] = Double.toString(r.nextGaussian() * 10 + 15);
		inventory[15][1] = "Sexual Prowess";
		inventory[15][2] = Double.toString(r.nextGaussian() * 10 + 15);

		inventory[16][1] = "Hype Train Attack";
		inventory[16][2] = Double.toString(r.nextGaussian() * 10 + 15);
		inventory[17][1] = "Asian Laugh";
		inventory[17][2] = Double.toString(r.nextGaussian() * 10 + 15);

		inventory[18][1] = "Steel-Toed Shin Kick";
		inventory[18][2] = Double.toString(r.nextGaussian() * 10 + 15);
		inventory[19][1] = "Deafening Scream";
		inventory[19][2] = Double.toString(r.nextGaussian() * 10 + 15);

		inventory[20][1] = "You're so meeeean!";
		inventory[20][2] = Double.toString(r.nextGaussian() * 10 + 15);
		inventory[21][1] = "Buzzkill";
		inventory[21][2] = Double.toString(r.nextGaussian() * 10 + 15);

		inventory[22][1] = "Math Attack";
		inventory[22][2] = Double.toString(r.nextGaussian() * 10 + 15);
		inventory[23][1] = "Yo-Yo Smash";
		inventory[23][2] = Double.toString(r.nextGaussian() * 10 + 15);

		inventory[24][1] = "Disgusting Perversion";
		inventory[24][2] = Double.toString(r.nextGaussian() * 10 + 15);
		inventory[25][1] = "Knife Stab";
		inventory[25][2] = Double.toString(r.nextGaussian() * 10 + 15);

		inventory[26][1] = "Thigh Slap";
		inventory[26][2] = Double.toString(r.nextGaussian() * 10 + 15);
		inventory[27][1] = "Make Bigger";
		inventory[27][2] = Double.toString(r.nextGaussian() * 10 + 15);

		inventory[28][1] = "Sassafrass";
		inventory[28][2] = Double.toString(r.nextGaussian() * 10 + 15);
		inventory[29][1] = "Rampage";
		inventory[29][2] = Double.toString(r.nextGaussian() * 10 + 15);

		inventory[30][1] = "Face Slap";
		inventory[30][2] = Double.toString(r.nextGaussian() * 10 + 15);
		inventory[31][1] = "Feminist Tirade";
		inventory[31][2] = Double.toString(r.nextGaussian() * 10 + 15);

		inventory[2][1] = "Brown Lightning";
		inventory[2][2] = Double.toString(r.nextGaussian() * 10 + 15);
		inventory[3][1] = "Sock Rock";
		inventory[3][2] = Double.toString(r.nextGaussian() * 10 + 15);

		inventory[4][1] = "Verbal Abuse";
		inventory[4][2] = Double.toString(r.nextGaussian() * 10 + 15);
		inventory[5][1] = "Physical Abuse";
		inventory[5][2] = Double.toString(r.nextGaussian() * 10 + 15);

		inventory[6][1] = "Monochromatic Laser";
		inventory[6][2] = Double.toString(r.nextGaussian() * 10 + 15);
		inventory[7][1] = "Actuarial Strength";
		inventory[7][2] = Double.toString(r.nextGaussian() * 10 + 15);

		inventory[8][1] = "BLACK BEAR MAUL";
		inventory[8][2] = Double.toString(r.nextGaussian() * 10 + 15);
		inventory[9][1] = "Rap God";
		inventory[9][2] = Double.toString(r.nextGaussian() * 10 + 15);

		inventory[10][1] = "Theta approaches infinity";
		inventory[10][2] = Double.toString(r.nextGaussian() * 10 + 15);
		inventory[11][1] = "Assert: Dominance";
		inventory[11][2] = Double.toString(r.nextGaussian() * 10 + 15);

	}// fill inventory with the name in one col, move name in col 2, and damage
		// in col 3

}