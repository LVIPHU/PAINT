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
public class Triangle implements Shape2D{
    private Point A, B, C;
    private int size;
    private Color color;

    public Triangle() {
    }

    public Triangle(Point A, Point B, Point C, int size, Color color) {
        this.A = A;
        this.B = B;
        this.C = C;
        this.size = size;
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

    public Point getC() {
        return C;
    }

    public void setC(Point C) {
        this.C = C;
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

    public void draw(Graphics g) {
        g.setColor(color);
        
        Line line;
        line = new Line(A, B, size, color);
        line.draw(g);
        line = new Line(B, C, size, color);
        line.draw(g);
        line = new Line(C, A, size, color);
        line.draw(g);
    }
    
    public void triaDash(Graphics g){
        g.setColor(color);
        
        Line line;
        
        line = new Line(A, B, size, color);
        line.dashedLine(g);
        line = new Line(B, C, size, color);
        line.dashedLine(g);
        line = new Line(C, A, size, color);
        line.dashedLine(g);
    }
    
    public void triaDot(Graphics g){
        g.setColor(color);
        Line line;
        
        line = new Line(A, B, size, color);
        line.dotLine(g);
        line = new Line(B, C, size, color);
        line.dotLine(g);
        line = new Line(C, A, size, color);
        line.dotLine(g);
    }
    
    public void triaDD(Graphics g){
        g.setColor(color);
        Line line;
        
        line = new Line(A, B, size, color);
        line.dashedDotLine(g);
        line = new Line(B, C, size, color);
        line.dashedDotLine(g);
        line = new Line(C, A, size, color);
        line.dashedDotLine(g);
    }
    
    public void triaDDD(Graphics g){
        g.setColor(color);
        Line line;
        
        line = new Line(A, B, size, color);
        line.dashedDotDotLine(g);
        line = new Line(B, C, size, color);
        line.dashedDotDotLine(g);
        line = new Line(C, A, size, color);
        line.dashedDotDotLine(g);
    }
    
    public void triaArrow(Graphics g){
        g.setColor(color);
        Line line;
        
        line = new Line(A, B, size, color);
        line.arrowLine(g);
        line = new Line(B, C, size, color);
        line.arrowLine(g);
        line = new Line(C, A, size, color);
        line.arrowLine(g);
    }

    public void init(Point a, Point b, int size, Color color) {
        this.setA(new Point((a.x + b.x)/2, a.y));
        this.setB(b);
        this.setC(new Point(a.x, b.y));
        this.setSize(size);
        this.setColor(color);
    }
    
    public int ConvertX(int coor) {
        return (coor - 990 / 2)/size  ;
    }

    public int ConvertY(int coor) {
        return (-(coor - 500 / 2)/size) ;
    }
    
    public void Axis(Point start, Point end, Graphics g) {
        String Ax = Integer.toString(ConvertX(A.x));
        String Ay = Integer.toString(ConvertY(A.y));
        
        String Bx = Integer.toString(ConvertX(B.x));
        String By = Integer.toString(ConvertY(B.y));
        
        String Cx = Integer.toString(ConvertX(C.x));
        String Cy = Integer.toString(ConvertY(C.y));
        
        g.setColor(Color.RED);
        
        this.setA(start);
        this.setB(end);
        if(Math.abs(end.y) >= Math.abs(start.y)){
            g.drawString("(" + Ax + ", " + Ay + ")", A.x - 2*size, A.y - 2*size);
            g.drawString("(" + Bx + ", " + By + ")", B.x - 2*size, B.y + 3*size);
            g.drawString("(" + Cx + ", " + Cy + ")", C.x - 2*size, C.y - 2*size);
        }else{
            g.drawString("(" + Ax + ", " + Ay + ")", A.x - 2*size, A.y + 3*size);
            g.drawString("(" + Bx + ", " + By + ")", B.x - 2*size, B.y - 2*size);
            g.drawString("(" + Cx + ", " + Cy + ")", C.x - 2*size, C.y + 3*size);
        }
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
