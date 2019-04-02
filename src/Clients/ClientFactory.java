/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Clients;

import ItemLists.ClientList;

/**
 *
 * @author FZs
 */
public class ClientFactory {
    public Client getClient(String name, String motherName){
        Client result = new Client(name, motherName);
        ClientList.addClient(result);
        return result;
    }
    
}
