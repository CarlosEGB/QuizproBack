package com.quizpro.quizpro.controllers;

import com.quizpro.quizpro.entities.Questions;
import com.quizpro.quizpro.exceptions.ApiResponse;
import com.quizpro.quizpro.repositorios.IAnswer;
import com.quizpro.quizpro.repositorios.IQuestion;
import com.quizpro.quizpro.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
@CrossOrigin(origins = "http://localhost:5173")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @Autowired
    private IAnswer iAnswer;

    @Autowired
    private IQuestion iQuestion;

    @GetMapping("/get/{id}")
    public ResponseEntity<Questions> getQuestion(@PathVariable long id) {
        try {
            return new ResponseEntity<>(questionService.getQuestion(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<List<Questions>> getAllQuestion() {
        return new ResponseEntity<>(questionService.getAllQuestions(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Questions> saveQuestionService(@RequestBody Questions question) {
        return new ResponseEntity<>(questionService.addQuestion(question), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Questions> updateQuestion(@RequestBody Questions question) {
        if (iQuestion.findById(question.getId()).isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(questionService.updateQuestion(question), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteQuestion(@PathVariable Long id) {

        try {
            if (iQuestion.findById(id).isEmpty()) {
                return new ResponseEntity<>(new ApiResponse(false, "Pregunta no encontrada", id), HttpStatus.NOT_FOUND);
            }
            questionService.deleteQuestion(id);
            return new ResponseEntity<>(new ApiResponse(true, "Pregunta eliminada con éxito", id), HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(new ApiResponse(false, "Error al eliminar pregunta: " + ex.getMessage(), id), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
