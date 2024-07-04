package com.usm.usmobile.repository;

import com.usm.usmobile.model.DailyUsage;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface DailyUsageRepository extends MongoRepository<DailyUsage, String> {
    List<DailyUsage> findByMdnAndUserId(String mdn, String userId);
}