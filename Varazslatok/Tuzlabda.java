package Varazslatok;
import miez.Csatater;
import miez.Hos;

import java.util.Scanner;

/**
 * A tuzlabda egy 3x3-as teruleten okoz sebzest minden egysegnek
 *  @version 1
 *  @author Zsebedics Mark
 */

public class Tuzlabda extends Varazslat{
    public Tuzlabda() {
        super(120, 9,"Tuzlabda");
    }


    @Override
    public boolean effekt(Hos hos, Csatater csatater) {
        int elok = 0;
        Scanner nehezsegScan = new Scanner(System.in);
        System.out.println("Hova dobnad, a tuzlabdad? (x,y)");
        String pos = nehezsegScan.nextLine();
        String[] trimmEltEgysegPosition = pos.strip().split(",");
        try {
            Integer.parseInt(trimmEltEgysegPosition[0]);
            Integer.parseInt(trimmEltEgysegPosition[1]);
        } catch(NumberFormatException  | ArrayIndexOutOfBoundsException e){
            System.err.println("Nem jo koordinata formatumot adtal meg (x,y), pelda jo formatumra: 3,1 ");return false;}
        int iksz = Integer.parseInt(trimmEltEgysegPosition[0]);
        int ipszilon = Integer.parseInt(trimmEltEgysegPosition[1]);

        int[] korTerulet = new int[]{iksz,ipszilon,iksz-1,ipszilon,iksz-1,ipszilon-1,iksz,ipszilon+1,iksz+1,ipszilon+1,iksz+1,ipszilon,iksz
        +1,ipszilon-1,iksz,ipszilon-1,iksz-1,ipszilon-1};

        for (int i = 0; i < korTerulet.length ; i+=2) {
            if(korTerulet[i]>9){
               // System.err.println("maprol csak ne menj mar ki");
                continue; }
            if(korTerulet[i+1]>11){
                //System.err.println("maprol csak ne menj mar ki");
                continue;}
            iksz = korTerulet[i];
            ipszilon = korTerulet[i+1];
            if(csatater.mezok[iksz][ipszilon]!=null){
                elok =  (csatater.mezok[iksz][ipszilon].getEletero()* csatater.mezok[iksz][ipszilon].getLetszam()
                        -hos.getVarazsero()*20)/csatater.mezok[iksz][ipszilon].getEletero();
                System.out.println(csatater.mezok[iksz][ipszilon].getLetszam()-elok+" egyseg valt hamuva, a tuzlabdad nyoman a  "+csatater.mezok[iksz][ipszilon]);
                csatater.mezok[iksz][ipszilon].setLetszam(
                        elok
                );
            }
        }
        hos.setTudlepni(false);
return true;
    }
}
