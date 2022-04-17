package Varazslatok;

import Egysegek.Foldmuves;
import Egysegek.Griff;
import Egysegek.Ijasz;
import Hos.Hos;

public class Nyilzapor extends Varazslat{
    public Nyilzapor() {
        super("Nyílzápor",50,50,0);
    }

    public void nyilzapor(Hos hos, Foldmuves ellenfelF, Griff ellenfelGriff, Ijasz ellenfelIjasz){
        ellenfelF.setEletero(ellenfelF.getEletero() - hos.getVarazsero() * 70);
        ellenfelGriff.setEletero(ellenfelGriff.getEletero() - hos.getVarazsero() * 70);
        ellenfelIjasz.setEletero(ellenfelIjasz.getEletero() - hos.getVarazsero() * 70);
        hos.csokkentMana(hos.getMana() - getMana());
    }
}
