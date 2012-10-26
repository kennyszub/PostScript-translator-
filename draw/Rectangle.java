package draw;

import java.util.List;
import java.io.PrintWriter;
import java.util.ArrayList;

/** A Rectangle picture in the interpreter.
    @author Ken Szubzda
 */

class Rectangle extends Picture {
    /** Rectangle constructor.
     * @param coordinates contains coordinates.
     */
    Rectangle(List<Double> coordinates) {
        _coordinates = coordinates;
        x0 = _coordinates.get(0);
        y0 = _coordinates.get(1);
        x1 = _coordinates.get(2);
        y1 = _coordinates.get(3);
        x2 = _coordinates.get(4);
        y2 = _coordinates.get(5);
        x3 = _coordinates.get(6);
        y3 = _coordinates.get(7);
        red = super.getred();
        green = super.getgreen();
        blue = super.getblue();
        linewidth = super.getlinewidth();
    }
    /** Rectangle constructor with colors.
     * @param coordinates the coors
     * @param r red
     * @param g green
     * @param b blue
     * @param w width
     */
    Rectangle(List<Double> coordinates, double r, double g,
              double b, double w) {
        _coordinates = coordinates;
        x0 = _coordinates.get(0);
        y0 = _coordinates.get(1);
        x1 = _coordinates.get(2);
        y1 = _coordinates.get(3);
        x2 = _coordinates.get(4);
        y2 = _coordinates.get(5);
        x3 = _coordinates.get(6);
        y3 = _coordinates.get(7);
        red = r;
        green = g;
        blue = b;
        linewidth = w;
    }
    /** draw method.
     * @param out printwriter
     */
    void draw(PrintWriter out) {
        out.println(x0 + " " + y0 + " " + "moveto");
        out.println(x1 + " " + y1 + " " + "lineto");
        out.println(x2 + " " + y2 + " " + "lineto");
        out.println(x3 + " " + y3 + " " + "lineto");
        out.println(x0 + " " + y0 + " " + "lineto");
        out.println(linewidth + " setlinewidth");
        out.println(red + " " + green + " " + blue + " setrgbcolor");
        out.println("stroke");
    }
    /** Translate method.
     * @param xShift shift in x dir
     * @param yShift shift in y dir
     * @return returns new rectangle.
    */
    Picture translate(double xShift, double yShift) {
        List<Double> newCoors = new ArrayList<Double>();
        newCoors.add(x0 + xShift);
        newCoors.add(y0 + yShift);
        newCoors.add(x1 + xShift);
        newCoors.add(y1 + yShift);
        newCoors.add(x2 + xShift);
        newCoors.add(y2 + yShift);
        newCoors.add(x3 + xShift);
        newCoors.add(y3 + yShift);
        return new Rectangle(newCoors, red, green, blue, linewidth);
    }

    /** scale method.
     * @param factor factor to scale by
     * @return returns a rectangle
    */
    Picture scale(double factor) {
        if (factor <= 0) {
            throw new ProgramError("Error : factor must be > 0");
        }
        List<Double> newCoors = new ArrayList<Double>();
        newCoors.add(x0 * factor);
        newCoors.add(y0 * factor);
        newCoors.add(x1 * factor);
        newCoors.add(y1 * factor);
        newCoors.add(x2 * factor);
        newCoors.add(y2 * factor);
        newCoors.add(x3 * factor);
        newCoors.add(y3 * factor);
        return new Rectangle(newCoors, red, green, blue, linewidth);
    }

    /** rotate method.
     * @param degrees rotation
     * @return returns a rectangle
     */
    Picture rotate(double degrees) {
        List<Double> newCoors = new ArrayList<Double>();
        double rDegrees = Math.toRadians(degrees);
        double cosDegree = Math.cos(rDegrees);
        double sinDegree = Math.sin(rDegrees);
        newCoors.add((x0 * cosDegree) - (y0 * sinDegree));
        newCoors.add((x0 * sinDegree) + (y0 * cosDegree));
        newCoors.add((x1 * cosDegree) - (y1 * sinDegree));
        newCoors.add((x1 * sinDegree) + (y1 * cosDegree));
        newCoors.add((x2 * cosDegree) - (y2 * sinDegree));
        newCoors.add((x2 * sinDegree) + (y2 * cosDegree));
        newCoors.add((x3 * cosDegree) - (y3 * sinDegree));
        newCoors.add((x3 * sinDegree) + (y3 * cosDegree));
        return new Rectangle(newCoors, red, green, blue, linewidth);
    }


    /** The coordinates. */
    private List<Double> _coordinates;
    /** An x coor. */
    private double x0;
    /** A y coor. */
    private double y0;
    /** An x coor. */
    private double x1;
    /** A y coor. */
    private double y1;
    /** An x coor. */
    private double x2;
    /** A y coor. */
    private double y2;
    /** An x coor. */
    private double x3;
    /** A y coor. */
    private double y3;
    /** red. */
    private double red;
    /** green. */
    private double green;
    /** blue. */
    private double blue;
    /** linewidth. */
    private double linewidth;
}
