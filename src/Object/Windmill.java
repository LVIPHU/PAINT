/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import Shapes2D.Circle;
import Shapes2D.Line;
import Shapes2D.Rectangle;
import Shapes2D.Transform;
import Shapes2D.Triangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author DELL
 */
public class Windmill {
    private Point O;
    private int size, R;
    private int r;
    private Color color;
    
    Point rowA, rowB;
    Point d1, d2, d3;
    Point A1, A2, A3;
    Point B1, B2, B3;
    Rectangle rect;

    public Windmill() {
    }

    public Windmill(Point O, int size, int R, Color color) {
        this.O = O;
        this.size = size;
        if(R<10){
            this.r = 1;
        }else{
            this.r = R/10;
        }
        this.R = R;
        this.color = color;
    }

    public Point getO() {
        return O;
    }

    public void setO(Point O) {
        this.O = O;
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

    public int getR() {
        return R;
    }

    public void setR(int R) {
        this.R = R;
    }
    
    public void init(){
        // Vẽ cây cột điện
        rowA = new Point((O.x + r*size/2), O.y);
        rowB = new Point((O.x - r*size/2), O.y+(R*3)*size);
        
        // Vẽ cánh cối xay
        float canh = (float)Math.sqrt(3)*(R*size); 
        d1 = new Point((O.x + R*size/2), (int)(O.y + canh/2));
        d2 = new Point((O.x + R*size/2), (int)(O.y - canh/2));
        d3 = new Point((O.x - R*size), O.y);
        
        A1 = new Point(O.x + r*r, O.y - r*r);
        B1 = new Point(O.x - r*r, O.y + r*r);
        
        A2 = new Point(O.x + r*r, O.y +r*r);
        B2 = new Point(O.x - r*r, O.y -r*r);
        
        A3 = new Point(O.x , O.y + r*r);
        B3 = new Point(O.x , O.y - r*r);
    }
    
    public void draw(Graphics g){
        // Vẽ cây cột điện
        rect = new Rectangle();
        rect.init(rowA, rowB, size, color);
        rect.draw(g);
        // Tô màu 
        int[] xPoint1 = {rect.getA().x, rect.getB().x, rect.getC().x, rect.getD().x};
        int[] yPoint1 = {rect.getA().y, rect.getB().y, rect.getC().y, rect.getD().y};
        g.fillPolygon(xPoint1, yPoint1, 4);
        
        // Vẽ cánh cối xay
        Line l = new Line();
        l.init(d1, A1, size, color);
        l.draw(g);
        l.init(d1, B1, size, color);
        l.draw(g);
        int[] xPoint2 = {d1.x, A1.x, B1.x};
        int[] yPoint2 = {d1.y, A1.y, B1.y};
        g.fillPolygon(xPoint2, yPoint2, 3);
        
        l.init(d2, A2, size, color);
        l.draw(g);
        l.init(d2, B2, size, color);
        l.draw(g);
        int[] xPoint3 = {d2.x, A2.x, B2.x};
        int[] yPoint3 = {d2.y, A2.y, B2.y};
        g.fillPolygon(xPoint3, yPoint3, 3);
        
        l.init(d3, A3, size, color);
        l.draw(g);
        l.init(d3, B3, size, color);
        l.draw(g);
        int[] xPoint4 = {d3.x, A3.x, B3.x};
        int[] yPoint4 = {d3.y, A3.y, B3.y};
        g.fillPolygon(xPoint4, yPoint4, 3);
        
        // Vẽ Tâm
        Circle c = new Circle();
        Point A = new Point(O.x + r*size, O.y + r*size);
        Point B = new Point(O.x - r*size, O.y - r*size);
        c.init(A, B, size, color);
        c.draw(g);
        g.fillOval(O.x - r*size, O.y - r*size, r*size, r*size);
    }
    
    // Hàm vẽ các loại biến dổi
    public void drawRotate(Graphics g, float angle){
        angle *= Math.PI/180;
        Transform trans = new Transform();
        this.d1 = trans.rotateAny(O, d1, angle);
        this.d2 = trans.rotateAny(O, d2, angle);
        this.d3 = trans.rotateAny(O, d3, angle);
        this.A1 = trans.rotateAny(O, A1, angle);
        this.A2 = trans.rotateAny(O, A2, angle);
        this.A3 = trans.rotateAny(O, A3, angle);
        this.B1 = trans.rotateAny(O, B1, angle);
        this.B2 = trans.rotateAny(O, B2, angle);
        this.B3 = trans.rotateAny(O, B3, angle);
        
        draw(g);
    }
    
    public void drawTran(Graphics g, int dx, int dy){
        Transform trans= new Transform();
        this.d1 = trans.translation(d1, dx, dy);
        this.d2 = trans.translation(d2, dx, dy);
        this.d3 = trans.translation(d3, dx, dy);
        this.A1 = trans.translation(A1, dx, dy);
        this.A2 = trans.translation(A2, dx, dy);
        this.A3 = trans.translation(A3, dx, dy);
        this.B1 = trans.translation(B1, dx, dy);
        this.B2 = trans.translation(B2, dx, dy);
        this.B3 = trans.translation(B3, dx, dy);
        this.rowA = trans.translation(rowA, dx, dy);
        this.rowB = trans.translation(rowB, dx, dy);
        this.O = trans.translation(O, dx, dy);
        
        draw(g);
    }
    
    public void drawScale(Graphics g, float sx, float sy){
        Transform trans= new Transform();
        this.d1 = trans.scale(d1, O, sx, sy);
        this.d2 = trans.scale(d2, O, sx, sy);
        this.d3 = trans.scale(d3, O, sx, sy);
        
        draw(g);
    }
    
    public void drawRefX(Graphics g){
        Transform trans = new Transform();
        this.d1 = trans.symmetryX(d1);
        this.d2 = trans.symmetryX(d2);
        this.d3 = trans.symmetryX(d3);
        this.A1 = trans.symmetryX(A1);
        this.A2 = trans.symmetryX(A2);
        this.A3 = trans.symmetryX(A3);
        this.B1 = trans.symmetryX(B1);
        this.B2 = trans.symmetryX(B2);
        this.B3 = trans.symmetryX(B3);
        this.rowA = trans.symmetryX(rowA);
        this.rowB = trans.symmetryX(rowB);
        this.O = trans.symmetryX(O);
        
        draw(g);
    }
    
    public void drawRefY(Graphics g){
        Transform trans = new Transform();
        this.d1 = trans.symmetryY(d1);
        this.d2 = trans.symmetryY(d2);
        this.d3 = trans.symmetryY(d3);
        this.A1 = trans.symmetryY(A1);
        this.A2 = trans.symmetryY(A2);
        this.A3 = trans.symmetryY(A3);
        this.B1 = trans.symmetryY(B1);
        this.B2 = trans.symmetryY(B2);
        this.B3 = trans.symmetryY(B3);
        this.rowA = trans.symmetryY(rowA);
        this.rowB = trans.symmetryY(rowB);
        this.O = trans.symmetryY(O);
        
        draw(g);
    }
    
    public void drawRefO(Graphics g){
        Transform trans = new Transform();
        this.d1 = trans.symmetryO(d1);
        this.d2 = trans.symmetryO(d2);
        this.d3 = trans.symmetryO(d3);
        this.A1 = trans.symmetryO(A1);
        this.A2 = trans.symmetryO(A2);
        this.A3 = trans.symmetryO(A3);
        this.B1 = trans.symmetryO(B1);
        this.B2 = trans.symmetryO(B2);
        this.B3 = trans.symmetryO(B3);
        this.rowA = trans.symmetryO(rowA);
        this.rowB = trans.symmetryO(rowB);
        this.O = trans.symmetryO(O);
        
        draw(g);
    }
    
    // Hiển thị tọa độ
    public int ConvertX(int coor) {
        return (coor - 990 / 2)/size  ;
    }

    public int ConvertY(int coor) {
        return (-(coor - 500 / 2)/size) ;
    }
    
    public String showCoor(){
        // Cột
        String str = "\t\t Cối xay gió";
        str += "\n\nCột";
        str += "\nA1(" + ConvertX(rect.getA().x) + ", "+ ConvertY(rect.getA().y) +")\t" + "A2(" + ConvertX(rect.getB().x) + ", " + ConvertY(rect.getB().x) + ")";
        str += "\nA3(" + ConvertX(rect.getC().x) + ", "+ ConvertY(A3.y) +")\t" + "A4(" + ConvertX(rect.getD().x) + ", " + ConvertY(rect.getD().x) + ")";
        // Tâm Cối Xay
        str += "\n\nTâm Cối Xay";
        str += "\nO(" + ConvertX(O.x) + ", "+ ConvertY(O.y) +")";
        // Các đỉnh Cối xay
        str += "\n\nĐỉnh";
        str += "\nD1(" + ConvertX(d1.x) + ", "+ ConvertY(d1.y) +")"; 
        str += "\nD2(" + ConvertX(d2.x) + ", " + ConvertY(d2.y) + ")";
        str += "\nD3(" + ConvertX(d3.x) + ", " + ConvertY(d3.y) + ")";
        
        return str;
    }
}
