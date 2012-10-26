package draw;

import java.io.PrintWriter;

/** A Filled Circle picture in the interpreter.
 * @author Ken Szubzda cs61b-ek
 */

class FilledCircle extends Picture {
    /** constructor X Y R. */
    FilledCircle(double x, double y, double r) {
        xCoor = x;
        yCoor = y;
        radius = r;
        red = super.getred();
        green = super.getgreen();
        blue = super.getblue();
        linewidth = super.getlinewidth();
    }
    /** constructor with colors X Y RAD R G B W. */
    FilledCircle(double x, double y, double rad, double r, double g,
                 double b, double w) {
        xCoor = x;
        yCoor = y;
        radius = rad;
        red = r;
        green = g;
        blue = b;
        linewidth = w;
    }
    /** draw method OUT. */
    void draw(PrintWriter out) {
        out.println(xCoor + " " + yCoor + " " + radius
                    + " " + zero + " " + three60 + " arc");
        out.println(linewidth + " setlinewidth");
        out.println(red + " " + green + " " + blue + " setrgbcolor");
        out.println("fill");
    }
    /** translate method XSHIFT YSHIFT return filledcirc. */
    Picture translate(double xShift, double yShift) {
        return new FilledCircle((xCoor + xShift), (yCoor + yShift),
                                radius, red, green, blue, linewidth);
    }
    /** scale method FACTOR scale return filledcirc. */
    Picture scale(double factor) {
        if (factor <= 0) {
            throw new ProgramError("Error : factor must be > 0");
        }
        return new FilledCircle((xCoor * factor), (yCoor * factor),
                                (radius * factor), red, green, blue, linewidth);
    }
    /** rotate method DEGREES return filledcirc. */
    Picture rotate(double degrees) {
        double rDegrees = Math.toRadians(degrees);
        double cosDegree = Math.cos(rDegrees);
        double sinDegree = Math.sin(rDegrees);
        double newX = (xCoor * cosDegree) - (yCoor * sinDegree);
        double newY = (xCoor * sinDegree) + (yCoor * cosDegree);
        return new FilledCircle(newX, newY, radius, red, green,
                                blue, linewidth);
    }

    /** x coordinate. */
    private double xCoor;
    /** y coordinate. */
    private double yCoor;
    /** radius. */
    private double radius;
    /** zero. */
    private final double zero = 0;
    /** threehundredsixty. */
    private final double three60 = 360;
    /** colors and linewidth. */
    private double red, green, blue, linewidth;
}
