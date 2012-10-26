package draw;

/** A primitive Expr that corresponds to a numeral in a program, such as the
 *  numeral 3.0 in the statement (:= x 3.0).
 * @author Ken Szubzda cs61b-ek
 */
class Numeral extends Expr {

    /** A Numeral whose value is represented by VALUE, which must be a
     *  valid integer or floating-point numeral. */
    Numeral(String value) {
        this(Double.parseDouble(value));
    }

    /** A Numeral whose value is VALUE. */
    Numeral(double value) {
        _value = new Number(value);
    }

    /** When executed, a Literal simply yields the Number formed by
     *  the argument to its constructor. */
    Value execute(Interpreter ignored) {
        return _value;
    }
    /** The value I represent. */
    private Value _value;
}



