package com.docmanager.entity;

public class Assess {
	

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

	public Assess() {
		
	}

	//brief
	public Assess(String time,int userId,int docId,int rank,int assessType,String briefAssess,int state) {
		this.time=time;
		this.userId=userId;
		this.docId=docId;
		this.rank=rank;
		this.assessType=assessType;
		this.briefAssess=briefAssess;
		this.state=state;
	}
//all
	public Assess(int assessId,String time, int userId,int docId, int rank,
			int assessType,String briefAssess, String problem, String idea, String experiment,
			String contribution, String improvement, int state) {
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

	}
	//detailed
	public Assess(String time, int userId, int docId, int rank,
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
	public Assess clone(){
		return new Assess(assessId, time,userId,docId,rank,
				assessType, briefAssess,  problem, idea, experiment,
				contribution,improvement, state);
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

	
}
