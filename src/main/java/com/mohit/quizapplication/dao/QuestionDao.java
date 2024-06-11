package com.mohit.quizapplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mohit.quizapplication.model.Question;

@Repository
public interface QuestionDao extends JpaRepository <Question,Integer>{

	List<Question> findByCategory(String category);
	
	@Query(value = "SELECT * FROM Question q WHERE q.category=:category ORDER BY RAND() LIMIT :noOfQuestion",nativeQuery = true)
	List<Question> findRandomQuestionByCategory(String category, int noOfQuestion);
	
}
