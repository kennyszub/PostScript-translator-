package draw;

import java.util.List;

/** A ScaleExpr is a scale expression that has a list
    of 2 operands given to its constructor.
 * @author Ken Szubzda
 */

public class ScaleExpr extends Combination {
    /** Constructor.
     * @param operands ops.
     */
    public ScaleExpr(List<Expr> operands) {
        super(operands);
    }
    /** create method.
     * @param operands ops.
     * @return a new ScaleExpr
     */
    public ScaleExpr create(List<Expr> operands) {
        if (operands.size() != 2) {
            throw new ProgramError("Error : Need to have 2 operands");
        } else {
            return new ScaleExpr(operands);
        }
    }
    /** Execute method.
     * @param machine interpreter
     * @return a shape
     */
    public Picture execute(Interpreter machine) {
        Picture shape = _operands.get(0).execute(machine).pictureValue();
        double factor = _operands.get(1).execute(machine).doubleValue();
        return shape.scale(factor);
    }
}
