package com.nosql.lada.MongoEntity;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.annotation.Id;

@Document(collection = "Brand")
public class BrandMongo {
    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "description")
    private String description;

    @Field(name = "country")
    private String country;

    @Field(name = "popularity")
    private Integer popularity;

       public BrandMongo() {
        this.name="Porshe";
        this.description= "";
        this.country=" Ukraine";
    }

    public BrandMongo(String id, String name, String description, String country, Integer popularity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.country = country;
        this.popularity = popularity;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPopularity() {
        return popularity;
    }

    public void setPopularity(Integer popularity) {
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return "BrandMongo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", popularity=" + popularity +
                '}';
    }
}


