/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaction;

import Interface.ITransactions;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author FZs
 */
public abstract class Transaction implements ITransactions {

    protected final int AMOUNT;
    protected final String DATE;

    protected TransactionType type;
    protected double cost;
    protected double duty;
    protected double rateOfCost;
    protected double rateOfDuty;
//    private Owner entrusting;

    public Transaction(int amount) {
        this.DATE = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        this.AMOUNT = amount;

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

    protected double setCost() {
        return AMOUNT * rateOfCost;
    }

    protected double setDuty() {
        return AMOUNT * rateOfDuty;
    }

    @Override
    public String toString() {
        return "Transaction{" + "AMOUNT=" + AMOUNT + ", COST=" + cost + ", DUTY=" + duty + ", DATE=" + DATE + '}';
    }

}
