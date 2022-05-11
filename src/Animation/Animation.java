/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Animation;

import Object.Truck;
import Object.Windmill;
import Shapes2D.Circle;
import Shapes2D.Ellipse;
import Shapes2D.Line;
import Shapes2D.Rectangle;
import Shapes2D.Transform;
import Shapes2D.Triangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JPanel;

/**
 *
 * @author DELL
 */
public class Animation {
    Ellipse e;
    Triangle tria;
    Circle c; 
    Rectangle rec;
    Line l;
    Windmill wm1, wm2, wm3;
    Truck truck;
    int size = 5;
    
    Point A1, A2, A3, A4, A5, A6, A7, A8;
    Point B1, B2, B3, B4, B5, B6 ,B7, B8;
    Point O1, O2, O3;
    Point O;
    
    public void init(JPanel panel){
        // Khởi tạo tâm mặt trời
        O = new Point(960, 20);
        // Khởi tạo tia nắng
        A1 = new Point(960, 80);    B1 = new Point(960, 120);// hướng nam
        A2 = new Point(910, 65);    B2 = new Point(880, 90);// hướng tây nam
        A3 = new Point(900, 20);    B3 = new Point(860, 20);// hướng tây
        A4 = new Point(910, -25);   B4 = new Point(880, -50);// hướng tây bắc
        A5 = new Point(960, -20);   B5 = new Point(960, -60);// hướng bắc
        A6 = new Point(1010, -25);  B6 = new Point(1040, -40);// hướng đông bắc
        A7 = new Point(1020, 20);   B7 = new Point(1060, 20);// hướng đông
        A8 = new Point(1010, 65);   B8 = new Point(1040, 90);// hướng đông nam
        // Khởi tạo điểm Cối xay gió
        O1 = new Point(700, panel.getHeight()/3-110);
        O2 = new Point(600, panel.getHeight()/3-90);
        O3 = new Point(800, panel.getHeight()/3-90);
        wm1 = new Windmill(O1, size, 10, Color.lightGray);
        wm1.init();
        wm2 = new Windmill(O2, size, 8, Color.lightGray);
        wm2.init();
        wm3 = new Windmill(O3, size, 8, Color.lightGray);
        wm3.init();
        // Khởi tạo xe
        truck = new Truck(new Point(220, 360), 65, size);
        truck.init();
    }
    
    public void play(JPanel panel, Graphics g, float angle, int dx, int dy){
        int h = panel.getHeight();
        int w = panel.getWidth();
        
        // Vẽ Cảnh vật
        // Vẽ Núi, mây, mặt trời
        // nền
        g.setColor(new Color(80, 200, 245));
        g.fillRect(0, 0, w, h/3);
        // mây
        g.setColor(Color.white);
        g.fillOval(-40, 40, 120, 40);
        g.fillOval(150, 10, 180, 30);
        g.fillOval(550, 15, 200, 50);
        
        // núi
        g.setColor(new Color(139, 69, 19));
        int[] xPoint = {450,250,650};
        int[] yPoint = {0, h/3, h/3};
        g.fillPolygon(xPoint, yPoint, 3);
        g.setColor(new Color(34,139,34));
        int[] xPoint1 = {w*2/3+60,400,990};
        int[] yPoint1 = {10, h/3, h/3};
        g.fillPolygon(xPoint1, yPoint1, 3);
        g.setColor(Color.darkGray);
        int[] xPoint2 = {w/3-40,0,500};
        int[] yPoint2 = {30, h/3, h/3};
        g.fillPolygon(xPoint2, yPoint2, 3);
        
        // Vẽ cỏ
        g.setColor(Color.green);
        g.fillRect(0, h/3, w, 50);
        g.fillRect(0, 400, w, 100);
        
        // Vẽ đường
        g.setColor(Color.gray);
        g.fillRect(0, h/3+50, w, 184);
        l = new Line(new Point(0, 308), new Point(990, 308), size, Color.white);
        l.dashedLine(g);
        
        // mặt trời && cối xay gió
        c = new Circle();
        c.init(new Point(910, 20), new Point(1010, 20), size, Color.red);
        c.draw(g);
        g.setColor(Color.yellow);
        g.fillOval(910, -30, 100, 100);
        
        
        anime(g, angle, dx, dy);
    }
    
