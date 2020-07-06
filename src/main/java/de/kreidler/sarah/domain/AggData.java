package de.kreidler.sarah.domain;

import javax.persistence.*;

@Entity
public class AggData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String tradeid;
    private String isin;
    private double mean;
    //Sarah: noch nicht vollständig zunächst auf Mean beschränkt

    public AggData() {
    }

    public AggData(String tradeid, String isin, double mean) {
        this.tradeid = tradeid;
        this.isin = isin;
        this.mean = mean;
    }
}