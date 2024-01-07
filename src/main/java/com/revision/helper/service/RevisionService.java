package com.revision.helper.service;


import com.revision.helper.dao.RevisionRepository;
import com.revision.helper.model.RevisionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RevisionService {

    @Autowired
    private RevisionRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(RevisionService.class);

    public RevisionRequest getQuestion(Integer questionId) {
        logger.debug("Control reached to service layer, fetching questions from dB...");
        return repository.findById(questionId).get();
    }

    public RevisionRequest addQuestion(RevisionRequest request) {
        logger.debug("Control reached to service layer, persisting changes to dB...");
        return repository.save(request);
    }
}