    public void anime(Graphics g, float angle, int dx, int dy){
        Transform trans = new Transform();
        // Xe
        truck.drawTran(g, dx, dy);

        
        // mặt trời
        angle *= Math.PI/180;
        
        A1 = trans.rotateAny(O, A1, angle); B1 = trans.rotateAny(O, B1, angle);
        A2 = trans.rotateAny(O, A2, angle); B2 = trans.rotateAny(O, B2, angle);
        A3 = trans.rotateAny(O, A3, angle); B3 = trans.rotateAny(O, B3, angle);
        A4 = trans.rotateAny(O, A4, angle); B4 = trans.rotateAny(O, B4, angle);
        A5 = trans.rotateAny(O, A5, angle); B5 = trans.rotateAny(O, B5, angle);
        A6 = trans.rotateAny(O, A6, angle); B6 = trans.rotateAny(O, B6, angle);
        A7 = trans.rotateAny(O, A7, angle); B7 = trans.rotateAny(O, B7, angle);
        A8 = trans.rotateAny(O, A8, angle); B8 = trans.rotateAny(O, B8, angle);
        l = new Line(A1, B1, size, Color.yellow);
        l.draw(g);
        l = new Line(A2, B2, size, Color.yellow);
        l.draw(g);
        l = new Line(A3, B3, size, Color.yellow);
        l.draw(g);
        l = new Line(A4, B4, size, Color.yellow);
        l.draw(g);
        l = new Line(A5, B5, size, Color.yellow);
        l.draw(g);
        l = new Line(A6, B6, size, Color.yellow);
        l.draw(g);
        l = new Line(A7, B7, size, Color.yellow);
        l.draw(g);
        l = new Line(A8, B8, size, Color.yellow);
        l.draw(g);
        
        // Vẽ cối xay gió
        wm1.drawRotate(g, angle);
        wm2.drawRotate(g, angle);
        wm3.drawRotate(g, angle);
    }
    
    // Hiển thị tọa độ
    public int ConvertX(int coor) {
        return (coor - 990 / 2)/size  ;
    }

    public int ConvertY(int coor) {
        return (-(coor - 500 / 2)/size) ;
    }
    
    public String showCoor(){
        // Mặt Trời
        String str = "\t Hoạt Ảnh";
        str += "\n\nMặt Trời";
        str += "\nTâm";
        str += "\tO(" + ConvertX(O.x) + ", " + ConvertY(O.y) +")";
        str += "\nCác tia nắng";
        str += "\nA1(" + ConvertX(A1.x) + ", "+ ConvertY(A1.y) +")\t" + "B1(" + ConvertX(B1.x) + ", "+ ConvertY(B1.y) +")"; 
        str += "\nA2(" + ConvertX(A2.x) + ", "+ ConvertY(A2.y) +")\t" + "B2(" + ConvertX(B2.x) + ", "+ ConvertY(B2.y) +")";
        str += "\nA3(" + ConvertX(A3.x) + ", "+ ConvertY(A3.y) +")\t" + "B3(" + ConvertX(B3.x) + ", "+ ConvertY(B3.y) +")";
        str += "\nA4(" + ConvertX(A4.x) + ", "+ ConvertY(A4.y) +")\t" + "B4(" + ConvertX(B4.x) + ", "+ ConvertY(B4.y) +")";
        str += "\nA5(" + ConvertX(A5.x) + ", "+ ConvertY(A5.y) +")\t" + "B5(" + ConvertX(B5.x) + ", "+ ConvertY(B5.y) +")"; 
        str += "\nA6(" + ConvertX(A6.x) + ", "+ ConvertY(A6.y) +")\t" + "B6(" + ConvertX(B6.x) + ", "+ ConvertY(B6.y) +")";
        str += "\nA7(" + ConvertX(A7.x) + ", "+ ConvertY(A7.y) +")\t" + "B7(" + ConvertX(B7.x) + ", "+ ConvertY(B7.y) +")";
        str += "\nA8(" + ConvertX(A8.x) + ", "+ ConvertY(A8.y) +")\t" + "B8(" + ConvertX(B8.x) + ", "+ ConvertY(B8.y) +")";
        
        // Xe
        str += "\n\nXe";
        str += truck.showCoor();
        
        // Cối xay gió
        str += "\n\nCối xay gió 1";
        str += wm1.showCoor();
        str += "\n\nCối xay gió 2";
        str += wm2.showCoor();
        str += "\n\nCối xay gió 3";
        str += wm3.showCoor();
        
        return str;
    }
}
