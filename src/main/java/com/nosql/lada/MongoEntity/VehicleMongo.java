package com.nosql.lada.MongoEntity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "Vehicle")
public class VehicleMongo {
    @Id
    private String id;

    @Indexed(name = "tittle",unique = true)
    @Field(name = "name")
    private String name;

    @Indexed(name = "tittle",unique = false)
    @Field(name = "price")
    private Double price;

    @Field(name = "color")
    private String color;
    @Field(name = "mileage")
    private Double mileage;

    @Field(name = "manufacture_year")
    private Integer manufactureYear;

    @Field(name = "brand")
    private BrandMongo brandMongo;

    @Field(name = "company")
    private CompanyMongo companyMongo;

    @Field(name = "form")
    private FormMongo formMongo;

    public VehicleMongo(String id, String name, Double price, String color, Double mileage, Integer manufactureYear, BrandMongo brandMongo, CompanyMongo companyMongo, FormMongo formMongo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.color = color;
        this.mileage = mileage;
        this.manufactureYear = manufactureYear;
        this.brandMongo = brandMongo;
        this.companyMongo = companyMongo;
        this.formMongo = formMongo;
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

    public BrandMongo getBrandMongo() {
        return brandMongo;
    }

    public void setBrandMongo(BrandMongo brandMongo) {
        this.brandMongo = brandMongo;
    }

    public CompanyMongo getCompanyMongo() {
        return companyMongo;
    }

    public void setCompanyMongo(CompanyMongo companyMongo) {
        this.companyMongo = companyMongo;
    }

    public FormMongo getFormMongo() {
        return formMongo;
    }

    public void setFormMongo(FormMongo formMongo) {
        this.formMongo = formMongo;
    }

    @Override
    public String toString() {
        return "VehicleMongo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", mileage=" + mileage +
                ", manufactureYear=" + manufactureYear +
                ", brandMongo=" + brandMongo +
                ", companyMongo=" + companyMongo +
                ", formMongo=" + formMongo +
                '}';
    }
}