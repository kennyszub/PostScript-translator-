package draw;

import java.util.List;
import java.io.PrintWriter;
import java.util.ArrayList;

/** A Group of pictures in the interpreter.
 * @author Ken Szubzda
 */

class Group extends Picture {
    /** list of PICS. */
    Group(List<Picture> pics) {
        _pics = pics;
    }
    /** draw method takes in OUT. */
    void draw(PrintWriter out) {
        for (int i = 0; (i < _pics.size()); i += 1) {
            _pics.get(i).draw(out);
        }
    }
    /** translate method XSHIFT x and YSHIFT y return group. */
    Picture translate(double xShift, double yShift) {
        List<Picture> tPics = new ArrayList<Picture>();
        for (int i = 0; (i < _pics.size()); i += 1) {
            tPics.add(_pics.get(i).translate(xShift, yShift));
        }
        return new Group(tPics);
    }
    /** scale method FACTOR times return GROUP. */
    Picture scale(double factor) {
        List<Picture> fPics = new ArrayList<Picture>();
        for (int i = 0; (i < _pics.size()); i += 1) {
            fPics.add(_pics.get(i).scale(factor));
        }
        return new Group(fPics);
    }
    /** rotate DEGREES and return new Group. */
    Picture rotate(double degrees) {
        List<Picture> dPics = new ArrayList<Picture>();
        for (int i = 0; (i < _pics.size()); i += 1) {
            dPics.add(_pics.get(i).rotate(degrees));
        }
        return new Group(dPics);
    }

    /** The pictures. */
    private List<Picture> _pics;
}

