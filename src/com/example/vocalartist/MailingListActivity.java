package com.example.vocalartist;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Build;

public class MailingListActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mailing_list);

		final EditText nameET = (EditText) findViewById(R.id.editText1);
		final EditText emailET = (EditText) findViewById(R.id.editText2);
		final TextView errorTV = (TextView) findViewById(R.id.textView4);

		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String name = nameET.getText().toString();
				String email = emailET.getText().toString();

				System.out.println(name);
				if(name.matches("") || email.matches("")) {
					System.out.println("NO DATA ERROR!!!");
					errorTV.setText("Please enter correct data");
				}
				else {
					String msg = "Add "+name+", "+email+" to mailing list";
					Intent sendIntent = new Intent(Intent.ACTION_SEND);
					sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"125shwetha@gmail.com"});
					sendIntent.putExtra(Intent.EXTRA_TEXT, msg);
					sendIntent.putExtra(Intent.EXTRA_SUBJECT, "VocalArtist");
					sendIntent.setType("message/rfc822");
					startActivity(Intent.createChooser(sendIntent, "Email:"));
					errorTV.setText("Added to mailing list");
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
		getMenuInflater().inflate(R.menu.mailing_list, menu);
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
			View rootView = inflater.inflate(R.layout.fragment_mailing_list,
					container, false);
			return rootView;
		}
	}

}
