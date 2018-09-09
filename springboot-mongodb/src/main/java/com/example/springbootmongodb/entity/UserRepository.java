package com.example.springbootmongodb.entity;


import org.springframework.data.mongodb.repository.MongoRepository;

//import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends MongoRepository<User, Long> {

    User findByUsername(String username);

    User findByid(Long id);

}
