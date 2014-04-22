package com.example.vocalartist;

import java.io.File;
import java.lang.reflect.Field;
import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.graphics.PixelFormat;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.VideoView;
import android.os.Build;

public class VideosActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_videos);
		
		TextView tv1 = (TextView) findViewById(R.id.textView2);
		TextView tv2 = (TextView) findViewById(R.id.textView3);
		TextView tv3 = (TextView) findViewById(R.id.textView4);
		final RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton1);
		final RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
		final RadioButton rb3 = (RadioButton) findViewById(R.id.radioButton3);
		final Button playBtn = (Button) findViewById(R.id.button1);
		
		ArrayList<String> list = new ArrayList<String>();
		Field[] fields = R.raw.class.getFields();
		for(Field f : fields)
		try {
			System.out.println(f.getName());
		        list.add(f.getName());
		}catch(Exception e) {
			System.out.println(e);
		}
		
		tv1.setText(list.get(3));
		tv2.setText(list.get(4));
		tv3.setText(list.get(5));
		
		playBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				getWindow().setFormat(PixelFormat.TRANSLUCENT);
				VideoView vv = (VideoView) findViewById(R.id.videoView1);
				if(vv.isPlaying()) {
					vv.stopPlayback();
					playBtn.setText("Play");
				}
				else {
				if(rb1.isChecked()) {
					String path = "android.resource://" + getPackageName() +
							"/" + R.raw.video1;
					vv.setVideoURI(Uri.parse(path));
					vv.start();
					rb1.setChecked(false);
					playBtn.setText("Stop");
				}
				if(rb2.isChecked()) {
					String path = "android.resource://" + getPackageName() +
							"/" + R.raw.video2;
					vv.setVideoURI(Uri.parse(path));
					vv.start();
					rb2.setChecked(false);
					playBtn.setText("Stop");
				}
				if(rb3.isChecked()) {
					String path = "android.resource://" + getPackageName() +
							"/" + R.raw.video3;
					vv.setVideoURI(Uri.parse(path));
					vv.start();
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
		getMenuInflater().inflate(R.menu.videos, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_videos,
					container, false);
			return rootView;
		}
	}

}
