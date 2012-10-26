package draw;

import java.util.List;

/** A RotateExpr is a rotate expression that has a list
 of 2 operands given to its constructor.
 * @author Ken Szubzda
 */

public class RotateExpr extends Combination {
    /** Constructor.
        @param operands ops.
    */
    public RotateExpr(List<Expr> operands) {
        super(operands);
    }
    /** Create method.
        @param operands ops.
        @return RotateExpr
    */
    public RotateExpr create(List<Expr> operands) {
        if (operands.size() != 2) {
            throw new ProgramError("Error : Need to have 2 operands");
        } else {
            return new RotateExpr(operands);
        }
    }
    /** execute method.
        @param machine interpreter.
        @return shape
    */
    public Picture execute(Interpreter machine) {
        Picture shape = _operands.get(0).execute(machine).pictureValue();
        double degrees = _operands.get(1).execute(machine).doubleValue();
        return shape.rotate(degrees);
    }
}
