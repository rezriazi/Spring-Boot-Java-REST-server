package com.usm.usmobile.repository;

import com.usm.usmobile.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}