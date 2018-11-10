/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpatternpull;

/**
 *
 * @author Biju Ale
 */
public class CurrentDisplay implements Observer {

    private float temp, pressure, humidity;

    @Override
    public void update(Object data) {
        WeatherData wd = (WeatherData) data;
        this.temp = wd.getTemp();
        this.pressure = wd.getTemp();
        this.humidity = wd.getTemp();
        display();
    }

    void display() {
        System.out.println("Current Temperature: " + temp);
        System.out.println("Current Pressure: " + pressure);
        System.out.println("Current Humidity: " + humidity);
    }

}
