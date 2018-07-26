package com.qa.persistence.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.qa.persistence.domain.*;

@Repository
public interface TrainerRepository extends ElasticsearchRepository<Trainer, Integer> {

}
