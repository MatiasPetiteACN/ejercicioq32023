package com.ejercicio.myaskgpt.main.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pair {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private long pairID;
	
	@Column
	private String question;
	
	@Column
	private String answer;
	
	public Pair() {
		super();
	}

	public Pair(String question, String answer) {
		super();
		this.question = question;
		this.answer = answer;
	}

	public long getPairID() {
		return pairID;
	}

	public void setPairID(long pairID) {
		this.pairID = pairID;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
