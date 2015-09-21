/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboration3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Christian
 */
public class Rect extends FillableShape{
    private double width;
    private double height;
    public Rect(double x,double y, double width, double height, Color color, boolean filled){
        super(x,y,color,filled);
        this.width = width;
        this.height = height;
        
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
    @Override
    public void constrain(double x, double y, //fixa!!
            double c, double d){

    }
    @Override
    public void paint(GraphicsContext gc){
        if(getFilled()){
            gc.setFill(getColor());
            gc.fillRect(getX(), getY(), width, height);
        }else{
            gc.setStroke(getColor());
            gc.strokeRect(getX(), getY(), width, height);

        }
    }
    @Override
    public String toString(){
        String info = new String();
        return info;
    }
}
