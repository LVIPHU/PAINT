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
public class Matrix {
    public float[] matrixMul(int n, float []a, float[][] b){// Nhân Ma trận 1xn với nxn
        float[] rs = new float[n];
        for(int i =0; i<n; i++){
            rs[i]=0;
            for(int j=0; j<n; j++){
                rs[i] += a[j]*b[j][i];
            }
        }
        return rs;
    }
    
    public float[][] matrixMul(int n, float[][] a, float[][] b){// Nhân Ma trận nxn với nxn
        float[][] rs = new float[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                rs[i][j] = 0;
                for(int k=0; k<n; k++){
                    rs[i][j] += a[i][k]*b[k][j];
                }
            }
        }
        return rs;
    }
}
