package com.softa.babywatch.detectors;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

import com.softa.babywatch.BabyState;
import com.softa.babywatch.R;

public class SimpleAmplitudeDetector implements BabyDetector {
	
	private short counter;
	private short currentValue;
	private short limit = Short.MAX_VALUE / 10;
	
	public SimpleAmplitudeDetector() {
		counter = 0;
	}

	@Override
	public BabyState updateState(double average) {
		currentValue = (short) average;
		if (counter > 1000) {
			counter = 0;
			return BabyState.AWAKE;
		} else if (average > limit) {
			counter +=10;
			return BabyState.NOISE;
		} else {
			if (counter > 0) {
				counter--;
			}
			return BabyState.SLEEPING;
		}
	}

	@Override
	public short getBackgroundLevel() {
		return counter;
	}

	@Override
	public short getCurrentLevel() {
		return currentValue;
	}

	@Override
	public View getConfigurationView(LayoutInflater lInflater) {
		View configView = lInflater.inflate(R.layout.simple_ampl_detector_config, null);
		
		final TextView amplitudeLabel = (TextView) configView.findViewById(R.id.amplitudeThreshold);

		SeekBar bar = (SeekBar) configView.findViewById(R.id.thresholdBar);
		bar.setProgress(10);
		bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// Do nothing 
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// Do nothing
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				limit = (short) (Short.MAX_VALUE * progress / 100);
				amplitudeLabel.setText(progress + "%");
			}
		});
		amplitudeLabel.setText(10 + "%");
		return configView;
	}

	@Override
	public String getDescription() {
		return "Detector that goes off the average value exceeds a set level for a certain amount of time.";
	}
	
	@Override
	public String toString() {
		return "Simple amplitude detector"; 
	}

}
