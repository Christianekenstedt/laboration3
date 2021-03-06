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
    
    public void setX2(double x2){
        this.x2 = x2; 
    }
    public void setY2(double y2){
        this.y2 = y2; 
    }
    
    @Override
    public void move(long elapsedTimeNs) {
        
        setX((getDx() * elapsedTimeNs / BILLION) + getX());
        setY((getDy() * elapsedTimeNs / BILLION) + getY());

        y2 += getDy() * elapsedTimeNs / BILLION;
        x2 += getDx() * elapsedTimeNs / BILLION;
    }

    @Override
    public void constrain(double boxX, double boxY, //fixa!!
            double boxWidth, double boxHeight){
        double dx,dy;
        if (getX() < boxX) {
            dx = Math.abs(getDx());
            super.setVelocity(dx, getDy());
        } else if (getX() > boxWidth) {
            dx = -Math.abs(getDx());
            super.setVelocity(dx, getDy());
        }
        if (getY() < boxY) {
            dy = Math.abs(getDy());
            super.setVelocity(getDx(), dy);
        } else if (getY() > boxHeight) {
            dy = -Math.abs(getDy());
            super.setVelocity(getDx(), dy);
        }
        
        if (x2 < boxX) {
            dx = Math.abs(getDx());
            super.setVelocity(dx, getDy());
        } else if (x2 > boxWidth) {
            dx = -Math.abs(getDx());
            super.setVelocity(dx, getDy());
        }
        if (y2 < boxY) {
            dy = Math.abs(getDy());
            super.setVelocity(getDx(), dy);
        } else if (y2 > boxHeight) {
            dy = -Math.abs(getDy());
            super.setVelocity(getDx(), dy);
        }
    }
    /**
     * Paints the line.
     */
    @Override
    public void paint(GraphicsContext gc){
        gc.setStroke(getColor());
        gc.strokeLine(getX(), getY(), x2, y2);    
    }
    @Override
    public String toString(){
        String info;
        info = "Line between:\n(" + getX() + "," + getY() + ") and (" + getX2() + "," + getY2()+")";
        return info;
    }
}
