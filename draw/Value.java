package draw;

/** Superclass describing values manipulated by the drawing
 *  system (stored into variables, or passed as function arguments).
 *  Provides default implementations for catching errors.
 *  @author Ken Szubzda cs61b-ek
 */
abstract class Value {

    /** Return my value as a number.  Throws IllegalStateException if I am
     *  not a number.  Default implementation. */
    double doubleValue() {
        throw new ProgramError("Error : value is not a number");
    }

    /** Return my value as a Picture.  Throws IllegalStateException if I am not
     *  a Picture.  Default implementation. */
    Picture pictureValue() {
        throw new ProgramError("Error : value is not a picture");
    }
}

