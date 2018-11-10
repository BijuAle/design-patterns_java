/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpatternpull;

import java.util.ArrayList;

/**
 *
 * @author Biju Ale
 */
public class WeatherData implements Subject {

    private float temp, pressure, humidity;
    ArrayList<Observer> observers = new ArrayList();

    void setWeatherData(float temp, float pressure, float humidity) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        notifyObservers();
    }

    public float getTemp() {
        return temp;
    }

    public float getPressure() {
        return pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    @Override
    public void registerObserver(Observer O) {
        observers.add(O);
    }

    @Override
    public void removeObserver(Observer O) {
        if (observers.indexOf(O) > 0) {
            observers.remove(O);
        } else {
            System.out.println("Observer not present in list.");
        }

    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

}
