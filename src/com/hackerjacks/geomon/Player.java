package com.hackerjacks.geomon;

import java.util.ArrayList;

public class Player {
 private ArrayList<Pokemon> Pokemons = new ArrayList<Pokemon>();
   private String name;
 
 public Player (String name){
   
  this.name = name; 
   
 }
 public ArrayList<Pokemon> getPokemons(){
   return Pokemons;   
}

 
   public void addPokemon(Pokemon x){
     Pokemons.add(x);
   }
   
   public String getName(){
     return name;
   }
}