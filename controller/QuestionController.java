package com.Telusko.quizapp.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.Telusko.quizapp.Model.Question;
import com.Telusko.quizapp.service.QuestionService;

@RestController
@RequestMapping("Question")

public class QuestionController {
	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestions")
	public ResponseEntity<List<Question>> getAllQuestions()
	{
		return questionService.getAllQuestions();
	}

	
@GetMapping("category/{category}")
public ResponseEntity<List<Question>> getQuestionsByCategory(@PathVariable String category)
{
return questionService.getQuestionByCategory(category);
}

@DeleteMapping("delete")
public ResponseEntity<String> deleteQuestion(@RequestBody Question question)
{
	return questionService.DeleteQuestion(question.getId());
}

@PostMapping("add")
public ResponseEntity<String> addQuestion(@RequestBody Question question)
{
	return questionService.addQuestion(question);
}

@PostMapping("update")
public ResponseEntity<String> update(@RequestBody Question question)
{
	return questionService.UpdateQuestion(question.getId(),question.getDifficultyLevel(),question.getOption1(),question.getOption2(),question.getOption3(),question.getOption4(),question.getQuestionTitile(),question.getRightOption(),question.getCategory());
}
}