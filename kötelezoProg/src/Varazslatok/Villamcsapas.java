package Varazslatok;

import Egysegek.Egyseg;
import Hos.Hos;

public class Villamcsapas extends Varazslat{

    public Villamcsapas() {
        super("Villámcsapás",60, 5,0);
    }

    public void villamcsapas(Hos hos, Egyseg ellenfel){
        ellenfel.setEletero(ellenfel.getEletero() - hos.getVarazsero() * 30);
        hos.csokkentMana(hos.getMana() - getMana());
    }

}
