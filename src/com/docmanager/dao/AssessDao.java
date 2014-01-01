package com.docmanager.dao;

import java.util.List;

import com.docmanager.entity.Assess;

public interface AssessDao {
	
	public int addbriefAssess(Assess assess);

	public int addDetailedAssess(Assess assess);

	public List getAssess(int docId);

	public List<Assess> getDraft(int userId);

	public Assess getDraftById(int assessId);

	public int updateBrief(int assessId, String time, int radio1,
			String briefAssess, int bod);

	public int updateDetail(int assessId, String time, int radio1,
			String problem, String idea, String experiment,
			String contribution, String improvement, int bod);

	public List getAllAssess();
	
}
