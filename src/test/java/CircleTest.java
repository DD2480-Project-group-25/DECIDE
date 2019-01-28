/*
 * Smallest enclosing circle - Test suite (Java)
 *
 * Copyright (c) 2017 Project Nayuki
 * https://www.nayuki.io/page/smallest-enclosing-circle
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program (see COPYING.txt and COPYING.LESSER.txt).
 * If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * Changes performed listed as per LPGLv3 requirements.
 *
 * Adapted to that SmallestEnclosingCircleTest was merged into Circle and
 * using our Point class.
 */

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.junit.Test;

public final class CircleTest {

  /*---- Test suite functions ----*/

  @Test
  public void testMatchingNaiveAlgorithm() {
    final int TRIALS = 1000;
    for (int i = 0; i < TRIALS; i++) {
      List<Point> points = makeRandomPoints(rand.nextInt(30) + 1);
      Circle reference = smallestEnclosingCircleNaive(points);
      Circle actual = Circle.makeCircle(points);
      assertEquals(reference.c.X, actual.c.X, EPSILON);
      assertEquals(reference.c.Y, actual.c.Y, EPSILON);
      assertEquals(reference.r, actual.r, EPSILON);
    }
  }

  @Test
  public void testTranslation() {
    final int TRIALS = 100;
    final int CHECKS = 10;
    for (int i = 0; i < TRIALS; i++) {
      List<Point> points = makeRandomPoints(rand.nextInt(300) + 1);
      Circle reference = Circle.makeCircle(points);

      for (int j = 0; j < CHECKS; j++) {
        double dx = rand.nextGaussian();
        double dy = rand.nextGaussian();
        List<Point> newPoints = new ArrayList<>();
        for (Point p : points) newPoints.add(new Point(p.X + dx, p.Y + dy));

        Circle translated = Circle.makeCircle(newPoints);
        assertEquals(reference.c.X + dx, translated.c.X, EPSILON);
        assertEquals(reference.c.Y + dy, translated.c.Y, EPSILON);
        assertEquals(reference.r, translated.r, EPSILON);
      }
    }
  }

  @Test
  public void testScaling() {
    final int TRIALS = 100;
    final int CHECKS = 10;
    for (int i = 0; i < TRIALS; i++) {
      List<Point> points = makeRandomPoints(rand.nextInt(300) + 1);
      Circle reference = Circle.makeCircle(points);

      for (int j = 0; j < CHECKS; j++) {
        double scale = rand.nextGaussian();
        List<Point> newPoints = new ArrayList<>();
        for (Point p : points) newPoints.add(new Point(p.X * scale, p.Y * scale));

        Circle scaled = Circle.makeCircle(newPoints);
        assertEquals(reference.c.X * scale, scaled.c.X, EPSILON);
        assertEquals(reference.c.Y * scale, scaled.c.Y, EPSILON);
        assertEquals(reference.r * Math.abs(scale), scaled.r, EPSILON);
      }
    }
  }

  /*---- Helper functions ----*/

  private static List<Point> makeRandomPoints(int n) {
    List<Point> result = new ArrayList<>();
    if (rand.nextDouble() < 0.2) { // Discrete lattice (to have a chance of duplicated points)
      for (int i = 0; i < n; i++) result.add(new Point(rand.nextInt(10), rand.nextInt(10)));
    } else { // Gaussian distribution
      for (int i = 0; i < n; i++) result.add(new Point(rand.nextGaussian(), rand.nextGaussian()));
    }
    return result;
  }

  // Returns the smallest enclosing circle in O(n^4) time using the naive algorithm.
  private static Circle smallestEnclosingCircleNaive(List<Point> points) {
    // Degenerate cases
    if (points.size() == 0) return null;
    else if (points.size() == 1) return new Circle(points.get(0), 0);

    // Try all unique pairs
    Circle result = null;
    for (int i = 0; i < points.size(); i++) {
      for (int j = i + 1; j < points.size(); j++) {
        Circle c = Circle.makeDiameter(points.get(i), points.get(j));
        if ((result == null || c.r < result.r) && c.contains(points)) result = c;
      }
    }
    if (result != null) return result; // This optimization is not mathematically proven

    // Try all unique triples
    for (int i = 0; i < points.size(); i++) {
      for (int j = i + 1; j < points.size(); j++) {
        for (int k = j + 1; k < points.size(); k++) {
          Circle c = Circle.makeCircumcircle(points.get(i), points.get(j), points.get(k));
          if (c != null && (result == null || c.r < result.r) && c.contains(points)) result = c;
        }
      }
    }
    if (result == null) throw new AssertionError();
    return result;
  }

  private static final double EPSILON = 1e-12;

  private static final Random rand = new Random();
}
