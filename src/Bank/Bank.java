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
package Bank;

import Clients.Client;
import Clients.ClientFactory;
import Transaction.Transaction;
import Transaction.TransactionFactory;
import Transaction.TransactionType;

/**
 *
 * @author FZs
 */
public class Bank {

    public static void main(String[] args) {
        TransactionFactory transactionFactory = new TransactionFactory();

        Transaction transaction1 = transactionFactory.getTransaction(TransactionType.CREDITING, 100);

        System.out.println(transaction1);
        
        ClientFactory clientFactory = new ClientFactory();
        
        Client Client1 = clientFactory.getClient("Géza", "Gizi");
        
        System.out.println(Client1);

    }

}
