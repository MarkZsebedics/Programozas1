package Egysegek;

import Egysegek.Egyseg;

/**
 * a foldmuves egy egyseg ami semmi kulonleges kepesseggel nem rendelkezik
 * @version 1.1
 * @author Zsebedics Mark
 */
public class Foldmuves extends Egyseg {
    public Foldmuves() {
        super("Foldmuves",2,  new int[]{1, 1}, 3, 4, 8);
    }

    public static String reklam(){
        return "Foldmuves, 2 aranyba kerul, 3 az elete, 4 a sebessege, 8 a kezdemenyezese, 1-1 a sebzese";
    }

}
