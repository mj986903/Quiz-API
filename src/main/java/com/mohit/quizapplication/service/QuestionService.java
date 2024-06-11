package com.mohit.quizapplication.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mohit.quizapplication.dao.QuestionDao;
import com.mohit.quizapplication.dao.QuizDao;
import com.mohit.quizapplication.model.Question;
import com.mohit.quizapplication.model.Quiz;

@Service
public class QuestionService {

	@Autowired
	QuestionDao questionDao;
	
	@Autowired
	QuizDao quizDao;
	
	public ResponseEntity<List<Question>> getAllQuestions() {
		try {
			return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
		try {
			return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Question question) {
		try {
			questionDao.save(question);
			return new ResponseEntity<>("Question Added Succesfully.",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Question Added Unsuccesfully.",HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> updateOrAddQuestion(Question question) {
		try {
			questionDao.save(question);
			return new ResponseEntity<>("Question Updated Succesfully.",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Question Updated Unsuccesfully.",HttpStatus.BAD_REQUEST);
	}
}