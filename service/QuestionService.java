package com.Telusko.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Telusko.quizapp.Model.Question;
import com.Telusko.quizapp.dao.QuestionDao;

@Service
public class QuestionService {
 @Autowired
 QuestionDao questionDao;
	public ResponseEntity<List<Question>> getAllQuestions() {
	try {
		return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<List<Question>> getQuestionByCategory(String category) {
		try {
		return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
	}
		catch(Exception e)
	{
		e.printStackTrace();
	}
	return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
	}
	
	public ResponseEntity<String> addQuestion(Question question) {
		try {
		questionDao.save(question);
          return new ResponseEntity<>( "success" ,HttpStatus.CREATED);
		}
		catch(Exception e)
	{
		e.printStackTrace();
	}
		return new ResponseEntity<>("Failure",HttpStatus.BAD_REQUEST);
		
		}

	public ResponseEntity<String> DeleteQuestion(Integer integer) {
		try {
			questionDao.deleteById(integer);
			return new ResponseEntity<>("Delete",HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			return new ResponseEntity<>("Failure",HttpStatus.BAD_REQUEST);
			
	}

	public ResponseEntity<String> UpdateQuestion(Integer id, String difficultyLevel, String option1, String option2,
			String option3, String option4,String question_titile, String rightOption, String category) {
		 
		 try {
			 questionDao.UpdateById(id,difficultyLevel,option1,option2,option3,option4,question_titile,rightOption,category);
		 return new ResponseEntity<>("Success",HttpStatus.OK);
		     }
	     catch(Exception e)
	      {
	 		e.printStackTrace();
	 	  }
	 		return new ResponseEntity<>("Failure",HttpStatus.BAD_REQUEST);
	 		
	}
    }
