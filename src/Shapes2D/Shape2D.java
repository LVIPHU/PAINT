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
public interface Shape2D {
    public void draw(Graphics g); 	//Vẽ đối tượng
    public void init(Point start, Point end, int size, Color color);//Gán tọa độ vào các điểm khi đã có startPoint và endPoint
    public boolean impact(Point p);	//Bắt tọa độ chuột kiểm tra điểm đó thuộc hình gì
    public void move(Point start, Point end);	//Cập nhật lại tọa độ mới sau khi đối tượng bị di chuyển
    public void rotate(Point start, Point end); //Cập nhật lại tọa độ mới sau khi đối tượng bị xoay
    public void scale(Point start, Point end); 	//Cập nhật lại tọa độ mới sau khi đối tượng bị Zoom
}
