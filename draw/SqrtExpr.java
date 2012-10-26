package draw;
import java.util.List;


/** A SqrtExpr is a sqrt expression that has
 a list of 1 operand given to its constructor.
 * @author Ken Szuzbda
 */

public class SqrtExpr extends Combination {
    /** constructor.
     * @param operands ops.
     */
    public SqrtExpr(List<Expr> operands) {
        super(operands);
    }
    /** create method.
     * @param operands ops.
     * @return SqrtExpr
     */
    public SqrtExpr create(List<Expr> operands) {
        if (operands.size() != 1) {
            throw new ProgramError("Error : Need to have 1 operand");
        } else {
            return new SqrtExpr(operands);
        }
    }
    /** execute method.
     * @param machine interpreter
     * @return a new Number
     */
    public Value execute(Interpreter machine) {
        double a = _operands.get(0).execute(machine).doubleValue();
        if (a < 0) {
            throw new ProgramError("Error : cannot take sqrt of < 0");
        }
        return new Number(Math.sqrt(a));
    }
}
