package com.idcl.textimania.service;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

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
public class HostServiceImpl extends DaoServiceImpl implements HostService {
	
	public static final Log LOG = LogFactory.getLog(HostServiceImpl.class);
			
	@Override
	public Question nextQuestion() throws Exception {
		LOG.debug("nextQuestion()");
		
		ContestState contestState = (ContestState) entityManager.find(ContestState.class, 1L);
		
		if(contestState.getCurrentQuestion() == null) {			
			contestState.setQuestionIndex(1);
		} else {
			contestState.setQuestionIndex(contestState.getQuestionIndex() + 1);
		}

		Question currentQuestion = findQuestion(contestState.getCurrentContest().getId(), contestState.getQuestionIndex());
			
		contestState.setCurrentQuestion(currentQuestion);
		
		contestState.setTimerStart(new Date());
			
		createPrelimResponses();
		
		entityManager.merge(contestState);
		
		return contestState.getCurrentQuestion();
	}
	
	public void incQuestionIndex() {
		
		ContestState contestState = (ContestState) entityManager.find(ContestState.class, 1L);
		
		contestState.setQuestionIndex(contestState.getQuestionIndex() + 1);
		
		entityManager.merge(contestState);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionResponse> listResults() throws Exception {
		LOG.debug("listResults()");
		
		ContestState contestState = (ContestState) entityManager.find(ContestState.class, 1L);
		
		contestState.setTimerStart(null);
		
		entityManager.merge(contestState);
		
		Query q = entityManager.createQuery(QUERY_LIST_RESPONSES);
		
		q.setParameter("contestId", contestState.getCurrentContest().getId());
		q.setParameter("questionId", contestState.getCurrentQuestion().getId());		
		
		return q.getResultList();
	}

	@Override
	public void selectRoundWinner(Long contestantId) throws Exception {
		LOG.debug("selectRoundWinner() - " + contestantId);
		
		if(contestantId != 0) {			
			Contestant contestant = entityManager.find(Contestant.class, contestantId);
			
			contestant.setScore(contestant.getScore() + 10);
			
			entityManager.merge(contestant);
		}		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contestant> selectOverallWinner() throws Exception {
		LOG.debug("selectOverallWinner()");		
		
		ContestState contestState = (ContestState) entityManager.find(ContestState.class, 1L);
		
		contestState.setTimerStart(null);
		
		contestState.setCurrentQuestion(null);
		
		contestState.setQuestionIndex(0);
		
		Query q = entityManager.createQuery(QUERY_LIST_CONTESTANTS);
		
		q.setParameter("contestId", contestState.getCurrentContest().getId());
		
		return q.getResultList();
	}

	@Override
	public void endContest() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("unchecked")
	private void createPrelimResponses() {	
		LOG.debug("createPrelimResponses()");
		
		ContestState contestState = (ContestState) entityManager.find(ContestState.class, 1L);
		
		Query q = entityManager.createQuery(QUERY_LIST_CONTESTANTS);
		
		q.setParameter("contestId", contestState.getCurrentContest().getId());
		
		List<Contestant> contestants = q.getResultList();
		
		for(Contestant c : contestants) {		
			QuestionResponseId responseId = new QuestionResponseId(findCurrentContest().getId(), c.getId(), findCurrentQuestion().getId());
			
			QuestionResponse response = new QuestionResponse();
			response.setId(responseId);
			response.setResponseTime(1000.0);
			
			entityManager.persist(response);
		}
	}

	private Question findQuestion(Long contestId, int questionIndex) {
		LOG.debug("findQuestion() - " + contestId + " " + questionIndex);
		
		Query q = entityManager.createQuery(QUERY_LIST_CONTEST_QUESTIONS);
		
		q.setParameter("contestId", contestId);
		q.setMaxResults(questionIndex);
		
		return (Question) q.getResultList().get(questionIndex - 1);
	}
	
	private Contest findCurrentContest() {
		return findContestState().getCurrentContest();
	}
	
	private Question findCurrentQuestion() {
		return findContestState().getCurrentQuestion();
	}
	
	public ContestState findContestState() {
		return (ContestState) entityManager.find(ContestState.class, 1L);
	}

	@Override
	public Long fetchQuestionCount() {
		LOG.debug("fetchQuestionCount()");
		
		Query q = entityManager.createQuery(QUERY_COUNT_QUESTIONS);
		
		ContestState contestState = (ContestState) entityManager.find(ContestState.class, 1L);
	
		q.setParameter("contestId", contestState.getCurrentContest().getId());
		
		return (Long) q.getSingleResult();
	}

	@Override
	public void createNewContest(String title, File questionSpreadsheet, int contestantCount) {
		LOG.debug("createNewContest - " + title + " " + contestantCount + " " + questionSpreadsheet);
		
		Contest contest = new Contest();
		contest.setDescription(title);
		entityManager.persist(contest);
		LOG.debug("createNewContest - Contest created.");
		
		ContestState contestState = (ContestState) entityManager.find(ContestState.class, 1L);
		
		if(contestState == null) {
			contestState = new ContestState();
			contestState.setId(1L);
			contestState.setCurrentContest(contest);
			entityManager.persist(contestState);
		} else {			
			contestState.setQuestionIndex(0);
			contestState.setCurrentQuestion(null);
			contestState.setCurrentContest(contest);
			entityManager.merge(contestState);
		}		
		
		LOG.debug("createNewContest - Contest state updated.");
		
		for(int i = 0; i < CONTESTANT_MAX; i++) {
			Contestant c = new Contestant();
			if(i < contestantCount) {
				c.setEnabled(true);
			}
			c.setContest(contest);
			c.setDeviceId("Contestant " + mapIndexToChar(i));
			c.setContest(contest);
			entityManager.persist(c);
		}
		LOG.debug("createNewContest - Contestants created.");
		
		if(questionSpreadsheet != null) {
			//Load questions
		}
	}

	@Override
	public void resetCurrentContest() {
		LOG.debug("fetchQuestionCount()");
		
		ContestState contestState = (ContestState) entityManager.find(ContestState.class, 1L);
		
		if(contestState != null) {			
			contestState.setQuestionIndex(0);
			contestState.setCurrentQuestion(null);
			entityManager.merge(contestState);
			
			Query q = entityManager.createQuery(QUERY_DELETE_RESPONSES);
			q.executeUpdate();
			
			q = entityManager.createQuery(QUERY_RESET_CONTESTANT_SCORES);
			q.executeUpdate();
		}		
	}
	
	private char mapIndexToChar(int index) {
		return CHARACTER_MAP.charAt(index);
	}
}
