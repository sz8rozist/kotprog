package Palya;

import Egysegek.Egyseg;
import Colors.*;

public class Palya {
    String [][] palya = new String[11][13];

    public String[][] getPalya() {
        return palya;
    }

    public void setPalya(String[][] palya) {
        this.palya = palya;
    }

    public Palya(){
        for (int i=0; i<10; i++) {
            for (int j=0; j<12; j++) {
                palya[i][j] = " ";
            }
        }
        palya[0][12] = "1";
        palya[1][12] = "2";
        palya[2][12] = "3";
        palya[3][12] = "4";
        palya[4][12] = "5";
        palya[5][12] = "6";
        palya[6][12] = "7";
        palya[7][12] = "8";
        palya[8][12] = "9";
        palya[9][12] = "10";

        palya[10][0] = "A";
        palya[10][1] = "B";
        palya[10][2] = "C";
        palya[10][3] = "D";
        palya[10][4] = "E";
        palya[10][5] = "F";
        palya[10][6] = "G";
        palya[10][7] = "K";
        palya[10][8] = "L";
        palya[10][9] = "J";
        palya[10][10] = "H";
        palya[10][11] = "I";
        palya[10][12] = "";
    }

    public void printPalya(){
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                System.out.print(palya[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean egysegElhelyezes(Egyseg e, String oszlop, int sor){
        if(oszlop.equals("A") || oszlop.equals("B")){
            for (int i = 0; i < 11; i++) {
                for (int j = 0; j < 13; j++) {
                    if(palya[10][j].equals(oszlop) && palya[i][12].equals(Integer.toString(sor))){
                        if(!palya[i][j].equals(" ")){
                            return false;
                        }
                        String firstChar = String.valueOf(e.getNev().charAt(0));
                        palya[i][j] = firstChar.toLowerCase();
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean ellenfelEgysegeinekElhelyezese(Egyseg e, String oszlop, int sor){
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 13; j++) {
                if(palya[10][j].equals(oszlop) && palya[i][12].equals(Integer.toString(sor))){
                    if(!palya[i][j].equals(" ")){
                        return false;
                    }
                    String firstChar = String.valueOf(e.getNev().charAt(0));
                    palya[i][j] = firstChar;
                    return true;
                }
            }
        }
        return false;
    }

    public Egyseg legnagyobbKezdemenyezesu(Egyseg[] egyseg){
        Egyseg legnagyobbKezdemenyezesu = null;
        int max = 0;
        for(Egyseg e : egyseg){
            if(e != null){
                if(e.getKezdemenyezes() > max){
                    max = e.getKezdemenyezes();
                }
                if(e.getKezdemenyezes() == max){
                    legnagyobbKezdemenyezesu = e;
                }
            }
        }
        return legnagyobbKezdemenyezesu;
    }
    
    public void mozgas(Egyseg[] egysegek, int hanyEgyseg, int merre){
        Egyseg legnagyobbKezdemenyezesu = legnagyobbKezdemenyezesu(egysegek);
        String firstLetter = String.valueOf(legnagyobbKezdemenyezesu.getNev().charAt(0)).toLowerCase();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 12; j++) {
                if(merre == 1){
                    if(!palya[i][j + hanyEgyseg].equals(" ")){
                        break;
                    }
                    if(hanyEgyseg < 1 || hanyEgyseg > legnagyobbKezdemenyezesu.getSebesseg() || j + hanyEgyseg > 12){
                        break;
                    }
                    if(palya[i][j].equals(firstLetter)){
                        palya[i][j + hanyEgyseg] = firstLetter;
                        palya[i][j] = " ";
                        break;
                    }
                }else if(merre == 2){

                }else if(merre == 3){

                }else if(merre == 4){

                }
            }
        }
    }
}
