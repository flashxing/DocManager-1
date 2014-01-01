package com.docmanager.action;

import java.util.ArrayList;
import java.util.List;
import org.apache.struts2.ServletActionContext;

import com.docmanager.entity.Doc;

import com.docmanager.service.SearchService;
import com.opensymphony.xwork2.ActionSupport;

public class SearchAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SearchService searchService;
	private int docId;
	private List<String> searchContent;
	private List<String> selectSearch;
	
	private String title;

	// book
	private String editor;
	private int ISBN;
	// book_section
	private String bookName;
	// confer
	private int DOI;
	private String conferenceYear;
	private String conferenceCity;
	// jour
	private String volume;
	private String issue;
	// online  report  thesis
	private String school;

	private List<Doc> docList;
	private Doc doc;
	private String tag;

	
	public String detailedSearch() throws Exception {
	//	List<Integer> titleList=new ArrayList<Integer>();
	//	for(int i=0;i<selectSearch.size();i++){
	//		if(selectSearch.get(i).equals("标题")){
	//			titleList.add(i);
	//		}
	//	}
		String title1="";
		List<String> author=new ArrayList<String>();
		int year=0;
		List<String> publisher=new ArrayList<String>();
		List<String> key=new ArrayList<String>();
		List<String> docAbstract=new ArrayList<String>();
		
		int t=selectSearch.indexOf("标题");
        if(t!=-1){title1=searchContent.get(t);}
        for(int i=0;i<selectSearch.size();i++){
        	if(selectSearch.get(i).equals("作者")){
        		author.add(searchContent.get(i));
        	}
        	if(selectSearch.get(i).equals("文献来源")){
        		publisher.add(searchContent.get(i));
        	}
        	if(selectSearch.get(i).equals("关键词")){
        		key.add(searchContent.get(i));
        	}
        	if(selectSearch.get(i).equals("摘要")){
        		docAbstract.add(searchContent.get(i));
        	}

        	
        }
		System.out.println("bug"+author);

		int y=selectSearch.indexOf("出版年份");
	    if(y!=-1){year=Integer.parseInt(searchContent.get(y));}

	    docList=searchService.detailedSearch(title1);
	    for(int i=0;i<docList.size();i++){
	    /*	if(!author.equals("")){
	    		if(!docList.get(i).getAuthor().contains(author)){
	    			docList.remove(i);
	    			i--;}
	    	}*/
	    	if(!author.isEmpty()){
	    		for(int j=0;j<author.size();j++){
	    		if(!docList.get(i).getAuthor().contains(author.get(j))){
	    			docList.remove(i);
	    			i--;}
	    		}
	    	}
	    	if(year!=0){
	    		if(docList.get(i).getYear()<year){
	    			docList.remove(i);
	    			i--;}
	    	}
	    	if(!publisher.isEmpty()){
	    		for(int j=0;j<publisher.size();j++){
	    		if(!docList.get(i).getPublisher().contains(publisher.get(j))){
	    			docList.remove(i);
	    			i--;}
	    		}
	    	}
	    	if(!key.isEmpty()){
	    		for(int j=0;j<key.size();j++){
	    		if(!docList.get(i).getKey().contains(key.get(j))){
	    			docList.remove(i);
	    			i--;}
	    		}
	    	}
	    	if(!docAbstract.isEmpty()){
	    		for(int j=0;j<docAbstract.size();j++){
	    		if(!docList.get(i).getDocAbstract().contains(docAbstract.get(j))){
	    			docList.remove(i);
	    			i--;}
	    		}
	    	}
	    	
	    }
	    
		int result = 1;
		if (result > 0) {
			return "success";
		} else
			return "failure";
	}
	
	public String simpleSearch() throws Exception {
		ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
		docList=searchService.simpleSearch(title);
		System.out.println("qqqqw"+title);
		int result = 1;
		if (result > 0) {
			return "success";
		} else
			return "failure";
	}
	public String searchByTag() throws Exception {
		ServletActionContext.getRequest().setCharacterEncoding("UTF-8");

		System.out.println("qqqqw"+tag);
		docList=searchService.searchByTag(tag);
		int result = 1;
		if (result > 0) {
			return "success";
		} else
			return "failure";
	}

	


	public List<Doc> getDocList() {
		return docList;
	}

	public void setDocList(List<Doc> docList) {
		this.docList = docList;
	}

	public Doc getDoc() {
		return doc;
	}

	public void setDoc(Doc doc) {
		this.doc = doc;
	}




	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getDOI() {
		return DOI;
	}

	public void setDOI(int dOI) {
		DOI = dOI;
	}


	public String getConferenceYear() {
		return conferenceYear;
	}

	public void setConferenceYear(String conferenceYear) {
		this.conferenceYear = conferenceYear;
	}

	public String getConferenceCity() {
		return conferenceCity;
	}

	public void setConferenceCity(String conferenceCity) {
		this.conferenceCity = conferenceCity;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getIssue() {
		return issue;
	}

	public void setIssue(String issue) {
		this.issue = issue;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}



	public SearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}
	public void setSearchContent(List<String> searchContent) {
		this.searchContent = searchContent;
	}
	public List<String> getSearchContent() {
		return searchContent;
	}

	public List<String> getSelectSearch() {
		return selectSearch;
	}

	public void setSelectSearch(List<String> selectSearch) {
		this.selectSearch = selectSearch;
	}
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}


}
