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
public class Ellipse implements Shape2D{
    private Point A, B;
    private int size;
    private Color color;
    private double R1, R2;

    public Ellipse() {
    }

    public Ellipse(Point A, Point B, int size, Color color, int R1, int R2) {
        this.A = A;
        this.B = B;
        this.size = size;
        this.color = color;
        this.R1 = R1;
        this.R2 = R2;
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

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public double getR1() {
        return R1;
    }

    public void setR1(double R1) {
        this.R1 = R1;
    }

    public double getR2() {
        return R2;
    }

    public void setR2(double R2) {
        this.R2 = R2;
    }
    
    private void put4Pixel(int xc, int yc, int x, int y, Graphics g) {
        g.fillRect((xc + x)-size/2, (yc +y)-size/2, size, size);
        g.fillRect((xc - x)-size/2, (yc +y)-size/2, size, size);
        g.fillRect((xc + x)-size/2, (yc -y)-size/2, size, size);
        g.fillRect((xc - x)-size/2, (yc -y)-size/2, size, size);
    }
    
    private void put2Pixel(int xc, int yc, int x, int y, Graphics g) {
        g.fillRect((xc + x)-size/2, (yc +y)-size/2, size, size);
        g.fillRect((xc - x)-size/2, (yc +y)-size/2, size, size);
    }
    
    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        float p, x0;
        int x, y, Ox, Oy;
        double a = R1,b =R2;
        
        x0 = (float)(a*a/ Math.sqrt(a*a + b*b));
        Ox = (B.x+A.x)/2;
        Oy = (B.y+A.y)/2;
        
        x = 0; y = (int)Math.round(b);
        p = (float)(b*b - a*a*b + a*a/4);
        put4Pixel(Ox, Oy, x, y, g);
        while(x<=x0){
            if(p < 0){
                p += (b*b)*(2*x + 3);
            }else{
                p += b*b*(2*x + 3) - 2*a*a*(y - 1);
                y--;
            }
            x++;
            put4Pixel(Ox, Oy, x, y, g);
        }

        y = 0; x = (int) Math.round(a);
        p = (float)(a*a - b*b*a + b*b/4);
        put4Pixel(Ox, Oy, x, y, g);
        while(x > x0){
            if (p < 0) {
                p += (a*a)*(2*y + 3);
            } else {
                p += a*a*(2*y + 3) - 2*b*b*(x - 1);
                x--;
            }
            y++;
            put4Pixel(Ox, Oy, x, y, g);
        }
    }
    
    public void ellipseDashed(Graphics g){
        g.setColor(color);
        float p, x0;
        int x, y, Ox, Oy;
        double a = R1,b =R2;
        
        x0 = (float)(a*a/ Math.sqrt(a*a + b*b));
        Ox = (B.x+A.x)/2;
        Oy = (B.y+A.y)/2;
        
        x = 0; y = (int)Math.round(b);
        p = (float)(b*b - a*a*b + a*a/4);
        put4Pixel(Ox, Oy, x, y, g);
        int flag =0;
        while(x<=x0){
            if(p < 0){
                p += (b*b)*(2*x + 3);
            }else{
                p += b*b*(2*x + 3) - 2*a*a*(y - 1);
                y--;
            }
            x++;
            if(flag < 3){
                put4Pixel(Ox, Oy, x, y, g);
                flag++;
            }else if(flag < 12){
                put2Pixel(Ox, Oy, x, y, g);
                flag++;
            }else{
                flag = 0;
                put4Pixel(Ox, Oy, x, y, g);
            }
        }

        y = 0; x = (int) Math.round(a);
        p = (float)(a*a - b*b*a + b*b/4);
        put4Pixel(Ox, Oy, x, y, g);
        while(x > x0){
            if (p < 0) {
                p += (a*a)*(2*y + 3);
            } else {
                p += a*a*(2*y + 3) - 2*b*b*(x - 1);
                x--;
            }
            y++;
            if(flag < 3){
                put4Pixel(Ox, Oy, x, y, g);
                flag++;
            }else if(flag < 12){
                put2Pixel(Ox, Oy, x, y, g);
                flag++;
            }else{
                flag = 0;
                put4Pixel(Ox, Oy, x, y, g);
            }
        }
    }

    @Override
    public void init(Point start, Point end, int size, Color color) {
        this.setA(start);
        this.setB(end);
        if(Math.abs(end.x-start.x) >= Math.abs(end.y-start.y)){
            this.setR1(Math.abs(end.x - start.x)/2);
            this.setR2(((Math.sqrt(2.0)/4)*R1));
        }else{
            this.setR2(Math.abs(end.y - start.y)/2);
            this.setR1(((Math.sqrt(2.0)/4)*R2));
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
        g.drawString("(" + Ox + ", " + Oy + ")",(A.x+B.x)/2 - 3*size ,(A.y+B.y)/2 - 3*size);
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
