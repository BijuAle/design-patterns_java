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
public class ForecastDisplay implements Observer {

    private float temp, pressure;

    @Override
    public void update(Object data) {
        WeatherData wd = (WeatherData) data;
        this.temp = wd.getTemp();
        this.pressure = wd.getPressure();
        display();
    }

    void display() {
        System.out.println("Forecast Temperature: " + temp);
        System.out.println("Forecast Pressure: " + pressure);
    }

}
