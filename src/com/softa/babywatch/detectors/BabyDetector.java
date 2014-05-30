package com.softa.babywatch.detectors;

import android.view.LayoutInflater;
import android.view.View;

import com.softa.babywatch.BabyState;

/**
 * Interface for implementing a noise detector for babies
 * 
 */
public interface BabyDetector {
	
	/**
	 * Update the current state of the baby detector.
	 * 
	 * @param average is the average for the absolute values measured during the last samples read to the buffer
	 * @return the current state of the detector
	 */
	BabyState updateState(double average);
	
	/**
	 * Gets the current level of the background noise. 
	 * 
	 * @return a short value between 0 and 32767 
	 */
	short getBackgroundLevel();
	
	/**
	 * Gets the current noise level.
	 * 
	 * @return a short value between 0 and 32767
	 * 
	 */
	short getCurrentLevel();
	
	/**
	 * Gets the configuration {@link View} of the noise detector 
	 * 
	 * @param inflater used to create the view
	 * @return a configuration view if such exists, else <code>null</code>
	 */
	View getConfigurationView(LayoutInflater inflater);
	
	/**
	 * Get a description of the detector and its characteristics.
	 * 
	 * @return a descriptive {@link String}
	 */
	String getDescription();

}
