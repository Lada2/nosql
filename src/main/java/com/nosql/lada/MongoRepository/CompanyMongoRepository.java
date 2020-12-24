package com.nosql.lada.MongoRepository;


import com.nosql.lada.MongoEntity.CompanyMongo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CompanyMongoRepository extends MongoRepository<CompanyMongo, ObjectId> {

    Optional<CompanyMongo> findFirstByCompanyName(String name);

    @Aggregation("{ '$project': { '_id' : '$manager' } },{ $group: {_id : $manager } }")
    List<String> findAllManager();



}
