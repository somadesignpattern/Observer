package com.headfirst.observer.util;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum= 0.0f;
	private int numReadings;
	Observable observable;

	public StatisticsDisplay(Observable observable) {
		this.observable = observable;
		this.observable.addObserver(this);
	}

	@Override
	public void update(Observable o, Object arg) {
		if (o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) o;
			float temp = weatherData.getTemperature();
			this.tempSum += temp;
			this.numReadings++;

			if (temp > this.maxTemp) {
				this.maxTemp = temp;
			}

			if (temp < this.minTemp) {
				this.minTemp = temp;
			}

			this.display();
		}
	}

	@Override
	public void display() {
		System.out.println("Avg/Max/Min temperature = " + this.tempSum / this.numReadings
			+ "/" + this.maxTemp + "/" + this.minTemp);
	}
}