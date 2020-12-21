package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Parent;

public interface ParentRepository extends MongoRepository<Parent, String> {

}
