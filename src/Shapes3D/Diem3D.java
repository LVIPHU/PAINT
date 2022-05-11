/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes3D;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import Shapes2D.*;
import java.awt.Point;

/**
 *
 * @author Admin
 */
public class Diem3D {
     public final int subFrameWidth = 320, subFrameHight = 260, labelSize = 40, textSize = 75;
    private int x, y, z;

  
    public Diem3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
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

//    public JFrame nhapToaDo3D() {
//        JFrame frame = new JFrame("ĐIỂM 3D");
//        frame.setSize(subFrameWidth, subFrameHight);
//        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//        frame.setLocationRelativeTo(null);
//        frame.setLayout(null);
//        frame.getContentPane().setBackground(Color.ORANGE);
//
//        JLabel labelX, labelY, labelZ;
//
//        labelX = new JLabel("x:");
//        labelX.setBounds(10, 25, labelSize, 25);
//        frame.add(labelX);
//        InputData.x = new JTextField();
//        InputData.x.setBounds(60, 25, textSize, 25);
//        frame.add(InputData.x);
//
//        labelY = new JLabel("y:");
//        labelY.setBounds(150, 25, labelSize, 25);
//        frame.add(labelY);
//        InputData.y = new JTextField();
//        InputData.y.setBounds(180, 25, textSize, 25);
//        frame.add(InputData.y);
//
//        labelZ = new JLabel("z:");
//        labelZ.setBounds(10, 75, labelSize, 25);
//        frame.add(labelZ);
//        InputData.z = new JTextField();
//        InputData.z.setBounds(60, 75, textSize, 25);
//        frame.add(InputData.z);
//
//        InputData.nutVe = new JButton("VẼ");
//        InputData.nutVe.setFocusPainted(false);     	// xoa duong vien tren button khi click
//        InputData.nutVe.setBackground(Color.white);	//background cho button
//        InputData.nutVe.setContentAreaFilled(false);	//làm cho button khong con giong button nua
//        InputData.nutVe.setOpaque(true);                  //làm cho nen khong trong suốt
//        InputData.nutVe.setBounds(60, 175, textSize, 30);
//        frame.add(InputData.nutVe);
//
//        InputData.nutXoa = new JButton("XÓA");
//        InputData.nutXoa.setFocusPainted(false);
//        InputData.nutXoa.setBackground(Color.white);
//        InputData.nutXoa.setContentAreaFilled(false);
//        InputData.nutXoa.setOpaque(true);
//        InputData.nutXoa.setBounds(180, 175, textSize, 30);
//        frame.add(InputData.nutXoa);
//        frame.setResizable(false);
//        frame.setVisible(true);
//        return frame;
//    }
//
//    public void xoaDuLieu() {
//        InputData.x.setText("");
//        InputData.x.requestFocus();
//        InputData.y.setText("");
//        InputData.z.setText("");
//    }
//
//    public void xuLyDuLieu() {
//        setX(Integer.parseInt(InputData.x.getText()));
//        setY(Integer.parseInt(InputData.y.getText()));
//        setZ(Integer.parseInt(InputData.z.getText()));
//    }
//
//    public String layDuLieu() {
//        String str = "\n\t\tTỌA ĐỘ ĐIỂM\n\n";
//
//        str += "\tA (" + x + ", " + y + ", " + z + ")";
//
//        return str;
//    }

    public void draw(Graphics2D g) {
        Diem3D a = new Diem3D(x, y, z);

        //Chuyển đổi sang 2D bằng phép chiếu Cabinet
       Point A = Cabinet.chieu(a.getX(), a.getY(), a.getZ());
        
        //Vẽ điểm
      

        //Vẽ tên điểm
    }
}
