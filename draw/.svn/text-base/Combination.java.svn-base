package draw;

import java.util.List;

/** The superclass of all types of Expr other than symbols and
 *  numerals.  A Combination has an operator and zero or more operands.
 *  @author Ken Szubzda
 */
abstract class Combination extends Expr {

    /** A new Combination that has OPERANDS as its operands. */
    protected Combination(List<Expr> operands) {
        _operands = operands;
    }

    /** A factory method that returns a new instance of my type of
     *  Expr with the given OPERANDS. Each subtype of Combination
     *  defines this method with one that checks that the operands
     *  are acceptable in number for the expression and constructs a new
     *  Combination of that subtype.  A single Combination of each subtype
     *  (with dummy operands) can serve as an "exemplar" for instances of
     *  that Combination.  The intent is that these exemplars, being ordinary
     *  objects, can be put into a look-up table, with the operator
     *  symbol as the look-up key.  */
    abstract Expr create(List<Expr> operands);

    /** Return a new Combination of the type corresponding to the operator
     *  OPER, and having OPERANDS as its operands. */
    static Expr create(String oper, List<Expr> operands) {
        try {
            Combination expression = Interpreter.OPERATIONSTABLE.get(oper);
            return expression.create(operands);
        } catch (NullPointerException e) {
            throw new ProgramError("Error : Invalid combination");
        }
    }

    /** The list of all my operands, as provided to my construtor. */
    protected final List<Expr> _operands;
}
