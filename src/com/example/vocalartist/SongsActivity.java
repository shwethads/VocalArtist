package com.example.vocalartist;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.res.Resources;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class SongsActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_songs);

		TextView tv1 = (TextView) findViewById(R.id.textView2);
		TextView tv2 = (TextView) findViewById(R.id.textView3);
		TextView tv3 = (TextView) findViewById(R.id.textView4);
		final RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton1);
		final RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
		final RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);
		final Button playBtn = (Button) findViewById(R.id.button1);
		final Button stopBtn = (Button) findViewById(R.id.button2);

		ArrayList<String> list = new ArrayList<String>();
		Field[] fields = R.raw.class.getFields();
		for(Field f : fields)
			try {
				System.out.println(f.getName());
				list.add(f.getName());
			}catch(Exception e) {
				System.out.println(e);
			}

		System.out.println("......"+list.size());
		tv1.setText(list.get(0));
		tv2.setText(list.get(1));
		tv3.setText(list.get(2));



		playBtn.setOnClickListener(new OnClickListener() {
			MediaPlayer mp = new MediaPlayer();
			@Override
			public void onClick(View v) {
				if(mp.isPlaying()) {
					mp.stop();
					playBtn.setText("Play");
				}
				else {
					if(rb1.isChecked()) {
						mp = MediaPlayer.create(getApplicationContext(), R.raw.let_it_go_frozen);
						mp.start();
						rb1.setChecked(false);
						playBtn.setText("Stop");
					}
					if(rb2.isChecked()) {
						mp = MediaPlayer.create(getApplicationContext(), R.raw.selfie);
						mp.start();
						rb2.setChecked(false);
						playBtn.setText("Stop");
					}
					if(rb3.isChecked()) {
						mp = MediaPlayer.create(getApplicationContext(), R.raw.snowman_frozen);
						mp.start();
						rb3.setChecked(false);
						playBtn.setText("Stop");
					}
				}

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
		getMenuInflater().inflate(R.menu.songs, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_songs,
					container, false);
			return rootView;
		}
	}

}
