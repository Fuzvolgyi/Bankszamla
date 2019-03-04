/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bank_0303;

import logika.BankSzamla;

/**
 *
 * @author FZs
 */
public class Bank_0303 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        BankSzamla szamla1 = new BankSzamla("Béla");
              
        
        System.out.println(szamla1);
        szamla1.betet(150);
        System.out.println(szamla1);
        szamla1.kivet(50);
        System.out.println(szamla1);
        System.out.println(szamla1.getTulajdonosok());
        szamla1.kivet(50);
        szamla1.tulajdonosHozzaad("Géza");
        System.out.println(szamla1);
        
        szamla1.tulajdonosHozzaad("Juli");
        System.out.println(szamla1);
        
        szamla1.tulajdonosTorol("Géza");
        System.out.println(szamla1);
        
        szamla1.tulajdonosTorol("Juli");
        System.out.println(szamla1);
        
        szamla1.tulajdonosTorol("Bela");
        System.out.println(szamla1);
        
        
        System.out.println("Összes tranzakciós díj: " 
                + szamla1.osszTranzakciosDij() + " Ft" );
        
    }
    
}
