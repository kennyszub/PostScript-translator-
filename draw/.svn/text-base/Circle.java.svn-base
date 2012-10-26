package draw;

import java.io.PrintWriter;

/** A Circle picture in the interpreter.
 * @author Ken Szubzda
 */

class Circle extends Picture {
    /** Circle constructor.
     * @param x xcoor
     * @param y ycoor
     * @param r radius
     */
    Circle(double x, double y, double r) {
        xCoor = x;
        yCoor = y;
        radius = r;
        red = super.getred();
        green = super.getgreen();
        blue = super.getblue();
        linewidth = super.getlinewidth();
    }

    /** Circle constructor with colors.
     * @param x xcoor
     * @param y ycoor
     * @param radiu radius
     * @param r red
     * @param g green
     * @param b blue
     * @param w width
     */
    Circle(double x, double y, double radiu, double r,
           double g, double b, double w) {
        xCoor = x;
        yCoor = y;
        radius = radiu;
        red = r;
        green = g;
        blue = b;
        linewidth = w;
    }

    /** Draw method.
     * @param out Printwriter output
     */
    void draw(PrintWriter out) {
        out.println(xCoor + " " + yCoor + " " + radius
                    + " " + zero + " " + three60 + " arc");
        out.println(linewidth + " setlinewidth");
        out.println(red + " " + green + " " + blue + " setrgbcolor");
        out.println("stroke");
    }
    /** translate method.
     * @param xShift shift in x dir
     * @param yShift shift in y dir
     * returns new Circle
     */
    Picture translate(double xShift, double yShift) {
        return new Circle((xCoor + xShift), (yCoor + yShift),
                          radius, red, green, blue, linewidth);
    }

    /** scale method.
     * @param factor to scale by.
     * returns a new Circle
     */
    Picture scale(double factor) {
        if (factor <= 0) {
            throw new ProgramError("Error : factor must be > 0");
        }
        return new Circle((xCoor * factor), (yCoor * factor),
                          (radius * factor), red, green, blue, linewidth);
    }
    /** rotate method.
     * @param degrees to rotate.
     * returns new Circle
     */
    Picture rotate(double degrees) {
        double rDegrees = Math.toRadians(degrees);
        double cosDegree = Math.cos(rDegrees);
        double sinDegree = Math.sin(rDegrees);
        double newX = (xCoor * cosDegree) - (yCoor * sinDegree);
        double newY = (xCoor * sinDegree) + (yCoor * cosDegree);
        return new Circle(newX, newY, radius, red, green, blue, linewidth);
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
    /** red. */
    private double red;
    /** green. */
    private double green;
    /** blue. */
    private double blue;
    /** linewidth. */
    private double linewidth;
}
