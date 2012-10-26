package draw;

/** A primitive Expr that corresponds to a symbol in a program, such as the
 *  symbol x in the statement (:= x 3.0).
 * @author Ken Szubzda cs61b-ek
 */
class Symbol extends Expr {

    /** A Symbol whose value is represented by VALUE, which must be a.
     * either a valid numeral, floating point integer or a picture value.
     @param string input*/
    Symbol(String string) {
        _string = string;
    }
    /** Gets the key.
        @return the string key */
    public String getKey() {
        return _string;
    }
    /** When executed, a Literal simply yields the Number formed by
     *  the argument to its constructor.
     @param machine the interpreter
    @return the value in the assignments table*/
    Value execute(Interpreter machine) {
        Value val = Interpreter.getInAssignmentsTable(_string);
        if (val == null) {
            throw new ProgramError("Error : Symbol not assigned.");
        } else {
            return val;
        }
    }
    /** The value I represent. */
    private String _string;
}
