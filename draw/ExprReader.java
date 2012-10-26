package draw;

import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.io.IOException;

/** An ExprReader reads expressions from a source given to its constructor,
 *  returning (unexecuted) Exprs as requested.
 *  @author Ken Szubzda cs61b-ek
 */
class ExprReader {

    /** A new ExprReader that reads from INP. */
    ExprReader(Reader inp) {
        _tokens = new StreamTokenizer(inp);
        this.configTokenizer();
    }

    /** Configuration for Tokenizer. */
    private void configTokenizer() {
        _tokens.parseNumbers();
        _tokens.slashStarComments(true);
        _tokens.slashSlashComments(true);
        _tokens.wordChars('A', 'z');
        _tokens.wordChars('!', '!');
        _tokens.wordChars('_', '_');
        _tokens.wordChars('*', '*');
        _tokens.wordChars('/', '/');
        _tokens.ordinaryChar('-');
        _tokens.wordChars('-', '-');
        _tokens.wordChars('+', '+');
        _tokens.wordChars('=', '=');
        _tokens.wordChars(':', ':');
        _tokens.commentChar(';');
    }


    /** Reads and returns the next command from my input source,
     *  without executing it.  Returns null at end of file.
     */
    Expr read() {
        try {
            String op = "Not Initialized";
            Expr expression;
            ArrayList<Expr> operands = new ArrayList<Expr>();
            int tok = _tokens.nextToken();
            if (_tokens.ttype == _tokens.TT_EOF) {
                return null;
            }
            if (_tokens.ttype == _tokens.TT_NUMBER) {
                return new Numeral(_tokens.nval);
            } else if (_tokens.ttype == _tokens.TT_WORD) {
                try {
                    return new Numeral(_tokens.sval);
                } catch (NumberFormatException e) {
                    if ((Character.isDigit(_tokens.sval.charAt(0)))
                        || (_tokens.sval.charAt(0) == '.')
                        || (_tokens.sval.charAt(0) == '-')
                        || (_tokens.sval.charAt(0) == '+')) {
                        throw new ProgramError("Error : Invalid symbol format");
                    } else {
                        return new Symbol(_tokens.sval);
                    }
                }
            } else if (tok == '(') {
                _tokens.nextToken();
                op = _tokens.sval;
            }
            while (true) {
                if (_tokens.nextToken() == ')') {
                    break;
                } else if (_tokens.ttype == _tokens.TT_EOF) {
                    throw new ProgramError("Error : is not a S expression,"
                                       + " unclosed parens");
                } else {
                    _tokens.pushBack();
                    operands.add(this.read());
                }
            }
            return Combination.create(op, operands);
        } catch (IOException e) {
            throw new ProgramError("Error : is not a S expression");
        }
    }

    /** My input source.  We use a StreamTokenizer because it is
     *  "tuned" to the constituents of an S-expression. */
    private final StreamTokenizer _tokens;

}
