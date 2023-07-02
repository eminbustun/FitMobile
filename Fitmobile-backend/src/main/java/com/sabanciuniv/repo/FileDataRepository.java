package com.sabanciuniv.repo;


import com.sabanciuniv.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface FileDataRepository extends MongoRepository<FileData,String> {
    Optional<FileData> findByName(String fileName);
}