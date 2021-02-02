package com.app.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer msgId;
	
	@Column(length = 50)
	private String msgDesc;
	
	//@OneToOne
	//@JoinColumn(name="ID")
	private Integer senderId;
	
	//@OneToOne
	//@JoinColumn(name="ID")
	private Integer recieverId;
	public Message() {
		super();
		System.out.println("In Constructor " + getClass().getName());

	}
	public Message(Integer msgId, String msgDesc, Integer senderId, Integer recieverId) {
		super();
		this.msgId = msgId;
		this.msgDesc = msgDesc;
		this.senderId = senderId;
		this.recieverId = recieverId;
	}
	public Integer getMsgId() {
		return msgId;
	}
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	public String getMsgDesc() {
		return msgDesc;
	}
	public void setMsgDesc(String msgDesc) {
		this.msgDesc = msgDesc;
	}
	public Integer getSenderId() {
		return senderId;
	}
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	public Integer getRecieverId() {
		return recieverId;
	}
	public void setRecieverId(Integer recieverId) {
		this.recieverId = recieverId;
	}
	
}
