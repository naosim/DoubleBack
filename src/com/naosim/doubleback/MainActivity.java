package com.naosim.doubleback;

import com.naosim.doubleback.lib.DoubleBackFucker;
import com.naosim.doubleback.lib.DoubleBackToast;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;

public class MainActivity extends Activity {
	
	DoubleBackFucker mDoubleBackFucker;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		mDoubleBackFucker = new DoubleBackFucker(new DoubleBackToast(this, "もう一度押すと終了します"));
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		
		mDoubleBackFucker.onStartActivity();
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if(mDoubleBackFucker.onKeyDown(keyCode, event)) return true;
		return super.onKeyDown(keyCode, event);
	}

}
