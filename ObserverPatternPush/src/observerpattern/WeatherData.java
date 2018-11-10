/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern;

import java.util.ArrayList;

/**
 *
 * @author Biju Ale
 */
public class WeatherData implements Subject {

    float temperature, pressure, humidity;
    ArrayList<Observer> observers = new ArrayList();

    @Override
    public void registerObserver(Observer O) {
        observers.add(O);
    }

    @Override
    public void removeObserver(Observer O) {
        if (observers.indexOf(O) > -1) {
            observers.remove(O);
            System.out.println("Observer removed");
        } else {
            System.out.println("Observer not present in list.");
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature, pressure, humidity);
        }

    }

    void setData(float temperature, float pressure, float humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        notifyObservers();
    }

}
