package com.sabanciuniv.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.sabanciuniv.model.*;

import java.util.Optional;

public interface StorageRepository extends MongoRepository<ImageData,String> {


    Optional<ImageData> findByName(String fileName);
}