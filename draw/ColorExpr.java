package draw;

import java.util.List;


/** A ColorExpr is a color expression that has a list of
    operands given to its constructor.
 * @author Ken Szubzda
 */

public class ColorExpr extends Combination {
    /** constructor for colors.
     * @param operands ops */
    public ColorExpr(List<Expr> operands) {
        super(operands);
    }
    /** create takes in OPERANDS, return ColorExpr. */
    public ColorExpr create(List<Expr> operands) {
        if (operands.size() != 3) {
            throw new ProgramError("Error : Need to have 3 operands");
        } else {
            return new ColorExpr(operands);
        }
    }
    /** execute takes in a MACHINE Interpreter, returns null. */
    public Picture execute(Interpreter machine) {
        double red =  _operands.get(0).execute(machine).doubleValue();
        double green = _operands.get(1).execute(machine).doubleValue();
        double blue = _operands.get(2).execute(machine).doubleValue();
        if ((red < 0) || (green < 0) || (blue < 0)
            || (red > 1) || (green > 1) || (blue > 1)) {
            throw new ProgramError("Error : All color values must"
                               + " be between 0 and 1 inclusive");
        }
        Picture.setred(red);
        Picture.setgreen(green);
        Picture.setblue(blue);
        return null;
    }
}



