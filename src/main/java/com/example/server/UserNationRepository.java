package com.example.server;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserNationRepository extends MongoRepository<UserNation, Integer> {

    Optional<UserNation> getById(Integer id);
}
