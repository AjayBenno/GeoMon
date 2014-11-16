package com.hackerjacks.geomon;

public class P {

	public static String Name;
	public static int Number;
	public static String Description;
	public static String Type;
	public static String Height;
	public static String Weight;
	
	public static Pokemond getPokemon()
	{
		Pokemond p = new Pokemond(Name, Number, Description, Type, Height, Weight);
		return p;
	}

}
