package com.sharesnippetcode.androidserviceexample;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class MyService extends Service{

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Toast.makeText(this.getApplicationContext(), "Service started", Toast.LENGTH_LONG).show();
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		Toast.makeText(this.getApplicationContext(), "Service destroyed", Toast.LENGTH_LONG).show();
		super.onDestroy();
	}
	
	
}
