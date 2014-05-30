package com.softa.babywatch.actions;

import com.softa.babywatch.R;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MakeCallAction implements WakeUpAction {
	
	EditText phoneNumber;

	@Override
	public void babyAwake(Context context) {
		Intent intent = new Intent(Intent.ACTION_CALL);

		intent.setData(Uri.parse("tel:" + phoneNumber.getText()));
		context.startActivity(intent);

	}


	@Override
	public View getConfigurationView(LayoutInflater inflater) {
		View configView = inflater.inflate(R.layout.make_call_configuration, null);
		phoneNumber = (EditText) configView.findViewById(R.id.phoneNumber);
		return configView;
	}
	
	@Override
	public String toString() {
		return "Make phone call";
	}


	@Override
	public String getDescription() {
		return "Make a phone call to the selected number";
	}

}
