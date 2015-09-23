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
    public void setWidht(double width){
        this.width = width;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public void toggleFilled(){
        System.out.println("hello");
        if(super.getFilled()){
            super.setFilled(false);
        }else{
            super.setFilled(true);
            
        }
    }
    @Override
    public void constrain(double boxX, double boxY, //fixa!!
            double boxWidth, double boxHeight){
        double dx,dy;
        if (getX() < boxX) {
            dx = Math.abs(getDx());
            super.setVelocity(dx, getDy());
        } else if (getX() > boxWidth - width) {
            dx = -Math.abs(getDx());
            super.setVelocity(dx, getDy());
        }
        if (getY() < boxY) {
            dy = Math.abs(getDy());
            super.setVelocity(getDx(), dy);
        } else if (getY() > boxHeight - height) {
            dy = -Math.abs(getDy());
            super.setVelocity(getDx(), dy);
        }
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
        String info;
        info = "Rect:\nx = " + getX() + " y = " + getY() + " width = " + getWidth() + " height = " + getHeight();
        return info;
    }
}
