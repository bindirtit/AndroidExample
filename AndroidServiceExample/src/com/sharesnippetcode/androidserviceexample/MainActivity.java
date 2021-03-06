package com.sharesnippetcode.androidserviceexample;

import android.support.v7.app.ActionBarActivity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void startService(View view){
		this.startService(new Intent(this.getBaseContext(), MyService.class));
	}
	
	public void stopService(View view){
		stopService(new Intent(getBaseContext(), MyService.class));
	}
	
	//com.sharesnippetcode.android.A_CUSTOM_INTENT
	public void broadcastCustomIntent(View view){
		
		EditText et = (EditText) this.findViewById(R.id.extraIntent);
		
		Intent intent = new Intent("MyCustomIntent");
		intent.setAction("com.sharesnippetcode.android.A_CUSTOM_INTENT");
		intent.putExtra("message", (CharSequence)et.getText().toString());
		
		this.sendBroadcast(intent);
	}
}
