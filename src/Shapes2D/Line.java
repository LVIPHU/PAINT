/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;


/**
 *
 * @author DELL
 */
public class Line implements Shape2D{
    private Point A, B;
    private int size = 5;
    private Color color;

    public Line() {
    }

    public Line(Point A, Point B){
        this.A = A;
        this.B = B;
    }
    
    public Line(Point A, Point B, int size, Color color) {
        this.A = A;
        this.B = B;
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

    public void init(Point a, Point b, int size, Color color) {
        this.setA(a);
        this.setB(b);
        this.setSize(size);
        this.setColor(color);
    }

    public void draw(Graphics g) {
        line(g, A.x, B.x, A.y, B.y);
    }
    
    
    public void line(Graphics g, int x1, int x2, int y1, int y2){
        g.setColor(color);
        int dx, dy, x, y, p;
        dx = Math.abs(x2 - x1);
        dy = Math.abs(y2 - y1);
        x = x1; y = y1;
        int pushX = size, pushY = size;
        g.fillRect(x-size/2, y-size/2, size, size);
        if (x2 - x1 < 0) {
            pushX = -pushX;
        }
        if (y2 - y1 < 0) {
            pushY = -pushY;
        }
        if (dx >= dy) {
            p = 2*dy - dx;
            do{
                if (p < 0){
                    p += 2*dy;
                }else{
                    p += 2*(dy - dx);
                    y += pushY;
                }
                x += pushX;
                g.fillRect(x-size/2, y-size/2, size, size);
                if(Math.abs(x - x2) < size)    return;
            }while (x != x2);
        } else {
            p = 2*dx - dy;
            do{
                if (p < 0){
                    p += 2*dx;
                } else {
                    p += 2*(dx - dy);
                    x += pushX;
                }
                y += pushY;
                g.fillRect(x-size/2, y-size/2, size, size);
                if(Math.abs(y - y2) < size)    return;
            }while (y != y2);
        }
    }
    
    public void dashedLine(Graphics g){
        g.setColor(color);
        int dx, dy, x, y, p, flag = 0;
        dx = Math.abs(B.x - A.x);
        dy = Math.abs(B.y - A.y);
        x = A.x; y = A.y;
        int pushX = size, pushY = size;
        g.fillRect(x - size/2, y - size/2, size, size);
        if(B.x - A.x < 0){
            pushX = -pushX;
        }
        if(B.y - A.y < 0){
            pushY = -pushY;
        }
        if(dx >= dy){
            p = 2*dy - dx;
            while (x != B.x){
                if (p < 0){
                    p += 2*dy;
                }else{
                    p += 2*(dy - dx);
                    y += pushY;
                }
                x += pushX;
                if(flag < 3){
                    g.fillRect(x - size/2, y - size/2, size, size);
                    flag++;
                }else if(flag < 6){
                    flag++;
                }else{
                    flag = 0;
                    g.fillRect(x - size/2, y - size/2, size, size);
                }
                if(Math.abs(x - B.x) < size)    return;
            }
        } else {
            p = 2*dx - dy;
            while (y != B.y){
                if (p < 0){
                    p += 2*dx;
                } else {
                    p += 2*(dx - dy);
                    x += pushX;
                }
                y += pushY;
                if(flag < 3){
                    g.fillRect(x - size/2, y - size/2, size, size);
                    flag++;
                }else if(flag < 6){
                    flag++;
                }else{
                    flag = 0;
                    g.fillRect(x - size/2, y - size/2, size, size);
                }
                if(Math.abs(y - B.y) < size)    return;
            }
        }
    }
    
    public void dotLine(Graphics g){
        g.setColor(color);
        int dx, dy, x, y, p, flag = 2;
        dx = Math.abs(B.x - A.x);
        dy = Math.abs(B.y - A.y);
        x = A.x; y = A.y;
        int pushX = size, pushY = size;
        g.fillRect(x - size/2, y - size/2, size, size);
        if(B.x - A.x < 0){
            pushX = -pushX;
        }
        if(B.y - A.y < 0){
            pushY = -pushY;
        }
        if(dx >= dy){
            p = 2*dy - dx;
            while (x != B.x){
                if (p < 0){
                    p += 2*dy;
                }else{
                    p += 2*(dy - dx);
                    y += pushY;
                }
                x += pushX;
                if(flag % 2 != 0){
                    g.fillRect(x - size/2, y - size/2, size, size);
                    flag++;
                }else{
                    flag++;
                }
                if(Math.abs(x - B.x) < size)    return;
            }
        } else {
            p = 2*dx - dy;
            while (y != B.y){
                if (p < 0){
                    p += 2*dx;
                } else {
                    p += 2*(dx - dy);
                    x += pushX;
                }
                y += pushY;
                if(flag % 2 != 0){
                    g.fillRect(x - size/2, y - size/2, size, size);
                    flag++;
                }else{
                    flag++;
                }
                if(Math.abs(y - B.y) < size)    return;
            }
        }
    }
    
    public void dashedDotLine(Graphics g){
        g.setColor(color);
        int dx, dy, x, y, p, flag = 0;
        dx = Math.abs(B.x - A.x);
        dy = Math.abs(B.y - A.y);
        x = A.x; y = A.y;
        int pushX = size, pushY = size;
        g.fillRect(x - size/2, y - size/2, size, size);
        if(B.x - A.x < 0){
            pushX = -pushX;
        }
        if(B.y - A.y < 0){
            pushY = -pushY;
        }
        if(dx >= dy){
            p = 2*dy - dx;
            while (x != B.x){
                if (p < 0){
                    p += 2*dy;
                }else{
                    p += 2*(dy - dx);
                    y += pushY;
                }
                x += pushX;
                if(flag < 3){
                    g.fillRect(x - size/2, y - size/2, size, size);
                    flag++;
                }else if(flag == 4){
                    flag++;
                    g.fillRect(x - size/2, y - size/2, size, size);
                }else if(flag < 6){
                    flag++;
                }else{
                    flag = 0;
                    g.fillRect(x - size/2, y - size/2, size, size);
                }
                if(Math.abs(x - B.x) < size)    return;
            }
        } else {
            p = 2*dx - dy;
            while (y != B.y){
                if(p < 0){
                    p += 2*dx;
                }else{
                    p += 2*(dx - dy);
                    x += pushX;
                }
                y += pushY;
                if(flag < 3){
                    g.fillRect(x - size/2, y - size/2, size, size);
                    flag++;
                }else if(flag == 4){
                    flag++;
                    g.fillRect(x - size/2, y - size/2, size, size);
                }else if(flag < 6){
                    flag++;
                }else{
                    flag = 0;
                    g.fillRect(x - size/2, y - size/2, size, size);
                }
                if(Math.abs(y - B.y) < size)    return;
            }
        }
    }
    
    public void dashedDotDotLine(Graphics g){
        g.setColor(color);
        int dx, dy, x, y, p, flag = 0;
        dx = Math.abs(B.x - A.x);
        dy = Math.abs(B.y - A.y);
        x = A.x; y = A.y;
        int pushX = size, pushY = size;
        g.fillRect(x - size/2, y - size/2, size, size);
        if(B.x - A.x < 0){
            pushX = -pushX;
        }
        if(B.y - A.y < 0){
            pushY = -pushY;
        }
        if(dx >= dy){
            p = 2*dy - dx;
            while (x != B.x){
                if (p < 0){
                    p += 2*dy;
                }else{
                    p += 2*(dy - dx);
                    y += pushY;
                }
                x += pushX;
                if(flag < 3){
                    g.fillRect(x - size/2, y - size/2, size, size);
                    flag++;
                }else if(flag == 4){
                    flag++;
                    g.fillRect(x - size/2, y - size/2, size, size);
                }else if(flag == 6){
                    flag++;
                    g.fillRect(x - size/2, y - size/2, size, size);
                }else if(flag < 8){
                    flag++;
                }else{
                    flag = 0;
                    g.fillRect(x - size/2, y - size/2, size, size);
                }
                if(Math.abs(x - B.x) < size)    return;
            }
        } else {
            p = 2*dx - dy;
            while (y != B.y){
                if(p < 0){
                    p += 2*dx;
                }else{
                    p += 2*(dx - dy);
                    x += pushX;
                }
                y += pushY;
                if(flag < 3){
                    g.fillRect(x - size/2, y - size/2, size, size);
                    flag++;
                }else if(flag == 4){
                    flag++;
                    g.fillRect(x - size/2, y - size/2, size, size);
                }else if(flag == 6){
                    flag++;
                    g.fillRect(x - size/2, y - size/2, size, size);
                }else if(flag < 8){
                    flag++;
                }else{
                    flag = 0;
                    g.fillRect(x - size/2, y - size/2, size, size);
                }
                if(Math.abs(y - B.y) < size)    return;
            }
        }
    }
    
    public void arrowLine(Graphics g){
        g.setColor(color);
        int dx, dy, x, y, p;
        dx =(B.x - A.x);
        dy =(B.y - A.y);
        x = A.x; y = A.y;
        int pushX = size, pushY = size;
        g.fillRect(x - size/2, y - size/2, size, size);
        if (B.x - A.x < 0) {
            pushX = -pushX;
        }
        if (B.y - A.y < 0) {
            pushY = -pushY;
        }
        if (Math.abs(dx) >= Math.abs(dy)) {
            dx = Math.abs(dx);
            dy= Math.abs(dy);
            p = 2*dy - dx;
            while (x != B.x){
                if (p < 0){
                    p += 2*dy;
                }else{
                    p += 2*(dy - dx);
                    y += pushY;
                }
                x += pushX;
                g.fillRect(x - size/2, y - size/2, size, size);
                if(Math.abs(x - B.x) < size)    break;
            }
        } else {
            dx = Math.abs(dx);
            dy= Math.abs(dy);
            p = 2*dx - dy;
            while (y != B.y){
                if (p < 0){
                    p += 2*dx;
                } else {
                    p += 2*(dx - dy);
                    x += pushX;
                }
                y += pushY;
                g.fillRect(x - size/2, y - size/2, size, size);
                if(Math.abs(y - B.y) < size)    break;
            }
        }
        // Vẽ mũi tên
        int point1, point2;
        dx = (B.x - A.x);
        dy = (B.y - A.y);
        if (Math.abs(dx) <= Math.abs(dy)) {
            if (dy >= 0) {
                point1 = B.x - 30;
                point2 = B.x + 30;
                line(g, B.x, point1, B.y, B.y - 30);
                line(g, B.x, point2, B.y, B.y - 30);
            } else if (dy < 0) {
                point1 = B.x - 30;
                point2 = B.x + 30;
                line(g, B.x, point1, B.y, B.y+30);
                line(g, B.x, point2, B.y, B.y+30);
            }
        } else if (Math.abs(dx) > Math.abs(dy)) {
            if (dx >= 0) {
                point1 = B.y - 30;
                point2 = B.y + 30;
                line(g, B.x, B.x - 30, B.y, point1);
                line(g, B.x, B.x - 30, B.y, point2);
            } else if (dx < 0) {
                point1 = B.y - 30;
                point2 = B.y + 30;
                line(g, B.x, B.x +30, B.y, point1);
                line(g, B.x, B.x +30, B.y, point2);
            }
        }
    }
    
    public int ConvertX(int coor) {
        return (coor - 990 / 2)/size  ;
    }

    public int ConvertY(int coor) {
        return (-(coor - 500 / 2)/size) ;
    }
    
    public void Axis(Point start, Point end, Graphics g) {
        String Ax = Integer.toString(ConvertX(A.x));
        String Ay = Integer.toString(ConvertY(A.y) );
        
        String Bx = Integer.toString(ConvertX(B.x) );
        String By = Integer.toString(ConvertY(B.y));
        
        g.setColor(Color.RED);
        
        this.setA(start);
        this.setB(end);
        if(Math.abs(end.y) >= Math.abs(start.y)){
            g.drawString("(" + Ax + ", " + Ay + ")", A.x - 2*size, A.y - 2*size);
            g.drawString("(" + Bx + ", " + By + ")", B.x - 2*size, B.y + 3*size);
        }else{
            g.drawString("(" + Ax + ", " + Ay + ")", A.x - 2*size, A.y + 3*size);
            g.drawString("(" + Bx + ", " + By + ")", B.x - 2*size, B.y - 2*size);
        }
    }

    @Override
    public boolean impact(Point p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void move(Point start, Point end) {
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
