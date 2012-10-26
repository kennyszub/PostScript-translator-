package draw;
import java.util.List;


/** A FilledCircleExpr is a filled circle expression
    that has a list of operands given to its constructor.
 * @author Ken Szubzda cs61b-ek
 */

public class FilledCircleExpr extends Combination {
    /** constructor with OPERANDS. */
    public FilledCircleExpr(List<Expr> operands) {
        super(operands);
    }
    /** create method with OPERANDS and return new FilledCircExpr. */
    public FilledCircleExpr create(List<Expr> operands) {
        if (operands.size() != 3) {
            throw new ProgramError("Error : Need to have 3 operands");
        } else {
            return new FilledCircleExpr(operands);
        }
    }
    /** execute method that takes in a MACHINE and returns Filledcircle. */
    public FilledCircle execute(Interpreter machine) {
        double xCoor =  _operands.get(0).execute(machine).doubleValue();
        double yCoor = _operands.get(1).execute(machine).doubleValue();
        double radius = _operands.get(2).execute(machine).doubleValue();
        return new FilledCircle(xCoor, yCoor, radius);
    }
}

