package com.idcl.textimania.service;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.idcl.textimania.model.Contest;
import com.idcl.textimania.model.ContestState;
import com.idcl.textimania.model.Contestant;
import com.idcl.textimania.model.Question;
import com.idcl.textimania.model.QuestionResponse;
import com.idcl.textimania.model.QuestionResponseId;

@Transactional
public class ContestantServiceImpl extends DaoServiceImpl implements ContestantService {
	public static final Log LOG = LogFactory.getLog(ContestantServiceImpl.class);

	@Override
	public Object register(String deviceId, String name) throws Exception {
		LOG.debug("register - " + deviceId + " " + name);

		Object response = null;
		try {
			Contestant contestant = new Contestant();
			
			contestant.setDeviceId(deviceId);
			contestant.setName(name);
			
			entityManager.persist(contestant);
		} catch (ConstraintViolationException e) {
			LOG.error("Device already registered: " + e);
			response = "This device is already registered.";
		} catch (Throwable e) {
			LOG.error("Contact registration failed: " + e);
			response = "Registration failed; system failure.";
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public void sendMessage(Long contestantId, String message) throws Exception {		
		ContestState contestState = (ContestState) entityManager.find(ContestState.class, 1L);

		long responseMillis = new Date().getTime() - contestState.getTimerStart().getTime();

		LOG.debug("sendMessage - Contestant: " + mapIndexToChar(contestantId.intValue() - 1) + " Response: [" + message + "] Time: " + (responseMillis / 1000.0));		
		
		if(contestState.getTimerStart() != null) {												
			QuestionResponseId responseId = new QuestionResponseId(findCurrentContest().getId(), contestantId, findCurrentQuestion().getId());
			QuestionResponse response = entityManager.find(QuestionResponse.class, responseId);
			
			response.setResponseTime(responseMillis / 1000.0);
			response.setTextValue(message);
			
			entityManager.merge(response);
		}
	}
	
	private Contest findCurrentContest() {
		return findContestState().getCurrentContest();
	}
	
	private Question findCurrentQuestion() {
		return findContestState().getCurrentQuestion();
	}
	
	private ContestState findContestState() {
		return (ContestState) entityManager.find(ContestState.class, 1L);
	}
	
	private char mapIndexToChar(int index) {
		return CHARACTER_MAP.charAt(index);
	}
}
