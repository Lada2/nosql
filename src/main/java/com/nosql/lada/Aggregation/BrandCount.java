package com.nosql.lada.Aggregation;

import org.springframework.data.annotation.Id;

public class BrandCount {
    @Id
    String country;
    int count;

    public BrandCount(String country, int count) {
        this.country = country;
        this.count = count;
    }

    @Override
    public String toString() {
        return "BrandCount{" +
                "country='" + country + '\'' +
                ", count=" + count +
                '}';
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
