package com.idcl.textimania.struts;

import java.io.File;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.idcl.textimania.model.ContestState;
import com.idcl.textimania.model.Contestant;
import com.idcl.textimania.model.Question;
import com.idcl.textimania.model.QuestionResponse;
import com.idcl.textimania.service.HostService;
import com.opensymphony.xwork2.ActionSupport;

public class HostAction extends ActionSupport {
	private static final Log LOG = LogFactory.getLog(HostAction.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -978378839904986964L;
	
	private Question question;
	
	private HostService service;
	
	List<QuestionResponse> results;
	
	private Long winnerId;
	
	private List<Contestant> contestants;
	
	private ContestState contestState;
	
	private String title;
	
	private Integer contestantCount;
	
	private File questionFile;

	public String start() {
		LOG.debug("start()");
		
		try {
			question = service.nextQuestion();
			contestState = service.findContestState();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "countDown";
	}	
	
	@Override
	public String execute() {
		LOG.debug("execute()");
		return SUCCESS;
	}	
	
	public String listResults() {
		LOG.debug("listResults()");
		
		try {
			results = service.listResults();
			contestState = service.findContestState();
			question = service.findContestState().getCurrentQuestion();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "listResults";
	}
	
	public String selectRoundWinner() {
		LOG.debug("selectRoundWinner()");
		
		String goTo = SUCCESS;
		try {
			service.selectRoundWinner(winnerId);
			contestState = service.findContestState();
			if(contestState.getQuestionIndex() < 18) {
				question = service.nextQuestion();
			} else {
				service.incQuestionIndex();
			}
			
			contestState = service.findContestState();
			
			LOG.debug("A=" + contestState.getQuestionIndex() + " B=" + (service.fetchQuestionCount() + 1));
			if(contestState.getQuestionIndex() == service.fetchQuestionCount() + 1) {
				contestants = service.selectOverallWinner();
				goTo = "winner";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return goTo;
	}
	
	public String selectOverallWinner() {
		LOG.debug("selectOverallWinner()");
		
		try {
			contestants = service.selectOverallWinner();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "winner";
	}
	
	public String restart() {
		LOG.debug("restart()");
		
		try {
			service.resetCurrentContest();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home";
	}
	
	public String newContest() {
		LOG.debug("newContest()");
		
		try {
			service.createNewContest(title, questionFile, contestantCount);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "home";
	}
	
	public String dashboard() {
		LOG.debug("dashboard()");
		
		return "dashboard";
	}

	public void setService(HostService service) {
		this.service = service;
	}

	public Question getQuestion() {
		return question;
	}

	public List<QuestionResponse> getResults() {
		return results;
	}

	public Long getWinnerId() {
		return winnerId;
	}

	public void setWinnerId(Long winnerId) {
		this.winnerId = winnerId;
	}

	public List<Contestant> getContestants() {
		return contestants;
	}

	public ContestState getContestState() {
		return contestState;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getContestantCount() {
		return contestantCount;
	}

	public void setContestantCount(Integer contestantCount) {
		this.contestantCount = contestantCount;
	}

	public File getQuestionFile() {
		return questionFile;
	}

	public void setQuestionFile(File questionFile) {
		this.questionFile = questionFile;
	}
}
