package laboration3;

import javafx.scene.paint.Color;

/**
 *
 * @author Christian
 */
abstract public class FillableShape extends Shape{
    private boolean filled = false;
    
    public FillableShape(double x, double y, Color color, boolean filled){
        super(x,y,color);
        this.filled=filled;
    }
    
    public boolean getFilled(){
        return filled;
    }
    
    public void setFilled(boolean filled){
        this.filled = filled;
    }
}
