package Varazslatok;

import Egysegek.Egyseg;
import Hos.Hos;

public class Varazslat {
    private int ar;
    private int mana;
    private String nev;
    private int darab;

    public Varazslat(){

    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Varazslat(String nev,int ar, int mana, int db) {
        this.nev = nev;
        this.ar = ar;
        this.mana = mana;
        this.darab = db;
    }

    public int getDarab() {
        return darab;
    }

    public void setDarab(int darab) {
        this.darab = darab;
    }

    public void vasarol(Hos h, int darab){
        if(getDarab() == 0){
            setDarab(darab);
            if(h.vanelegArany(this.getAr() * darab)){
                int arany = h.getArany();
                arany -= this.getDarab() * this.getAr();
                h.setArany2(arany);
            }
        }
    }

    public boolean vanElegMana(int hosMana){
        if(mana > hosMana){
            return false;
        }else{
            return true;
        }
    }

    public void villamcsapas(Hos hos, Egyseg[] ellenfel, int egyseg){
        int c = 0;
        for (Egyseg e : ellenfel) {
            if (e != null) {
                c++;
                if (c == egyseg) {
                    e.setEletero(e.getEletero() - hos.getVarazsero() * 30);
                    hos.csokkentMana(hos.getMana() - getMana());
                }
            }
        }
    }

    public void nyilzapor(Hos hos, Egyseg[] ellenfel){
        for (Egyseg e : ellenfel) {
            if (e != null) {
                e.setEletero(e.getEletero() - hos.getVarazsero() * 70);
                hos.csokkentMana(hos.getMana() - getMana());
            }
        }
    }


    public void tornado(Hos hos, Egyseg[] ellenfel){
        int max = 0;
        Egyseg l = null;
        for(Egyseg e : ellenfel){
            if(e != null){
                if(e.getKezdemenyezes() > max){
                    max = e.getKezdemenyezes();
                }
                if(e.getKezdemenyezes() == max){
                    l = e;
                }
            }
        }
        assert l != null;
        l.setEletero(0);
        hos.csokkentMana(hos.getMana() - getMana());
    }

    public void feltamasztas(Hos hos, Egyseg[] hosEgyseg){}
}
