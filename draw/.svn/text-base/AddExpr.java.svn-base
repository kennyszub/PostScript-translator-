package draw;
import java.util.List;

/** An AddExpr is a add expression that has a list of operands
    given to its constructor.
    * @author Ken Szubzda
    */

public class AddExpr extends Combination {
    /** AddExpr constructor.
     * @param operands doubles to add.*/
    public AddExpr(List<Expr> operands) {
        super(operands);
    }
    /** Create method.
     * @param operands doubles to add
     * @return returns an AddExpr*/
    public AddExpr create(List<Expr> operands) {
        if (operands.size() != 2) {
            throw new ProgramError("Error : Need to have 2 operands");
        } else {
            return new AddExpr(operands);
        }
    }
    /** Execute method.
     * @param machine the interpreter.
     * @return returns a Number */
    public Value execute(Interpreter machine) {
        double a =  _operands.get(0).execute(machine).doubleValue();
        double b =  _operands.get(1).execute(machine).doubleValue();
        return new Number(a + b);
    }
}
