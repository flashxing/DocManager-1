package com.docmanager.dao;

import java.util.List;

import org.springframework.dao.support.DaoSupport;

import com.docmanager.entity.Doc;
import com.docmanager.entity.DocAttach;

public interface DocManageDao {
	

	public int addDoc(Doc doc);
	public List<Doc> getDocByUser(int userId);
	public int updateDoc(Doc doc);
	public Doc getDocById(int docId);
	public int addAttach(List<DocAttach> docattachList);
	public List<DocAttach> getAttach(int adocId);
	public List<Doc> detailedSearch(String title);
	public List<Doc> simpleSearch(String title);
	public List<Doc> getAllDocs();
	public void docDelete(int docId);
	public List<Doc> searchByTag(String tag);
	
}
