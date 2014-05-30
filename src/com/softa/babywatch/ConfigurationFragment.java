package com.softa.babywatch;

import java.util.List;
import java.util.Vector;

import com.softa.babywatch.actions.MakeCallAction;
import com.softa.babywatch.actions.ShowToastAction;
import com.softa.babywatch.actions.WakeUpAction;
import com.softa.babywatch.detectors.BabyDetector;
import com.softa.babywatch.detectors.ExponentialDetector;
import com.softa.babywatch.detectors.SimpleAmplitudeDetector;
import com.softa.babywatch.detectors.TestDetector;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class ConfigurationFragment extends Fragment {

	private List<WakeUpAction> actions;
	private List<BabyDetector> detectors;
	private BabyWatchActivity parentActivity;
	private LinearLayout detectorConfigLayout;
	private LinearLayout actionConfigLayout;
	private LayoutInflater inflater;


	@Override
	public View onCreateView(final LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		this.inflater = inflater;
		
		// Add action implementations
		actions = new Vector<WakeUpAction>();
		actions.add(new ShowToastAction());
		actions.add(new MakeCallAction());

		// Add detector implementations
		detectors = new Vector<BabyDetector>();
		detectors.add(new ExponentialDetector());
		detectors.add(new SimpleAmplitudeDetector());
		detectors.add(new TestDetector());

		if (container != null) {
			LinearLayout layout = (LinearLayout) inflater.inflate(R.layout.configuration, container,false);
			parentActivity = (BabyWatchActivity) getActivity();

			actionConfigLayout = (LinearLayout) layout.findViewById(R.id.actionConfigLayout);
			Spinner actionSelector = (Spinner) layout.findViewById(R.id.actionSelector);
			final TextView actionDescription = (TextView) layout.findViewById(R.id.actionDescription);

			ArrayAdapter<WakeUpAction> actionAdapter = new ArrayAdapter<WakeUpAction>(getActivity(), android.R.layout.simple_spinner_item);
			// Specify the layout to use when the list of choices appears
			actionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			for (WakeUpAction action : actions) {
				actionAdapter.add(action);
			}
			// Apply the adapter to the spinner
			actionSelector.setAdapter(actionAdapter);
			actionSelector.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int item, long arg3) {
					parentActivity.currentlySelectedAction = actions.get(item);
					actionDescription.setText(parentActivity.currentlySelectedAction.getDescription());
					actionConfigLayout.removeAllViews();
					View configurationView = parentActivity.currentlySelectedAction.getConfigurationView(inflater);
					if (configurationView != null) {
						actionConfigLayout.addView(configurationView);
					}
					actionConfigLayout.invalidate();		// TODO Auto-generated method stub
					
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					// TODO Auto-generated method stub
					
				}
			});

			parentActivity.currentlySelectedAction = actions.get(0);
			actionDescription.setText(parentActivity.currentlySelectedAction.getDescription());
			View configurationView = parentActivity.currentlySelectedAction.getConfigurationView(inflater);
			if (configurationView != null) {
				actionConfigLayout.addView(configurationView);
			}

			
			detectorConfigLayout = (LinearLayout) layout.findViewById(R.id.detectorConfigLayout);
			Spinner detectorSelector = (Spinner) layout.findViewById(R.id.soundDetectorSelector);
			final TextView detectorDescription = (TextView) layout.findViewById(R.id.detectorDescription);

			ArrayAdapter<BabyDetector> detectorAdapter = new ArrayAdapter<BabyDetector>(getActivity(), android.R.layout.simple_spinner_item);
			// Specify the layout to use when the list of choices appears
			detectorAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
			for (BabyDetector detector : detectors) {
				detectorAdapter.add(detector);
			}
			// Apply the adapter to the spinner
			detectorSelector.setAdapter(detectorAdapter);
			detectorSelector.setOnItemSelectedListener(new OnItemSelectedListener() {

				@Override
				public void onItemSelected(AdapterView<?> arg0, View arg1,
						int item, long arg3) {
					parentActivity.currentlySelectedDetector = detectors.get(item);
					detectorConfigLayout.removeAllViews();
					View detectorConfigurationView = parentActivity.currentlySelectedDetector.getConfigurationView(inflater);
					detectorDescription.setText(parentActivity.currentlySelectedDetector.getDescription());
					if (detectorConfigurationView != null) {
						detectorConfigLayout.addView(detectorConfigurationView);
					}
					detectorConfigLayout.invalidate();	
					
				}

				@Override
				public void onNothingSelected(AdapterView<?> arg0) {
					
				}
			});


			parentActivity = (BabyWatchActivity) getActivity();
			parentActivity.currentlySelectedDetector = detectors.get(0);
			detectorDescription.setText(parentActivity.currentlySelectedDetector.getDescription());
			View detectorConfigurationView = parentActivity.currentlySelectedDetector.getConfigurationView(inflater);
			if (detectorConfigurationView != null) {
				detectorConfigLayout.addView(detectorConfigurationView);
			}
			return layout;			
		} else {
			return null;
		}

	}
}
