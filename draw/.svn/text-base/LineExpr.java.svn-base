package draw;
import java.util.List;


/** A LineExpr is a line expression that has a list of
    operands given to its constructor.
    * @author Ken Szubzda
    */

public class LineExpr extends Combination {
    /** LineExpr constructor.
        @param operands line coordinates.
    */
    public LineExpr(List<Expr> operands) {
        super(operands);
    }
    /** Create method.
        @param operands line coordinates.
        @return a LineExpr.
    */
    public LineExpr create(List<Expr> operands) {
        if (operands.size() != 4) {
            System.err.println("Error : Need to have 4 operands");
            System.exit(1);
            return null;
        } else {
            return new LineExpr(operands);
        }
    }

    /** execute method.
        @param machine Interpreter with all values.
        @return a Line.
    */
    public Line execute(Interpreter machine) {
        double x0 = _operands.get(0).execute(machine).doubleValue();
        double y0 = _operands.get(1).execute(machine).doubleValue();
        double x1 = _operands.get(2).execute(machine).doubleValue();
        double y1 = _operands.get(3).execute(machine).doubleValue();
        return new Line(x0, y0, x1, y1);
    }
}
