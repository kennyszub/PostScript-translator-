package draw;

import java.util.HashMap;
import java.io.PrintWriter;

/** An Interpreter maintains all necessary information about the running
 *  program, such as the values of variables and the destination of output.
 * @author Ken Szubzda cs61b-ek
 */
class Interpreter {

    /** An Interpreter that prints its Postscript output on
     *  PSOUT. */
    Interpreter(PrintWriter psOut) {
        _psOut = psOut;
        OPERATIONSTABLE.put("+", new AddExpr(null));
        OPERATIONSTABLE.put("*", new MultiplyExpr(null));
        OPERATIONSTABLE.put("/", new DivideExpr(null));
        OPERATIONSTABLE.put("-", new SubtractExpr(null));
        OPERATIONSTABLE.put("sqrt", new SqrtExpr(null));
        OPERATIONSTABLE.put("sin", new SinExpr(null));
        OPERATIONSTABLE.put("cos", new CosExpr(null));
        OPERATIONSTABLE.put(":=", new AssignmentExpr(null));
        OPERATIONSTABLE.put("rect", new RectangleExpr(null));
        OPERATIONSTABLE.put("draw", new DrawExpr(null));
        OPERATIONSTABLE.put("move", new MoveExpr(null));
        OPERATIONSTABLE.put("rotate", new RotateExpr(null));
        OPERATIONSTABLE.put("scale", new ScaleExpr(null));
        OPERATIONSTABLE.put("group", new GroupExpr(null));
        OPERATIONSTABLE.put("color", new ColorExpr(null));
        OPERATIONSTABLE.put("linewidth", new LineWidthExpr(null));
        OPERATIONSTABLE.put("filledrect", new FilledRectExpr(null));
        OPERATIONSTABLE.put("circ", new CircleExpr(null));
        OPERATIONSTABLE.put("filledcirc", new FilledCircleExpr(null));
        OPERATIONSTABLE.put("for", new ForExpr(null));
        OPERATIONSTABLE.put("line", new LineExpr(null));
    }

    /** Read a drawing program from RDR and execute it. */
    void readAndExecute(ExprReader rdr) {
        try {
            _psOut.println("%!PS-Adobe-2.0");
            Expr expression = rdr.read();
            while (expression != null) {
                expression.execute(this);
                expression = rdr.read();
            }
            _psOut.println("showpage");
        } catch (ProgramError e) {
            System.err.println(e.getmsg());
            System.exit(1);
        }
    }

    /** puts in A B assignments table. */
    static void putInAssignmentsTable(String a, Value b) {
        assignmentsTable.put(a, b);
    }
    /** returns value of A assignmentstable. */
    static Value getInAssignmentsTable(String a) {
        return assignmentsTable.get(a);
    }
    /** returns psout. */
    PrintWriter getpsOut() {
        return _psOut;
    }
    /** Printwriter. */
    private PrintWriter _psOut;

    /** Hashmap of operations. */
    public static final HashMap<String, Combination> OPERATIONSTABLE
        = new HashMap<String, Combination>();
    /** Hashmap of assignments. */
    private static HashMap<String, Value> assignmentsTable
        = new HashMap<String, Value>();
}
