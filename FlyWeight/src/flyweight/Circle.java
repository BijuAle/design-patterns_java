/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyweight;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Biju Ale
 */
public class Circle implements Shape {

    private int xcord, ycord, radius;

    Circle(Color color) {
    }

    public void draw() {

    }

    public void setXCord(int xcord) {
        this.xcord = xcord;
    }

    public void setYCord(int ycord) {
        this.ycord = ycord;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getXcord() {
        return xcord;
    }

    public int getYcord() {
        return ycord;
    }

    public int getRadius() {
        return radius;
    }

}
