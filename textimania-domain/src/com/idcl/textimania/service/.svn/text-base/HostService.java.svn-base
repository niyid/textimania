package com.idcl.textimania.service;

import java.io.File;
import java.util.List;

import com.idcl.textimania.model.ContestState;
import com.idcl.textimania.model.Contestant;
import com.idcl.textimania.model.Question;
import com.idcl.textimania.model.QuestionResponse;


public interface HostService extends DaoService {
	public static final int CONTESTANT_MAX = 6;
	
	public static final String CHARACTER_MAP = "ABCDEF";
	
	public static final String QUERY_LIST_CONTEST_QUESTIONS = "select o from Question o where o.contest.id = :contestId";
	
	public static final String QUERY_LIST_RESPONSES = "select o from QuestionResponse o where o.contest.id = :contestId and o.question.id = :questionId order by o.responseTime";
	
	public static final String QUERY_LIST_CONTESTANTS = "select o from Contestant o where o.contest.id = :contestId and o.enabled = true order by o.score desc";
	
	public static final String QUERY_COUNT_QUESTIONS = "select count(o.id) from Question o where o.contest.id = :contestId";
	
	public static final String QUERY_DELETE_RESPONSES = "delete from QuestionResponse";
	
	public static final String QUERY_RESET_CONTESTANT_SCORES = "update Contestant o set o.score = 0";
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public Question nextQuestion() throws Exception;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<QuestionResponse> listResults() throws Exception;
	
	/**
	 * 
	 * @param contestantId
	 * @throws Exception
	 */
	public void selectRoundWinner(Long contestantId) throws Exception;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Contestant> selectOverallWinner() throws Exception;
	
	/**
	 * 
	 * @throws Exception
	 */
	public void endContest() throws Exception;
	
	/**
	 * 
	 * @return
	 */
	public ContestState findContestState();
	
	/**
	 * 
	 * @return
	 */
	public Long fetchQuestionCount();
	
	/**
	 * 
	 * @param title
	 * @param questionSpreadsheet
	 * @param contestantCount
	 */
	public void createNewContest(String title, File questionSpreadsheet, int contestantCount);
	
	/**
	 * 
	 */
	public void resetCurrentContest();
	
	/**
	 * 
	 */
	public void incQuestionIndex();
}
