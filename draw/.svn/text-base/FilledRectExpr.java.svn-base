package draw;
import java.util.List;
import java.util.ArrayList;


/** A FilledRectExpr is a filled rectangle expression that has a list
    of operands given to its constructor.
 * @author Ken Szubzda
 */

public class FilledRectExpr extends Combination {
    /** Constructor with OPERANDS. */
    public FilledRectExpr(List<Expr> operands) {
        super(operands);
    }
    /** Create method with OPERANDS, return null. */
    public FilledRectExpr create(List<Expr> operands) {
        if (operands.size() != 4) {
            throw new ProgramError("Error : Need to have 4 operands");
        } else {
            return new FilledRectExpr(operands);
        }
    }
    /** execute MACHINE which is a interpreter, return filledrectangle. */
    public FilledRectangle execute(Interpreter machine) {
        List<Double> coordinates = new ArrayList<Double>();
        double xCoor =  _operands.get(0).execute(machine).doubleValue();
        double yCoor = _operands.get(1).execute(machine).doubleValue();
        double width = _operands.get(2).execute(machine).doubleValue();
        double height = _operands.get(3).execute(machine).doubleValue();
        double x0 = xCoor;
        double y0 = yCoor;
        double x1 = x0 + width;
        double y1 = y0;
        double x2 = x0 + width;
        double y2 = y0 + height;
        double x3 = x0;
        double y3 = y0 + height;
        coordinates.add(x0);
        coordinates.add(y0);
        coordinates.add(x1);
        coordinates.add(y1);
        coordinates.add(x2);
        coordinates.add(y2);
        coordinates.add(x3);
        coordinates.add(y3);
        return new FilledRectangle(coordinates);
    }
}
