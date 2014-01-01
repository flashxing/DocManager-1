package com.docmanager.service.impl;

import java.util.List;

import com.docmanager.dao.DocManageDao;
import com.docmanager.entity.Doc;

import com.docmanager.service.SearchService;

public class SearchServiceImpl implements SearchService {
	
	DocManageDao docManageDao;
	
	public void setdocManageDao(DocManageDao docManageDao) {
		this.docManageDao= docManageDao;
	}

	@Override
	public List<Doc> detailedSearch(String title) {
		// TODO Auto-generated method stub
		return docManageDao.detailedSearch(title);
	}

	@Override
	public List<Doc> simpleSearch(String title) {
		// TODO Auto-generated method stub
		return docManageDao.simpleSearch(title);
	}

	@Override
	public List<Doc> searchByTag(String tag) {
		// TODO Auto-generated method stub
		return docManageDao.searchByTag(tag);
	}



}
