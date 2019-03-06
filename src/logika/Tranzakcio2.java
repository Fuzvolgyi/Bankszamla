/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logika;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author FZs
 */
public abstract class Tranzakcio2 {

    
    private int id = 0;
    private String inditoSzemely;
    private int osszeg;
//    private LocalDate inditas;

    public Tranzakcio2(String inditoSzemely, int osszeg) {
        this.id = getId();
        this.inditoSzemely = inditoSzemely;
        this.osszeg = osszeg;
        
        
    }
    
    public int getId() {
        id++;  
        return id;
    }

    public String getInditoSzemely() {
        return inditoSzemely;
    }

    public int getOsszeg() {
        return osszeg;
    }
    
    public void trancakcioIndit(){
        }

    @Override
    public String toString() {
        return "Tranzakcio2{" + "id=" + id + ", inditoSzemely=" + inditoSzemely + ", osszeg=" + osszeg + '}';
    }

    

    
 

    

}
