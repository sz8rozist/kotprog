package Palya;

import Egysegek.Egyseg;
import Colors.*;

public class Palya {
    String [][] palya = new String[11][13];
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
        palya[10][7] = "H";
        palya[10][8] = "I";
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
                        switch (e.getNev()) {
                            case "Földműves" -> palya[i][j] = Colors.ANSI_BLUE + firstChar + Colors.ANSI_RESET;
                            case "Griff" -> palya[i][j] = Colors.ANSI_YELLOW + firstChar + Colors.ANSI_RESET;
                            case "Íjász" -> palya[i][j] = Colors.ANSI_RED + firstChar + Colors.ANSI_RESET;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
