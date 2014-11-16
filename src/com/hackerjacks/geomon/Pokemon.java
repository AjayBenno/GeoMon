package com.hackerjacks.geomon;

import com.google.android.gms.maps.model.LatLng;

public class Pokemon{
  private LatLng loc;
  private String type;
  private String name;
  private Moves mov= new Moves();
  private String [][] moves = new String [4][2];
  //write an attack method
  private int health;
  public Pokemon (String name, String type){
   this.name = name;
   this.type = type;
   moves = mov.setMoves(name);
  }
  
  public LatLng getLoc(){
    return loc;
  }
  
  public String getType(){
    return type;
  }
  
  public void setLoc(LatLng loc){
   this.loc = loc;
     }
  
    
   public String getName(){
     return name;
   }
   
   public String [][] getMoves(){
    return moves; 
   }
 
   public void reduceHealth(int reduce){
    health-=reduce; 
   }
   
}
