package com.docmanager.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.docmanager.dao.DocManageDao;
import com.docmanager.entity.Doc;
import com.docmanager.entity.DocAttach;

public class DocManageDaoImpl extends HibernateDaoSupport implements DocManageDao {


	@Override
	public int addDoc(Doc doc){
		Serializable id = this.getHibernateTemplate().save(doc);
		return id!=null?(Integer) id:0;
	}

	@Override
	public List<Doc> getDocByUser(int userId) {
		// TODO Auto-generated method stub
		List<Doc> docList = new ArrayList<Doc>();
		String hql = "from Doc where userId='" + userId + "'";
		Iterator<Doc> iterator = this.getHibernateTemplate().find(hql).iterator();
		while(iterator.hasNext()){
			docList.add(iterator.next().clone());
		}
		return docList;

	}


	@Override
	public int updateDoc(Doc doc) {
		// TODO Auto-generated method stub
		//System.out.println("dfdgdgg"+doc.getDocId());
/*		Doc doc1=(Doc) this.getHibernateTemplate().find("from Doc where docId='" + docId + "'").get(0);
		doc1.setTitle(title);
		doc1.setAuthor(author);
		doc1.setYear(year);
		doc1.setPages(pages);
		doc1.setPublisher(publisher);
		doc1.setDocAbstract(docAbstract);
		doc1.setKey(key);
		doc1.setUrl(url);
		doc1.setEditor(editor);
		doc1.setISBN(ISBN);
		doc1.setBookName(bookName);
		doc1.setDOI(DOI);
		doc1.setConferenceYear(conferenceYear);
		doc1.setConferenceCity(conferenceCity);
		doc1.setVolume(volume);
		doc1.setIssue(issue);
		doc1.setSchool(school);
		this.getHibernateTemplate().update(doc1);
		*/
		this.getHibernateTemplate().update(doc);
		return 1;
	}

	@Override
	public Doc getDocById(int docId) {
		// TODO Auto-generated method stub
		Object object = this.getHibernateTemplate().get(Doc.class, docId);
		return object!=null?(Doc) object:new Doc();
	}

	@Override
	public int addAttach(List<DocAttach> docattachList) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().saveOrUpdateAll(docattachList);
		return 1;

	}

	@Override
	public List<DocAttach> getAttach(int adocId) {
		// TODO Auto-generated method stub
		List<DocAttach> docattachList = new ArrayList<DocAttach>();
		String hql = "from DocAttach where docId='" + adocId + "'";
		Iterator<DocAttach> iterator = this.getHibernateTemplate().find(hql).iterator();

		while(iterator.hasNext()){
			docattachList.add(iterator.next().clone());
		}
		return docattachList;


	}

	@Override
	public List<Doc> detailedSearch(String title) {
		// TODO Auto-generated method stub
		List<Doc> docList = new ArrayList<Doc>();
		if(!title.equals("")){
			String hql="from Doc where title like '%" + title + "%'";
			Iterator<Doc> iterator = this.getHibernateTemplate().find(hql).iterator();
			while(iterator.hasNext()){
				docList.add(iterator.next().clone());}
		}
		else{
			Iterator<Doc> iterator = this.getHibernateTemplate().find("from Doc").iterator();
			while(iterator.hasNext()){
				docList.add(iterator.next().clone());
			}
		}
		return docList;
	}

	@Override
	public List<Doc> simpleSearch(String title) {
		// TODO Auto-generated method stub
		List<Doc> docList = new ArrayList<Doc>();
	//	String hql="from Doc where title = '" + title + "'";
//	    String hql="from Doc where title like '%"+title+"%'";

	    String hql="from Doc where title like '%"+title+"%' ";
	    System.out.println(title);
	    //List<String> searchList=new ArrayList<String>();
	    //searchList.add(title);
		Iterator<Doc> iterator = this.getHibernateTemplate().find(hql).iterator();
		while(iterator.hasNext()){
			docList.add(iterator.next().clone());
		}
		System.out.println("simple"+docList.size());

		return docList;

	}

	@Override
	public List<Doc> getAllDocs() {
		// TODO Auto-generated method stub
		List<Doc> docList = new ArrayList<Doc>();
		Iterator<Doc> iterator = this.getHibernateTemplate().find("from Doc").iterator();
		while(iterator.hasNext()){
			docList.add(iterator.next().clone());
		}
		return docList;
	}

	@Override
	public void docDelete(int docId) {
		// TODO Auto-generated method stub
		Doc doc1=(Doc) this.getHibernateTemplate().find("from Doc where docId='" + docId + "'").get(0);
		this.getHibernateTemplate().delete(doc1);

	}

	@Override
	public List<Doc> searchByTag(String tag) {
		// TODO Auto-generated method stub
		List<Doc> docList = new ArrayList<Doc>();
		    String hql="from Doc where key like '%"+tag+"%' ";
		    //List<String> searchList=new ArrayList<String>();
		    //searchList.add(title);
			Iterator<Doc> iterator = this.getHibernateTemplate().find(hql).iterator();
			while(iterator.hasNext()){
				docList.add(iterator.next().clone());
			}

			return docList;
	}

}
