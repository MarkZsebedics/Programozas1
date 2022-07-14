package Varazslatok;
import miez.Csatater;
import miez.Hos;
public class Feltamasztas extends Varazslat{
    public Feltamasztas() {
        super(120, 6,"Feltamasztas");
    }
    @Override
    public boolean effekt(Hos hos, Csatater csatater) {
        return true;

    }
}
