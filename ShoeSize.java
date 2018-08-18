
/* ShoeSize - Eric McCreath 2015 - GPL
 * This class stores a persons shoe size.
 */


import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.*;

public class ShoeSize {
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
        // JSON
        File f = new File(FILENAME);
        ShoeSize res = new ShoeSize();
        try {
            JSONObject obj = (JSONObject) JSONValue.parse(new FileReader(f));
            res.shoesize = ((Long) obj.get(SHOESIZEENAME)).intValue();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res;
    }

    void save() {
        // add code here that will save shoe size into a file called "FILENAME"
        // JSON

        File f = new File(FILENAME);
        JSONObject obj = new JSONObject();
        obj.put(SHOESIZEENAME, shoesize);
        FileWriter out;
        try {
            out = new FileWriter(f);
            obj.writeJSONString(out);
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
