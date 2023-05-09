package com.quizpro.quizpro.controllers;

import com.quizpro.quizpro.entities.Results;
import com.quizpro.quizpro.models.TotalQuestionsOkModel;
import com.quizpro.quizpro.services.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    @Autowired
    private ResultsService resultsService;

    @GetMapping("/get/{id}")
    public ResponseEntity<Results> getResult(@PathVariable long id) {
        try {
            return new ResponseEntity<>(resultsService.getResultQuestion(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Results> postResult(@RequestBody Results result) {
        return new ResponseEntity<>(resultsService.saveResultQuestion(result), HttpStatus.CREATED);
    }

    @GetMapping("/getTotalAnswerOK")
    public ResponseEntity<TotalQuestionsOkModel> getTotalQuestionsOk(@RequestBody Results results) {
        try {
            return new ResponseEntity<>(resultsService.getTotalQuestionsOk(results.getUser().getId(), results.getQuestion().getId()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
