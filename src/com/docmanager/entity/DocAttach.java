package com.docmanager.entity;

public class DocAttach {
	private int attachId;
	private int docId;

	private String attachType;
	private String attachName;
	private String attachAddress;
	private int userId;
	
	public DocAttach(){
	}
	
	public DocAttach(int docId, String attachType, String attachName, String attachAddress, int userId){
		this.docId = docId;
		this.attachType = attachType;
		this.attachName = attachName;
		this.attachAddress = attachAddress;
		this.userId = userId;
	}

	public DocAttach(int attachId,int docId, String attachType, String attachName, String attachAddress, int userId){
		this.attachId = attachId;
		this.docId = docId;
		this.attachType = attachType;
		this.attachName = attachName;
		this.attachAddress = attachAddress;
		this.userId = userId;
	}
	
	@Override
	public DocAttach clone(){
		return new DocAttach(attachId,docId,attachType,attachName,attachAddress, userId);
	}

	public int getAttachId() {
		return attachId;
	}

	public void setAttachId(int attachId) {
		this.attachId = attachId;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getAttachType() {
		return attachType;
	}

	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}

	public String getAttachName() {
		return attachName;
	}

	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}

	public String getAttachAddress() {
		return attachAddress;
	}

	public void setAttachAddress(String attachAddress) {
		this.attachAddress = attachAddress;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
}
