package laboration3;
import javafx.scene.paint.Color;

/**
 * A representation of a world containing a set of moving shapes. NB! The worlds
 * y-axis points downward.
 *
 * @author Anders Lindström, anderslm@kth.se 2015-09-16
 */
public class World {

    private double width, height; // this worlds width and height
    private static final long time = (long) 1_000_00.0;
    private final Shape[] shapes; // an array of references to the shapes

    /**
     * Creates a new world, containing a pad and a set of balls. NB! The worlds
     * y-axis points downward.
     *
     * @param width the width of this world
     * @param height the height of this worl
     */
    public World(double width, double height) {
        this.width = width;
        this.height = height;

        shapes = new Shape[4]; // an array of references (change to non-zero size)
        // Create the actual Shape objects (sub types)
        // ....
        shapes[0] = new Line(10.0,10.0,60.0,60.0,Color.BLACK);
        shapes[0].setVelocity(90,100);
        shapes[1] = new Circle(150.0,150.0,20,Color.AQUA,true);
        shapes[1].setVelocity(100,50);
        shapes[2] = new Rect(200.0,200.0,30,40,Color.RED,true);
        shapes[2].setVelocity(100,150);
        shapes[3] = new Rect(250.0,200.0,30,40,Color.GREEN,false);
        shapes[3].setVelocity(100,150);
    }

    /**
     * Sets the new dimensions, in pixels, for this world. The method could be
     * used for example when the canvas is reshaped.
     *
     * @param newWidth
     * @param newHeight
     */
    public void setDimensions(double newWidth, double newHeight) {
        this.width = newWidth;
        this.height = newHeight;
    }

    /**
     * Move the world one step, based on the time elapsed since last move.
     *
     * @param elapsedTimeNs the elpsed time in nanoseconds
     */
    public void move(long elapsedTimeNs) {
        // alterantive loop: for(Shape s : shapes) { ...
        for (int i = 0; i < shapes.length; i++) { 
            shapes[i].move(elapsedTimeNs);
            shapes[i].constrain(0, 0, width, height);
        }
        System.out.println(width + ", " + height);
    }

    /**
     * Returns a copy of the list of ball references.
     * Due to the implementation of clone, a shallow copy is returned.
     *
     * @return a copy of the list of balls
     */
    public Shape[] getShapes() {
        return (Shape[]) shapes.clone();
    }
    /**
     * Toggle the shapes with filled or not filled.
     * @param elapsedTime 
     */
    public void toggleFill(long elapsedTime){        
        for (Shape shape : shapes) {
            if (shape instanceof Rect) {
                if (elapsedTime/time > 175) {
                    if(((Rect) shape).getFilled())((Rect) shape).setFilled(false);    
                    else ((Rect) shape).setFilled(true);
                }
            }
        }
    }
}