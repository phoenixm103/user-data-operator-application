package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.Child;

public interface ChildRepository extends MongoRepository<Child, String> {

}
