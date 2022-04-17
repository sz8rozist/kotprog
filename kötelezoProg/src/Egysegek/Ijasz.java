package Egysegek;

import Hos.Hos;

import java.util.Random;

public class Ijasz extends Egyseg{
    public Ijasz(){
        super("Íjász",6,new int[]{2, 4},7,4,9,"lövés",0);
    }


    public boolean ijjaszTamad(String[][] palya, int melyik, Egyseg ellenfel, Hos h, Hos e) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if(i == 9){
                    return false;
                }
                if(j == 1){
                    return false;
                }
                if(!palya[i+1][j].equals(" ") && !palya[i-1][j].equals(" ") && !palya[i][j+1].equals(" ") && !palya[i][j-1].equals(" ")){
                    return false;
                }
            }
        }
        Random rnd = new Random();
        int sebzes = rnd.nextInt((getSebzes()[0] - getSebzes()[1]) + getSebzes()[0]) + getSebzes()[0];
        double alapSebzes = getDarab() * sebzes;
        switch (h.getTamadas()) {
            case 1 -> alapSebzes *= 1.1;
            case 2 -> alapSebzes *= 1.2;
            case 3 -> alapSebzes *= 1.3;
            case 4 -> alapSebzes *= 1.4;
            case 5 -> alapSebzes *= 1.5;
            case 6 -> alapSebzes *= 1.6;
            case 7 -> alapSebzes *= 1.7;
            case 8 -> alapSebzes *= 1.8;
            case 9 -> alapSebzes *= 1.9;
            case 10 -> alapSebzes *= 1.10;
        }
        switch (e.getVedekezes()) {
            case 1 -> alapSebzes *= 0.1;
            case 2 -> alapSebzes *= 0.2;
            case 3 -> alapSebzes *= 0.3;
            case 4 -> alapSebzes *= 0.4;
            case 5 -> alapSebzes *= 0.5;
            case 6 -> alapSebzes *= 0.6;
            case 7 -> alapSebzes *= 0.7;
            case 8 -> alapSebzes *= 0.8;
            case 9 -> alapSebzes *= 0.9;
            case 10 -> alapSebzes *= 0.10;
        }
        int sebzesErteke = (int) Math.ceil(alapSebzes);
        int ellenfelEletero = ellenfel.getDarab() * ellenfel.getEletero();
        ellenfel.setEletero(ellenfelEletero - sebzesErteke);
        return true;
    }
}
