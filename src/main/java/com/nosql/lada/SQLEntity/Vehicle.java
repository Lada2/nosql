package com.nosql.lada.SQLEntity;

import javax.persistence.*;

@Entity
@Table(name = "Vehicle",
        indexes = {@Index(name = "index_name",  columnList="name", unique = true),
                @Index(name = "index_price", columnList="price", unique = false)})
public class Vehicle {
    @Id
    private String id;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "color", nullable = false)
    private String color;
    @Column(name = "mileage")
    private Double mileage;

    @Column(name = "manufacture_year", nullable = false)
    private Integer manufactureYear;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand = new Brand();

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company= new Company();

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "form_id", nullable = false)
    private Form form = new Form();

    public Vehicle(String id, String name, Double price, String color, Double mileage, Integer manufactureYear, Brand brand, Company company, Form form) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.mileage = mileage;
        this.manufactureYear = manufactureYear;
        this.brand = brand;
        this.company = company;
        this.form = form;
    }

    public Vehicle() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Double getMileage() {
        return mileage;
    }

    public void setMileage(Double mileage) {
        this.mileage = mileage;
    }

    public Integer getManufactureYear() {
        return manufactureYear;
    }

    public void setManufactureYear(Integer manufactureYear) {
        this.manufactureYear = manufactureYear;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", mileage=" + mileage +
                ", manufactureYear=" + manufactureYear +
                ", brand=" + brand.toString() +
                ", company=" + company.toString() +
                ", form=" + form.toString() +
                '}';
    }
}

