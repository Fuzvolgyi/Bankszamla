/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Interface;

import Clients.Client;
import Transaction.Transaction;

/**
 *
 * @author FZs
 */
public interface TransactionItem {
    public Client client();
    public Transaction transction();
}
