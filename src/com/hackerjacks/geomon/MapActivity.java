package com.hackerjacks.geomon;

import java.util.ArrayList;
import java.util.Collections;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends Activity {
	private GoogleMap map;
	private LocationManager lm;
	private LocationListener ll;
	private android.location.Location current;
	private ArrayList<Double> lats;
	ArrayList<Double> longs;
	ArrayList<Pokemon> pks = new ArrayList<Pokemon>();
	public static Player pl = new Player("dsd");
	public static Pokemon pk = null;
	Context context = this;
	private int numPokemon = 10;
	final double change = .001;
	public static Boolean playerwon = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map);
		// CameraUpdate cu = CameraUpdateFactory.newLatLngZoom(ll, 16); changes
		// your view to a new lat long
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		map.animateCamera(CameraUpdateFactory.zoomIn());
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		map.setMyLocationEnabled(true);
		map.setIndoorEnabled(true);
		map.getUiSettings().setZoomControlsEnabled(false);
		map.getUiSettings().setMyLocationButtonEnabled(false);
		map.getUiSettings().setCompassEnabled(true);
		getCurrentLocation();
		android.location.Location location = current;
		CameraUpdate cu = CameraUpdateFactory.newLatLngZoom(
				new LatLng(current.getLatitude(), current.getLongitude()), 16);
		if (location != null) {
			map.animateCamera(cu);
			// Toast.makeText(this, current.getLatitude()+"",
			// Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "No Previous Location Stored",
					Toast.LENGTH_SHORT).show();
		}
		pks.add(new Pokemon("Pikachu", "hi"));
		pks.add(new Pokemon("Raichu", "hi"));
		pks.add(new Pokemon("Bulbasaur", "hi"));
		pks.add(new Pokemon("Charmander", "hi"));
		pks.add(new Pokemon("Charizard", "hi"));
		pks.add(new Pokemon("Squirtle", "hi"));
		pks.add(new Pokemon("Jigglypuff", "hi"));
		pks.add(new Pokemon("Ninetales", "hi"));
		pks.add(new Pokemon("Electrode", "hi"));
		pks.add(new Pokemon("Electabuzz", "hi"));
		int rand = (int) (10 * Math.random());
		pl.addPokemon(pks.get(rand));

		addPokemon();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.map, menu);
		return true;
	}

	private void moveCamera() {
		android.location.Location location = current;
		CameraUpdate cu = CameraUpdateFactory.newLatLngZoom(
				new LatLng(current.getLatitude(), current.getLongitude()), 16);
		if (location != null) {
			map.animateCamera(cu);
			// Toast.makeText(this, current.getLatitude()+"",
			// Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(this, "No Previous Location Stored",
					Toast.LENGTH_SHORT).show();
		}

	}

	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		lm.removeUpdates(ll);

	}

	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, ll);
		lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, ll);
		if (playerwon != null) {
			if (playerwon) {
				Toast.makeText(context, "Player won battle", Toast.LENGTH_SHORT)
						.show();
				pks.set(pks.indexOf(pk), null);
				pk = null;
				drawPokemon();
			} else {
				Toast.makeText(context, "Player lost the fucking battle",
						Toast.LENGTH_SHORT).show();
			}
		}
	}

	private void addPokemon() {
		final double currentLat = current.getLatitude();
		final double currentLong = current.getLongitude();
		android.location.Location l = null;
		for (int i = 0; i < numPokemon; i++) {
			double dub = Math.random();
			double dub2 = Math.random();
			if (dub > .5) {
				pks.get(i).setLoc(
						new LatLng((currentLat + dub * change),
								(currentLong - dub2 * change)));
			} else {
				dub = Math.random();
				dub2 = Math.random();
				pks.get(i).setLoc(
						new LatLng((currentLat - dub * change),
								(currentLong + dub2 * change)));
			}
			// Create a pokemon object right here.(change it such that instead
			// of a for loop that its hardcoded with another method to determine
			// randomness
		}
		drawPokemon();
	}

	public void drawPokemon() {
		map.clear();
		ArrayList<String> str = new ArrayList<String>();
		for (int i = 0; i < pks.size(); i++) {
			try {
				str.add(pks.get(i).getName());
			} catch (NullPointerException e) {
				System.err.println(e);

			}
		}
		if (str.indexOf("Pikachu") != -1) {
			map.addMarker(
					new MarkerOptions().position(pks.get(0).getLoc()).title(
							"Pikachu")).setIcon(
					BitmapDescriptorFactory.fromResource(R.raw.pikachumap));
		}
		if (str.indexOf("Raichu") != -1) {
			map.addMarker(
					new MarkerOptions().position(pks.get(1).getLoc()).title(
							"Raichu")).setIcon(
					BitmapDescriptorFactory.fromResource(R.raw.raichumap));
		}
		if (str.indexOf("Bulbasaur") != -1) {
			map.addMarker(
					new MarkerOptions().position(pks.get(2).getLoc()).title(
							"Bulbasaur")).setIcon(
					BitmapDescriptorFactory.fromResource(R.raw.bulbasaurmap));
		}
		if (str.indexOf("Charmander") != -1) {
			map.addMarker(
					new MarkerOptions().position(pks.get(3).getLoc()).title(
							"Charmander")).setIcon(
					BitmapDescriptorFactory.fromResource(R.raw.charmandermap));
		}
		if (str.indexOf("Charizard") != -1) {
			map.addMarker(
					new MarkerOptions().position(pks.get(4).getLoc()).title(
							"Charizard")).setIcon(
					BitmapDescriptorFactory.fromResource(R.raw.charizardmap));
		}
		if (str.indexOf("Squirtle") != -1) {
			map.addMarker(
					new MarkerOptions().position(pks.get(5).getLoc()).title(
							"Squirtle")).setIcon(
					BitmapDescriptorFactory.fromResource(R.raw.squirtlemap));
		}
		if (str.indexOf("Jigglypuff") != -1) {
			map.addMarker(
					new MarkerOptions().position(pks.get(6).getLoc()).title(
							"Jigglypuff")).setIcon(
					BitmapDescriptorFactory.fromResource(R.raw.jigglypuffmap));
		}
		if (str.indexOf("Ninetales") != -1) {
			map.addMarker(
					new MarkerOptions().position(pks.get(7).getLoc()).title(
							"Ninetales")).setIcon(
					BitmapDescriptorFactory.fromResource(R.raw.ninetalesmap));
		}
		if (str.indexOf("Electrode") != -1) {
			map.addMarker(
					new MarkerOptions().position(pks.get(8).getLoc()).title(
							"Electrode")).setIcon(
					BitmapDescriptorFactory.fromResource(R.raw.electrodemap));
		}
		if (str.indexOf("Electabuzz") != -1) {
			map.addMarker(
					new MarkerOptions().position(pks.get(9).getLoc()).title(
							"Electabuzz")).setIcon(
					BitmapDescriptorFactory.fromResource(R.raw.electabuzzmap));
		}
	}

	private void getCurrentLocation() {
		lm = (LocationManager) this.getSystemService(LOCATION_SERVICE);
		current = lm.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		Toast.makeText(this, current.getLongitude() + "", Toast.LENGTH_SHORT)
				.show();
		ll = new LocationListener() {

			@Override
			public void onLocationChanged(android.location.Location location) {
				current = location;
				// moveCamera();
				Integer index = checkIntersect();
				if (index != -1) {
					MapActivity.pk = pks.get(index);
					fight();
				}

			}

			@Override
			public void onStatusChanged(String provider, int status,
					Bundle extras) {

			}

			@Override
			public void onProviderEnabled(String provider) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onProviderDisabled(String provider) {
				// TODO Auto-generated method stub

			}

		};

		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 20, 1, ll);
		lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 30, 1, ll);
	}

	private void fight() {
		AlertDialog.Builder builder = new AlertDialog.Builder(MapActivity.this);
		builder.setTitle("Choose your action").setItems(
				new CharSequence[] { "Run", "Fight" },
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						if (which == 1) {
							Intent in = new Intent(context, Game_Activity.class);
							startActivity(in);

						} else {
							Toast.makeText(context, "Okay", Toast.LENGTH_SHORT)
									.show();
						}

					}
				});

		AlertDialog dialog = builder.create();
		dialog.show();
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

	private int checkIntersect() { // return pokemon object, or return null. If
									// returned null, continue program, if
									// returned pokemon then start a game object
		final double currentLat = current.getLatitude();
		final double currentLong = current.getLongitude();

		for (int i = 0; i < numPokemon; i++) {
			double d = 5.0;
			try {
				d = getDistance(currentLat, currentLong,
						pks.get(i).getLoc().latitude,
						pks.get(i).getLoc().longitude);
			} catch (NullPointerException e) {
				System.err.println(e);

			}
			if (d < .0002) {
				return i;
			}
		}

		return -1;

	}

	private double getDistance(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
	}
}
