/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clients;

/**
 *
 * @author FZs
 */
public class ClientFactory {
    public Client getClient(String name, String city){
        return new Client(name, city);
    }
    
}
