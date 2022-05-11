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
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author DELL
 */
public class Truck {
    private Point O;
    private int sizeTruck;
    private int r = 4;
    private int size;
    int sizeBody, heightBody;
    
    // Khởi tạo các điểm
    Point A1, A2, A3, A4;// Điểm thân
    Point B1, B2, B3, B4;// Điểm cổ
    Point C1, C2, C3, C4;// Điểm đầu dưới
    Point D1, D2, D3, D4;// Điểm đầu trên
    Point DT1, DT2;// Điểm đường thẳng
    Point O1, O2;// Điểm tâm bánh xe

    public Truck() {
    }

    public Truck(Point O, int sizeTruck, int size) {
        this.O = O;
        this.sizeTruck = sizeTruck;
        this.size = size;
    }

    public Point getO() {
        return O;
    }

    public void setO(Point O) {
        this.O = O;
    }

    public int getSizeTruck() {
        return sizeTruck;
    }

    public void setSizeTruck(int sizeTruck) {
        this.sizeTruck = sizeTruck;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }
    
    public void init(){
        // Tọa độ thân xe
        sizeBody = sizeTruck*3/4;
        heightBody = sizeBody/2;
        A1 = new Point((O.x-((sizeBody-r)*size)), O.y-size);
        A2 = new Point((A1.x + sizeBody*size), A1.y);
        A3 = new Point(A2.x, O.y-heightBody*size);
        A4 = new Point(A1.x, A3.y);
        
        // Tọa độ cổ xe
        B1 = A2;
        B2 = new Point(B1.x + ((r*size)*3/2), B1.y);
        B3 = new Point(B2.x, B2.y -(r*size));
        B4 = new Point(B1.x, B3.y);
        
        // Tọa độ đầu xe dưới
        C1 = B2;
        C2 = new Point(A1.x+sizeTruck*size,C1.y);
        C3 = new Point(C2.x, C2.y - (heightBody/2)*size);
        C4 = new Point(C1.x, C3.y);
        
        // Tọa độ đầu xe trên
        D1 = C4;
        D2 = new Point(D1.x +(C2.x-C1.x)/2, D1.y);
        D3 = new Point(D2.x, D2.y - (heightBody/4)*size);
        D4 = new Point(D1.x, D3.y);
        DT1 = D3;
        DT2 = new Point(D2.x + r*size,D2.y);
        
        // Tọa độ bánh xe
        O1 = new Point((A1.x +((r*3/2)*size)), O.y);
        O2 = new Point((C1.x +((r*3/2)*size)), O.y);
    }
    
