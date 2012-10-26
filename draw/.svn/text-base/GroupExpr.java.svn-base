package draw;

import java.util.List;
import java.util.ArrayList;

/** A GroupExpr is a group expression that has a list of x
    operands given to its constructor.
 * @author Ken Szubzda
 */

public class GroupExpr extends Combination {
    /** constructor OPERANDS ops. */
    public GroupExpr(List<Expr> operands) {
        super(operands);
    }

    /** create OPERANDS ops return groupExpr. */
    public GroupExpr create(List<Expr> operands) {
        if (operands.size() < 0) {
            throw new ProgramError("Error : Need to have 0 operands");
        } else {
            return new GroupExpr(operands);
        }
    }
    /** execute MACHINE interpreter return group. */
    public Picture execute(Interpreter machine) {
        List<Picture> picList = new ArrayList<Picture>();
        for (int i = 0; (i < _operands.size()); i += 1) {
            Picture pic = _operands.get(i).execute(machine).pictureValue();
            picList.add(pic);
        }
        return new Group(picList);
    }
}
