package com.softa.babywatch.actions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class ShowToastAction implements WakeUpAction {

	@Override
	public void babyAwake(Context context) {
		CharSequence text = "Baby is awake!";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(context, text, duration);
		toast.show();

	}

	@Override
	public View getConfigurationView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return "Show Toast";
	}

	@Override
	public String getDescription() {
		return "Shows a message the baby is awake";
	}

}
