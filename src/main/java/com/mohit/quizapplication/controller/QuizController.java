package com.mohit.quizapplication.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.quizapplication.model.Question;
import com.mohit.quizapplication.model.QuestionWrapper;
import com.mohit.quizapplication.model.Quiz;
import com.mohit.quizapplication.model.Response;
import com.mohit.quizapplication.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	@Autowired
	QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category,@RequestParam int noOfQuestion,@RequestParam String title){
		return quizService.createQuiz(category,noOfQuestion,title);
	}
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
		return quizService.getQuiz(id);
	}
	
	@GetMapping("submit/{id}")
	public ResponseEntity<String> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
		return quizService.submitQuiz(id,responses);
	}
	
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> deleteQuiz(@PathVariable Integer id){
		return quizService.deleteQuiz(id);
	}
}