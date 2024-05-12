package com.Order.ApOrder.theModel.Entity.interfac;

public interface Bank {

    public String getBankName();
    public String getBankAccount();
    public String getIBAN();
    public String getSWIFT();
    public float getBalance();
    public void setBalance(float amount);
    public float getAvailableBalance();
    public void setAvailableBalance(float amount);
    public void withdraw(float amount);
    public float pull();
    public void push(float amount);

}
