package com.example.noSqlProject.repositories;

import com.example.noSqlProject.entities.TypeCapteur;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeCapteurRepository extends MongoRepository<TypeCapteur,String> {
}
