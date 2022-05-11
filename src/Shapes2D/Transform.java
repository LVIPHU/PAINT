/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Shapes2D;

import java.awt.Point;

/**
 *
 * @author DELL
 */
public class Transform {
    public Point translation(Point A, int dx, int dy){// Tịnh tiến
        Point rs = new Point();
        float[] matrix = new float[3];
        matrix[0] = A.x;
        matrix[1] = A.y;
        matrix[2] = 1;
        float[][] matrixTrans;// ma trận tịnh tiến
        matrixTrans = new float[][]{{1, 0, 0},
                                    {0, 1, 0}, 
                                    {dx, dy, 1}};
        float[] matrixRS = new Matrix().matrixMul(3, matrix, matrixTrans);
        rs.x = (int)matrixRS[0];
        rs.y = (int)matrixRS[1];
        return rs;
    }
    
    public Point rotateO(Point A, double angle){// Xoay
        Point rs = new Point();
        float[] matrix = new float[3];
        matrix[0] = A.x;
        matrix[1] = A.y;
        matrix[2] = 1;
        float[][] matrixTrans;// ma trận xoay
        matrixTrans = new float[][]{{(float)Math.cos(angle), (float)Math.sin(angle),0},
                                    {(float)(-Math.sin(angle)), (float)Math.cos(angle),0}, 
                                    {0, 0, 1}};
        float[] matrixRS = new Matrix().matrixMul(3, matrix, matrixTrans);
        rs.x = (int)matrixRS[0];
        rs.y = (int)matrixRS[1];
        return rs;
    }
    
    public Point rotateAny(Point O, Point A, double angle){ // Xoay tâm bất kì
        Point rs = new Point();
        float[] matrix = new float[3];
        matrix[0] = A.x;
        matrix[1] = A.y;
        matrix[2] = 1;
        float[][] tt = new float[][]{{1, 0, 0},
                                     {0, 1, 0},
                                     {-O.x, -O.y, 1}};
        float[][] tt1 = new float[][]{{1, 0, 0},
                                      {0, 1, 0},
                                      {O.x, O.y, 1}};
        float[][] q = new float[][]{{(float) Math.cos(angle), (float) Math.sin(angle), 0}, 
                                    {(float) (-Math.sin(angle)), (float) Math.cos(angle), 0}, 
                                    {0, 0, 1}};
        float[][] qbk;
        qbk = new Matrix().matrixMul(3, tt, q);
        qbk = new Matrix().matrixMul(3, qbk, tt1);
        matrix = new Matrix().matrixMul(3, matrix, qbk);
        rs.x =((int) matrix[0]);
        rs.y = ((int) matrix[1]);
        return rs;
    }
    
    public Point scale(Point A, Point O, float sx, float sy){// Tỉ lệ
        Point rs = new Point();
        float[] matrix = new float[3];
        matrix[0] = A.x;
        matrix[1] = A.y;
        matrix[2] = 1;
        float[][] matrixTrans;// ma trận tỉ lệ
        matrixTrans = new float[][]{{sx, 0, 0},
                                    {0, sy, 0}, 
                                    {0, 0, 1}};
        float[] matrixRS = new Matrix().matrixMul(3, matrix, matrixTrans);
        rs.x = (int) (matrixRS[0] - (sx - 1) * O.getX());
        rs.y = (int) (matrixRS[1] - (sy - 1) * O.getY());
        return rs;
    }
    
    // ------------------- Đối xứng ------------------
    // Chuyển về tọa độ thực
    public int ConvertRealX(int coor) {
        return (coor - 990 / 2)/5;
    }

    public int ConvertRealY(int coor) {
        return (-(coor - 500 / 2)/5);
    }
    
    // Chuyển về tọa độ máy
    public int ConvertX(int coor) {
        return coor*5 +495;
    }

    public int ConvertY(int coor) {
        return (-coor)*5 +250;
    }
    
    public Point symmetryX(Point A){ 
        Point rs = new Point();
        float[] matrix = new float[3];
        matrix[0] = ConvertRealX(A.x);
        matrix[1] = ConvertRealY(A.y);
        matrix[2] = 1;
        float[][] matrixTrans;// ma trận đối xứng Ox
        matrixTrans = new float[][]{{1, 0, 0},
                                    {0, -1, 0}, 
                                    {0, 0, 1}};
        float[] matrixRS = new Matrix().matrixMul(3, matrix, matrixTrans);
        rs.x = ConvertX((int)matrixRS[0]);
        rs.y = ConvertY((int)matrixRS[1]);
        
        return rs;
    }
    
    public Point symmetryY(Point A){
        Point rs = new Point();
        float[] matrix = new float[3];
        matrix[0] = ConvertRealX(A.x);
        matrix[1] = ConvertRealY(A.y);
        matrix[2] = 1;
        float[][] matrixTrans;// ma trận đối xứng Oy
        matrixTrans = new float[][]{{-1, 0, 0},
                                    {0, 1, 0}, 
                                    {0, 0, 1}};
        float[] matrixRS = new Matrix().matrixMul(3, matrix, matrixTrans);
        rs.x = ConvertX((int)matrixRS[0]);
        rs.y = ConvertY((int)matrixRS[1]);
        return rs;
    }
    
    public Point symmetryO(Point A){
        Point rs = new Point();
        float[] matrix = new float[3];
        matrix[0] = ConvertRealX(A.x);
        matrix[1] = ConvertRealY(A.y);
        matrix[2] = 1;
        float[][] matrixTrans;// ma trận đối xứng O
        matrixTrans = new float[][]{{-1, 0, 0},
                                    {0, -1, 0}, 
                                    {0, 0, 1}};
        float[] matrixRS = new Matrix().matrixMul(3, matrix, matrixTrans);
        rs.x = ConvertX((int)matrixRS[0]);
        rs.y = ConvertY((int)matrixRS[1]);
        return rs;
    }
}
