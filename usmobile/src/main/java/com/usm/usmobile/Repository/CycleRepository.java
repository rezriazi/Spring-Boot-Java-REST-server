package com.usm.usmobile.repository;

import com.usm.usmobile.model.Cycle;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface CycleRepository extends MongoRepository<Cycle, String> {
    List<Cycle> findByMdn(String mdn);
}