
/* ShoeSize - Eric McCreath 2015 - GPL
 * This class stores a persons shoe size.
 */

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

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
        try {
            FileReader f_reader = new FileReader(FILENAME);
            Scanner in = new Scanner(f_reader);
            Integer mySize = in.nextInt();
            in.close();
            return new ShoeSize(mySize);

        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
            return new ShoeSize();
        } catch (NoSuchElementException e){
            System.err.format("NoSuchElementException: %s%n", e);
            return new ShoeSize();
        }
    }

    void save() {
        // add code here that will save shoe size into a file called "FILENAME"
        try {
            FileWriter f_writer = new FileWriter(FILENAME);
            BufferedWriter b_writer = new BufferedWriter(f_writer);
            System.out.println(shoesize);
            String info = shoesize.toString();
            b_writer.write(info);
            b_writer.close();


        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
