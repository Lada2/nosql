package com.nosql.lada.MongoRepository;

import com.nosql.lada.MongoEntity.FormMongo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FormMongoRepository extends MongoRepository<FormMongo, ObjectId> {

    Optional<FormMongo> findFirstByName(String name);
}
