package com.headfirst.observer.custom;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject{

	private List<Observer> observers;
	private float temperature, humidity, pressure;

	public WeatherData() {
		this.observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		this.observers.add(o);
	}

	@Override
	public void removeObserver(Observer o) {
		int i = this.observers.indexOf(o);
		if (i >= 0) {
			this.observers.remove(i);
		}
	}

	@Override
	public void notifyObservers() {
		for(int i = 0; i < this.observers.size(); i ++) {
			Observer observer = this.observers.get(i);
			observer.update(this.temperature, this.humidity, this.pressure);
		}
	}

	public void measurementChanged() {
		this.notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		this.measurementChanged();
	}

	public float getTemperature() {
		return this.temperature;
	}

	public float getHumidity() {
		return this.humidity;
	}

	public float getPressure() {
		return this.pressure;
	}

}
