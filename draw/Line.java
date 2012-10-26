package draw;

import java.io.PrintWriter;

/** A Line picture in the interpreter.
 * @author Ken Szubzda cs61b-ek
 */

class Line extends Picture {
    /** constructor with X0O Y0O X1O Y1O. */
    Line(double x0o, double y0o, double x1o, double y1o) {
        x0 = x0o;
        y0 = y0o;
        x1 = x1o;
        y1 = y1o;
        red = super.getred();
        green = super.getgreen();
        blue = super.getblue();
        linewidth = super.getlinewidth();
    }
    /** constructor with X0O Y0O X1O Y1O R G B W colors. */
    Line(double x0o, double y0o, double x1o, double y1o,
         double r, double g, double b, double w) {
        x0 = x0o;
        y0 = y0o;
        x1 = x1o;
        y1 = y1o;
        red = r;
        green = g;
        blue = b;
        linewidth = w;
    }

    /** draw to OUT. */
    void draw(PrintWriter out) {
        out.println(x0 + " " + y0 + " " + "moveto");
        out.println(x1 + " " + y1 + " " + "lineto");
        out.println(linewidth + " setlinewidth");
        out.println(red + " " + green + " " + blue + " setrgbcolor");
        out.println("stroke");
    }
    /** translate with XSHIFT in x dir, YSHIFT in y dir return line. */
    Picture translate(double xShift, double yShift) {
        double newx0 = x0 + xShift;
        double newy0 = y0 + yShift;
        double newx1 = x1 + xShift;
        double newy1 = y1 + yShift;
        return new Line(newx0, newy0, newx1, newy1,
                        red, green, blue, linewidth);
    }
    /** scale with FACTOR times coors return line. */
    Picture scale(double factor) {
        if (factor <= 0) {
            throw new ProgramError("Error : factor must be > 0");
        }
        double newx0 = x0 * factor;
        double newy0 = y0 * factor;
        double newx1 = x1 * factor;
        double newy1 = y1 * factor;
        return new Line(newx0, newy0, newx1, newy1,
                        red, green, blue, linewidth);
    }
    /** rotate shape DEGREES return line. */
    Picture rotate(double degrees) {
        double rDegrees = Math.toRadians(degrees);
        double cosDegree = Math.cos(rDegrees);
        double sinDegree = Math.sin(rDegrees);
        double newx0 = (x0 * cosDegree) - (y0 * sinDegree);
        double newy0 = (x0 * sinDegree) + (y0 * cosDegree);
        double newx1 = (x1 * cosDegree) - (y1 * sinDegree);
        double newy1 = (x1 * sinDegree) + (y1 * cosDegree);
        return new Line(newx0, newy0, newx1, newy1, red,
                        green, blue, linewidth);
    }
    /** x0 coordinate. */
    private double x0;
    /** y0 coordinate. */
    private double y0;
    /** x1 coordinate. */
    private double x1;
    /** y1 coordinate. */
    private double y1;
    /** red. */
    private double red;
    /** green. */
    private double green;
    /** blue. */
    private double blue;
    /** linewidth. */
    private double linewidth;
}
