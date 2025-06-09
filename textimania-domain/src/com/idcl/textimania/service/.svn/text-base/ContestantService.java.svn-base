package com.idcl.textimania.service;



public interface ContestantService extends DaoService {
	
	public static final String QUERY_FIND_RESPONSE = "select o from QuestionResponse o where o.contestant.id = :contestantId and o.contest.id = :contestId and o.question.id = :questionId";
	
	public static final String CHARACTER_MAP = "ABCDEF";
	
	/**
	 * 
	 * @param deviceId
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Object register(String deviceId, String name) throws Exception;
	
	/**
	 * 
	 * @param contestantId
	 * @param message
	 * @throws Exception
	 */
	public void sendMessage(Long contestantId, String message) throws Exception;	

}
