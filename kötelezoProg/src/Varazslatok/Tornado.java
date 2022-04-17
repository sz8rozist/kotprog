package Varazslatok;

import Egysegek.Egyseg;
import Egysegek.Foldmuves;
import Egysegek.Griff;
import Egysegek.Ijasz;
import Hos.Hos;

import java.util.ArrayList;
import java.util.List;

public class Tornado extends Varazslat {
    public Tornado() {
        super("Tornádó",20,15,0);
    }

    public void tornado(Hos hos, Foldmuves ellenfelF, Griff ellenfelGriff, Ijasz ellenfelIjasz){
        int max = 0;
        List<Egyseg> egysegList = new ArrayList<>();
        egysegList.add(ellenfelF);
        egysegList.add(ellenfelGriff);
        egysegList.add(ellenfelIjasz);

        for(Egyseg e : egysegList){
            if(e.getKezdemenyezes() > max){
                max = e.getKezdemenyezes();
            }

            if(max == e.getKezdemenyezes()){
                e.setEletero(0);
                hos.csokkentMana(hos.getMana() - getMana());
            }
        }

    }
}
