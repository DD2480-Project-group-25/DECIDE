public class Point {
    public final double X;
    public final double Y;

    public Point(double x, double y){
        this.X = x;
        this.Y = y;
    }

    /** 
     *  Calculates the euclidean distance between two points
     *  @Param a point 
     *  @Return the euclidean distance between this point and the other point. 
     **/
    public double distance(Point point){
        return Math.sqrt(Math.pow(this.X-point.X,2)+Math.pow(this.Y-point.Y,2));
    }
}
