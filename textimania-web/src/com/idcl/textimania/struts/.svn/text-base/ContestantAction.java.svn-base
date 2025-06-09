package com.idcl.textimania.struts;

import java.io.ByteArrayInputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.google.gson.Gson;
import com.idcl.textimania.service.ContestantService;
import com.opensymphony.xwork2.ActionSupport;

public class ContestantAction extends ActionSupport {
	private static final Log LOG = LogFactory.getLog(ContestantAction.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = -978378839904986964L;
	
	private ContestantService service;
	
	private ByteArrayInputStream jsonStream;

	private String id;
	
	private String name;
	
	private String msg;
	
	private Long cid;

	public String register() {
		LOG.debug("register() - " + id);
		LOG.debug("register() - " + name);
		
		try {
			service.register(id, name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return SUCCESS;
	}	
	
	@Override
	public String execute() {
		LOG.debug("execute()");
		return SUCCESS;
	}	
	
	public String sendMessage() {
		LOG.debug("sendMessage() - " + cid + " " + msg);

		Boolean flag = false;
		
		try {
			service.sendMessage(cid, msg);
			flag = true;
		} catch (Exception e) {
			LOG.error(e);
			e.printStackTrace();
		}
		
		LOG.debug("New Infection Flag: " + flag);
		
		jsonStream = new ByteArrayInputStream(new Gson().toJson(flag).getBytes());		
		
		return SUCCESS;
	}
	
	public ByteArrayInputStream getJsonStream() {
		return jsonStream;
	}

	public void setService(ContestantService service) {
		this.service = service;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

}
