package Varazslatok;
import miez.Csatater;
import miez.Hos;

/**
 * @version 1
 * @author Zsebedics Mark
 * A varazslat egy olyan objektum aminek hatasara a hosok befolyasolhatjak a csata kimenetelet(extra sebzesek, stat bonusok)
 */
public abstract class Varazslat {
    private int ar;
    private int manna;
    private String nev;



    public Varazslat(int ar, int manna,String nev) {
        this.ar = ar;
        this.manna = manna;
        this.nev = nev;

    }


    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public int getManna() {
        return manna;
    }

    public void setManna(int manna) {
        this.manna = manna;
    }

    public abstract boolean effekt(Hos hos, Csatater csatater);

    @Override
    public String toString() {
        return this.nev;
    }
}


