package com.softa.babywatch.actions;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

public interface WakeUpAction {

	/**
	 * Performs an action when the baby wakes up
	 */
	void babyAwake(Context context);
	
	/**
	 * Fetch the configuration {@link View} that is used by the handler.
	 * 
	 * @param inflater used to inflate the view
	 * @return the configuration View if such exists, else <code>null</code> is returned.
	 */
	View getConfigurationView(LayoutInflater inflater);

	String getDescription();

}
