package Varazslatok;

import miez.Csatater;
import miez.Hos;

/**
 * A banat varazslat az egesz ellenfel moraljra(kezdemenyezes kepesseg) hat, es mindet lejjebb viszi 3-al
 *  @version 1
 *  @author Zsebedics Mark
 */

public class Banat extends Varazslat{
    public Banat() {
        super(90, 9,"Banat");
    }


    public void Baneffekt(Hos hos,Hos enemy ,Csatater csatater) {
        for (int i = 0; i < enemy.getSereg().size(); i++) {
            enemy.getSereg().get(i).setKezdemenyezes(enemy.getSereg().get(i).getKezdemenyezes()-3);
        }
    }

    @Override
    public boolean effekt(Hos hos, Csatater csatater) {
        return false;
    }
}
