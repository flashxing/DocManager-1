package com.docmanager.service;

import java.util.List;

import com.docmanager.entity.Assess;

public interface AssessService {

	public int addbriefAssess(String time,int userId,int docId,int rank,int assessType,String briefAssess, int state);

	public int addDetailedAssess(String time, int userId, int docId, int rank,
			int assessType, String problem, String idea, String experiment,
			String contribution, String improvement, int state);

	public List<Assess> getAssess(int docId);

	public List<Assess> getDraft(int userId);

	public Assess getDraftById(int assessId);

	public int updateBrief(int assessId, String time, int radio1,
			String briefAssess, int bod);

	public int updateDetail(int assessId, String time, int radio1,
			String problem, String idea, String experiment,
			String contribution, String improvement, int bod);

	public List getAllAssess();

}
