package draw;

import java.util.List;


/** An AssignmentExpr is an expression that has a list of 2
    operands given to its constructor.
    * @author Ken Szuzbda
    */

public class AssignmentExpr extends Combination {
    /** AssignmentExpr constructor.
     * @param operands doubles to add.*/
    public AssignmentExpr(List<Expr> operands) {
        super(operands);
    }
    /** Create method.
     * @param operands doubles to assign
     * @return returns an AssignmentExpr*/
    public AssignmentExpr create(List<Expr> operands) {
        if (operands.size() != 2) {
            throw new ProgramError("Error : Need to have 2 operands");
        } else {
            return new AssignmentExpr(operands);
        }
    }
    /** Execute method.
     * @param machine the interpreter.
     * @return returns a returns a Value. */
    public Value execute(Interpreter machine) {
        try {
            Symbol x = (Symbol) _operands.get(0);
            String a = x.getKey();
            Value b = _operands.get(1).execute(machine);
            Interpreter.putInAssignmentsTable(a, b);
            return b;
        } catch (ClassCastException e) {
            throw new ProgramError("Error : invalid class cast");
        }
    }
}

