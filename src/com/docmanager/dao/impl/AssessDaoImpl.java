package com.docmanager.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.docmanager.entity.Assess;
import com.docmanager.dao.AssessDao;

public class AssessDaoImpl extends HibernateDaoSupport implements AssessDao {


	@Override
	public int addbriefAssess(Assess assess) {
		// TODO Auto-generated method stub
		Serializable id = this.getHibernateTemplate().save(assess);
		return id!=null?(Integer) id:0;
	}

	@Override
	public int addDetailedAssess(Assess assess) {
		// TODO Auto-generated method stub
		Serializable id = this.getHibernateTemplate().save(assess);
		return id!=null?(Integer) id:0;
	}

	@Override
	public List getAssess(int docId) {
		// TODO Auto-generated method stub
		List alist = new ArrayList();
		//String hql="from Doc where title like '%" + title + "%' and author like'%" + author + "%'";
		String hql = "select a.assessId,a.time,a.rank,a.assessType,a.briefAssess,a.problem,a.idea,a.experiment,a.contribution,a.improvement,u.name,d.title " +
				"from Assess as a,User as u,Doc as d " +
				"where a.docId='" + docId + "' and a.state=0 and a.userId=u.uid and a.docId=d.docId";
	/*	Iterator<Assess> iterator = this.getHibernateTemplate().find(hql).iterator();
		while(iterator.hasNext()){
			assessList.add(iterator.next().clone());
		}
		return assessList;*/
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		   Query q = session.createQuery(hql);
		   alist = q.list();
		   System.out.println("shenme!"+alist.size());

 		return alist;

	}

	@Override
	public List getDraft(int userId) {
		// TODO Auto-generated method stub
		List dlist = new ArrayList();

		String hql = "select a.assessId,a.time,a.rank,a.assessType,a.briefAssess,a.problem,a.idea,a.experiment,a.contribution,a.improvement,u.name,d.title " +
		"from Assess as a,User as u,Doc as d " +
		"where a.userId='" + userId + "' and a.state=1 and a.userId=u.uid and a.docId=d.docId";
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		   Query q = session.createQuery(hql);
		   dlist = q.list();
		return dlist;

		//List<Assess> assessList = new ArrayList<Assess>();
		/*String hql = "from Assess where userId='" + userId + "' and state=1";
	    Iterator<Assess> iterator = this.getHibernateTemplate().find(hql).iterator();
		while(iterator.hasNext()){
			assessList.add(iterator.next().clone());
		}
		return assessList;
		*/
	}

	@Override
	public Assess getDraftById(int assessId) {
		// TODO Auto-generated method stub
		Object object = this.getHibernateTemplate().get(Assess.class, assessId);
		return object!=null?(Assess) object:new Assess();
	}

	@Override
	public int updateBrief(int assessId, String time, int radio1,
			String briefAssess, int bod) {
		// TODO Auto-generated method stub
		Assess assess1=(Assess) this.getHibernateTemplate().find("from Assess where assessId='" + assessId + "'").get(0);
		assess1.setTime(time);
		assess1.setRank(radio1);
		assess1.setBriefAssess(briefAssess);
		assess1.setState(bod);
		this.getHibernateTemplate().update(assess1);
		return 1;
	}

	@Override
	public int updateDetail(int assessId, String time, int radio1,
			String problem, String idea, String experiment,
			String contribution, String improvement, int bod) {
		// TODO Auto-generated method stub
		Assess assess1=(Assess) this.getHibernateTemplate().find("from Assess where assessId='" + assessId + "'").get(0);
		assess1.setTime(time);
		assess1.setRank(radio1);
		assess1.setProblem(problem);
		assess1.setIdea(idea);
		assess1.setExperiment(experiment);
		assess1.setContribution(contribution);
		assess1.setImprovement(improvement);
		assess1.setState(bod);
		this.getHibernateTemplate().update(assess1);
		return 1;

	}

	@Override
	public List getAllAssess() {
		// TODO Auto-generated method stub
		List alist = new ArrayList();
		//String hql="from Doc where title like '%" + title + "%' and author like'%" + author + "%'";
		String hql = "select a.assessId,a.time,a.rank,a.assessType,a.briefAssess,a.problem,a.idea,a.experiment,a.contribution,a.improvement,u.name,d.title " +
				"from Assess as a,User as u,Doc as d " +
				"where a.userId='" + 1 + "' and a.state=0 and a.userId=u.uid and a.docId=d.docId order by a.time desc";
		Session session = getHibernateTemplate().getSessionFactory().getCurrentSession();
		   Query q = session.createQuery(hql);
		   alist = q.list();
		   System.out.println("test"+alist.size());
 		return alist;
	}

}
