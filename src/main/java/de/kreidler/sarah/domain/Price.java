package de.kreidler.sarah.domain;

import javax.persistence.*;

@Entity
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    //Sarah: Workaround: Date zunächst als String gesetzt, passendes Datumsformat noch finden
    private String date;
    private String isin;
    private double price;

    public Price() {
    }

    public Price(String date, String isin, double price) {
        this.date = date;
        this.isin = isin;
        this.price = price;
    }
}