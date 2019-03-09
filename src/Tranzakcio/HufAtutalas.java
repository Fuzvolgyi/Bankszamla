/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tranzakcio;

import Szamla.BankSzamla;

/**
 *
 * @author FZs
 */
public class HufAtutalas extends Megbizas implements Tranzakcio{

    private tipus tipus; 
    private double tranzakciosDij = 0.05;
    private double illetek = 0.003;
    private int koltseg;
    
    
    public HufAtutalas(String inditoSzemely, int osszeg) {                      // megbízás példánya
        super(inditoSzemely, osszeg);
        this.tipus = tipus.HUF_ATUTALAS;
        this.koltseg = getKoltseg(osszeg);
        this.illetek = getIlletek(osszeg);
    }

    public void utalasIndit(HufAtutalas megbizas, BankSzamla szamla) {          //megbízás metodusa
        if (szamla.tulajEllenorzes(this.getInditoSzemely(), szamla)) {
            if (this.getOsszeg() > 0) {
                egyenlegNovekszik(megbizas, szamla);
                szamla.addTortenet(megbizas);
            } else {
                System.out.println("Nullánál nagyobb összegel lehet tranzakciót indítani");
            }
        }else{
            System.out.println("Csak számlatulajdonos indíthat tranzakciót");
        }
    }
    
    public void egyenlegNovekszik(HufAtutalas megbizas, BankSzamla szamla) {
        System.out.println("Utal ");
        szamla.setEgyenleg(szamla.getEgyenleg() + megbizas.getOsszeg() - megbizas.koltseg);
        
    }
    
    private int getKoltseg(int osszeg) {
        double szam = osszeg * tranzakciosDij + getIlletek(osszeg);
        return (int)szam;
    }

    private double getIlletek(int osszeg) {
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