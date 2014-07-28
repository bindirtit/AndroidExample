package com.sharesnippetcode.listviewexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SimpleListViewActivity extends Activity {

	private ListView _listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_list_view);

		// Get ListView object from xml
		_listView = (ListView) this.findViewById(R.id.mylist);

		// Defined Array values to show in ListView
		String[] values = new String[] { "Android List View",
				"Adapter implementation", "Simple List View In Android",
				"Create List View Android", "Android Example",
				"List View Source Code", "List View Array Adapter",
				"Android Example List View" };

		// Define a new Adapter
		// First parameter - Context
		// Second parameter - Layout for the row
		// Third parameter - ID of the TextView to which the data is written
		// Forth - the Array of data
		ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, android.R.id.text1, values);

		// Assign adapter to ListView
		_listView.setAdapter(myAdapter);

		// ListView Item Click Listener
		_listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// ListView Clicked item index
				int itemPosition = position;

				// ListView Clicked item value
				String itemValue = (String) _listView
						.getItemAtPosition(position);

				// Show Alert
				Toast.makeText(
						getApplicationContext(),
						"Position :" + itemPosition + "  ListItem : "
								+ itemValue, Toast.LENGTH_LONG).show();
			}
		});
	}

}
