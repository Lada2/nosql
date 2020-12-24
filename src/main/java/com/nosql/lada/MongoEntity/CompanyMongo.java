package com.nosql.lada.MongoEntity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Company")
public class CompanyMongo {
    @Id
    private String id;

    @Field(name = "companyName")
    private String companyName;

    @Field(name = "address")
    private String address;

    @Field(name = "phoneNumber")
    private Integer phoneNumber;

    @Field(name = "manager")
    private String manager;


    public CompanyMongo() {
        this.companyName="Хлеб завод";
    }

    public CompanyMongo(String id, String companyName, String address, Integer phoneNumber, String manager) {
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

    @Override
    public String toString() {
        return "CompanyMongo{" +
                "id='" + id + '\'' +
                ", companyName='" + companyName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", manager='" + manager + '\'' +
                '}';
    }
}