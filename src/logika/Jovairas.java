/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

/**
 *
 * @author FZs
 */
public class Jovairas extends Tranzakcio {

    public Jovairas(BankSzamla szamla, logika.tipus tipus, String inditoNev, int osszeg) {
        super(szamla, tipus, inditoNev, osszeg);
    }
    

    public static void jovairas(BankSzamla szamla, int osszeg, String nev) {
        System.out.println("Indított tranzakció típusa: " + tipus.HUF_ATUTALAS
                + ", Indító neve: " + nev);                                                 // ellenőrzés miatt
        if (szamla.getTulajdonosok().contains(nev)) {
            if (osszeg > 0) {
                Tranzakcio tr = new Tranzakcio(szamla, tipus.HUF_ATUTALAS, nev, osszeg);
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

    public static int ujEgyenleg(BankSzamla szamla, int osszeg, tipus tipus) {
        if (tipus == tipus.HUF_ATUTALAS) {
            int eredmeny = szamla.getEgyenleg() + osszeg - tranzakcioDij(osszeg);
            return eredmeny;
        } else {
            int eredmeny = szamla.getEgyenleg() - osszeg - tranzakcioDij(osszeg);
            return eredmeny;
        }
    }
    
    public static int tranzakcioDij(int osszeg) {
        double szam = osszeg * trKoltseg;
        return (int) szam;
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