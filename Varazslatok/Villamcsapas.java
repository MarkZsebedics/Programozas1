package Varazslatok;
import miez.Hos;
import miez.Csatater;
import Egysegek.Egyseg;

import java.util.Scanner;

/**
 * A villamcsapas egy akarhol elhelyezkedo ellenfelet sebez meg
 * @version 1
 * @author Zsebedics Mark
 */
public class Villamcsapas extends Varazslat{
    public Villamcsapas() {
        super(60, 5,"Villamcsapas");
    }

    @Override
    public boolean effekt(Hos hos,Csatater csatater) {
        int elok = 0;
        Scanner nehezsegScan = new Scanner(System.in);
        System.out.println("melyik pozicioban levo ellenfelet akarod megtamadni? (x,y)");
        String pos = nehezsegScan.nextLine();
        String[] trimmEltEgysegPosition = pos.strip().split(",");
        try {
            Integer.parseInt(trimmEltEgysegPosition[0]);
            Integer.parseInt(trimmEltEgysegPosition[1]);
        } catch(NumberFormatException  | ArrayIndexOutOfBoundsException e){
            System.err.println("Nem jo koordinata formatumot adtal meg (x,y), pelda jo formatumra: 3,1 ");return false;}
        int iksz = Integer.parseInt(trimmEltEgysegPosition[0]);
        int ipszilon = Integer.parseInt(trimmEltEgysegPosition[1]);
        if(csatater.mezok[iksz][ipszilon]!=null&&!hos.getSereg().contains(csatater.mezok[iksz][ipszilon])){
            elok =  (csatater.mezok[iksz][ipszilon].getEletero()* csatater.mezok[iksz][ipszilon].getLetszam()
                          -hos.getVarazsero()*30)/csatater.mezok[iksz][ipszilon].getEletero();
            System.out.println(csatater.mezok[iksz][ipszilon].getLetszam()-elok+" egyseg halt a villamod altal");
            csatater.mezok[iksz][ipszilon].setLetszam(
                    elok
            );
        }

        hos.setTudlepni(false);
        return true;



    }
}
