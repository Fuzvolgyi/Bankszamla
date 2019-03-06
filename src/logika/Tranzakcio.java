/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author FZs
 */
public abstract class Tranzakcio2 {

    
    private int id;
    private tipus tipus; 
    private String inditoSzemely;
    private int pillEgyenleg;
    private int ujEgyenleg;
    private double trKoltseg;
    private double illetek = 0.003;
    private int koltseg;
    private int osszeg;
    private LocalDate inditas;
    private LocalDate konyveles;

    public Tranzakcio2(BankSzamla szamla, tipus tipus, String inditoNev, int osszeg) {
        this.tipus = tipus;
        this.inditoSzemely = inditoNev;
        this.pillEgyenleg = szamla.getEgyenleg();
        this.ujEgyenleg = ujEgyenleg(szamla, osszeg, tipus);
        this.koltseg = tranzakcioDij(osszeg);
        this.osszeg = osszeg;

    }

    public int getKoltseg(Tranzakcio2 tr) {
        return tr.koltseg;
    }

    public tipus getTipus(Tranzakcio2 tr) {
        return tr.tipus;
    }
    
    public void tranzakcioIndit(BankSzamla szamla, int osszeg, String nev, tipus tipus) {
        System.out.println("Indított tranzakció típusa: " + tipus.HUF_ATUTALAS
                + ", Indító neve: " + nev);                                                 // ellenőrzés miatt
        if (szamla.getTulajdonosok().contains(nev)) {
            if (osszeg > 0) {
                Tranzakcio2 tr = new Tranzakcio2(szamla, tipus.HUF_ATUTALAS, nev, osszeg);
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
    
    
    
    
        
    
    public static void betet(BankSzamla szamla, int osszeg, String nev) {
        System.out.println("Indított tranzakció típusa: " + tipus.HUF_ATUTALAS
                + ", Indító neve: " + nev);                                                 // ellenőrzés miatt
        if (szamla.getTulajdonosok().contains(nev)) {
            if (osszeg > 0) {
                Tranzakcio2 tr = new Tranzakcio2(szamla, tipus.HUF_ATUTALAS, nev, osszeg);
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
        System.out.println("Indított tranzakció típusa: " + tipus.JOVAIRAS
                + ", Indító neve: " + nev);                                                 // ellenőrzés miatt
        if (szamla.getTulajdonosok().contains(nev)) {

            if (osszeg > 0) {
                if (szamla.getEgyenleg() - osszeg - tranzakcioDij(osszeg) > 0) {
                    Tranzakcio2 tr = new Tranzakcio2(szamla, tipus.JOVAIRAS, nev, osszeg);
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
        if (tipus == tipus.HUF_ATUTALAS) {
            int eredmeny = szamla.getEgyenleg() + osszeg - tranzakcioDij(osszeg);
            return eredmeny;
        } else {
            int eredmeny = szamla.getEgyenleg() - osszeg - tranzakcioDij(osszeg);
            return eredmeny;
        }
    }

    @Override
    public String toString() {
        return "Tranzakció típusa: " + getTipus(this) + ", Indító neve= " + inditoSzemely
                + ", Régi egyenleg= " + pillEgyenleg + " " 
                +  getTipus(this) + " összege: " + osszeg
                + ", Tranzakciós költség= " + koltseg
                + ", Új egyenleg: " + ujEgyenleg + '}';
    }

}