    public void draw(Graphics g){
        // Tô màu xe
        // Màu thân xe
        g.setColor(Color.red);
        int[] xpoint = {A1.x, A2.x, A3.x, A4.x};
        int[] ypoint = {A1.y, A2.y, A3.y, A4.y};
        g.fillPolygon(xpoint, ypoint, 4);
        // Màu cổ xe
        int[] xpoint2 = {B1.x, B2.x, B3.x, B4.x};
        int[] ypoint2 = {B1.y, B2.y, B3.y, B4.y};
        g.fillPolygon(xpoint2, ypoint2, 4);
        // Màu đầu dưới xe
        int[] xpoint3 = {C1.x, C2.x, C3.x, C4.x};
        int[] ypoint3 = {C1.y, C2.y, C3.y, C4.y};
        g.fillPolygon(xpoint3, ypoint3, 4);
        // Màu đầu trên xe
        int[] xpoint4 = {D1.x, D2.x, D3.x, D4.x};
        int[] ypoint4 = {D1.y, D2.y, D3.y, D4.y};
        g.fillPolygon(xpoint4, ypoint4, 4);
        g.setColor(Color.white);
        int[] xpoint5 = {D2.x, DT1.x, DT2.x};
        int[] ypoint5 = {D2.y, DT1.y, DT2.y};
        g.fillPolygon(xpoint5, ypoint5, 3);
        
        // Vẽ thân xe
        Rectangle rect;
        rect = new Rectangle(A1, A2, A3, A4, size, Color.black);
        rect.draw(g);
        
        // Vẽ cổ xe
        rect = new Rectangle(B1, B2, B3, B4, size, Color.black);
        rect.draw(g);
        
        
        // Vẽ đầu dưới
        rect = new Rectangle(C1, C2, C3, C4, size, Color.black);
        rect.draw(g);
        
        
        // Vẽ đầu trên
        rect = new Rectangle(D1, D2, D3, D4, size, Color.black);
        rect.draw(g);
        
        Line l = new Line();
        l.init(DT1, DT2, size, Color.black);
        l.draw(g);
        
        
        // Vẽ Bánh Xe
        Circle c = new Circle();
        // Bánh cuối
        c.init(new Point(O1.x - r*size, O1.y), new Point(O1.x + r*size, O1.y), size, Color.black);
        c.draw(g);
        g.setColor(Color.gray);
        g.fillOval(O1.x - r*size, O1.y-r*size, r*2*size, r*2*size);
        c.init(new Point(O1.x - r/2*size, O1.y), new Point(O1.x + r/2*size, O1.y), size, Color.black);
        c.draw(g);
        g.setColor(Color.white);
        g.fillOval(O1.x - r/2*size, O1.y-r/2*size, r*size, r*size);
        
        // Bánh giữa
        c.init(new Point(O.x-r*size, O.y), new Point(O.x+r*size, O.y), size, Color.black);
        c.draw(g);
        g.setColor(Color.gray);
        g.fillOval(O.x-r*size, O.y-r*size, r*2*size, r*2*size);
        c.init(new Point(O.x-r/2*size, O.y), new Point(O.x+r/2*size, O.y), size, Color.black);
        c.draw(g);
        g.setColor(Color.white);
        g.fillOval(O.x-r/2*size, O.y-r/2*size, r*size, r*size);
        
        // Bánh đầu
        c.init(new Point(O2.x - r*size, O2.y), new Point(O2.x + r*size, O2.y), size, Color.black);
        c.draw(g);
        g.setColor(Color.gray);
        g.fillOval(O2.x- r*size, O2.y-r*size, r*2*size, r*2*size);
        c.init(new Point(O2.x - r/2*size, O2.y), new Point(O2.x + r/2*size, O2.y), size, Color.black);
        c.draw(g);
        g.setColor(Color.white);
        g.fillOval(O2.x-r/2*size, O2.y-r/2*size, r*size, r*size);
    }
    
    // Hàm vẽ các loại biến dổi
    public void drawRotate(Graphics g, float angle){// Xoay
        angle = angle *(float) Math.PI/180;
        Transform trans= new Transform();
        this.A1 = trans.rotateAny(O, A1, angle);
        this.A2 = trans.rotateAny(O, A2, angle);
        this.A3 = trans.rotateAny(O, A3, angle);
        this.A4 = trans.rotateAny(O, A4, angle);
        this.B1 = trans.rotateAny(O, B1, angle);
        this.B2 = trans.rotateAny(O, B2, angle);
        this.B3 = trans.rotateAny(O, B3, angle);
        this.B4 = trans.rotateAny(O, B4, angle);
        this.C1 = trans.rotateAny(O, C1, angle);
        this.C2 = trans.rotateAny(O, C2, angle);
        this.C3 = trans.rotateAny(O, C3, angle);
        this.C4 = trans.rotateAny(O, C4, angle);
        this.D1 = trans.rotateAny(O, D1, angle);
        this.D2 = trans.rotateAny(O, D2, angle);
        this.D3 = trans.rotateAny(O, D3, angle);
        this.D4 = trans.rotateAny(O, D4, angle);
        this.DT1 = trans.rotateAny(O, DT1, angle);
        this.DT2 = trans.rotateAny(O, DT2, angle);
//        this.O = trans.rotateAny(O, O, angle);
        this.O1 = trans.rotateAny(O, O1, angle);
        this.O2 = trans.rotateAny(O, O2, angle);
        
        draw(g);
    }
    
