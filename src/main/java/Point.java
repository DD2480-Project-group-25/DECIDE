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

    /**
     * Calculates the area of a triangle.
     * Area is calculated according to https://www.mathopenref.com/coordtrianglearea.html
     * @param a first point
     * @param b second point
     * @param c third point
     * @return the area of the triangle that has the three points as vertices
     */
    public static double triangleArea(Point a, Point b, Point c) {
        return Math.abs((a.X * (b.Y - c.Y) + b.X * (c.Y - a.Y) + c.X * (a.Y - b.Y))/2.0);
    }
}
