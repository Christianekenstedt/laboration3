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
    @Override
    public void constrain(double x, double y, //fixa!!
            double c, double d){

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
        String info = new String();
        return info;
    }
}
