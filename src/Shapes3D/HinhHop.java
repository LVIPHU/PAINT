/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes3D;

import java.awt.Point;
import java.awt.Color;
import java.awt.Graphics2D;
import Shapes2D.Line;


/**
 *
 * @author Admin
 */
public class HinhHop extends Line {

    private int x, y, z, dai, rong, cao;
    private Color color;
    
    public int ConvertX(int coor) {
        return coor * 5 + 990 / 2;
    }

    public int ConvertY(int coor) {
        return (-coor) * 5 + 500 / 2;
    }

    public HinhHop() {
    }

    public HinhHop(int x, int y, int z, int dai, int rong, int cao) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.dai = dai;
        this.rong = rong;
        this.cao = cao;
    }
    
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public int getDai() {
        return dai;
    }

    public void setDai(int dai) {
        this.dai = dai;
    }

    public int getRong() {
        return rong;
    }

    public void setRong(int rong) {
        this.rong = rong;
    }

    public int getCao() {
        return cao;
    }

    public void setCao(int cao) {
        this.cao = cao;
    }

    public void draw(Graphics2D g) {

        //các điểm đáy trên
        Diem3D a1 = new Diem3D(x, y, z);
        Diem3D b1 = new Diem3D(x + dai, y, z);
        Diem3D c1 = new Diem3D(x + dai, y , z+ rong);
        Diem3D d1 = new Diem3D(x, y , z +rong);

        //các điểm đáy dưới
        Diem3D a2 = new Diem3D(x, y +cao, z );
        Diem3D b2 = new Diem3D(x + dai, y +cao, z );
        Diem3D d2 = new Diem3D(x, y + cao, z + rong);
        Diem3D c2 = new Diem3D(x + dai, y + cao, z + rong);

        //chuyển đổi sang 2D bằng phép chiếu Cabinet
        Point A1 = Cabinet.chieu(a1.getX(), a1.getY(), a1.getZ());
        Point B1 = Cabinet.chieu(b1.getX(), b1.getY(), b1.getZ());
        Point C1 = Cabinet.chieu(c1.getX(), c1.getY(), c1.getZ());
        Point D1 = Cabinet.chieu(d1.getX(), d1.getY(), d1.getZ());

        Point A2 = Cabinet.chieu(a2.getX(), a2.getY(), a2.getZ());
        Point B2 = Cabinet.chieu(b2.getX(), b2.getY(), b2.getZ());
        Point C2 = Cabinet.chieu(c2.getX(), c2.getY(), c2.getZ());
        Point D2 = Cabinet.chieu(d2.getX(), d2.getY(), d2.getZ());

        // chuyen đổi người dùng sang máy
        A1.x = ConvertX(A1.x);
        A1.y = ConvertY(A1.y);
        B1.x = ConvertX(B1.x);
        B1.y = ConvertY(B1.y);
        C1.x = ConvertX(C1.x);
        C1.y = ConvertY(C1.y);
        D1.x = ConvertX(D1.x);
        D1.y = ConvertY(D1.y);

        A2.x = ConvertX(A2.x);
        A2.y = ConvertY(A2.y);
        B2.x = ConvertX(B2.x);
        B2.y = ConvertY(B2.y);
        C2.x = ConvertX(C2.x);
        C2.y = ConvertY(C2.y);
        D2.x = ConvertX(D2.x);
        D2.y = ConvertY(D2.y);
        System.out.println(A2 + "A2");
        System.out.println(B2 + "B2");
        System.out.println(C2 + "C2");

        //Vẽ các đoạn thẳng đáy dưới
        Line A1B1 = new Line(A1, B1, 5, color);
        A1B1.dashedLine(g);
        Line B1C1 = new Line(B1, C1, 5, color);
        B1C1.draw(g);
        Line D1C1 = new Line(D1, C1, 5, color);
        D1C1.draw(g);
        Line D1A1 = new Line(D1, A1, 5, color);
        D1A1.dashedLine(g);

        //Vẽ các đoạn thẳng đáy trên
        Line A2B2 = new Line(A2, B2, 5, color);
        A2B2.draw(g);
        Line B2C2 = new Line(B2, C2, 5, color);
        B2C2.draw(g);
        Line D2C2 = new Line(D2, C2, 5, color);
        D2C2.draw(g);
        Line D2A2 = new Line(D2, A2, 5, color);
        D2A2.draw(g);

        //Vẽ các cạnh bên
        Line A1A2 = new Line(A1, A2, 5, color);
        A1A2.dashedLine(g);
        Line B1B2 = new Line(B1, B2, 5, color);
        B1B2.draw(g);
        Line C1C2 = new Line(C1, C2, 5, color);
        C1C2.draw(g);
        Line D1D2 = new Line(D1, D2, 5, color);
        D1D2.draw(g);
        
        // hien toa do
        g.setColor(Color.RED);
        String A1x = Integer.toString(x);
        String A1y = Integer.toString(y);
        String A1z = Integer.toString(z);
        String B1x = Integer.toString(x +dai);
        String B1y = Integer.toString(y);
        String B1z = Integer.toString(z);
        String C1x = Integer.toString(x + dai);
        String C1y = Integer.toString(y);
        String C1z = Integer.toString(z +rong);
        String D1x = Integer.toString(x);
        String D1y = Integer.toString(y);
        String D1z = Integer.toString(z + rong);
        String A2x = Integer.toString(x);
        String A2y = Integer.toString(y + cao);
        String A2z = Integer.toString(z);
        String B2x = Integer.toString(x + dai);
        String B2y = Integer.toString(y+ cao);
        String B2z = Integer.toString(z);
        String C2x = Integer.toString(x + dai);
        String C2y = Integer.toString(y + cao);
        String C2z = Integer.toString(z + rong);
        String D2x = Integer.toString(x);
        String D2y = Integer.toString(y + cao);
        String D2z = Integer.toString(z + rong);
        g.drawString("(" + A1x + ", " + A1y +"," + A1z + ")", A1.x + 3 ,A1.y -5 );
        g.drawString("(" + B1x + ", " + B1y +"," + B1z + ")",B1.x + 3 ,B1.y -5 );
        g.drawString("(" + C1x + ", " + C1y +"," + C1z + ")",C1.x + 3 ,C1.y  + 5 );
        g.drawString("(" + D1x + ", " + D1y +"," + D1z + ")",D1.x + 3 ,D1.y +15  );
        g.drawString("(" + A2x + ", " + A2y +"," + A2z + ")",A2.x + 3 ,A2.y -5 );
        g.drawString("(" + B2x + ", " + B2y +"," + B2z + ")",B2.x + 3 ,B2.y -5 );
        g.drawString("(" + C2x + ", " + C2y +"," + C2z + ")",C2.x + 3 ,C2.y +5);
        g.drawString("(" + D2x + ", " + D2y +"," + D2z + ")",D2.x + 3 ,D2.y +15);
    }
}
