package com.Telusko.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Telusko.quizapp.Model.Quiz;

public interface QuizeDao extends JpaRepository<Quiz,Integer>{

}
