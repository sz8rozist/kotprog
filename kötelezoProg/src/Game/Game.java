package Game;

import Egysegek.*;
import Hos.Hos;
import Palya.Palya;
import Varazslatok.*;
import Colors.*;

import java.util.Random;
import java.util.Scanner;

public class Game {
    public static void main(String args[]){
        int nehezseg = 0;
        Hos hos = new Hos();
        Palya p = new Palya();
        Hos ellenfel = hos.createEllenfel();
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);

        Feltamasztas feltamasztas = new Feltamasztas();
        Tuzlabda tuzlabda = new Tuzlabda();
        Villamcsapas villamcsapas = new Villamcsapas();
        Tornado tornado = new Tornado();
        Nyilzapor nyilzapor = new Nyilzapor();

        Feltamasztas ellenfelFeltamasztas = new Feltamasztas();
        Tuzlabda ellenfelTuzlabda = new Tuzlabda();
        Villamcsapas ellenfelVillamcsapas = new Villamcsapas();
        Tornado ellenfelTornado = new Tornado();
        Nyilzapor ellenfelNyilzapor = new Nyilzapor();

        Foldmuves foldmuves = new Foldmuves();
        Griff griff = new Griff();
        Ijasz ijasz = new Ijasz();
        Lovag lovag = new Lovag();
        Pap pap = new Pap();

        Foldmuves ellenfelFoldmuves = new Foldmuves();
        Griff ellenfelGriff = new Griff();
        Ijasz ellenfelIjjasz = new Ijasz();
        Lovag ellenfelLovag = new Lovag();
        Pap ellenfelPap = new Pap();

