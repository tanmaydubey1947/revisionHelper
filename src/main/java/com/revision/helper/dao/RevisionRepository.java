package com.revision.helper.dao;

import com.revision.helper.model.RevisionRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RevisionRepository extends JpaRepository<RevisionRequest, Integer> {
}
