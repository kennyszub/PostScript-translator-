package draw;

import java.util.List;
import java.io.PrintWriter;

/** A DrawExpr is a draw expression that has a list
    of 1 operand given to its constructor.
 * @author Ken Szubzda
 */

public class DrawExpr extends Combination {
    /** constructer with OPERANDS. */
    public DrawExpr(List<Expr> operands) {
        super(operands);
    }
    /** create method with OPERANDS return DrawExpr. */
    public DrawExpr create(List<Expr> operands) {
        if (operands.size() != 1) {
            throw new ProgramError("Error : Need to have 1 operand");
        } else {
            return new DrawExpr(operands);
        }
    }
    /** execute MACHINE and return null. */
    public Picture execute(Interpreter machine) {
        Picture shape = _operands.get(0).execute(machine).pictureValue();
        PrintWriter psOut = machine.getpsOut();
        shape.draw(psOut);
        return null;
    }
}