        chooseLevel(nehezseg, hos, sc);
        choosHosTulajdonsag(hos,sc);
        chooseVarazslatok(hos, sc, feltamasztas, tuzlabda, villamcsapas, tornado,nyilzapor);
        do{
            chooseSereg(hos,sc, foldmuves, griff, ijasz);
        }while(foldmuves.getDarab() == 0 && griff.getDarab() == 0 && ijasz.getDarab() == 0);
        ellenfelBeallitas(ellenfelFeltamasztas, ellenfelTuzlabda, ellenfelVillamcsapas, ellenfelTornado, ellenfelNyilzapor, ellenfelFoldmuves, ellenfelGriff, ellenfelIjjasz, ellenfel, rnd);
        egysegElhelyezese(p, hos,sc, ellenfel, rnd, foldmuves, griff, ijasz, ellenfelFoldmuves, ellenfelGriff, ellenfelIjjasz);
        hosAdatok(hos);
        ellenfelAdatai(ellenfel, ellenfelFeltamasztas, ellenfelNyilzapor, ellenfelTornado, ellenfelTuzlabda, ellenfelVillamcsapas, ellenfelFoldmuves, ellenfelGriff, ellenfelIjjasz);
        jatek(hos, ellenfel, p, sc, foldmuves, griff, ijasz, ellenfelFoldmuves, ellenfelGriff, ellenfelIjjasz, feltamasztas, nyilzapor, tornado, tuzlabda, villamcsapas);
    }
    public static void chooseLevel(int nehezseg, Hos hos, Scanner sc){
        System.out.println(Colors.ANSI_BLUE +"<----------------------------- V??laszd ki a neh??zs??gi szintet! ----------------------------->"+Colors.ANSI_RESET);
        System.out.println("1 - K??nny??");
        System.out.println("2 - K??zepes");
        System.out.println("3 - Neh??z");
        System.out.println(Colors.ANSI_BLUE +"<------------------------------------------------------------------------------------------->"+ Colors.ANSI_RESET);

        do{
            System.out.print("V??laszd ki a neh??zs??gi szintet: ");
            nehezseg = sc.nextInt();
        } while(nehezseg != 1 && nehezseg != 2 && nehezseg != 3);


        hos.setArany(nehezseg);
        System.out.println(Colors.ANSI_BLUE +"<----------------------------- V??laszd ki a h??s??d tulajdons??gpontjait! ----------------------------->"+Colors.ANSI_RESET);
    }
    public static void choosHosTulajdonsag(Hos hos, Scanner sc){
        int in;
        do{
            System.out.println("Tulajdons??gpontok");
            System.out.println("1 - T??mad??s: "+ hos.getTamadas() + " ??ra: "+ (int)hos.getAr());
            System.out.println("2 - V??dekez??s: " + hos.getVedekezes() + " ??ra: "+ (int)hos.getAr());
            System.out.println("3 - Var??zser??: " + hos.getVarazsero()  + " ??ra: "+ (int)hos.getAr());
            System.out.println("4 - Tud??s: " + hos.getTudas()  + " ??ra: "+ (int)hos.getAr());
            System.out.println("5 - Mor??l: " + hos.getMoral()  + " ??ra: "+ (int)hos.getAr());
            System.out.println("6 - Szerencse: " + hos.getSzerencse()  + " ??ra: "+ (int)hos.getAr());
            System.out.println("10 - Tov??bb a var??zslatok megv??s??rl??s??hoz!");
            System.out.println(Colors.ANSI_YELLOW+ "Arany: "+ hos.getArany() + Colors.ANSI_RESET);
            System.out.print("Melyik tulajdons??gpontot fejleszted?: ");
            in = sc.nextInt();
            hos.setTulajdonsagpontok(in);
        }while(in != 10);
    }
    public static void chooseVarazslatok(Hos hos, Scanner sc, Feltamasztas feltamasztas,Tuzlabda tuzlabda, Villamcsapas villamcsapas, Tornado tornado, Nyilzapor nyilzapor){

        System.out.println(Colors.ANSI_BLUE +"<----------------------------- V??s??rolj var??zslatokat! ----------------------------->"+Colors.ANSI_RESET);
        int darab;
        int darab2;
        do{
            System.out.println("Var??zslatok");
            System.out.println("1 - Felt??maszt??s (??ra: " + feltamasztas.getAr() + ") (manak??lts??ge: "+ feltamasztas.getMana()+ ")");
            System.out.println("2 - T??zlabda (??ra: " + tuzlabda.getAr() + ") (manak??lts??ge: "+ tuzlabda.getMana()+ ")");
            System.out.println("3 - Vill??mcsap??s (??ra: " + villamcsapas.getAr() + ") (manak??lts??ge: "+ villamcsapas.getMana()+ ")");
            System.out.println("4 - Torn??d?? (??ra: " + tornado.getAr() + ") (manak??lts??ge: "+ tornado.getMana()+ ")");
            System.out.println("5 - Ny??lz??por (??ra: " + nyilzapor.getAr() + ") (manak??lts??ge: "+ nyilzapor.getMana()+ ")");
            System.out.println("10 - Tov??bb a sereg ??ssze??ll??t??s??hoz!");
            System.out.println(Colors.ANSI_YELLOW+ "Arany: "+ hos.getArany() + Colors.ANSI_RESET);
            System.out.print("Melyik var??zslatot szeretn??d?: ");
            darab = sc.nextInt();
            switch(darab){
                case 1 -> {
                    System.out.print("H??ny darabot veszel?: ");
                    darab2 = sc.nextInt();
                    if(!hos.vanelegArany(feltamasztas.getAr() * darab2)){
                        System.err.println("Nem elegend?? az aranyad a v??s??rl??shoz!");
                    }
                    feltamasztas.vasarol(hos,darab2);
                }
                case 2 -> {
                    System.out.print("H??ny darabot veszel?: ");
                    darab2 = sc.nextInt();
                    if(hos.vanelegArany(tuzlabda.getAr()  * darab2)){
                        tuzlabda.vasarol(hos,darab2);
                    }else{
                        System.err.println("Nem elegend?? az aranyad a v??s??rl??shoz!");
                    }
                }
                case 3 -> {
                    System.out.print("H??ny darabot veszel?: ");
                    darab2 = sc.nextInt();
                    if(hos.vanelegArany(villamcsapas.getAr() * darab2)){
                        villamcsapas.vasarol(hos,darab2);
                    }else{
                        System.err.println("Nem elegend?? az aranyad a v??s??rl??shoz!");
                    }
                }
                case 4 -> {
                    System.out.print("H??ny darabot veszel?: ");
                    darab2 = sc.nextInt();
                    if(hos.vanelegArany(tornado.getAr() * darab2)){
                        tornado.vasarol(hos,darab2);
                    }else{
                        System.err.println("Nem elegend?? az aranyad a v??s??rl??shoz!");
                    }
                }
                case 5 -> {
                    System.out.print("H??ny darabot veszel?: ");
                    darab2 = sc.nextInt();
                    if(hos.vanelegArany(nyilzapor.getAr() * darab2)){
                        nyilzapor.vasarol(hos,darab2);
                    }else{
                        System.err.println("Nem elegend?? az aranyad a v??s??rl??shoz!");
                    }
                }
            }
            System.out.println(feltamasztas.getNev() + feltamasztas.getDarab());
        }while(darab != 10);
    }
    public static void chooseSereg(Hos hos, Scanner sc, Foldmuves foldmuves, Griff griff, Ijasz ijasz){
        System.out.println(Colors.ANSI_BLUE +"<----------------------------- ??ll??tsd ??ssze a sereged! ----------------------------->"+Colors.ANSI_RESET);
        int d;
        int db;
            do{
                System.out.println(Colors.ANSI_YELLOW+ "Arany: "+ hos.getArany() + Colors.ANSI_RESET);
                System.out.println("1 - "+foldmuves.getNev());
                System.out.println("2 - "+griff.getNev());
                System.out.println("3 - "+ijasz.getNev());
                System.out.println("10 - Elhelyezem az egys??geimet a p??ly??n!");
                System.out.print("Melyik egys??get szeretn??d?: ");
                d = sc.nextInt();
                switch (d) {
                    case 1 -> {
                        System.out.print("H??ny darabot veszel?: ");
                        db = sc.nextInt();
                        if(!hos.vanelegArany(foldmuves.getAr() * db)){
                            System.err.println("Nem elegend?? az aranyad a v??s??rl??shoz!");
                        }
                        foldmuves.egysegVasarlas(hos,db);
                    }
                    case 2 -> {
                        System.out.print("H??ny darabot veszel?: ");
                        db = sc.nextInt();
                        if(!hos.vanelegArany(griff.getAr() * db)){
                            System.err.println("Nem elegend?? az aranyad a v??s??rl??shoz!");
                        }
                        griff.egysegVasarlas(hos,db);
                    }
                    case 3 -> {
                        System.out.print("H??ny darabot veszel?: ");
                        db = sc.nextInt();
                        if(!hos.vanelegArany(ijasz.getAr() * db)){
                            System.err.println("Nem elegend?? az aranyad a v??s??rl??shoz!");
                        }
                        ijasz.egysegVasarlas(hos,db);
                    }
                }
            }while(d != 10);
    }
    public static void egysegElhelyezese(Palya p, Hos hos, Scanner sc, Hos ellenfel, Random rnd, Foldmuves f, Griff g, Ijasz i, Foldmuves ef, Griff eg, Ijasz ei){
        String oszlop = "";
        int sor = 0;
        System.out.println(Colors.ANSI_BLUE +"<----------------------------- Helyezd el az egys??geidet a p??ly??n! ----------------------------->"+Colors.ANSI_RESET);
        p.printPalya();
        System.out.println("Helyezd el a p??ly??n az egys??geidet!");
        if(f.getDarab() > 0){
            do{
                System.out.println("Hova tegy??k a "+ f.getNev() + " egys??get?");
                System.out.print("Oszlop: ");
                oszlop = sc.next();
                System.out.print("Sor: ");
                sor = sc.nextInt();
            }while(!p.egysegElhelyezes(f, oszlop, sor));

        }
        if(g.getDarab() > 0){
            do{
                System.out.println("Hova tegy??k a "+ g.getNev() + " egys??get?");
                System.out.print("Oszlop: ");
                oszlop = sc.next();
                System.out.print("Sor: ");
                sor = sc.nextInt();
            }while(!p.egysegElhelyezes(g, oszlop, sor));
        }
        if(i.getDarab() > 0){
            do{
                System.out.println("Hova tegy??k a "+ i.getNev() + " egys??get?");
                System.out.print("Oszlop: ");
                oszlop = sc.next();
                System.out.print("Sor: ");
                sor = sc.nextInt();
            }while(!p.egysegElhelyezes(i, oszlop, sor));
        }
        if(ef.getDarab() > 0){
            String c = String.valueOf(rnd.nextBoolean() ? 'H' : 'I');
            p.ellenfelEgysegeinekElhelyezese(ef, c, rnd.nextInt((10 - 1) + 1) + 1);
        }
        if(eg.getDarab() > 0){
            String c = String.valueOf(rnd.nextBoolean() ? 'H' : 'I');
            p.ellenfelEgysegeinekElhelyezese(eg, c, rnd.nextInt((10 - 1) + 1) + 1);
        }
        if(ei.getDarab() > 0){
            String c = String.valueOf(rnd.nextBoolean() ? 'H' : 'I');
            p.ellenfelEgysegeinekElhelyezese(ei, c, rnd.nextInt((10 - 1) + 1) + 1);
        }
        p.printPalya();
    }
    public static void ellenfelBeallitas(Feltamasztas feltamasztas, Tuzlabda tuzlabda, Villamcsapas villamcsapas,Tornado tornado, Nyilzapor nyilzapor, Foldmuves foldmuves, Griff griff, Ijasz ijasz, Hos ellenfel, Random rnd){
        feltamasztas.vasarol(ellenfel,rnd.nextInt((4 - 1) + 1) + 1);
        tuzlabda.vasarol(ellenfel,rnd.nextInt((4 - 1) + 1) + 1);
        villamcsapas.vasarol(ellenfel,rnd.nextInt((4 - 1) + 1) + 1);
        tornado.vasarol(ellenfel,rnd.nextInt((4 - 1) + 1) + 1);
        nyilzapor.vasarol(ellenfel,rnd.nextInt((4 - 1) + 1) + 1);

        foldmuves.egysegVasarlas(ellenfel, rnd.nextInt((100 - 1) + 1) + 1);
        griff.egysegVasarlas(ellenfel, rnd.nextInt((100 - 1) + 1) + 1);
        ijasz.egysegVasarlas(ellenfel, rnd.nextInt((100 - 1) + 1) + 1);
    }
    public static void jatek(Hos hos, Hos ellenfel, Palya p, Scanner sc, Foldmuves f, Griff g, Ijasz i, Foldmuves ellenfelF, Griff ellenfelGriff, Ijasz ellenfelIjasz, Feltamasztas feltamasztas, Nyilzapor nyilzapor, Tornado tornado, Tuzlabda tuzlabda, Villamcsapas villamcsapas){
        System.out.println(Colors.ANSI_BLUE +"<----------------------------- Kezd??dj??n a j??t??k! ----------------------------->"+Colors.ANSI_RESET);
        p.printPalya();
        int kor = 0;
        String karakter;
        int szam = 0;
        int hanyEgyseg = 0;
        int merre = 0;
        int h = 0;
        int kivalasztottVarazslat = 0;
        int megtamadottEgyseg = 0;
            kor++;
            Egyseg legnagyobbKezdemenyezesu = null;
            if(i.getDarab() > 0){
                legnagyobbKezdemenyezesu  = new Ijasz();
            }
        if(f.getDarab() > 0){
            legnagyobbKezdemenyezesu  = new Foldmuves();
        }
        if(g.getDarab() > 0){
            legnagyobbKezdemenyezesu  = new Griff();
        }
            System.out.println(Colors.ANSI_PURPLE+"K??r: "+kor+Colors.ANSI_RESET);
            do{
                System.out.print(Colors.ANSI_GREEN + "Egys??ggel szeretn??l l??pni vagy a h??s??ddel? (e/h): "+ Colors.ANSI_RESET);
                karakter = sc.next();
            }while(!karakter.equals("e") && !karakter.equals("h"));
            loop : switch (karakter) {
                case "e" -> {
                    System.out.println("1 - Mozg??s");
                    System.out.println("2 - V??rakoz??s");
                    System.out.println("3 - T??mad??s");
                    System.out.print("Mit szeretn??l tenni az egys??ggel?: ");
                    szam = sc.nextInt();
                    if (szam == 1) {
                        do{
                            System.out.print("Merre mozogjon? (1 - el??re, 2 - h??tra, 3 - jobbra, 4 - balra): ");
                            merre = sc.nextInt();
                            System.out.print("H??ny egys??get mozogjon?: ");
                            hanyEgyseg = sc.nextInt();
                        } while(!legnagyobbKezdemenyezesu.mozgas(hanyEgyseg, merre, p.getPalya()));
                    }
                    if(szam == 3){
                        int melyik = 0;
                            System.out.print("Melyik egys??get t??madjuk?: ");
                            System.out.println("1 - "+ellenfelF.getNev() + " (??leter??: "+ ellenfelF.getEletero()+")");
                            System.out.println("2 - "+ellenfelGriff.getNev() + " (??leter??: "+ ellenfelGriff.getEletero()+")");
                            System.out.println("3 - "+ellenfelIjasz.getNev() + " (??leter??: "+ ellenfelIjasz.getEletero()+")");
                            melyik = sc.nextInt();
                            if(melyik == 1){
                                i.ijjaszTamad(p.getPalya(),melyik,ellenfelF,hos,ellenfel);
                            }
                            if(melyik == 2){
                                i.ijjaszTamad(p.getPalya(),melyik,ellenfelGriff,hos,ellenfel);
                            }
                            if(melyik == 3){
                                i.ijjaszTamad(p.getPalya(),melyik,ellenfelIjasz,hos,ellenfel);
                            }
                    }
                    if(szam == 2){
                        break loop;
                    }
                }
                case "h" -> {
                    System.out.print("1 - T??mad??s / 2 - Var??zsl??s: ");
                    h = sc.nextInt();
                    if (h == 1) {
                        int c = 0;
                        System.out.println("Az ellenf??l egys??gei: ");
                        System.out.println("1 - "+ellenfelF.getNev() + " (??leter??: "+ ellenfelF.getEletero()+")");
                        System.out.println("2 - "+ellenfelGriff.getNev() + " (??leter??: "+ ellenfelGriff.getEletero()+")");
                        System.out.println("3 - "+ellenfelIjasz.getNev() + " (??leter??: "+ ellenfelIjasz.getEletero()+")");
                        System.out.print("Melyik egys??get t??madjuk: ");
                        megtamadottEgyseg = sc.nextInt();
                        if(megtamadottEgyseg == 1){
                            hos.hosTamad(ellenfelF);
                        }
                        if(megtamadottEgyseg == 2){
                            hos.hosTamad(ellenfelGriff);
                        }
                        if(megtamadottEgyseg == 3){
                            hos.hosTamad(ellenfelIjasz);
                        }

                    } else if (h == 2) {
                        System.out.println("Felhaszn??lhat?? var??zslatok");
                        if(villamcsapas.getDarab() > 0){
                            System.out.println("1 - "+villamcsapas.getNev() + " (mana: "+ villamcsapas.getMana()+")");
                        }
                        if(feltamasztas.getDarab() > 0){
                            System.out.println("2 - "+feltamasztas.getNev() + " (mana: "+ feltamasztas.getMana()+")");
                        }
                        if(nyilzapor.getDarab() > 0){
                            System.out.println("3 - "+nyilzapor.getNev() + " (mana: "+ nyilzapor.getMana()+")");
                        }
                        if(tuzlabda.getDarab() > 0){
                            System.out.println("4 - "+tuzlabda.getNev() + " (mana: "+ tuzlabda.getMana()+")");
                        }
                        if(tornado.getDarab() > 0){
                            System.out.println("5 - "+tornado.getNev() + " (mana: "+ tornado.getMana()+")");
                        }
                        System.out.print("Melyik var??zslatot v??lasztod?: ");
                        kivalasztottVarazslat = sc.nextInt();
                        switch (kivalasztottVarazslat){
                            case 1:
                                System.out.println("Ellenf??l egys??gei: ");
                                System.out.println("1 - "+ellenfelF.getNev() + " (??leter??: "+ ellenfelF.getEletero()+")");
                                System.out.println("2 - "+ellenfelGriff.getNev() + " (??leter??: "+ ellenfelGriff.getEletero()+")");
                                System.out.println("3 - "+ellenfelIjasz.getNev() + " (??leter??: "+ ellenfelIjasz.getEletero()+")");
                                System.out.print("Melyik egys??gre haszn??lnod a var??zsl??st?: ");
                                megtamadottEgyseg = sc.nextInt();
                                if(megtamadottEgyseg == 1){
                                    villamcsapas.villamcsapas(hos, ellenfelF);
                                }
                                if(megtamadottEgyseg == 2){
                                    villamcsapas.villamcsapas(hos, ellenfelGriff);
                                }
                                if(megtamadottEgyseg == 3){
                                    villamcsapas.villamcsapas(hos, ellenfelIjasz);
                                }
                                break;
                            case 2:
                                System.out.println("Az egys??geid ");
                                if(f.getDarab() > 0){
                                    System.out.println("1 - "+f.getNev() + " (??leter??: "+ f.getEletero()+")");
                                }
                                if(g.getDarab() > 0){
                                    System.out.println("2 - "+g.getNev() + " (??leter??: "+ g.getEletero()+")");
                                }
                                if(i.getDarab() > 0){
                                    System.out.println("3 - "+i.getNev() + " (??leter??: "+ i.getEletero()+")");
                                }
                                System.out.print("Melyik egys??gre haszn??lnod a var??zsl??st?: ");
                                megtamadottEgyseg = sc.nextInt();
                                if(megtamadottEgyseg == 1){
                                    feltamasztas.feltamasztas(hos, f);
                                }
                                if(megtamadottEgyseg == 2){
                                    feltamasztas.feltamasztas(hos, g);
                                }
                                if(megtamadottEgyseg == 3){
                                    feltamasztas.feltamasztas(hos, i);
                                }
                                break;
                            case 3:
                                nyilzapor.nyilzapor(hos, ellenfelF, ellenfelGriff, ellenfelIjasz);
                                break;
                            case 4: /*tuzlabda*/ break;
                            case 5:
                                tornado.tornado(hos, ellenfelF, ellenfelGriff, ellenfelIjasz);
                                break;
                        }
                    }
                }
            }
            p.printPalya();
    }
    public static void hosAdatok(Hos h){
        System.out.println();
        System.out.println(Colors.ANSI_BLUE+"Tulajdons??gpontjaim "+Colors.ANSI_RESET);
        System.out.println("T??mad??s: "+h.getTamadas());
        System.out.println("V??dekez??s: "+h.getVedekezes());
        System.out.println("Var??zser??: "+h.getVarazsero());
        System.out.println("Tud??s: "+h.getTudas());
        System.out.println("Mor??l: "+h.getMoral());
        System.out.println("Szerencse: "+h.getSzerencse());
        System.out.println("Mana: "+h.getMana());
    }
    public static void ellenfelAdatai(Hos h, Feltamasztas f, Nyilzapor ny, Tornado t, Tuzlabda tu, Villamcsapas v, Foldmuves fold, Griff g, Ijasz i){
        System.out.println();
        System.out.println(Colors.ANSI_BLUE + "Az ellenf??l adatai"+ Colors.ANSI_RESET);
        System.out.println("T??mad??s: "+h.getTamadas());
        System.out.println("V??dekez??s: "+h.getVedekezes());
        System.out.println("Var??zser??: "+h.getVarazsero());
        System.out.println("Tud??s: "+h.getTudas());
        System.out.println("Mor??l: "+h.getMoral());
        System.out.println("Szerencse: "+h.getSzerencse());
        System.out.println("Mana: "+h.getMana());

        System.out.println(Colors.ANSI_BLUE +"Az ellenf??l var??zser??i:"+ Colors.ANSI_RESET);
        if(f.getDarab() != 0){
            System.out.println(f.getNev());
        }
        if(ny.getDarab() != 0){
            System.out.println(ny.getNev());
        }
        if(t.getDarab() != 0){
            System.out.println(t.getNev());
        }
        if(tu.getDarab() != 0){
            System.out.println(tu.getNev());
        }
        if(v.getDarab() != 0){
            System.out.println(v.getNev());
        }
        System.out.println(Colors.ANSI_BLUE +"Az ellenf??l egys??gei:"+ Colors.ANSI_RESET);
        if(fold.getDarab() != 0){
            System.out.println(fold.getNev());
        }
        if(g.getDarab() != 0){
            System.out.println(g.getNev());
        }
        if(i.getDarab() != 0){
            System.out.println(i.getNev());
        }
    }
}
