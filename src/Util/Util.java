/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import Clients.Client;
import java.util.List;

/**
 *
 * @author FZs
 */
public class Util {

public static boolean isExistingClient(List<Client> list, Client client) {
        boolean validName = false;
        boolean validMotherName = false;
        String name = client.getName();
        String motherName = client.getMotherName();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equalsIgnoreCase(name)) {
                validName = true;
            }
            if (validName == true
                    && list.get(i).getMotherName().equalsIgnoreCase(motherName)) {
                validMotherName = true;
            }
        }
        return validName && validMotherName;
        
    }    
    
}
