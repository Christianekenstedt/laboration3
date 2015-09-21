package laboration3;

/**
 *
 * @author Christian
 */
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Line extends Shape{
    private double x2;
    private double y2;
    
    /**
     * Constructor creates the line
     * @param x 
     * @param y
     * @param x2
     * @param y2
     * @param color
     */
    public Line(double x, double y,double x2,double y2, Color color){
        super(x,y,color);
        this.x2 = x2;
        this.y2 = y2;
    }
    /**
     * 
     * @return x2
     */
    public double getX2(){
        return x2;
    }
    /**
     * 
     * @return y2
     */
    public double getY2(){
        return y2;
    }
    /**
     * Paints the line.
     */
    @Override
    public void paint(GraphicsContext gc){
        
    }
}
