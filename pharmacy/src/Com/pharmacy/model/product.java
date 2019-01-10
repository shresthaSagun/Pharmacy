/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Com.pharmacy.model;

import java.sql.Date;


/**
 *
 * @author Sushil Shrestha
 */
public class product {
    private int id;
    private String name;
    private int qty;
    private double rate;
    private String exp_year;
    private String exp_month;
    private int sample_month;
    private double amount;
    private int soldno;
    private int SN;

    public int getSN() {
        return SN;
    }

    public void setSN(int SN) {
        this.SN = SN;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getSoldno() {
        return soldno;
    }

    public void setSoldno(int soldno) {
        this.soldno = soldno;
    }
    
    public String getExp_year() {
        return exp_year;
    }

    public int getSample_month() {
        return sample_month;
    }

    public void setSample_month(int sample_month) {
        this.sample_month = sample_month;
    }

    public void setExp_year(String exp_year) {
        this.exp_year = exp_year;
    }

    public String getExp_month() {
        return exp_month;
    }

    public void setExp_month(String exp_month) {
        this.exp_month = exp_month;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    
}
