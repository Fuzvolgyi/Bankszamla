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
package logika;

import java.util.ArrayList;

public class BankSzamla {

    private final int MAX_TULAJDONOS = 3;
    private ArrayList<String> tulajdonosLista;
    private int egyenleg;

    private ArrayList<Tranzakcio> tortenet;

    public BankSzamla(String tulajdonos) {
        tulajdonosLista = new ArrayList<>();
        this.tulajdonosLista.add(tulajdonos);
        this.egyenleg = 0;
        tortenet = new ArrayList<>();

    }

    public ArrayList<String> getTulajdonosok() {
        return tulajdonosLista;
    }

    public int getEgyenleg() {
        int eredmeny = egyenleg;
        return eredmeny;
    }

    public void setEgyenleg(int egyenleg) {
        this.egyenleg = egyenleg;
    }

    public void addTortenet(Tranzakcio peldany) {
        this.tortenet.add(peldany);
    }

    public ArrayList<Tranzakcio> getTortenet() {
        return tortenet;
    }

    public void tulajdonosHozzaad(String nev) {
        System.out.println("Tulajdonos hozzáad " + nev);
        if (tulajdonosLista.size() < MAX_TULAJDONOS) {
            tulajdonosLista.add(nev);
        }
    }

    public void tulajdonosTorol(String nev) {
        System.out.println("Tulajdonos töröl " + nev);
        if (tulajdonosLista.contains(nev)
                && tulajdonosLista.size() > 1) {
            boolean talalat = false;
            int i = 0;
            while (!talalat || i < tulajdonosLista.size()) {
                if (tulajdonosLista.get(i).equals(nev)) {
                    tulajdonosLista.remove(i);
                    talalat = true;
                }
                i++;
            }
        }

    }

    @Override
    public String toString() {
        return "BankSzamla{" + "tulajdonosok=" + tulajdonosLista + ", egyenleg=" + egyenleg + '}';
    }

}
