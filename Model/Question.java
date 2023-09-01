package com.Telusko.quizapp.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
@Data
@Entity
public class Question {
	@Id
	@GeneratedValue(strategy =GenerationType.SEQUENCE)
private Integer id;
private String questionTitile;
private String option1;
private String option2;
private String option3;
private String option4;
private String rightOption;
private String difficultyLevel;
public Question() {
	super();
	// TODO Auto-generated constructor stub
}
public Question(Integer id, String questionTitile, String option1, String option2, String option3, String option4,
		String rightOption, String difficultyLevel, String category) {
	super();
	this.id = id;
	this.questionTitile = questionTitile;
	this.option1 = option1;
	this.option2 = option2;
	this.option3 = option3;
	this.option4 = option4;
	this.rightOption = rightOption;
	this.difficultyLevel = difficultyLevel;
	this.category = category;
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getQuestionTitile() {
	return questionTitile;
}
public void setQuestionTitile(String questionTitile) {
	this.questionTitile = questionTitile;
}
public String getOption1() {
	return option1;
}
public void setOption1(String option1) {
	this.option1 = option1;
}
public String getOption2() {
	return option2;
}
public void setOption2(String option2) {
	this.option2 = option2;
}
public String getOption3() {
	return option3;
}
public void setOption3(String option3) {
	this.option3 = option3;
}
public String getOption4() {
	return option4;
}
public void setOption4(String option4) {
	this.option4 = option4;
}
public String getRightOption() {
	return rightOption;
}
public void setRightOption(String rightOption) {
	this.rightOption = rightOption;
}
public String getDifficultyLevel() {
	return difficultyLevel;
}
public void setDifficultyLevel(String difficultyLevel) {
	this.difficultyLevel = difficultyLevel;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
private String category;
}
