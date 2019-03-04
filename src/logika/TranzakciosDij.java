/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package logika;

import java.util.ArrayList;

/**
 *
 * @author FZs
 */
public abstract class TranzakciosDij {
    
    private static double tranzakcioKöltseg = 0.05;

//    private TranzakcioTípus tipus;
//    private String tranzakcioInditiNev;
    
    
    
    
    
    public static int tranzakcioDij(int osszeg){
        double szam = osszeg * tranzakcioKöltseg;
        return (int)szam;
    }
    
    
    
}
