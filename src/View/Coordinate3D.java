/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Shapes2D.Line;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class Coordinate3D extends JPanel{
    public void drawCoor(JPanel panel, Graphics g){
        int w = panel.getWidth();
        int h = panel.getHeight();
        
        g.drawLine(w, h/2, w/2, h/2);
        g.drawLine(w/2, 0, w/2, h/2);
        g.drawLine(w/2, h/2, 200, 550);
        g.drawString("X", w-20, h/2 -20);
        g.drawString("Y", w/2-20, 20);
        g.drawString("Z", 230, 500-20);
        
        // Trục Âm
//        Line l;
//        l = new Line(new Point(0, h/2), new Point(w/2, h/2), 1, Color.red);//x
//        l.dashedLine(g);
//        l = new Line(new Point(w/2, h/2), new Point(w/2, h), 1, Color.red);//y
//        l.dashedLine(g);
//        l = new Line(new Point(w/2, h/2), new Point(745, 0), 1, Color.red);//z
//        l.dashedLine(g);
    }
}
