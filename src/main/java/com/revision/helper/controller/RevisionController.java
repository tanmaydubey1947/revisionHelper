package com.revision.helper.controller;


import com.revision.helper.model.RevisionRequest;
import com.revision.helper.service.RevisionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
public class RevisionController {

    @Autowired
    private RevisionService service;

    private static final Logger logger = LoggerFactory.getLogger(RevisionController.class);


    @GetMapping("/getQuestion/{id}")
    public RevisionRequest getQuestion(@PathVariable("id") Integer questionId) {
        RevisionRequest response = service.getQuestion(questionId);
        logger.debug("Fetched question sending back the response...");
        return response;
    }

    @PostMapping("/addQuestion")
    public RevisionRequest addQuestion(@RequestBody RevisionRequest request) {
        RevisionRequest response = service.addQuestion(request);
        logger.debug("Question added successfully...");
        return response;
    }

}
