/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern;

/**
 *
 * @author Biju Ale
 */
public class ForecastDisplay implements Observer {

    float temp, pressure, humidity;

    @Override
    public void update(float temp, float pressure, float humidity) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        display();
    }

    void display() {
        System.out.println("Forecast temperature: " + temp);
        System.out.println("Forecast humidity: " + humidity);
    }

}
