package com.javarush.task.task24.task2413;

public class Canvas {
    private int width, height;
    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
         this.matrix = new char[height + 2][width+2];
    }

    public void setPoint (double x, double y, char c) {
        int X = (int) Math.round(x);
        int Y = (int) Math.round(y);
        if (!(X<0 || Y< 0 || Y > matrix.length || X>matrix[0].length)) matrix[Y][X] = c;
    }

    public void drawMatrix (double x, double y, int[][] matrix, char c) {
        for ( int i = 0; i < matrix.length; i++ )
            for (int j = 0; j < matrix[0].length; j++)
                if (matrix[i][j] != 0) setPoint(x+j, y+i ,c);
    }

    public void clear() {
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[0].length; j++)
                matrix[i][j] = 0;
    }
    public void print() {
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++)
               System.out.print(matrix[i][j]);
            System.out.println(); }
            
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }
}
