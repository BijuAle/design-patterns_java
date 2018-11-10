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
public interface Subject {

    void registerObserver(Observer O);

    void removeObserver(Observer O);

    void notifyObservers();
}
