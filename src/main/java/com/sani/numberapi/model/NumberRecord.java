package com.sani.numberapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NumberRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int number;
    private boolean even;
    private int square;
    private boolean prime;
    private String range;

    public NumberRecord() {}

    public NumberRecord(int number, boolean even, int square, boolean prime, String range) {

        this.number = number;
        this.even = even;
        this.square = square;
        this.prime = prime;
        this.range = range;
    }
    
    public long getId() { return id; }
    public int getNunber() { return number; }
    public boolean getEven() { return even; }
    public int getSquare() { return square; }
    public boolean getPrime() { return prime; }
    public String getRange() { return range; }

    public void setNumber(int number) { this.number = number; }
    public void setEven(boolean even) { this.even = even; }
    public void setSquare(int square) { this.square = square; }
    public void setPrime(boolean prime) { this.prime = prime; }
    public void setRange(String range) { this.range = range;}
}