/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyweight;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Biju Ale
 */
public class Client {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        
        Canvas canvas = new Canvas(shapeFactory.getCircle(Color.yellow));

        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.add(canvas);
        canvas.setVisible(true);
    }
}
