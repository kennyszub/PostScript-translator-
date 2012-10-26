package draw;

import org.junit.Test;
import static org.junit.Assert.*;
import ucb.junit.textui;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import org.junit.Before;
import java.util.ArrayList;

/** Unit tests for draw package */
public class Testing {
    /** Run the JUnit tests in the draw package. */
    public static void main(String[] ignored) {
        textui.runClasses(draw.Testing.class);
    }
    /** Input reader. */
    private Reader input;
    /** output writer. */
    private PrintWriter output;
    /** Machine. */
    private Interpreter machine;
    /** expr reader. */
    private ExprReader exprInput;
    /** doubles. */
    private double c, d;
    /** Numerals. */
    private Numeral a, b;

    @Before
    public void init() {
        input = new InputStreamReader(System.in);
        output = new PrintWriter(System.out);
        machine = new Interpreter(output);
        exprInput = new ExprReader(input);
        c = Math.random() * 100;
        d = Math.random() * 100;
        a = new Numeral(c);
        b = new Numeral(d);

    }

    @Test
    public void addTest() {
        ArrayList<Expr> lst = new ArrayList<Expr>();
        lst.add(a);
        lst.add(b);
        AddExpr aexp = new AddExpr(lst);
        assertEquals(aexp.execute(machine).doubleValue(), c + d, 0.0);
    }
    @Test (expected = ProgramError.class)
    public void faddTest() {
        ArrayList<Expr> lst = new ArrayList<Expr>();
        lst.add(a);
        lst.add(b);
        lst.add(b);
        AddExpr aexp = (AddExpr) Combination.create("+", lst);
        aexp.execute(machine);
    }

    @Test
    public void subTest() {
        ArrayList<Expr> lst = new ArrayList<Expr>();
        lst.add(b);
        lst.add(a);
        SubtractExpr sexp = new SubtractExpr(lst);
        assertEquals(sexp.execute(machine).doubleValue(), d - c, 0.0);
    }

    @Test (expected = ProgramError.class)
    public void fsubTest() {
        ArrayList<Expr> lst = new ArrayList<Expr>();
        lst.add(a);
        lst.add(b);
        lst.add(b);
        SubtractExpr sexp = (SubtractExpr) Combination.create("-", lst);
        sexp.execute(machine);
    }

    @Test
    public void divideTest() {
        ArrayList<Expr> lst = new ArrayList<Expr>();
        lst.add(a);
        lst.add(b);
        DivideExpr dexp = new DivideExpr(lst);
        assertEquals(dexp.execute(machine).doubleValue(), c / d, 0.0);
    }
    @Test (expected = ProgramError.class)
    public void fdivideTest() {
        ArrayList<Expr> lst = new ArrayList<Expr>();
        lst.add(a);
        lst.add(b);
        lst.add(b);
        DivideExpr dexp = (DivideExpr) Combination.create("/", lst);
        dexp.execute(machine);
    }

    @Test
    public void sqrtTest() {
        ArrayList<Expr> lst = new ArrayList<Expr>();
        lst.add(a);
        SqrtExpr sqrtexp = new SqrtExpr(lst);
        assertEquals(sqrtexp.execute(machine).doubleValue(), Math.sqrt(c), 0.0);
    }
    @Test (expected = ProgramError.class)
    public void fsqrtTest() {
        ArrayList<Expr> lst = new ArrayList<Expr>();
        lst.add(a);
        lst.add(b);
        lst.add(b);
        SqrtExpr sexp = (SqrtExpr) Combination.create("sqrt", lst);
        sexp.execute(machine);
    }

    @Test
    public void sinTest() {
        ArrayList<Expr> lst = new ArrayList<Expr>();
        lst.add(a);
        SinExpr sinexp = new SinExpr(lst);
        assertEquals(sinexp.execute(machine).doubleValue(),
                     Math.sin(Math.toRadians(c)), 0.0);
    }
    @Test (expected = ProgramError.class)
    public void fsinTest() {
        ArrayList<Expr> lst = new ArrayList<Expr>();
        lst.add(a);
        lst.add(b);
        lst.add(b);
        SinExpr sinp = (SinExpr) Combination.create("sin", lst);
        sinp.execute(machine);
    }
    @Test
    public void cosTest() {
        ArrayList<Expr> lst = new ArrayList<Expr>();
        lst.add(a);
        CosExpr cosexp = new CosExpr(lst);
        assertEquals(cosexp.execute(machine).doubleValue(),
                     Math.cos(Math.toRadians(c)), 0.0);
    }
    @Test (expected = ProgramError.class)
    public void fcosTest() {
        ArrayList<Expr> lst = new ArrayList<Expr>();
        lst.add(a);
        lst.add(b);
        lst.add(b);
        CosExpr cosp = (CosExpr) Combination.create("cos", lst);
        cosp.execute(machine);
    }
    @Test
    public void multiplyTest() {
        ArrayList<Expr> lst = new ArrayList<Expr>();
        lst.add(a);
        lst.add(b);
        MultiplyExpr mexp = new MultiplyExpr(lst);
        assertEquals(mexp.execute(machine).doubleValue(), c * d, 0.0);
    }
    @Test (expected = ProgramError.class)
    public void fmultiplyTest() {
        ArrayList<Expr> lst = new ArrayList<Expr>();
        lst.add(a);
        lst.add(b);
        lst.add(b);
        MultiplyExpr multiplyp = (MultiplyExpr) Combination.create("*", lst);
        multiplyp.execute(machine);
    }
    @Test
    public void assignmentTest() {
        ArrayList<Expr> lst = new ArrayList<Expr>();
        lst.add(new Symbol("ken"));
        lst.add(a);
        AssignmentExpr axp = new AssignmentExpr(lst);
        assertEquals(axp.execute(machine).doubleValue(), c, 0.0);
    }
    @Test (expected = ProgramError.class)
    public void fassignmentTest() {
        ArrayList<Expr> lst = new ArrayList<Expr>();
        lst.add(a);
        lst.add(b);
        lst.add(b);
        AssignmentExpr assignp = (AssignmentExpr) Combination.create(":=", lst);
        assignp.execute(machine);
    }
}
