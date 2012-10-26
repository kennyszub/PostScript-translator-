package draw;
import java.util.List;


/** A CircleExpr is a circle expression that has a list of
    operands given to its constructor.
    * @author Ken Szubzda
    */

public class CircleExpr extends Combination {
    /** CircleExpr constructor.
     * @param operands doubles to construct.*/
    public CircleExpr(List<Expr> operands) {
        super(operands);
    }
    /** Create method.
     * @param operands of circle.
     * @return returns an CircleExpr*/
    public CircleExpr create(List<Expr> operands) {
        if (operands.size() != 3) {
            throw new ProgramError("Error : Need to have 3 operands");
        } else {
            return new CircleExpr(operands);
        }
    }
    /** Execute method.
     * @param machine the interpreter.
     * @return returns a Circle. */
    public Circle execute(Interpreter machine) {
        double xCoor =  _operands.get(0).execute(machine).doubleValue();
        double yCoor = _operands.get(1).execute(machine).doubleValue();
        double radius = _operands.get(2).execute(machine).doubleValue();
        return new Circle(xCoor, yCoor, radius);
    }
}

