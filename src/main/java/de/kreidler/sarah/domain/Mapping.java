package de.kreidler.sarah.domain;

import javax.persistence.*;

@Entity
public class Mapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    String isin;
    String tradeId;

    public Mapping() {
    }

    public Mapping(String isin, String tradeId) {
        this.isin = isin;
        this.tradeId = tradeId;
    }
}
