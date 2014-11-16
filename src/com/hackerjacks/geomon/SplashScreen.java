package com.hackerjacks.geomon;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class SplashScreen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
	public void startGame(View v){
		Intent goToTabbed = new Intent(this,MapActivity.class);
		 startActivity(goToTabbed);
	}
	public void pokedex(View v){
		Intent goToTabbed = new Intent(this,CustomList.class);
		 startActivity(goToTabbed);
	}
}
