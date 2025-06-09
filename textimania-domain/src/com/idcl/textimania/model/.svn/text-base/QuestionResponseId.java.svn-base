package com.idcl.textimania.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class QuestionResponseId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8172673145110967391L;
	
	private Long contestId;
	
	private Long contestantId;

	private Long questionId;
	
	public QuestionResponseId() {
		super();
	}

	public QuestionResponseId(Long contestId, Long contestantId, Long questionId) {
		super();
		this.contestId = contestId;
		this.contestantId = contestantId;
		this.questionId = questionId;
	}

	public Long getContestId() {
		return contestId;
	}

	public void setContestId(Long contestId) {
		this.contestId = contestId;
	}

	public Long getContestantId() {
		return contestantId;
	}

	public void setContestantId(Long contestantId) {
		this.contestantId = contestantId;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contestId == null) ? 0 : contestId.hashCode());
		result = prime * result
				+ ((contestantId == null) ? 0 : contestantId.hashCode());
		result = prime * result
				+ ((questionId == null) ? 0 : questionId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionResponseId other = (QuestionResponseId) obj;
		if (contestId == null) {
			if (other.contestId != null)
				return false;
		} else if (!contestId.equals(other.contestId))
			return false;
		if (contestantId == null) {
			if (other.contestantId != null)
				return false;
		} else if (!contestantId.equals(other.contestantId))
			return false;
		if (questionId == null) {
			if (other.questionId != null)
				return false;
		} else if (!questionId.equals(other.questionId))
			return false;
		return true;
	}
	
}
