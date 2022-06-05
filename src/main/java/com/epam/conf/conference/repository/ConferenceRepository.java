package com.epam.conf.conference.repository;

import com.epam.conf.conference.entity.Conference;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRepository extends CrudRepository<Conference, Long> {
    @Query(value = "SELECT c FROM Conference c")
    Iterable<Conference> findAll(Sort sort);
}
