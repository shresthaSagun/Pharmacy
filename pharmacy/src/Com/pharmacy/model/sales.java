/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Com.pharmacy.model;

import java.util.Date;

/**
 *
 * @author Sushil Shrestha
 */
public class sales {
    private int sn;
    private int billno;
    private String item;
    private int qtysold;
    private String exp_month;
    private String exp_year;
    private double rate;
    private double amount;
    private  Date dos;

    public Date getDos() {
        return dos;
    }

    public void setDos(Date dos) {
        this.dos = dos;
    }
    

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public int getBillno() {
        return billno;
    }

    public void setBillno(int billno) {
        this.billno = billno;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public int getQtysold() {
        return qtysold;
    }

    public void setQtysold(int qtysold) {
        this.qtysold = qtysold;
    }

    public String getExp_month() {
        return exp_month;
    }

    public void setExp_month(String exp_month) {
        this.exp_month = exp_month;
    }

    public String getExp_year() {
        return exp_year;
    }

    public void setExp_year(String exp_year) {
        this.exp_year = exp_year;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    
}
