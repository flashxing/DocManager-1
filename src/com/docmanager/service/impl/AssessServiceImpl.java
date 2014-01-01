package com.docmanager.service.impl;

import java.util.List;

import com.docmanager.dao.AssessDao;
import com.docmanager.entity.Assess;
import com.docmanager.service.AssessService;

public class AssessServiceImpl implements AssessService {
	
	AssessDao assessDao;


	@Override
	public int addbriefAssess(String time, int userId, int docId, int rank,
			int assessType, String briefAssess, int state) {
		// TODO Auto-generated method stub
		Assess assess=new Assess(time,  userId,  docId,  rank,assessType,  briefAssess,  state);
		return assessDao.addbriefAssess(assess);

	}

	@Override
	public int addDetailedAssess(String time, int userId, int docId, int rank,
			int assessType, String problem, String idea, String experiment,
			String contribution, String improvement, int state) {
		// TODO Auto-generated method stub
		Assess assess=new Assess(time,  userId,  docId,  rank,
				 assessType,  problem,  idea,  experiment,
				 contribution,  improvement,  state);
		return assessDao.addDetailedAssess(assess );
	}

	public AssessDao getAssessDao() {
		return assessDao;
	}


	public void setAssessDao(AssessDao assessDao) {
		this.assessDao = assessDao;
	}

	@Override
	public List<Assess> getAssess(int docId) {
		// TODO Auto-generated method stub
		//System.out.println(docId);
		return assessDao.getAssess(docId);

	}

	@Override
	public List<Assess> getDraft(int userId) {
		// TODO Auto-generated method stub
		return assessDao.getDraft(userId);
	}

	@Override
	public Assess getDraftById(int assessId) {
		// TODO Auto-generated method stub
		return assessDao.getDraftById(assessId);
	}

	@Override
	public int updateBrief(int assessId, String time, int radio1,
			String briefAssess, int bod) {
		// TODO Auto-generated method stub
		assessDao.updateBrief(assessId,time,radio1,briefAssess,bod);
		return 1;
	}

	@Override
	public int updateDetail(int assessId, String time, int radio1,
			String problem, String idea, String experiment,
			String contribution, String improvement, int bod) {
		// TODO Auto-generated method stub
		assessDao.updateDetail(assessId,time,radio1,problem,idea,experiment,contribution,
				improvement,bod);
		return 1;
	}

	@Override
	public List getAllAssess() {
		// TODO Auto-generated method stub
		return assessDao.getAllAssess();
	}


}
