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

import BankAccount.BankAccount;
import BankAccount.BankAccountBuilder;
import Clients.Client;
import Clients.ClientFactory;
import ItemLists.BankAccountList;
import ItemLists.ClientList;
import ItemLists.TransactionItemList;
import Transaction.Transaction;
import Transaction.TransactionFactory;
import Transaction.TransactionType;
import TransactionStart.TransactionStartFactory;

/**
 *
 * @author FZs
 */
public class Bank {

    public static void main(String[] args) {

        ClientFactory clientFactory = new ClientFactory();
        TransactionFactory transactionFactory = new TransactionFactory();
        BankAccountBuilder accountBuilder = new BankAccountBuilder();
        TransactionStartFactory start = new TransactionStartFactory();

        Client client1 = clientFactory.getClient("Géza", "Gizi");
        Client client2 = clientFactory.getClient("Józsi", "Etelka");
        Client client3 = clientFactory.getClient("Pista", "Juli");
        Client client4 = clientFactory.getClient("Gizi", "Noémi");
        Client client5 = clientFactory.getClient("Jolán", "Csilla");
        Client client6 = clientFactory.getClient("Pista", "Juli");
        Client client7 = clientFactory.getClient("Gizi", "Noémi");

        BankAccount account1 = accountBuilder.getBankAccount(client1);
        accountBuilder.showAccount(account1);

        BankAccount account2 = accountBuilder.getBankAccount(client4);
        accountBuilder.showAccount(account2);

        BankAccount account3 = accountBuilder.getBankAccount(client7);
        accountBuilder.showAccount(account2);

        Transaction transaction1 = transactionFactory.getTransaction(TransactionType.CREDITING, 100, client1);
        start.getTransactionValid(account1, transaction1);

        Transaction transaction2 = transactionFactory.getTransaction(TransactionType.HUF_TRANSFER, 70, client1);
        start.getTransactionValid(account1, transaction2);

        Transaction transaction3 = transactionFactory.getTransaction(TransactionType.HUF_TRANSFER, 70, client2);

        account1.showOwnerList();
        
        account1.addOwnerList(client2);
        account1.addOwnerList(client5);
         account1.showOwnerList();
         
        account1.addOwnerList(client7);
        account1.addOwnerList(client7);
        account1.takeOutOwnerList(client2);
         account1.showOwnerList();
         
        account1.addOwnerList(client4);
        account1.addOwnerList(client7);
        
        account1.showOwnerList();

        start.getTransactionValid(account1, transaction3);

        //kiiratás
        ClientList.showClientList();

        TransactionItemList.showTransactionItems();

        BankAccountList.showBankAccountList();
    }

}
