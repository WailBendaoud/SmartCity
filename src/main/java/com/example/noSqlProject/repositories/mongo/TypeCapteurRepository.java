package com.example.noSqlProject.repositories.mongo;

import com.example.noSqlProject.entities.mongo.TypeCapteur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCapteurRepository extends MongoRepository<TypeCapteur,String> {
}
