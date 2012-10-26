package draw;

/** The superclass of all types of Expr. An Expr is denoted by
 *  an S-expression, as indicated in the specifications.
 *  @author Ken Szubzda cs61b-ek
 */
abstract class Expr {

    /** Execute me, modifying the state in MACHINE as appropriate and
     *  returning the resulting Value. */
    abstract Value execute(Interpreter machine);
}

