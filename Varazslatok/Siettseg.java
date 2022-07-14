package Varazslatok;

import miez.Csatater;
import miez.Hos;

/**
 * A Siettseg az egesz hadseregunk sebbesseget feljebb viszi 2-vel
 * @version 1
 * @author Zsebedics Mark
 */

public class Siettseg extends Varazslat {
    public Siettseg() {
        super(70, 11, "Siettseg");
    }


    @Override
    public boolean effekt(Hos hos,Csatater csatater) {
        for (int i = 0; i < hos.getSereg().size(); i++) {
            hos.getSereg().get(i).setSebesseg(hos.getSereg().get(i).getSebesseg()+ 2);
        }
        return true;
    }

}

