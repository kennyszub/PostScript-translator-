package draw;
import java.util.List;


/** A SinExpr is a sin expression that has a list of 1 operand
    given to its constructor.
 * @author Ken Szuzbda
 */
public class SinExpr extends Combination {
    /** Constructor.
     * @param operands ops
     */
    public SinExpr(List<Expr> operands) {
        super(operands);
    }
    /** create method, takes in a list of.
     * @param operands ops
     * @return SinExpr with operands
     */
    public SinExpr create(List<Expr> operands) {
        if (operands.size() != 1) {
            throw new ProgramError("Error : Need to have 1 operand");
        } else {
            return new SinExpr(operands);
        }
    }
    /** execute method.
     * @param machine take in Interpreter.
     * @return returns a new Number.
     */
    public Value execute(Interpreter machine) {
        double degrees = _operands.get(0).execute(machine).doubleValue();
        degrees = Math.toRadians(degrees);
        return new Number(Math.sin(degrees));
    }
}

