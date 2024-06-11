package com.mohit.quizapplication.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mohit.quizapplication.model.Quiz;

@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer>{

}
