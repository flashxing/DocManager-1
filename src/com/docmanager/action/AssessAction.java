package com.docmanager.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.docmanager.entity.Assess;
import com.docmanager.entity.AssessMoreInfo;
import com.docmanager.service.AssessService;
import com.opensymphony.xwork2.ActionSupport;

public class AssessAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AssessService assessService;
	private int docId;
	String briefAssess;
	private String problem;
	private String idea;
	private String experiment;
	private String contribution;
	private String improvement;
	private int radio1;
	private int radio2;
	private String time;
	private Assess assess;
	private int assessId;
	//private Doc doc;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Assess getAssess() {
		return assess;
	}
	private List<AssessMoreInfo> assessList;

	private List<AssessMoreInfo> briefList;
	private List<AssessMoreInfo> detailedList;

	public int getBod() {
		return bod;
	}
	public void setBod(int bod) {
		this.bod = bod;
	}
	private int bod;


	public String briefAssess() throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		time=sdf.format(new java.util.Date());  
        //int bod1=Integer.parseInt(bod);
		System.out.println("qqqqqqqq"+bod);
		int result = assessService.addbriefAssess(time,1,docId,radio1,0,briefAssess,bod);
		if(result>0){
    		return "success";
    	}
		else
			return "failure";
	}
	public String detailedAssess() throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		time=sdf.format(new java.util.Date());  

		int result = assessService.addDetailedAssess(time,1,docId,radio2,1,problem,idea,experiment,contribution,improvement,bod);
		if(result>0){
    		return "success";
    	}
		else
			return "failure";
	}
	
	public String getDraft() throws Exception {
	//	assessList = assessService.getDraft(1);
		List list= assessService.getDraft(1);
		   if(list != null && list.size()>0){
			   assessList = new LinkedList();
			    AssessMoreInfo am;
			    for(int i = 0; i < list.size();i++){
			     am = new AssessMoreInfo();
			     Object[] object = (Object[])list.get(i);// 每行记录不在是一个对象 而是一个数组
			     int assessId =  (Integer) object[0];
			     String time =  (String)object[1];
			     int rank =  (Integer)object[2];
			     int assessType =  (Integer)object[3];
			     String briefAssess =  (String)object[4];
			     String problem =  (String)object[5];
			     String idea =  (String)object[6];
			     String experiment =  (String)object[7];
			     String contribution =  (String)object[8];
			     String improvement =  (String)object[9];
			     String userName =  (String)object[10];
			     String title =  (String)object[11];

			     // 重新封装在一个javabean里面
			     am.setAssessId(assessId);
			     am.setTime(time);
			     am.setRank(rank);
			     am.setAssessType(assessType);
			     am.setBriefAssess(briefAssess);
			     am.setProblem(problem);
			     am.setIdea(idea);
			     am.setExperiment(experiment);
			     am.setContribution(contribution);
			     am.setImprovement(improvement);
			     am.setUserName(userName);
			     am.setTitle(title);
			     assessList.add(am); // 最终封装在list中 传到前台。
			    }
		   }

		   
		   
		briefList=new ArrayList<AssessMoreInfo>();
		detailedList=new ArrayList<AssessMoreInfo>();

		int result = 1;
		for (AssessMoreInfo assess:assessList){
				if(assess.getAssessType()==0){
					briefList.add(assess);
				}
				if(assess.getAssessType()==1){
					detailedList.add(assess);
					//System.out.println("DETAILED"+detailedList.size());
                    
				}				
		}

		if (result > 0) {
			return "success";
		} else
			return "failure";

	}
	public String getDraftById() throws Exception {
		assess = assessService.getDraftById(assessId);
		int result = 1;
	//	System.out.println("size"+assessList.size());
		if (assess.getAssessType()==0) {
			return "success";
		} else if(assess.getAssessType()==1)
			{return "detailsuccess";}
		return "failure";

	}

	public String updateBrief() throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		time=sdf.format(new java.util.Date());  
		int result = assessService.updateBrief(assessId,time,radio1,briefAssess,bod);
			return "success";

	}
	public String updateDetail() throws Exception {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		time=sdf.format(new java.util.Date());  
		int result = assessService.updateDetail(assessId,time,radio1,problem,idea,experiment,contribution,improvement,bod);
			return "success";

	}


	public void setAssessService(AssessService assessService) {
		this.assessService = assessService;
	}
	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public List<AssessMoreInfo> getAssessList() {
		return assessList;
	}
	public void setAssessList(List<AssessMoreInfo> assessList) {
		this.assessList = assessList;
	}
	public void setAssess(Assess assess) {
		this.assess = assess;
	}

	public String getBriefAssess() {
		return briefAssess;
	}

	public void setBriefAssess(String briefAssess) {
		this.briefAssess = briefAssess;
	}

	public AssessService getAssessService() {
		return assessService;
	}
	public int getRadio1() {
		return radio1;
	}

	public void setRadio1(int radio1) {
		this.radio1 = radio1;
	}

	public int getRadio2() {
		return radio2;
	}

	public void setRadio2(int radio2) {
		this.radio2 = radio2;
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
	public int getAssessId() {
		return assessId;
	}
	public void setAssessId(int assessId) {
		this.assessId = assessId;
	}
	public List<AssessMoreInfo> getBriefList() {
		return briefList;
	}
	public void setBriefList(List<AssessMoreInfo> briefList) {
		this.briefList = briefList;
	}
	public List<AssessMoreInfo> getDetailedList() {
		return detailedList;
	}
	public void setDetailedList(List<AssessMoreInfo> detailedList) {
		this.detailedList = detailedList;
	}

}
