package com.docmanager.entity;

public class Doc {
	private int docId;
	private String type;
	private String title;
	private String author;
	private int year;
	private String time;
	private String pages;
	private String publisher;
	private String docAbstract;
	private String key;
	private String url;
	private int userId;
	private int rank;
	//big string
	private String content;

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Doc(){
		
	}
	public Doc(String type, String title, String author, int year, int rank,
				String time, String pages, String publisher, String docAbstract,
				String key, String url, int userId, String content){
		this.type = type;
		this.title = title;
		this.author = author;
		this.year = year;
		this.rank=rank;
		this.time=time;
		this.pages=pages;
		this.publisher = publisher;
		this.docAbstract = docAbstract;
		this.key = key;
		this.url = url;
		this.userId = userId;
		
		this.content=content;
	}
		public Doc(String type, String title, String author, int year, int rank,
				String pages, String publisher, String docAbstract,
				String key, String url, int userId, String content){
		this.type = type;
		this.title = title;
		this.author = author;
		this.year = year;
		this.rank=rank;
		this.pages=pages;
		this.publisher = publisher;
		this.docAbstract = docAbstract;
		this.key = key;
		this.url = url;
		this.userId = userId;
		
		this.content=content;
	}

		
		public Doc(int docId,String type, String title, String author, int year, int rank,
				String time, String pages, String publisher, String docAbstract,
				String key, String url, int userId, String content){
			this.docId=docId;
		this.type = type;
		this.title = title;
		this.author = author;
		this.year = year;
		this.rank=rank;
		this.time=time;
		this.pages=pages;
		this.publisher = publisher;
		this.docAbstract = docAbstract;
		this.key = key;
		this.url = url;
		this.userId = userId;
		
		this.content=content;
	}
		
		
		public Doc(int docId, String title, String author, int year, int rank,
				 String pages, String publisher, String docAbstract,
				String key, String url, int userId, String content){
			this.docId=docId;
		this.title = title;
		this.author = author;
		this.year = year;
		this.rank=rank;
		this.pages=pages;
		this.publisher = publisher;
		this.docAbstract = docAbstract;
		this.key = key;
		this.url = url;
		this.userId = userId;
		
		this.content=content;
	}

	public int getDocId() {
		return docId;
	}
	public void setDocId(int docId) {
		this.docId = docId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDocAbstract() {
		return docAbstract;
	}
	public void setDocAbstract(String docAbstract) {
		this.docAbstract = docAbstract;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Override
	public Doc clone(){
		return new Doc(docId,type,title,author,year,rank,time, pages,publisher,docAbstract,key,url,
				userId,content);
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getPages() {
		return pages;
	}
	public void setPages(String pages) {
		this.pages = pages;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	
	
}
