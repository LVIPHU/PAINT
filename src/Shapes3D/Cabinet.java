/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes3D;

import java.awt.Point;



/**
 *
 * @author Admin
 */
public class Cabinet {
    public static Point chieu(int x, int y, int z) {
        int X = (int) (x - z * (Math.sqrt(2)) / 4);
        int Y = (int) (y - z * (Math.sqrt(2)) / 4);
        Point d = new Point(X, Y);
        return d;
    }
}
