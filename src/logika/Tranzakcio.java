/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import java.util.ArrayList;

/**
 *
 * @author FZs
 */
public class Tranzakcio {

    private static double trKoltseg = 0.05;
    private static tipus tipus; 
    private String inditoNev;
    private int pillEgyenleg;
    private int ujEgyenleg;
    private int koltseg;
    private int osszeg;

    public Tranzakcio(BankSzamla szamla, tipus tipus, String inditoNev, int osszeg) {
        this.tipus = tipus;
        this.inditoNev = inditoNev;
        this.pillEgyenleg = szamla.getEgyenleg();
        this.ujEgyenleg = ujEgyenleg(szamla, osszeg, tipus);
        this.koltseg = tranzakcioDij(osszeg);
        this.osszeg = osszeg;

    }

    public int getKoltseg(Tranzakcio tr) {
        return tr.koltseg;
    }

    public tipus getTipus(Tranzakcio tr) {
        return tr.tipus;
    }
    
        
    
    public static void betet(BankSzamla szamla, int osszeg, String nev) {
        System.out.println("Indított tranzakció típusa: " + tipus.BETET
                + ", Indító neve: " + nev);                                                 // ellenőrzés miatt
        if (szamla.getTulajdonosok().contains(nev)) {
            if (osszeg > 0) {
                Tranzakcio tr = new Tranzakcio(szamla, tipus.BETET, nev, osszeg);
                szamla.addTortenet(tr);
                System.out.println(tr);                                                     // ellenőrzés miatt
                szamla.setEgyenleg(tr.ujEgyenleg);
                
            } else {
//                throw new IllegalArgumentException("Negatív összeggel nem lehet betétet indítani!");
                System.out.println("Negatív összeggel nem lehet betétet indítani!");        // ellenőrzés miatt

            }
        } else {
//            throw new IllegalArgumentException("Csak számlatulajdonos indíthat tranzakciót!");
            System.out.println("Csak számlatulajdonos indíthat tranzakciót!");              // ellenőrzés miatt
        }
        System.out.println("");                                                             // ellenőrzés miatt
    }

    public static void kivet(BankSzamla szamla, int osszeg, String nev) {
        System.out.println("Indított tranzakció típusa: " + tipus.KIVET
                + ", Indító neve: " + nev);                                                 // ellenőrzés miatt
        if (szamla.getTulajdonosok().contains(nev)) {

            if (osszeg > 0) {
                if (szamla.getEgyenleg() - osszeg - tranzakcioDij(osszeg) > 0) {
                    Tranzakcio tr = new Tranzakcio(szamla, tipus.KIVET, nev, osszeg);
                    szamla.addTortenet(tr);
                    System.out.println(tr);                                                     // ellenőrzés miatt
                    szamla.setEgyenleg(tr.ujEgyenleg);
                } else {
//             throw new IllegalArgumentException("A kivét nem lehet több mint az egyenleg "
//                    + "és az összegnek nagyobbnak kell lennie nullánál!");
                    System.out.println("A kivét nem lehet több, mint az egyenleg "
                            + "és ");
                }
            } else {
//            throw new IllegalArgumentException("Az összegnek nagyobbnak kell lennie nullánál!");
                System.out.println("Az összegnek nagyobbnak kell lennie nullánál!");            // ellenőrzés miatt
            }
        } else {
//            throw new IllegalArgumentException("Csak számlatulajdonos indíthat tranzakciót!");
            System.out.println("Csak számlatulajdonos indíthat tranzakciót!");                  // ellenőrzés miatt
        }
        System.out.println("");                                                                 // ellenőrzés miatt
    }

    public static int tranzakcioDij(int osszeg) {
        double szam = osszeg * trKoltseg;
        return (int) szam;
    }

    public static int ujEgyenleg(BankSzamla szamla, int osszeg, tipus tipus) {
        if (tipus == tipus.BETET) {
            int eredmeny = szamla.getEgyenleg() + osszeg - tranzakcioDij(osszeg);
            return eredmeny;
        } else {
            int eredmeny = szamla.getEgyenleg() - osszeg - tranzakcioDij(osszeg);
            return eredmeny;
        }
    }

    @Override
    public String toString() {
        return "Tranzakció típusa: " + getTipus(this) + ", Indító neve= " + inditoNev
                + ", Régi egyenleg= " + pillEgyenleg + " " 
                +  getTipus(this) + " összege: " + osszeg
                + ", Tranzakciós költség= " + koltseg
                + ", Új egyenleg: " + ujEgyenleg + '}';
    }

}
