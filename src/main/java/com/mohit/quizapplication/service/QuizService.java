package com.mohit.quizapplication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mohit.quizapplication.dao.QuestionDao;
import com.mohit.quizapplication.dao.QuizDao;
import com.mohit.quizapplication.model.Question;
import com.mohit.quizapplication.model.QuestionWrapper;
import com.mohit.quizapplication.model.Quiz;
import com.mohit.quizapplication.model.Response;

@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int noOfQuestion, String title) {
		try {
			List<Question> questions = questionDao.findRandomQuestionByCategory(category,noOfQuestion);
			Quiz quiz = new Quiz();
			quiz.setTitle(title);
			quiz.setQuestions(questions);
			quizDao.save(quiz);
			
			return new ResponseEntity<>("Quiz Created Succesfully. \nYour Quiz ID : " + quiz.getId(),HttpStatus.CREATED);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Quiz Created Unsuccesfully.",HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuiz(int id) {
		try {
			Optional<Quiz> quiz = quizDao.findById(id);
			List<Question> questions = quiz.get().getQuestions();
			List<QuestionWrapper> finalQuestions = new ArrayList<>();
			for(Question q : questions) {
				QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
				finalQuestions.add(qw);
			}
			return new ResponseEntity<>(finalQuestions,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> submitQuiz(Integer id, List<Response> responses) {
		try {
			Quiz quiz = quizDao.findById(id).get();
			List<Question> questions = quiz.getQuestions();
			int right = 0;
			int i = 0;
			for(Response response : responses) {
				if(response.getResponse().equals(questions.get(i).getRightAnswer())) {
					right++;
				}
				i++;
			}
			return new ResponseEntity<>("Your Score : " + right,HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Your Score : 0" ,HttpStatus.OK);
	}

	public ResponseEntity<String> deleteQuiz(Integer id) {
		try {
			quizDao.deleteById(id);
			return new ResponseEntity<>("Quiz Deleted Succesfully.",HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>("Quiz Deleted Unsuccesfully.",HttpStatus.BAD_REQUEST);
	}	
}
