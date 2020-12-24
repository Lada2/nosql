package com.nosql.lada.SQLEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Company {
    @Id
    private String id;
    @Column(name = "companyName", nullable = false)
    private String companyName;

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNumber")
    private Integer phoneNumber;

    @Column(name = "manager")
    private String manager;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<Vehicle> vehicles;

    public Company() {
        this.companyName="Хлеб завод";
    }

    public Company(String id, String companyName, String address, Integer phoneNumber, String manager) {
        this.id = id;
        this.companyName = companyName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.manager = manager;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id='" + id + '\'' +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", manager='" + manager + '\'' +
                '}';
    }
}

