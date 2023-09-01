package com.Telusko.quizapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Telusko.quizapp.Model.Question;

import jakarta.transaction.Transactional;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
List<Question>findByCategory(String category);
@Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
List<Question> findRandomQuestionsByCategory(String category, int numQ);
   @Transactional
    @Query("update Question q set q.difficultyLevel = :difficultyLevel, q.option1 = :option1, q.option2 = :option2, q.option3 = :option3, q.option4 = :option4, q.questionTitle = :questionTitle, q.rightOption = :rightOption, q.category = :category where q.id = :id")
    List<Question> UpdateById(
        @Param("id") Integer id,
        @Param("difficultyLevel") String difficultyLevel,
        @Param("option1") String option1,
        @Param("option2") String option2,
        @Param("option3") String option3,
        @Param("option4") String option4,
        @Param("questionTitle") String questionTitle,
        @Param("rightOption") String rightOption,
        @Param("category") String category
    );
}