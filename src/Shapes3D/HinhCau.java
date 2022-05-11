/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes3D;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import Shapes2D.*;

/**
 *
 * @author Admin
 */
public class HinhCau {

    private int x, y, z, r;
    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int ConvertX(int coor) {
        return coor * 5 + 990 / 2;
    }

    public int ConvertY(int coor) {
        return (-coor) * 5 + 500 / 2;
    }

    public HinhCau() {
    }

    public HinhCau(int x, int y, int z, int r) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.r = r;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getR() {
        return r;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public void setR(int r) {
        this.r = r;
    }

    public void draw(Graphics2D g) {
        //Đoạn thẳng d
        Diem3D o = new Diem3D(x, y, z);

        //chuyển đổi sang 2D bằng phép chiếu Cabinet
        Point O = Cabinet.chieu(o.getX(), o.getY(), o.getZ());

        Point A = new Point(O.x - r, O.y - r);
        Point B = new Point(O.x + r, O.y + r);
        A.x = ConvertX(A.x);
        A.y = ConvertY(A.y);
        B.x = ConvertX(B.x);
        B.y = ConvertY(B.y);
        O.x = ConvertX(O.x);
        O.y = ConvertY(O.y);

        //Vẽ hình tròn
        Circle T = new Circle();
        T.init(A, B, 5, color);
        T.draw(g);

        //Vẽ ellipse
        Ellipse E = new Ellipse();
        E.init(A, B, 5, color);
        E.ellipseDashed(g);
        
        // hien toa do
        g.setColor(Color.RED);
        String Ox = Integer.toString(o.getX());
        String Oy = Integer.toString(o.getY());
        String Oz = Integer.toString(o.getZ());
        g.drawString("(" + Ox + ", " + Oy +"," + Oz + ")",O.x + 3 ,O.y);
    }
}
