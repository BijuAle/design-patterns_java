/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flyweight;

import java.awt.Color;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Biju Ale
 */
public class ShapeFactory {

    HashMap<Color, Shape> shapeMap = new HashMap();

    Circle getCircle(Color color) {
        Random random = new Random();
        Shape randomShape = null;

        if (!shapeMap.containsKey(color)) {

            Circle circle = new Circle(color);
            circle.setXCord(random.nextInt(300));
            circle.setYCord(random.nextInt(300));
            circle.setRadius(random.nextInt(40));

            shapeMap.put(color, circle);
        } else {
            randomShape = shapeMap.get(random.nextInt(shapeMap.size()));
        }
        return (Circle) randomShape;
    }
}
