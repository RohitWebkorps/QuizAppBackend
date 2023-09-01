package com.Telusko.quizapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Telusko.quizapp.Model.Question;
import com.Telusko.quizapp.Model.QuestionWrapper;
import com.Telusko.quizapp.Model.Quiz;
import com.Telusko.quizapp.Model.Response;
import com.Telusko.quizapp.dao.QuestionDao;
import com.Telusko.quizapp.dao.QuizeDao;

@Service
public class QuizService {

	@Autowired
	QuizeDao quizDao;
    @Autowired
    QuestionDao questionDao;
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
List<Question> questions=questionDao.findRandomQuestionsByCategory(category,numQ);
	Quiz quiz=new Quiz();
	quiz.setTitle(title);
	quiz.setQuestions(questions);
	quizDao.save(quiz);
	return new ResponseEntity<>("success",HttpStatus.CREATED);
	}
	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Optional<Quiz> quiz=quizDao.findById(id);
	List<Question> questionFromDB=quiz.get().getQuestions();
	List<QuestionWrapper> questionsForUser=new ArrayList<>();
	for(Question q:questionFromDB) {
		QuestionWrapper qw=new QuestionWrapper(q.getId(),q.getQuestionTitile(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
	    questionsForUser.add(qw);
	}
		return new ResponseEntity<>(questionsForUser,HttpStatus.OK);
	}
	public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responses) {
		Quiz quiz = quizDao.findById(id).get();
	     List<Question> question=quiz.getQuestions();
	     int right=0;
	     int i=0;
	     for(Response response : responses)
	     {
	    	 if(response.getResponse().equals(question.get(i).getRightOption()))
	    		 right++;
	    	 
	    	 i++;
	     }
	     return new ResponseEntity<>(right,HttpStatus.OK);
	}	
}
