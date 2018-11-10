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
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        WeatherData wd = new WeatherData();
        CurrentDisplay cd = new CurrentDisplay();
        ForecastDisplay fd = new ForecastDisplay();

        wd.registerObserver(fd);
        wd.registerObserver(cd);
        wd.setWeatherData(23.4f, 22f, 2.3f);

    }

}
