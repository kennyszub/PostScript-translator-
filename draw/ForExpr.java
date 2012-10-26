package draw;

import java.util.List;
import java.util.ArrayList;

/** A ForExpr is a for  expression that has a list of x operands
    given to its constructor.
 * @author Ken Szubzda
 */

public class ForExpr extends Combination {
    /** constructor OPERANDS ops. */
    public ForExpr(List<Expr> operands) {
        super(operands);
    }
    /** create OPERANDS ops returns FOREXPR. */
    public ForExpr create(List<Expr> operands) {
        if (operands.size() < 3) {
            throw new ProgramError("Error : Need to have at least 3 operands");
        } else {
            return new ForExpr(operands);
        }
    }
    /** execute method takes in MACHINE returns null. */
    public Value execute(Interpreter machine) {
        try {
            Symbol I = (Symbol) _operands.get(0);
            double L = _operands.get(1).execute(machine).doubleValue();
            try {
                int Y = (int) L;
                if (Y != L) {
                    throw new ProgramError("Error : L must be an integer");
                }
            } catch (ClassCastException e) {
                throw new ProgramError("Error : Illegal Class cast");
            }
            double U = _operands.get(2).execute(machine).doubleValue();
            List<Expr> exprList = new ArrayList<Expr>();
            for (int i = 3; (i < _operands.size()); i += 1) {
                exprList.add(_operands.get(i));
            }
            for (double x = L; x <= U; x += 1) {
                List<Expr> assignmentList = new ArrayList<Expr>();
                assignmentList.add(I);
                assignmentList.add(new Numeral(x));
                new AssignmentExpr(assignmentList).execute(machine);
                for (int t = 0; t < exprList.size(); t += 1) {
                    exprList.get(t).execute(machine);
                }
            }
            return null;
        } catch (ClassCastException e) {
            throw new ProgramError("Error : Illegal Class cast");
        }
    }
}
