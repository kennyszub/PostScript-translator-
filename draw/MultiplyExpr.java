package draw;
import java.util.List;


/** A MultiplyExpr is a multiplication expression
that has a list of operands given to its constructor.
 * @author Ken Szuzbda
 */

public class MultiplyExpr extends Combination {
    /** Constructor.
     * @param operands ops.
     */
    public MultiplyExpr(List<Expr> operands) {
        super(operands);
    }
    /** create.
     * @param operands ops.
     * @return multiplyexpr
     */
    public MultiplyExpr create(List<Expr> operands) {
        if (operands.size() != 2) {
            throw new ProgramError("Error : Need to have 2 operands");
        } else {
            return new MultiplyExpr(operands);
        }
    }
    /** execute.
     * @param machine interpreter
     * @return new number
     */
    public Value execute(Interpreter machine) {
        double a = _operands.get(0).execute(machine).doubleValue();
        double b = _operands.get(1).execute(machine).doubleValue();
        return new Number(a * b);
    }
}
