package draw;
import java.util.List;


/** A DivideExpr is a division expression that
    has a list of operands given to its constructor.
 * @author Ken Szuzbda
 */

public class DivideExpr extends Combination {
    /** constructor takes in OPERANDS. */
    public DivideExpr(List<Expr> operands) {
        super(operands);
    }
    /** create OPERANDS ops return null. */
    public DivideExpr create(List<Expr> operands) {
        if (operands.size() != 2) {
            throw new ProgramError("Error : Need to have 2 operands");
        } else {
            return new DivideExpr(operands);
        }
    }
    /** execute MACHINE interpreter return Number. */
    public Value execute(Interpreter machine) {
        double a = _operands.get(0).execute(machine).doubleValue();
        double b = _operands.get(1).execute(machine).doubleValue();
        if (b == 0) {
            throw new ProgramError("Error : cannot divide by zero.");
        }
        return new Number(a / b);
    }
}
