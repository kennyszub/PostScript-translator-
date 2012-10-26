package draw;
import java.util.List;

/** A SubtractExpr is a subtraction expression
    that has a list of operands given to its constructor.
    * @author Ken Szuzbda
    */

public class SubtractExpr extends Combination {
    /** Constructor.
     * @param operands List of ops */
    public SubtractExpr(List<Expr> operands) {
        super(operands);
    }
    /** Create method.
     * @param operands list of ops
     * @return new SubtractExpr
     */
    public SubtractExpr create(List<Expr> operands) {
        if (operands.size() != 2) {
            throw new ProgramError("Error : Need to have 2 operands");
        } else {
            return new SubtractExpr(operands);
        }
    }
    /** Execute method.
     * @param machine the interpreter
     * @return returns a number */
    public Value execute(Interpreter machine) {
        double a = _operands.get(0).execute(machine).doubleValue();
        double b = _operands.get(1).execute(machine).doubleValue();
        return new Number(a - b);
    }
}
