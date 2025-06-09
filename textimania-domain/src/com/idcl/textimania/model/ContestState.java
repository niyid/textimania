package com.idcl.textimania.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema = "textimania")
public class ContestState implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8435269106810929820L;
	
	private Long id;
	
	private Contest currentContest;
	
	private Question currentQuestion;
	
	private Date timerStart;
	
	private int questionIndex;
	
	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "currentContestId")
	public Contest getCurrentContest() {
		return currentContest;
	}

	public void setCurrentContest(Contest currentContest) {
		this.currentContest = currentContest;
	}

	@ManyToOne
	@JoinColumn(name = "currentQuestionId")
	public Question getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getTimerStart() {
		return timerStart;
	}

	public void setTimerStart(Date timerStart) {
		this.timerStart = timerStart;
	}

	public int getQuestionIndex() {
		return questionIndex;
	}

	public void setQuestionIndex(int questionIndex) {
		this.questionIndex = questionIndex;
	}
}
