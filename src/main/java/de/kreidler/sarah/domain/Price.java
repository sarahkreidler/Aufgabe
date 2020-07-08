package de.kreidler.sarah.domain;

import javax.persistence.*;

@Entity
public class Price implements Comparable<Price>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String date;
    private String isin;
    private int price;

    public Price() {
    }

    public Price(String date, String isin, int price) {
        this.date = date;
        this.isin = isin;
        this.price = price;
    }

    public String getisin() {

        return isin;
    }
    public int getPrice() {
        return price;
    }
    public int compareTo(Price comparePrice){
        int comparePrices = ((Price) comparePrice).getPrice();
        //SK: ascending order
        return this.price - comparePrices;
    }

}