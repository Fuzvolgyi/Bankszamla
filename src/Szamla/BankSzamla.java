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
package Szamla;

import Megbizas.Megbizas;
import java.util.ArrayList;

public class BankSzamla {

    private final int MAX_TULAJDONOS = 3;
    private ArrayList<String> tulajdonosLista;
    private int egyenleg;
    private ArrayList<Megbizas> trTortenet;

    public BankSzamla(String tulajdonos) {
        tulajdonosLista = new ArrayList<>();
        this.tulajdonosLista.add(tulajdonos);
        this.egyenleg = 0;
        trTortenet = new ArrayList<>();

    }

    //<editor-fold defaultstate="collapsed" desc="Getter-Setter">
    
    
    
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
    
    public ArrayList<Megbizas> getTortenet() {
        return trTortenet;
    }
//</editor-fold>

    public void addTortenet(Megbizas peldany) {
        this.trTortenet.add(peldany);
    }
    
    public void tulajdonosHozzaad(String nev) {
        System.out.println("Tulajdonos hozzáad " + nev);        // ellenőrzés miatt
        if (getTulajdonosok().size() < MAX_TULAJDONOS) {
            getTulajdonosok().add(nev);
        }
    }
    
    public void tulajdonosTorol(String nev) {
        System.out.println("Tulajdonos töröl " + nev);
        if (tulajEllenorzes(nev)) {
            int i = getTulajdonosok().indexOf(nev);
            getTulajdonosok().remove(i);
        }
    }

    @Override
    public String toString() {
        return "BankSzamla{" + "tulajdonosok=" + tulajdonosLista + ", egyenleg=" + egyenleg + '}';
    }

    public void trTortenetKiir(){
        System.out.println("");
        System.out.println("A bankszámla összes tranzakció listája:");
        for (int i = 0; i < trTortenet.size(); i++) {
            System.out.println(trTortenet.get(i));
        }
    }
    
    public void osszKoltseg(){
        int eredmeny = 0;
        for (int i = 0; i < trTortenet.size(); i++) {
            eredmeny += trTortenet.get(i).getKoltseg();
            }
        System.out.println("Az összes tranzakció költsége: " + eredmeny + " Ft");
    }    

        
    public boolean tulajEllenorzes(String nev) {
        return (getTulajdonosok().size() > 1 && getTulajdonosok().contains(nev));
    }
}
