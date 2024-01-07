package com.revision.helper.service;


import com.revision.helper.dao.RevisionRepository;
import com.revision.helper.model.RevisionRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class RevisionService {

    @Autowired
    private RevisionRepository repository;

    private static final Logger logger = LoggerFactory.getLogger(RevisionService.class);

    public List<RevisionRequest> getQuestion(String topic, String tags) {
        logger.debug("Control reached to service layer, fetching questions from dB...");
        List<RevisionRequest> questions = repository.findByTopic(topic);
        return questions.stream().filter(tag -> tag.getTags().contains(tags)).collect(Collectors.toList());
    }

    public RevisionRequest addQuestion(RevisionRequest request) {
        logger.debug("Control reached to service layer, persisting changes to dB...");
        return repository.save(request);
    }
}
