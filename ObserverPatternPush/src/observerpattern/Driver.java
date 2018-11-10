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
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CurrentDisplay cd = new CurrentDisplay();
        ForecastDisplay fd = new ForecastDisplay();
        WeatherData wd = new WeatherData();

        wd.registerObserver(fd);
        wd.registerObserver(cd);
        wd.setData(34.4f, 3.4f, 23.4f);

    }

}
