package draw;
import java.util.List;


/** A CosExpr is a cos expression that has a list
    of 1 operand given to its constructor.
 * @author Ken Szuzbda
 */

public class CosExpr extends Combination {
    /** constructer with OPERANDS. */
    public CosExpr(List<Expr> operands) {
        super(operands);
    }
    /** Create with OPERANDS return null. */
    public CosExpr create(List<Expr> operands) {
        if (operands.size() != 1) {
            throw new ProgramError("Error : Need to have 1 operand");
        } else {
            return new CosExpr(operands);
        }
    }
    /** execute with MACHINE and return a number. */
    public Value execute(Interpreter machine) {
        double degrees = _operands.get(0).execute(machine).doubleValue();
        degrees = Math.toRadians(degrees);
        return new Number(Math.cos(degrees));
    }
}
