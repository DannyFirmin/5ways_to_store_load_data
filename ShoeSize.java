
/* ShoeSize - Eric McCreath 2015 - GPL
 * This class stores a persons shoe size.
 */

import java.util.prefs.Preferences;

public class ShoeSize {
    Preferences prefs;
    private static final String SHOESIZEENAME = "SHOESIZE";
    public static final int SHOESIZEMAX = 15;
    public static final int SHOESIZEMIN = 3;
    private static final int DEFAULTSIZE = 10;
    
    static final String FILENAME = "shoesize.xml";

    private Integer shoesize;

    public ShoeSize() {
        shoesize = null;
        prefs = Preferences.userNodeForPackage(ShoeSize.class);

    }

    public ShoeSize(Integer shoesize) {
        this.shoesize = shoesize;
        prefs = Preferences.userNodeForPackage(ShoeSize.class);

    }

    public String show() {
        return (shoesize == null ? "" : shoesize.toString());
    }

    public boolean set(Integer v) {
        if (v == null || v >= ShoeSize.SHOESIZEMIN && v <= ShoeSize.SHOESIZEMAX) {
            shoesize = v;
            save();
            return true;
        } else {
            shoesize = null;
            return false;
        }
    }

    static ShoeSize load() {
        // add code here that will load shoe size from a file called "FILENAME"
        //Preferences
        Preferences prefs = Preferences.userNodeForPackage(ShoeSize.class);
        return new ShoeSize(prefs.getInt(SHOESIZEENAME, DEFAULTSIZE));
    }

    void save() {
        // add code here that will save shoe size into a file called "FILENAME"
        //Preferences
        ShoeSize data = new ShoeSize();
        if (shoesize != null) {
            data.prefs.putInt(SHOESIZEENAME, shoesize);
        }
    }
}
