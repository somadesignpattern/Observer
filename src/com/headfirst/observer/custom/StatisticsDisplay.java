package com.headfirst.observer.custom;

public class StatisticsDisplay implements Observer, DisplayElement {
	private float maxTemp = 0.0f;
	private float minTemp = 200;
	private float tempSum= 0.0f;
	private int numReadings;
	private Subject weatherData;

	public StatisticsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
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

	@Override
	public void display() {
		System.out.println("Avg/Max/Min temperature = " + this.tempSum / this.numReadings
			+ "/" + this.maxTemp + "/" + this.minTemp);
	}
}