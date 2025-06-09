package com.idcl.textimania.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "textimania")
public class QuestionResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3230238435063918911L;
	
	private QuestionResponseId id;
	
	private String textValue;
	
	private Double responseTime;
	
	private Contest contest;
	
	private Contestant contestant;
	
	private Question question;

	@EmbeddedId
	public QuestionResponseId getId() {
		return id;
	}

	public void setId(QuestionResponseId id) {
		this.id = id;
	}

	public String getTextValue() {
		return textValue;
	}

	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}

	public Double getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(Double responseTime) {
		this.responseTime = responseTime;
	}

	@ManyToOne
	@JoinColumn(name = "contestId", referencedColumnName = "id", updatable = false, insertable = false)
	public Contest getContest() {
		return contest;
	}

	public void setContest(Contest contest) {
		this.contest = contest;
	}

	@ManyToOne
	@JoinColumn(name = "contestantId", referencedColumnName = "id", updatable = false, insertable = false)
	public Contestant getContestant() {
		return contestant;
	}

	public void setContestant(Contestant contestant) {
		this.contestant = contestant;
	}

	@ManyToOne
	@JoinColumn(name = "questionId", referencedColumnName = "id", updatable = false, insertable = false)
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}
