package com.softa.babywatch.detectors;

import android.view.LayoutInflater;
import android.view.View;

import com.softa.babywatch.BabyState;

public class TestDetector implements BabyDetector {

	@Override
	public BabyState updateState(double average) {
		/*
		 * Add detector implementation here.
		 * 
		 * This method is called every sample interval with the average of the
		 * last recorded samples.
		 * 
		 * Use the values to update according to the algorithm selected and
		 * return the current state of the Baby.
		 */
		return BabyState.SLEEPING;
	}

	@Override
	public short getBackgroundLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public short getCurrentLevel() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getConfigurationView(LayoutInflater inflater) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "This is a test implementation";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Test detector";
	}

}
