package draw;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

/** The main class of the CS61B drawing system.
 *  @author Ken Szubzda
 */
public final class Main {

    /** Entry to the 'draw' program.  ARGS are the command-line
     *  arguments.  Exits with status code 0 if there are no errors in
     *  the input or ARGS; otherwise with code 1. */
    public static void main(String[] args) {
        Reader input;
        PrintWriter output;
        boolean waitToClose;
        waitToClose = false;
        try {
            switch (args.length) {
            case 0:
                usage();
                return;
            case 1: case 2:
                if (args[0].equals("-")) {
                    input = new InputStreamReader(System.in);
                } else {
                    waitToClose = true;
                    input = new FileReader(args[0]);
                }
                break;
            default:
                usage();
                System.exit(1);
                return;
            }

            switch (args.length) {
            case 1:
                output = new PrintWriter(new Display());
                break;
            case 2:
                waitToClose = false;
                if (args[1].equals("-")) {
                    output = new PrintWriter(System.out);
                } else {
                    output = new PrintWriter(args[1]);
                }
                break;
            default:
                throw new Error("internal error: impossible case");
            }

            translate(input, output);
            if (waitToClose) {
                System.err.printf("Type <RETURN> or <ENTER> to quit.%n");
                try {
                    System.in.read();
                } catch (IOException e) {
                    /* Ignore IOException. */
                }
            }
            output.close();
        } catch (IOException e) {
            System.err.printf("error: %s%n", e.getMessage());
            System.exit(1);
        }
    }

    /** Read the input program from INPUT and write a Postscript translation
     *  to OUTPUT. */
    static void translate(Reader input, PrintWriter output) {
        Interpreter machine = new Interpreter(output);
        ExprReader exprInput = new ExprReader(input);
        machine.readAndExecute(exprInput);
    }
    /** Print usage message on standard error. */
    static void usage() {
        System.err.printf("Usage: java draw.Main  INPUTFILE [ OUTPUTFILE ]%n"
                           + "  Either file may be '-', "
                           + "denoting standard input/output.%n");
    }
}

