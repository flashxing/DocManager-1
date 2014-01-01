package com.docmanager.entity;

public class AssessMoreInfo {
	

	private int assessId;
	private String time;
	private int rank;
	private int assessType;
	private String briefAssess;
	private String problem;
	private String idea;
	private String experiment;
	private String contribution;
	private String improvement;
	private int state;
    private int userId;  
	private int docId;  
	private String userName;
	private String title;

	public AssessMoreInfo() {
		
	}

	//brief
	public AssessMoreInfo(String time,int userId,int docId,int rank,int assessType,String briefAssess,int state) {
		this.time=time;
		this.userId=userId;
		this.docId=docId;
		this.rank=rank;
		this.assessType=assessType;
		this.briefAssess=briefAssess;
		this.state=state;
	}
//all
	public AssessMoreInfo(int assessId,String time, int userId,int docId, int rank,
			int assessType,String briefAssess, String problem, String idea, String experiment,
			String contribution, String improvement, int state,String userName,String title) {
		// TODO Auto-generated constructor stub
		this.assessId=assessId;
		this.time=time;
		this.userId=userId;
		this.docId=docId;
		this.rank=rank;
		this.assessType=assessType;
		this.briefAssess=briefAssess;
		this.problem=problem;
		this.idea=idea;
		this.experiment=experiment;
		this.contribution=contribution;
		this.improvement=improvement;
		this.state=state;
		this.userName=userName;
		this.title=title;

	}
	//detailed
	public AssessMoreInfo(String time, int userId, int docId, int rank,
			int assessType, String problem, String idea, String experiment,
			String contribution, String improvement, int state) {
		// TODO Auto-generated constructor stub
		this.time=time;
		this.userId=userId;
		this.docId=docId;
		this.rank=rank;
		this.assessType=assessType;
		this.problem=problem;
		this.idea=idea;
		this.experiment=experiment;
		this.contribution=contribution;
		this.improvement=improvement;
		this.state=state;

	}

	@Override
	public AssessMoreInfo clone(){
		return new AssessMoreInfo(assessId, time,userId,docId,rank,
				assessType, briefAssess,  problem, idea, experiment,
				contribution,improvement, state,userName,title);
	}


	public int getAssessId() {
		return assessId;
	}

	public void setAssessId(int assessId) {
		this.assessId = assessId;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}



	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getAssessType() {
		return assessType;
	}

	public void setAssessType(int assessType) {
		this.assessType = assessType;
	}

	public String getBriefAssess() {
		return briefAssess;
	}

	public void setBriefAssess(String briefAssess) {
		this.briefAssess = briefAssess;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getIdea() {
		return idea;
	}

	public void setIdea(String idea) {
		this.idea = idea;
	}

	public String getExperiment() {
		return experiment;
	}

	public void setExperiment(String experiment) {
		this.experiment = experiment;
	}

	public String getContribution() {
		return contribution;
	}

	public void setContribution(String contribution) {
		this.contribution = contribution;
	}

	public String getImprovement() {
		return improvement;
	}

	public void setImprovement(String improvement) {
		this.improvement = improvement;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
    public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


}
