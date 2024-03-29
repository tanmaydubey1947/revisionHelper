package com.revision.helper.controller;


import com.revision.helper.model.exchange.AddTopic;
import com.revision.helper.model.exchange.RevisionRequest;
import com.revision.helper.service.RevisionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class RevisionController {

    @Autowired
    private RevisionService service;

    private static final Logger logger = LoggerFactory.getLogger(RevisionController.class);


    @GetMapping("/getQuestion/{topic}/{tags}")
    public List<RevisionRequest> getQuestion(@PathVariable("topic") String topic, @PathVariable("tags") String tags) {
        List<RevisionRequest> response = service.getQuestion(topic, tags);
        logger.debug("Fetched question sending back the response...");
        return response;
    }

    @PostMapping("/addQuestion")
    public RevisionRequest addQuestion(@RequestBody RevisionRequest request) {
        RevisionRequest response = service.addQuestion(request);
        logger.debug("Question added successfully...");
        return response;
    }

    @PostMapping("/addTopic")
    public String addTopic(@RequestBody AddTopic topic) {
        service.addTopic(topic);
        return "Added Topic Successfully...";
    }

    @GetMapping("/getAllTopic")
    public List<String> getAllQuestion(){
        return service.getAllTopic();
    }

    @GetMapping("/getTagsByTopic/{topic}")
    public List<String> getTagsByTopic(@PathVariable("topic") String topic){
        return service.getTagsByTopic(topic);
    }


}
