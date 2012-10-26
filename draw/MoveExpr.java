package draw;

import java.util.List;

/** A MoveExpr is a move expression that has a
list of 3 operands given to its constructor.
 * @author Ken Szubzda
 */

public class MoveExpr extends Combination {
    /** constructor.
     * @param operands ops
     */
    public MoveExpr(List<Expr> operands) {
        super(operands);
    }
    /** create method.
     * @param operands ops
     * @return MoveExpr
     */
    public MoveExpr create(List<Expr> operands) {
        if (operands.size() != 3) {
            throw new ProgramError("Error : Need to have 3 operands");
        } else {
            return new MoveExpr(operands);
        }
    }
    /** execute method.
     * @param machine interpreter
     * @return translated shape.
     */
    public Picture execute(Interpreter machine) {
        Picture shape = _operands.get(0).execute(machine).pictureValue();
        double xShift = _operands.get(1).execute(machine).doubleValue();
        double yShift = _operands.get(2).execute(machine).doubleValue();
        return shape.translate(xShift, yShift);
    }
}
