package com.docmanager.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import com.docmanager.dao.DocManageDao;
import com.docmanager.entity.Doc;
import com.docmanager.entity.DocAttach;

import com.docmanager.service.DocAddService;

public class DocAddServiceImpl implements DocAddService {
	
	DocManageDao docManageDao;
	
	public void setdocManageDao(DocManageDao docManageDao) {
		this.docManageDao= docManageDao;
	}


	@Override
	public List<Doc> getDocsByUserId(int userId) {
		// TODO Auto-generated method stub
		return docManageDao.getDocByUser(userId);
	}



	@Override
	public Doc getDocById(int docId) {
		// TODO Auto-generated method stub
		return docManageDao.getDocById(docId);
	}



	@Override
	public int addAttach(List<DocAttach> docattachList) {
		// TODO Auto-generated method stub
		return docManageDao.addAttach(docattachList);

	}


	@Override
	public int addDoc(String type, String title, String author, int year,
			String pages, String publisher, String docAbstract, String key,
			String url, String content) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");  
		String time=sdf.format(new java.util.Date());  

		Doc doc = new Doc(type, title, author,year,0,time, pages, publisher, docAbstract, key, url, 1,
				content);
		//System.out.println(doc.getTime());
		
		return docManageDao.addDoc(doc);
	}


	@Override
	public int updateDoc(int docId, String type,String title, String author, int year,String time,
			String pages, String publisher, String docAbstract, String key,
			String url, String content) {
		// TODO Auto-generated method stub
		Doc doc = new Doc(docId,type, title, author,year,0,time, pages, publisher, docAbstract, key, url, 1,
				content);

		docManageDao.updateDoc(doc);
		//System.out.println("dfagag"+docId);
		return 0;
	}


	@Override
	public List<DocAttach> getAttach(int adocId) {
		// TODO Auto-generated method stub
		return docManageDao.getAttach(adocId);

	}


	@Override
	public List<Doc> getAllDocs() {
		// TODO Auto-generated method stub
		return docManageDao.getAllDocs();
	}


	@Override
	public int docDelete(int docId) {
		// TODO Auto-generated method stub
		docManageDao.docDelete(docId);
		return 1;
	}
}
