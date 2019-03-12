/*
 Egy Bankszamla nevű osztály, melynek a következő kívülről látható „dolgai” vannak: 
 Egyenleg (csak olvasható), betét, Kivét, ez utóbbi természetesen csak az egyenleg összegéig terjedhet. 
 Hozzáférő személyek ebből max 3 lehet.

 Szabályok: mínusz összeget nem lehet betenni, felvenni, a számla sem mehet el negatívba, 
 minden tranzakciónak legyen költsége amit az egyenlegből rögtön levon, 
 persze a költséget tudjam lekérdezni, és annak összesítését is. 
 Tranzakció nem történhet addig amíg legalább egy személy nincs rendelve a számlához. 
 Lehessen személyt visszavonni is, a neve alapján de csak akkor ha több van, azaz az utolsót ne engedje törölni.
 */
package bank_0303;

import Szamla.BankSzamla;
import Megbizas.Megbizas;
import Tranzakcio.Tranzakcio;
import Tranzakcio.tipus;

/**
 *
 * @author FZs
 */
public class Bank_0303 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Teszt
        BankSzamla szamla1 = new BankSzamla("Béla");

        System.out.println("Alaphelyzet: " + szamla1);
        System.out.println("");

        teszt("Béla", 100, tipus.HUF_ATUTALAS, szamla1);

        teszt("Béla", 50, tipus.JOVAIRAS, szamla1);

        teszt("Béla", 50, tipus.JOVAIRAS, szamla1);

        // Tulajdonoskezelés ellenőrzés
        szamla1.tulajdonosHozzaad("Géza");
        System.out.println(szamla1);
        System.out.println("");

        teszt("Juli", 150, tipus.HUF_ATUTALAS, szamla1);

        szamla1.tulajdonosHozzaad("Juli");
        System.out.println(szamla1);
        System.out.println("");

        teszt("Juli", 110, tipus.JOVAIRAS, szamla1);
        
        teszt("Juli", 150, tipus.HUF_ATUTALAS, szamla1);

        szamla1.tulajdonosTorol("Géza");
        System.out.println(szamla1);
        System.out.println("");

        szamla1.tulajdonosTorol("Juli");
        System.out.println(szamla1);
        System.out.println("");

        szamla1.tulajdonosTorol("Béla");
        System.out.println(szamla1);

        szamla1.trTortenetKiir();

        System.out.println("");

        szamla1.osszKoltseg();
    }

    private static void teszt(String nev, int szam, tipus tipus, BankSzamla szamla1) {
        Megbizas megbizas = new Megbizas(nev, szam, tipus);
        System.out.println(megbizas);
        Tranzakcio tr = new Tranzakcio(megbizas, szamla1);
        tr.tranzakcioIndit();
        System.out.println(megbizas);
        System.out.println(szamla1);
        System.out.println("");
    }

}
