package com.docmanager.service;

import java.util.List;

import com.docmanager.entity.Doc;

public interface SearchService {

	public List<Doc> detailedSearch(String title);

	public List<Doc> simpleSearch(String title);

	public List<Doc> searchByTag(String tag);

}
