/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaction;

import Clients.Client;

/**
 *
 * @author FZs
 */
class Crediting extends Transaction {

    private final double rateOfCostCrediting = 0.03;
    private final double rateOfDutyCrediting = 0.003;
    private final TransactionType TYPE = TransactionType.CREDITING;

    Crediting(int amount, Client client) {
        super(amount, client);
        this.rateOfCost = rateOfCostCrediting;
        this.rateOfDuty = rateOfDutyCrediting;
        this.cost = setCost();
        this.duty = setDuty();
        this.allDeduction = this.cost + this.duty;
        this.type = TYPE;
    }

    @Override
    public void transaction() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Crediting " + super.toString();
    }

}
