/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaction;

import Clients.Client;
import Interface.ITransactions;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author FZs
 */
public abstract class Transaction implements ITransactions {

    protected final Client client;
    protected final int AMOUNT;
    protected final String DATE;

    protected TransactionType type;
    protected double cost;
    protected double duty;
    protected double allDeduction;
    protected double rateOfCost;
    protected double rateOfDuty;
    protected TransactionCondition condition;

    public Transaction(int amount, Client client) {
        this.DATE = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.AMOUNT = amount;
        this.client = client;

    }

    public String getDate() {
        String result = DATE;
        return result;
    }

    public int getAmount() {
        int result = AMOUNT;
        return result;
    }

    public double getCost() {
        double result = cost;
        return result;
    }

    public double getDuty() {
        double result = duty;
        return result;
    }

    public TransactionType getType() {
        return type;
    }

    public Client getClient() {
        return client;
    }

    public TransactionCondition getCondition() {
        return condition;
    }

    public void setCondition(TransactionCondition condition) {
        this.condition = condition;
    }
    
    protected double setCost() {
        return AMOUNT * rateOfCost;
    }

    protected double setDuty() {
        return AMOUNT * rateOfDuty;
    }

    public double getAllDeduction() {
        return allDeduction;
    }

    @Override
    public String toString() {
        return "Transaction {condition= " + condition + " client=" + client 
                + ", AMOUNT=" + AMOUNT + ", DATE=" + DATE + ", type=" + type 
                + ", cost=" + cost + ", duty=" + duty + ", allDeduction=" + allDeduction + '}';
    }

        
}
