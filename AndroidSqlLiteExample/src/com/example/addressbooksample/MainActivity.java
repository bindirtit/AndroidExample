package com.example.addressbooksample;

import java.util.ArrayList;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {

	public final static String EXTRA_MESSAGE = "com.sharesnippetcode.AddressBook.MESSAGE";
	private ListView _listView;
	private DBHelper _mydb;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		_mydb = new DBHelper(this);

		ArrayList<String> contactNames = _mydb.getAllContacts();
		ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
				android.R.layout.simple_list_item_1, contactNames);

		_listView = (ListView) this.findViewById(R.id.listView1);
		_listView.setAdapter(arrayAdapter);

		_listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				int idToSearch = position + 1;
				Bundle bundle = new Bundle();
				bundle.putInt("id", idToSearch);

				Intent intent = new Intent(getApplicationContext(),
						DisplayContact.class);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.

		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.

		super.onOptionsItemSelected(item);

		int id = item.getItemId();
		if (id == R.id.item1) {
			Bundle dataBundle = new Bundle();
			dataBundle.putInt("id", 0);
			Intent intent = new Intent(this.getApplicationContext(),
					DisplayContact.class);
			intent.putExtras(dataBundle);
			this.startActivity(intent);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			moveTaskToBack(true);
		}
		return super.onKeyDown(keyCode, event);
	}

}
