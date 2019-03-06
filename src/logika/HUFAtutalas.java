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
public class HUFAtutalas extends Tranzakcio {

    

    public static void kivet(BankSzamla szamla, int osszeg, String nev) {
        System.out.println("Indított tranzakció típusa: " + tipus.HUF_ATUTALAS
                + ", Indító neve: " + nev);                                                 // ellenőrzés miatt
        if (szamla.getTulajdonosok().contains(nev)) {

            if (osszeg > 0) {
                if (szamla.getEgyenleg() - osszeg - tranzakcioDij(osszeg) > 0) {
                    Tranzakcio tr = new Tranzakcio(szamla, tipus.HUF_ATUTALAS, nev, osszeg);
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

    public static int ujEgyenleg(BankSzamla szamla, int osszeg, tipus tipus) {
        if (tipus == tipus.JOVAIRAS) {
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

    public HUFAtutalas(BankSzamla szamla, logika.tipus tipus, String inditoNev, int osszeg) {
        super(szamla, tipus, inditoNev, osszeg);
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