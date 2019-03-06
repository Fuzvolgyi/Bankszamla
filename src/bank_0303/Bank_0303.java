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

import logika.BankSzamla;
import logika.Tranzakcio;

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
        // betét ellenőrzés
        Tranzakcio.betet(szamla1, 150, "Béla");

        Tranzakcio.betet(szamla1, -150, "Béla");

        Tranzakcio.betet(szamla1, 70, "Juli");

        // kivét ellenőrzés
        Tranzakcio.kivet(szamla1, 50, "Bela");

        Tranzakcio.kivet(szamla1, 50, "Béla");

        Tranzakcio.kivet(szamla1, -50, "Béla");

        // Tulajdonoskezelés ellenőrzés
        szamla1.tulajdonosHozzaad("Géza");
        System.out.println(szamla1);
        System.out.println("");

        szamla1.tulajdonosHozzaad("Juli");
        System.out.println(szamla1);
        System.out.println("");
        
        Tranzakcio.betet(szamla1, 70, "Juli");

        szamla1.tulajdonosTorol("Géza");
        System.out.println(szamla1);
        System.out.println("");

        szamla1.tulajdonosTorol("Juli");
        System.out.println(szamla1);
        System.out.println("");
        
        Tranzakcio.betet(szamla1, 70, "Juli");

        szamla1.tulajdonosTorol("Béla");
        System.out.println(szamla1);

        szamla1.trTortenetKiir(szamla1);
        
        System.out.println("");

        szamla1.osszKoltseg(szamla1);
    }

}
