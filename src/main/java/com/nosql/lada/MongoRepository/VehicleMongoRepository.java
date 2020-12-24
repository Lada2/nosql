package com.nosql.lada.MongoRepository;

import com.nosql.lada.MongoEntity.VehicleMongo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleMongoRepository extends MongoRepository<VehicleMongo, ObjectId> , VehicleCustomRepository{

    List<VehicleMongo> findAllByName(String name);
    List<VehicleMongo> findAllByPriceGreaterThanEqual(Double price);

    void deleteAllByName(String name);

      Optional<VehicleMongo> findFirstByName(String name);
}
