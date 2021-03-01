package com.example.batchtxttomongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.batchtxttomongodb.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {
    
}