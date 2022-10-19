package com.map;

import javax.persistence.*;


@Entity
public class Answer {

	@Id
	@Column(name = "answer_id")
	private int answerId;
	private String answer;
	
	
//	@OneToOne(mappedBy = "answer")
//	@JoinColumn(name = "que_id")
	
	@ManyToOne
	private Question question;
	
	
	
	
	public Answer(int answerId, String answer, Question question) {
		super();
		this.answerId = answerId;
		this.answer = answer;
		this.question = question;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public Answer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
