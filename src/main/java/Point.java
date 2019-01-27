public class Point {
  public final double X;
  public final double Y;

  public Point(double x, double y) {
    this.X = x;
    this.Y = y;
  }

  /**
   * Calculates the euclidean distance between two points
   * @param p a point
   * @return the euclidean distance between this point and the other point.
   */
  public double distance(Point p) {
    return Math.hypot(X - p.X, Y - p.Y);
  }

  /**
   * Calculates the area of a triangle. Area is calculated according to
   * https://www.mathopenref.com/coordtrianglearea.html
   *
   * @param a first point
   * @param b second point
   * @param c third point
   * @return the area of the triangle that has the three points as vertices
   */
  public static double triangleArea(Point a, Point b, Point c) {
    return Math.abs((a.X * (b.Y - c.Y) + b.X * (c.Y - a.Y) + c.X * (a.Y - b.Y)) / 2.0);
  }

  public Point subtract(Point p) {
    return new Point(X - p.X, Y - p.Y);
  }

  // Signed area / determinant thing
  public double cross(Point p) {
    return X * p.Y - Y * p.X;
  }
}
