package com.Order.ApOrder.theModel.Entity;

import com.Order.ApOrder.theModel.Entity.interfac.Bank;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="banc")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Banc implements Bank {

    @Id
    @Getter
    private Long id;


    @Override
    public String getBankName() {
        return "";
    }

    @Override
    public String getBankAccount() {
        return "";
    }

    @Override
    public String getIBAN() {
        return "";
    }

    @Override
    public String getSWIFT() {
        return "";
    }

    @Override
    public float getBalance() {
        return 0;
    }

    @Override
    public void setBalance(float amount) {

    }

    @Override
    public float getAvailableBalance() {
        return 0;
    }

    @Override
    public void setAvailableBalance(float amount) {

    }

    @Override
    public void withdraw(float amount) {

    }

    @Override
    public float pull() {
        return 0;
    }

    @Override
    public void push(float amount) {

    }
}
