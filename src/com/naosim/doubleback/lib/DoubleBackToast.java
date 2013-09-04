package com.naosim.doubleback.lib;

import android.content.Context;
import android.widget.Toast;

/**
 * onFirstBackが呼ばれたときにトーストを表示する
 * @author nao_pillows
 *
 */
public class DoubleBackToast implements DoubleBackFucker.Listener{
	private Context mContext;
	private int mMessageId;
	private String mMessage;

	public DoubleBackToast(Context context, int messageId) {
		mContext = context;
		mMessageId = messageId;
	}
	
	public DoubleBackToast(Context context, String message) {
		mContext = context;
		mMessage = message;
	}

	@Override
	public void onFirstBack() {
		if(mMessage != null) {
			Toast.makeText(mContext, mMessage, Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(mContext, mMessageId, Toast.LENGTH_SHORT).show();
		}
	}

}
