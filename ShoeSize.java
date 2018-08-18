
/* ShoeSize - Eric McCreath 2015 - GPL
 * This class stores a persons shoe size.
 */

import java.io.*;

public class ShoeSize implements Serializable {
    private static final String SHOESIZEENAME = "SHOESIZE";
    public static final int SHOESIZEMAX = 15;
    public static final int SHOESIZEMIN = 3;

    static final String FILENAME = "shoesize.xml";

    private Integer shoesize;

    public ShoeSize() {
        shoesize = null;
    }

    public ShoeSize(Integer shoesize) {
        this.shoesize = shoesize;
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
        //Serialize
        ShoeSize res = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                    FILENAME));
            res = (ShoeSize) ois.readObject();
            ois.close();
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    void save() {
        // add code here that will save shoe size into a file called "FILENAME"
        //Serialize
        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(FILENAME));
            oos.writeObject(this);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}