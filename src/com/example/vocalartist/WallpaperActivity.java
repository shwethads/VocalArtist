package com.example.vocalartist;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.os.Build;

public class WallpaperActivity extends ActionBarActivity {
	private Integer[] imgIds = {R.drawable.img4, R.drawable.img5};	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_wallpaper);
		
		ImageView iv1 = (ImageView) findViewById(R.id.imageView1);
		iv1.setImageResource(R.drawable.img4);
		ImageView iv2 = (ImageView) findViewById(R.id.imageView2);
		iv2.setImageResource(R.drawable.img5);
		final RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton1);
		final RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
		Button btn = (Button) findViewById(R.id.button1);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				WallpaperManager myWallpaperManager
		         = WallpaperManager.getInstance(getApplicationContext());
				if(rb1.isChecked()) {
					try {
			             myWallpaperManager.setResource(R.drawable.img4);
			            } catch (Exception e) {
			             // TODO Auto-generated catch block
			             e.printStackTrace();
			            }
				         
				}
				
			}
		});
		
		iv1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				
			}
		});

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wallpaper, menu);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_wallpaper,
					container, false);
			return rootView;
		}
	}

}
