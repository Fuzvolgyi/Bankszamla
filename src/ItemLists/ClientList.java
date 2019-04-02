/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ItemLists;

import Clients.Client;
import Util.Util;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FZs
 */
public class ClientList {

    private static List<Client> clientList = new ArrayList<>();

    

    private ClientList() {

    }

    public static void addClient(Client item) {
        if (!Util.isExistingClient(clientList, item)) {
            clientList.add(item);
        }
        
    }

    
    public static List<Client> getClientList() {   
        List<Client> result = new ArrayList<>();
        for (Client client : clientList) {
            result.add(client);
        }
        return result;
    }

    public static void showClientList() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ügyfelek listája:")
                .append(System.lineSeparator());
        for (Client client : clientList) {
            sb.append(clientList.indexOf(client) + 1)
                    .append(". Ügyfélnév: ")
                    .append(client.getName())
                    .append(", Anyja neve: ")
                    .append(client.getMotherName())
                    .append(System.lineSeparator());
        }
        System.out.println(sb);
    }

}
