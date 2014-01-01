package com.docmanager.service;

import java.util.List;

import com.docmanager.entity.Doc;
import com.docmanager.entity.DocAttach;

public interface DocAddService {
	
	public int addDoc(String type, String title, String author,
			int year, String pages, String publisher, String docAbstract, String key,
			String url, String content);
	
	public List<Doc> getDocsByUserId(int userId);
	

	public int updateDoc(int docId,String type,String title, String author,
			int year, String time, String pages, String publisher, String docAbstract, String key,
			String url, String content);

	public Doc getDocById(int docId);
	
	public int addAttach(List<DocAttach> docattachList);

	public List<DocAttach> getAttach(int adocId);

	public List<Doc> getAllDocs();

	public int docDelete(int docId);

}
