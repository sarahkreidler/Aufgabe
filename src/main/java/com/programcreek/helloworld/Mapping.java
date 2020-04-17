package com.programcreek.helloworld;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Mapping {
    @Id
    @GeneratedValue
    private String isin;
    private String tradeid;

    public Mapping(String isin, String tradeid) {
        this.isin = isin;
        this.tradeid = tradeid;
    }
    public String getisin() {
        return isin;
    }

    public String gettradeid() {
        return tradeid;
    }


    @Override
    public String toString() {
        return "isin: " + isin + ", tradeid: " + tradeid;
    }


}