package draw;

import java.util.List;


/** A LineWidthExpr is a line width expression
    that has a list of operands given to its constructor.
 * @author Ken Szubzda
 */

public class LineWidthExpr extends Combination {
    /** constructor.
     * @param operands ops
     */
    public LineWidthExpr(List<Expr> operands) {
        super(operands);
    }
    /** create method.
     * @param operands ops
     * @return linewidthexpr
     */
    public LineWidthExpr create(List<Expr> operands) {
        if (operands.size() != 1) {
            throw new ProgramError("Error : Need to have 1 operand");
        } else {
            return new LineWidthExpr(operands);
        }
    }
    /** execute.
     * @param machine interpreter.
     * @return null
     */
    public Picture execute(Interpreter machine) {
        double width =  _operands.get(0).execute(machine).doubleValue();
        if (width < 0) {
            throw new ProgramError("Error : Width cannot be negative");
        }
        Picture.setlinewidth(width);
        return null;
    }
}


