package laboration3;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author Christian
 */
public class Circle extends FillableShape{
    private double diameter;
    public Circle(double x,double y, double diameter, Color color, boolean filled){
        super(x,y,color,filled);
        this.diameter = diameter;
        
    }
    public double getDiameter(){
        return diameter;
    }
    public void setDiameter(double diameter){
        this.diameter = diameter;
    }
    @Override
    public void constrain(double boxX, double boxY, //fixa!!
            double boxWidth, double boxHeight){
        double dx,dy;
        if (getX() < boxX + diameter/2) {
            dx = Math.abs(getDx());
            super.setVelocity(dx, getDy());
        } else if (getX() > boxWidth- diameter/2) {
            dx = -Math.abs(getDx());
            super.setVelocity(dx, getDy());
        }
        if (getY() < boxY+ diameter/2) {
            dy = Math.abs(getDy());
            super.setVelocity(getDx(), dy);
        } else if (getY() > boxHeight- diameter/2) {
            dy = -Math.abs(getDy());
            super.setVelocity(getDx(), dy);
        }
    }
    @Override
    public void paint(GraphicsContext gc){
        if(getFilled()){
            gc.setFill(getColor());
            gc.fillOval(getX() - (diameter/2), getY() - (diameter/2), diameter, diameter);
        }else{
            gc.setStroke(getColor());
            gc.strokeOval(getX() - (diameter/2), getY() - (diameter/2), diameter, diameter);
        }
    }
    @Override
    public String toString(){
        String info;
        info = "Circle with center at:\n(" + getX() + "," + getY() + ") and a diameter = " + getDiameter();
        return info;
    }
}
