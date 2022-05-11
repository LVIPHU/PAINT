/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author DELL
 */
public class Circle implements Shape2D{
    private Point A, B;
    private int size, R;
    private Color color;

    public Circle() {
    }

    public Circle(Point A, Point B, int size, int R, Color color) {
        this.A = A;
        this.B = B;
        this.size = size;
        this.R = R;
        this.color = color;
    }

    public Point getA() {
        return A;
    }

    public void setA(Point A) {
        this.A = A;
    }

    public Point getB() {
        return B;
    }

    public void setB(Point B) {
        this.B = B;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getR() {
        return R;
    }

    public void setR(int R) {
        this.R = R;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    void putPixel(int x, int y, Graphics g, Color c){
        g.setColor(c);
        g.fillRect(x-size/2, y-size/2, size, size);
    }
    
    void put8Pixel(int x0, int y0, int x, int y, Graphics g, Color c) {
        putPixel(x0 + x, y0 + y, g, c);
        putPixel(x0 - x, y0 + y, g, c);
        putPixel(x0 + x, y0 - y, g, c);
        putPixel(x0 - x, y0 - y, g, c);
        putPixel(x0 + y, y0 + x, g, c);
        putPixel(x0 - y, y0 + x, g, c);
        putPixel(x0 + y, y0 - x, g, c);
        putPixel(x0 - y, y0 - x, g, c);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        int x, y, p, Ox, Oy;
        x = 0;
        y = R;
        p = 3-2*R;
        Ox = (A.x+B.x)/2;
        Oy = (A.y+B.y)/2;
        putPixel(Ox, Oy, g, color);
        while(x<=y){
            put8Pixel(Ox, Oy, x, y, g, color);
            if(p<0) p = p+4*x+6;
            else{
                p = p + 4*(x-y) + 10;
                y = y-2;
            }
            x = x+2;
        }
    }

    public void init(Point a, Point b, int size, Color color) {
        this.setA(a);
        this.setB(b);
        if(Math.abs(b.x-a.x) >= Math.abs(b.y-a.y)){
            this.setR(Math.abs((a.x - b.x))/2);
        }else{
            this.setR(Math.abs((a.y - b.y))/2);
        }
        this.setSize(size);
        this.setColor(color);
    }
    
    public int ConvertX(int coor) {
        return (coor - 990 / 2)/size  ;
    }

    public int ConvertY(int coor) {
        return (-(coor - 500 / 2)/size) ;
    }
      
    public void Axis(Graphics g) {
        g.setColor(Color.RED);
        String Ox = Integer.toString(ConvertX((A.x+B.x)/2));
        String Oy = Integer.toString(ConvertY((A.y+B.y)/2));
        g.drawString("(" + Ox + ", " + Oy + ")",(A.x+B.x)/2 - 3*size,(A.y+B.y)/2 - 3*size);
    }

    @Override
    public void move(Point start, Point end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean impact(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rotate(Point start, Point end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void scale(Point start, Point end) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
