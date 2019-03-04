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
    private ArrayList<String> tulajdonosok;
    private int egyenleg;
    private ArrayList<Integer> koltsegek;
//    private ArrayList<TranzakciosDij> trDijak;
    
    

    public BankSzamla(String tulajdonos) {
        tulajdonosok = new ArrayList<>();
        this.tulajdonosok.add(tulajdonos);
        this.egyenleg = 0;
        this.koltsegek = new ArrayList<>();
//        trDijak = new ArrayList<>();
        
        
    }
    
    
    
    public void tulajdonosHozzaad(String nev){
        System.out.println("Tulajdonos hozzáad " + nev);
        if (tulajdonosok.size() < MAX_TULAJDONOS ) {
            tulajdonosok.add(nev);
        }
    }
    
    public void tulajdonosTorol(String nev){
        System.out.println("Tulajdonos töröl " + nev);
        if (tulajdonosok.contains(nev) 
                && tulajdonosok.size() > 1) {
            boolean talalat = false;
            int i = 0;
            while (! talalat || i < tulajdonosok.size()) {
                if (tulajdonosok.get(i).equals(nev) ) {
                    tulajdonosok.remove(i);
                    talalat = true;
                }
                i++;
            }
        }
    
    }
    
    public ArrayList<String> getTulajdonosok() {
        return tulajdonosok;
    }
       
    public void betet(int osszeg){
        int koltseg = TranzakciosDij.tranzakcioDij(osszeg);
        System.out.println("Betét " + osszeg);
        if (osszeg > 0) {
            egyenleg += osszeg - koltseg;
            koltsegek.add(koltseg);
        }
    }
    
    public void kivet(int osszeg){
        int koltseg = TranzakciosDij.tranzakcioDij(osszeg);
        System.out.println("Kivét " + osszeg);
        if ((egyenleg - osszeg - koltseg) > 0 && osszeg > 0) {
           egyenleg -= osszeg - koltseg;
           koltsegek.add(koltseg);
        }else{
        throw new IllegalArgumentException("A kivét nem lehet több mint az egyenleg");
        }
    }
    
    public int osszTranzakciosDij(){
        int eredmeny = 0;
        for (int i = 0; i < koltsegek.size(); i++) {
            eredmeny += koltsegek.get(i);
        }
        return eredmeny;
    }
    
    @Override
    public String toString() {
        return "BankSzamla{" + "tulajdonosok=" + tulajdonosok + ", egyenleg=" + egyenleg + '}';
    }

    

    
    
    
    
}