    public void drawTran(Graphics g, int dx, int dy){// Tịnh tiến
        Transform trans= new Transform();
        this.A1 = trans.translation(A1, dx, dy);
        this.A2 = trans.translation(A2, dx, dy);
        this.A3 = trans.translation(A3, dx, dy);
        this.A4 = trans.translation(A4, dx, dy);
        this.B1 = trans.translation(B1, dx, dy);
        this.B2 = trans.translation(B2, dx, dy);
        this.B3 = trans.translation(B3, dx, dy);
        this.B4 = trans.translation(B4, dx, dy);
        this.C1 = trans.translation(C1, dx, dy);
        this.C2 = trans.translation(C2, dx, dy);
        this.C3 = trans.translation(C3, dx, dy);
        this.C4 = trans.translation(C4, dx, dy);
        this.D1 = trans.translation(D1, dx, dy);
        this.D2 = trans.translation(D2, dx, dy);
        this.D3 = trans.translation(D3, dx, dy);
        this.D4 = trans.translation(D4, dx, dy);
        this.DT1 = trans.translation(DT1, dx, dy);
        this.DT2 = trans.translation(DT2, dx, dy);
        this.O = trans.translation(O, dx, dy);
        this.O1 = trans.translation(O1, dx, dy);
        this.O2 = trans.translation(O2, dx, dy);
        
        draw(g);
    }
    
    public void drawScale(Graphics g, float sx, float sy){// Tỉ lệ
        Transform trans= new Transform();
//        this.A1 = trans.scale(A1, A1, sx, sy);
        this.A2 = trans.scale(A2, A1, sx, sy);
        this.A3 = trans.scale(A3, A1, sx, sy);
        this.A4 = trans.scale(A4, A1, sx, sy);
        this.B1 = trans.scale(B1, A1, sx, sy);
        this.B2 = trans.scale(B2, A1, sx, sy);
        this.B3 = trans.scale(B3, A1, sx, sy);
        this.B4 = trans.scale(B4, A1, sx, sy);
        this.C1 = trans.scale(C1, A1, sx, sy);
        this.C2 = trans.scale(C2, A1, sx, sy);
        this.C3 = trans.scale(C3, A1, sx, sy);
        this.C4 = trans.scale(C4, A1, sx, sy);
        this.D1 = trans.scale(D1, A1, sx, sy);
        this.D2 = trans.scale(D2, A1, sx, sy);
        this.D3 = trans.scale(D3, A1, sx, sy);
        this.D4 = trans.scale(D4, A1, sx, sy);
        this.DT1 = trans.scale(DT1, A1, sx, sy);
        this.DT2 = trans.scale(DT2, A1, sx, sy);
        this.O = trans.scale(O, A1, sx, sy);
        this.O1 = trans.scale(O1, A1, sx, sy);
        this.O2 = trans.scale(O2, A1, sx, sy);
        
        draw(g);
    }
    
    public void drawRefX(Graphics g){
        Transform trans = new Transform();
        this.A1 = trans.symmetryX(A1);
        this.A2 = trans.symmetryX(A2);
        this.A3 = trans.symmetryX(A3);
        this.A4 = trans.symmetryX(A4);
        this.B1 = trans.symmetryX(B1);
        this.B2 = trans.symmetryX(B2);
        this.B3 = trans.symmetryX(B3);
        this.B4 = trans.symmetryX(B4);
        this.C1 = trans.symmetryX(C1);
        this.C2 = trans.symmetryX(C2);
        this.C3 = trans.symmetryX(C3);
        this.C4 = trans.symmetryX(C4);
        this.D1 = trans.symmetryX(D1);
        this.D2 = trans.symmetryX(D2);
        this.D3 = trans.symmetryX(D3);
        this.D4 = trans.symmetryX(D4);
        this.DT1 = trans.symmetryX(DT1);
        this.DT2 = trans.symmetryX(DT2);
        this.O = trans.symmetryX(O);
        this.O1 = trans.symmetryX(O1);
        this.O2 = trans.symmetryX(O2);
        
        draw(g);
    }
    
    public void drawRefY(Graphics g){
        Transform trans = new Transform();
        this.A1 = trans.symmetryY(A1);
        this.A2 = trans.symmetryY(A2);
        this.A3 = trans.symmetryY(A3);
        this.A4 = trans.symmetryY(A4);
        this.B1 = trans.symmetryY(B1);
        this.B2 = trans.symmetryY(B2);
        this.B3 = trans.symmetryY(B3);
        this.B4 = trans.symmetryY(B4);
        this.C1 = trans.symmetryY(C1);
        this.C2 = trans.symmetryY(C2);
        this.C3 = trans.symmetryY(C3);
        this.C4 = trans.symmetryY(C4);
        this.D1 = trans.symmetryY(D1);
        this.D2 = trans.symmetryY(D2);
        this.D3 = trans.symmetryY(D3);
        this.D4 = trans.symmetryY(D4);
        this.DT1 = trans.symmetryY(DT1);
        this.DT2 = trans.symmetryY(DT2);
        this.O = trans.symmetryY(O);
        this.O1 = trans.symmetryY(O1);
        this.O2 = trans.symmetryY(O2);
        
        draw(g);
    }
    
