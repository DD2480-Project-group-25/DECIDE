public class Parameters {
  final double length1;
  final double length2;
  final double radius1;
  final double radius2;
  final double epsilon;
  final double area1;
  final double area2;
  final double dist;
  final int q_pts;
  final int quads;
  final int n_pts;
  final int k_pts;
  final int a_pts;
  final int b_pts;
  final int c_pts;
  final int d_pts;
  final int e_pts;
  final int f_pts;
  final int g_pts;

  public Parameters(
      double length1,
      double length2,
      double radius1,
      double radius2,
      double epsilon,
      double area1,
      double area2,
      double dist,
      int q_pts,
      int quads,
      int n_pts,
      int k_pts,
      int a_pts,
      int b_pts,
      int c_pts,
      int d_pts,
      int e_pts,
      int f_pts,
      int g_pts) {
    this.length1 = length1;
    this.length2 = length2;
    this.radius1 = radius1;
    this.radius2 = radius2;
    this.epsilon = epsilon;
    this.area1 = area1;
    this.area2 = area2;
    this.dist = dist;
    this.quads = quads;
    this.q_pts = q_pts;
    this.n_pts = n_pts;
    this.k_pts = k_pts;
    this.a_pts = a_pts;
    this.b_pts = b_pts;
    this.c_pts = c_pts;
    this.d_pts = d_pts;
    this.e_pts = e_pts;
    this.f_pts = f_pts;
    this.g_pts = g_pts;
  }
}
