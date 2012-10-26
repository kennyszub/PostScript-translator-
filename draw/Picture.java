package draw;

import java.io.PrintWriter;

/** The interface describing all kinds of Pictures.
 * @author Ken Szubzda CS61b-ek
 */
abstract class Picture extends Value {

    @Override
    Picture pictureValue() {
        return this;
    }

    /** Draw me on OUT.  Default implementation does nothing. */
    void draw(PrintWriter out) {
    }

    /** Returns new Picture resulting from scaling me by a factor of FACTOR,
     *  which must be > 0.  Default implementation cannot be scaled. */
    Picture scale(double factor) {
        throw new IllegalArgumentException("Error : picture cannot be scaled");
    }

    /** Return new Picture resulting from translating me by an amount (X, Y).
     *  Default implementation cannot be translated. */
    Picture translate(double x, double y) {
        throw new IllegalArgumentException("Error : picture"
                                           + "cannot be translated");
    }

    /** Return new Picture resulting from rotating me by D degrees
     *  counterclockwise.  Default implementation cannot be rotated. */
    Picture rotate(double d) {
        throw new IllegalArgumentException("Error : picture cannot be rotated");
    }
    /** Gets red.
     * @return red value
     */
    static double getred() {
        return red;
    }
    /** Gets green.
     * @return green value
     */
    static double getgreen() {
        return green;
    }
    /** Gets blue.
     * @return blue value
     */
    static double getblue() {
        return blue;
    }
    /** Gets linewidth.
     * @return linewidthvalue
     */
    static double getlinewidth() {
        return linewidth;
    }
    /** Sets red.
     * @param r red
     */
    static void setred(double r) {
        red = r;
    }
    /** Sets green.
     * @param g green
     */
    static void setgreen(double g) {
        green = g;
    }
    /** Sets blue.
     * @param b blue
     */
    static void setblue(double b) {
        blue = b;
    }
    /** Sets linewidth.
     * @param l linewidth
     */
    static void setlinewidth(double l) {
        linewidth = l;
    }

    /** Red. */
    private static double red = 0;
    /** green. */
    private static double green = 0;
    /** blue. */
    private static double blue = 0;
    /** linewidth. */
    private static double linewidth = 1;

}