    public void drawRefO(Graphics g){
        Transform trans = new Transform();
        this.A1 = trans.symmetryO(A1);
        this.A2 = trans.symmetryO(A2);
        this.A3 = trans.symmetryO(A3);
        this.A4 = trans.symmetryO(A4);
        this.B1 = trans.symmetryO(B1);
        this.B2 = trans.symmetryO(B2);
        this.B3 = trans.symmetryO(B3);
        this.B4 = trans.symmetryO(B4);
        this.C1 = trans.symmetryO(C1);
        this.C2 = trans.symmetryO(C2);
        this.C3 = trans.symmetryO(C3);
        this.C4 = trans.symmetryO(C4);
        this.D1 = trans.symmetryO(D1);
        this.D2 = trans.symmetryO(D2);
        this.D3 = trans.symmetryO(D3);
        this.D4 = trans.symmetryO(D4);
        this.DT1 = trans.symmetryO(DT1);
        this.DT2 = trans.symmetryO(DT2);
        this.O = trans.symmetryO(O);
        this.O1 = trans.symmetryO(O1);
        this.O2 = trans.symmetryO(O2);
        
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
        // Thân xe
        String str = "\t\t Xe Tải";
        str += "\n\nThân Xe";
        str += "\nA1(" + ConvertX(A1.x) + ", "+ ConvertY(A1.y) +")\t" + "A2(" + ConvertX(A2.x) + ", " + ConvertY(A2.y) + ")";
        str += "\nA3(" + ConvertX(A3.x) + ", "+ ConvertY(A3.y) +")\t" + "A4(" + ConvertX(A4.x) + ", " + ConvertY(A4.y) + ")";
        // Cổ xe
        str += "\n\nCổ Xe";
        str += "\nB1(" + ConvertX(B1.x) + ", "+ ConvertY(B1.y) +")\t" + "B2(" + ConvertX(B2.x) + ", " + ConvertY(B2.y) + ")";
        str += "\nB3(" + ConvertX(B3.x) + ", "+ ConvertY(B3.y) +")\t" + "B4(" + ConvertX(B4.x) + ", " + ConvertY(B4.y) + ")";
        // Đầu xe
        str += "\n\nĐầu Xe Dưới";
        str += "\nC1(" + ConvertX(C1.x) + ", "+ ConvertY(C1.y) +")\t" + "C2(" + ConvertX(C2.x) + ", " + ConvertY(C2.y) + ")";
        str += "\nC3(" + ConvertX(C3.x) + ", "+ ConvertY(C3.y) +")\t" + "C4(" + ConvertX(C4.x) + ", " + ConvertY(C4.y) + ")";
        
        str += "\n\nĐầu Xe Trên";
        str += "\nD1(" + ConvertX(D1.x) + ", "+ ConvertY(D1.y) +")\t" + "D2(" + ConvertX(D2.x) + ", " + ConvertY(D2.y) + ")";
        str += "\nD3(" + ConvertX(D3.x) + ", "+ ConvertY(D3.y) +")\t" + "D4(" + ConvertX(D4.x) + ", " + ConvertY(D4.y) + ")";
        // Cửa sổ
        str += "\n\nCửa sổ";
        str += "\nDT1(" + ConvertX(DT1.x) + ", "+ ConvertY(DT1.y) +")\t" + "DT2(" + ConvertX(DT2.x) + ", " + ConvertY(DT2.y) + ")";
        // Bánh xe
        str += "\n\nBánh xe cuối";
        str += "\nO1(" + ConvertX(O1.x) + ", "+ ConvertY(O1.y) +")";
        str += "\n\nBánh xe giữa";
        str += "\nO(" + ConvertX(O.x) + ", "+ ConvertY(O.y) +")";
        str += "\n\nBánh xe đầu";
        str += "\nO2(" + ConvertX(O2.x) + ", "+ ConvertY(O2.y) +")";
        
        return str;
    }
}
