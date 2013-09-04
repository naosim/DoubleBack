package com.naosim.doubleback.lib;

import android.view.KeyEvent;

public class DoubleBackFucker {
	private Listener mListener;
	private int mBackCount = 0;

	public DoubleBackFucker(Listener l) {
		mListener = l;
		mBackCount = 0;
	}

	/**
	 * 画面が表示されたタイミングで呼ぶ。
	 * Activity#onStartやFragment#onStartで読んでください。
	 */
	public void onStartActivity() {
		mBackCount = 0;
	}

	/**
	 * 戻るイベントをキャンセルする場合はtrueを返す。
	 * それ以外はfalseを返す。
	 * @param keyCode
	 * @param event
	 * @return
	 */
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && mBackCount == 0) {
			mBackCount++;
			mListener.onFirstBack();
			return true;
		}
		return false;
	}

	public interface Listener {
		void onFirstBack();
	}

}
