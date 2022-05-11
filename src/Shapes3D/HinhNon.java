/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes3D;

import Shapes2D.Ellipse;
import Shapes2D.Line;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Admin
 */
public class HinhNon {

    private int x, y, z, r, cao;
    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public int getCao() {
        return cao;
    }

    public void setCao(int cao) {
        this.cao = cao;
    }

    public int ConvertX(int coor) {
        return coor * 5 + 990 / 2;
    }

    public int ConvertY(int coor) {
        return (-coor) * 5 + 500 / 2;
    }

    public HinhNon() {
    }

    public HinhNon(int x, int y, int z, int r) {
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
        Diem3D s = new Diem3D(o.getX(), y + cao, o.getZ());

        //chuyển đổi sang 2D bằng phép chiếu Cabinet
        Point O = Cabinet.chieu(o.getX(), o.getY(), o.getZ());
        Point S = Cabinet.chieu(s.getX(), s.getY(), s.getZ());

        Point A = new Point(O.x - r, O.y - r);
        Point B = new Point(O.x + r, O.y + r);
        A.x = ConvertX(A.x);
        A.y = ConvertY(A.y);
        B.x = ConvertX(B.x);
        B.y = ConvertY(B.y);

        S.x = ConvertX(S.x);
        S.y = ConvertY(S.y);
        O.x = ConvertX(O.x);
        O.y = ConvertY(O.y);
        System.out.println(O);
        Ellipse E = new Ellipse();
        E.init(A, B, 5, color);
        E.ellipseDashed(g);

        Line h = new Line(O, S, 5, color);
        h.dashedLine(g);

        A = new Point(O.x - r * 5, O.y);
        B = new Point(O.x + r * 5, O.y);

        Line d = new Line(O, B, 5, color);
        d.dashedLine(g);
        Line OA = new Line(O, A, 5, color);
        OA.dashedLine(g);

        Line l1 = new Line(S, A, 5, color);
        l1.draw(g);
        Line l2 = new Line(S, B, 5, color);
        l2.draw(g);
        
        // hien toa do
        g.setColor(Color.RED);
        String Ox = Integer.toString(o.getX());
        String Oy = Integer.toString(o.getY());
        String Oz = Integer.toString(o.getZ());
        String Sx = Integer.toString(o.getX());
        String Sy = Integer.toString(o.getY()+ cao);
        String Sz = Integer.toString(o.getZ());
        g.drawString("(" + Ox + ", " + Oy +"," + Oz + ")",O.x + 3 ,O.y -5 );
        g.drawString("(" + Sx + ", " + Sy +"," + Sz + ")",S.x + 3 ,S.y );
    }
}
