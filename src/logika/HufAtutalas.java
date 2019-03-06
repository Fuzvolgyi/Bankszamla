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
public class HufAtutalas extends Tranzakcio2 {

    private tipus tipus; 
    private double tranzakciosDij = 0.05;
    private double illetek = 0.003;
    private int koltseg;
    
    
    public HufAtutalas(String inditoSzemely, int osszeg) {
        super(inditoSzemely, osszeg);
        this.tipus = tipus.HUF_ATUTALAS;
        this.koltseg = getKoltseg(osszeg);
        this.illetek = getIlletek(osszeg);
        
    }

    public void utalasIndit(BankSzamla szamla) {
        if (szamla.getTulajdonosok().contains(this.getInditoSzemely())) {
            if (this.getOsszeg() > 0) {
                utal(this);
            } else {
                System.out.println("Nullánál nagyobb összegel lehet tranzakciót indítani");
            }
        }else{
            System.out.println("Csak számlatulajdonos indíthat tranzakciót");
        }
        
    }
    
    private void utal(HufAtutalas megbizas){
        System.out.println("Utal " + megbizas);
        System.out.println("");
    
    }
    
    public int getKoltseg(int osszeg) {
        double szam = osszeg * tranzakciosDij;
        return (int)szam;
    }

    public double getIlletek(int osszeg) {
        double szam = osszeg * illetek;
        return  szam;
    }
    
    
    

    
    @Override
    public String toString() {
        return super.toString() + "HufAtutalas{" + "tipus=" + tipus 
                + ", illetek=" + illetek 
                + ", koltseg=" + koltseg + '}';
    }

    
    
   
}