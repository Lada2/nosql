package com.nosql.lada.MongoRepository;

import com.nosql.lada.Aggregation.BrandCount;
import com.nosql.lada.MongoEntity.BrandMongo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface BrandMongoRepository extends MongoRepository<BrandMongo, ObjectId> {
   Optional<BrandMongo> findFirstByName(String name);

   @Aggregation("{ $group: {_id : $country, count  : {$sum : 1}  } }")
   List<BrandCount> countAllByCountry();

   @Aggregation(pipeline ={"{$match:{ popularity:{$gt:1500000}}}","{ $group: {_id : $country, count  : {$sum : 1}  } }" })
   List<BrandCount> countAllByCountryAndPopularityGreaterThan();

   @Aggregation("{$match: { 'country':'Германия' }}")
   List<BrandMongo> matchCountry();

   List<BrandMongo> findAllByCountry(String country);

   @Aggregation("{$match: { 'popularity':{$gt:1000} }}")
   List<BrandMongo> matchPopularityGreaterThan();

   List<BrandMongo> findAllByPopularityGreaterThan(Integer popularity);

}
