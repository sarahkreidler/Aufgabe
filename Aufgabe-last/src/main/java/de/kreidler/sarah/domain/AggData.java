package de.kreidler.sarah.domain;

import javax.persistence.*;

@Entity
public class AggData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    //SK
    //private String tradeid;
    private String STATS;
    private String isin;
    private int stat;

    public AggData() {
    }

    public AggData(String STATS, String isin, int stat) {
        //SK:
        //this.tradeid = tradeid;
        this.STATS = STATS;
        this.isin = isin;
        this.stat = stat;
    }

}