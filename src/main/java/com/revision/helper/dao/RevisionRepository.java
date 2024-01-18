package com.revision.helper.dao;

import com.revision.helper.model.exchange.RevisionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RevisionRepository extends JpaRepository<RevisionRequest, Integer> {

    @Query(value = "SELECT * FROM revision_request WHERE topic = ?1", nativeQuery = true)
    List<RevisionRequest> findByTopic(String topic);
}
