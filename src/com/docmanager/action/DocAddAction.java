package com.docmanager.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.struts2.ServletActionContext;

import com.docmanager.entity.Assess;
import com.docmanager.entity.AssessMoreInfo;
import com.docmanager.entity.Doc;
import com.docmanager.entity.DocAttach;

import com.docmanager.service.AssessService;
import com.docmanager.service.DocAddService;
import com.docmanager.util.MapUtil;
import com.opensymphony.xwork2.ActionSupport;

public class DocAddAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DocAddService docAddService;
	AssessService assessService;
	private int docId;
	private String type;
	private String title;
	private String author;

	private int year;
	private String pages;

	private String publisher;
	private String docAbstract;
	private String key;
	private String url;
	


	private List<Doc> docList;
	private Doc doc;
	private DocAttach docattach;
	private List<DocAttach> docattachList;
	
	private List<DocAttach> paperList;
	private List<DocAttach> pptList;
	private List<DocAttach> posterList;
	private List<DocAttach> presentList;
	private List<DocAttach> additionList;
	private List<DocAttach> codeList;

	private List<String> hiddenName;

	public List<String> getHiddenName() {
		return hiddenName;
	}
	public void setHiddenName(List<String> hiddenName) {
		this.hiddenName = hiddenName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private File[] paperA; // 上传的文件
	private File[] pptA; 
	private File[] posterA; 
	private File[] presentA; 
	private File[] additionA; 
	private File[] codeA; 


	private String[] paperAFileName; // 文件名称
	private String[] paperAContentType; // 文件类型
	private String[] pptAFileName; 
	private String[] pptAContentType; 
	private String[] posterAFileName; 
	private String[] posterAContentType; 
	private String[] presentAFileName; 
	private String[] presentAContentType; 
	private String[] additionAFileName; 
	private String[] additionAContentType; 
	private String[] codeAFileName; 
	private String[] codeAContentType; 


	private String savePath;

	private String attachType;
	private String attachName;
	private String attachAddress;

	

	private int assessId;
	private String time;
	private int userId;
	private int rank;
	private int assessType;
	private String briefAssess;
	private String problem;
	private String idea;
	private String experiment;
	private String contribution;
	private String improvement;
	private int radio1;
	private int radio2;
	private int state;
	private Assess assess;
	private List<AssessMoreInfo> assessList;
	
	private Map<String,String> map;
	public Map<String, String> getMap() {
		return map;
	}
	public void setMap(Map<String, String> map) {
		this.map = map;
	}

	private String[] content;
	private int[] contentId;
	private Map<String,String> contentMap;
	private List<String> typeList;
	private List<String> metaLists;
	private Map<String,String> metaMap;

	public Map<String, String> getMetaMap() {
		return metaMap;
	}
	public void setMetaMap(Map<String, String> metaMap) {
		this.metaMap = metaMap;
	}
	public List<String> getMetaLists() {
		return metaLists;
	}
	public void setMetaLists(List<String> metaLists) {
		this.metaLists = metaLists;
	}
	private List<Map<String, String>> metaMaps;
	private Map<String, String> tushuMap;
	private Map<String, String> tushuzhangjieMap;
	int id;
	public String getTypes() throws Exception {
		//System.out.println("test0");
		typeList=new ArrayList<String>();
		typeList.add("图书");
		typeList.add("图书章节");
		typeList.add("期刊");
		typeList.add("会议");
		typeList.add("在线资源");
		//System.out.println(typeList);
		metaMap =new HashMap<String, String>();
		
		metaMaps=new ArrayList<Map<String,String>>();
		tushuMap = new HashMap<String, String>() ;
		tushuzhangjieMap = new HashMap<String, String>() ;
		tushuMap.put("1", "标题");
		tushuMap.put("2", "作者");
		tushuMap.put("3", "出版社");
		tushuzhangjieMap.put("3", "出版社");
		metaMaps.add(tushuMap);
		metaMaps.add(tushuzhangjieMap);

		int result = 1;
		if (result > 0) {
			return "success";
		} else
			return "failure";
	}

	public List<DocAttach> uploadFile(File[] files,String type,String[] Afilename,int id) throws Exception{
		if (files != null && files.length > 0) {
			List<File> filesarray = new ArrayList<File>();
			List<String> namearray = new ArrayList<String>();
			for(int i = 0;i < files.length;i++){
				  filesarray.add(files[i]);
				}
			for(int i = 0;i < Afilename.length;i++){
				  namearray.add(Afilename[i]);
				}
			checkExist(filesarray,namearray);
			
			for (int i = 0; i < filesarray.size(); i++) {
				System.out.println(getSavePath() + "\\" + namearray.get(i));
				attachType = type;
				attachName = namearray.get(i);
				attachAddress = getSavePath() + "\\" + namearray.get(i);
				docattach = new DocAttach(id, attachType, attachName,attachAddress, 1);
				docattachList.add(docattach);
				FileOutputStream fos = new FileOutputStream(getSavePath()+ "\\" + namearray.get(i));
				System.out.print("qqq"+attachName);
				System.out.println(filesarray.get(i).exists());
				FileInputStream fis = new FileInputStream(filesarray.get(i));
				byte[] buffer = new byte[102400];
				int len = 0;
				while ((len = fis.read(buffer)) > 0) {
					fos.write(buffer, 0, len);
				}
				fis.close();
				fos.close();
			}
		}
return docattachList;
	}
public void checkExist(List<File> filesarray, List<String> namearray){
	for(int i=0;i<filesarray.size();i++){
		if (!filesarray.get(i).exists()){
			filesarray.remove(i);
			namearray.remove(i);
			i--;
		}
	}
	
}


	@Override
	public String execute() throws Exception {
		docattachList = new ArrayList<DocAttach>();
		ServletActionContext.getRequest().setCharacterEncoding("UTF-8");
		// 取得需要上传的文件数组
		File[] files = getPaperA();
		paperList=uploadFile(files,"paper",getPaperAFileName(),id);
		File[] files1 = getPptA();
		System.out.println(files1);
		pptList=uploadFile(files1,"ppt",getPptAFileName(),id);
		File[] files2 = getPosterA();
		posterList=uploadFile(files2,"poster",getPosterAFileName(),id);
		File[] files3 = getPresentA();
	    presentList=uploadFile(files3,"present",getPresentAFileName(),id);
		File[] files4 = getAdditionA();
		additionList=uploadFile(files4,"addition",getAdditionAFileName(),id);
		File[] files5 = getCodeA();
		codeList=uploadFile(files5,"code",getCodeAFileName(),id);

		return SUCCESS;
	}
	public String docAdd() throws Exception {
		// System.out.println("gdfsg");
		// System.out.println(key);
		contentId=new int[2];
		contentId[0]=1;		
		contentId[1]=4;

		String[] contentid=new String[2];
		contentid[0]=""+contentId[0];
		contentid[1]=""+contentId[1];

		content=new String[2];
		content[0]="sww";
		content[1]="xlx";

		Map<String,String> map=MapUtil.generateMapFromArray(contentid,content);
		String re=MapUtil.packageString(map);
		int result = docAddService.addDoc(type, title, author, year, pages,
				publisher, docAbstract, key, url,re );
		System.out.println(type);
		id=result;
		System.out.println(id);
		execute();

		int result2 = docAddService.addAttach(docattachList);
		if (result > 0) {
			return "success";
		} else
			return "failure";
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public String getDocs() throws Exception {
	//	contentList =new ArrayList<Map<String,String>>();
		docList = docAddService.getDocsByUserId(userId);
	//	for(Doc doc: docList){
	//		contentList.add(MapUtil.parserString(doc.getContent()));
	//	}
		System.out.println("userid"+userId);
		int result = 1;
		System.out.println("test");
		if (result > 0) {
			return "success";
		} else
			return "failure";
	}

	public String updateDoc() throws Exception {
		contentId=new int[2];
		contentId[0]=1;		
		contentId[1]=4;

		String[] contentid=new String[2];
		contentid[0]=""+contentId[0];
		contentid[1]=""+contentId[1];

		content=new String[2];
		content[0]="sww";
		content[1]="xlx";

		Map<String,String> map=MapUtil.generateMapFromArray(contentid,content);
		String re=MapUtil.packageString(map);

		int result = docAddService.updateDoc(docId, type,title, author, year,time, pages,
				publisher, docAbstract, key, url, re);
		//int result2 = docAddService.updateAttach(docattachList);
		id=docId;
		System.out.println("qqqqqq"+id);

		execute();
        System.out.println("testhidden"+hiddenName);
		int result2 = docAddService.addAttach(docattachList);

		return "success";
	}

	public String getDocById() throws Exception {
		contentMap =new HashMap<String, String>();
		doc = docAddService.getDocById(docId);
		contentMap=MapUtil.parserString(doc.getContent());

		docattachList=docAddService.getAttach(docId);
		paperList=new ArrayList<DocAttach>();
		pptList=new ArrayList<DocAttach>();
		posterList=new ArrayList<DocAttach>();
		presentList=new ArrayList<DocAttach>();
		additionList=new ArrayList<DocAttach>();
		codeList=new ArrayList<DocAttach>();

		//System.out.println(docattachList.size());
		for (DocAttach docattach:docattachList){
		//	System.out.println(docattach.getAttachType());
			if(docattach.getAttachType().equals("paper")){
				paperList.add(docattach);
				System.out.println("dfsdfadfa");
				System.out.println(paperList.size());

			}
			if(docattach.getAttachType().equals("ppt")){
				pptList.add(docattach);
			}
			if(docattach.getAttachType().equals("poster")){
				posterList.add(docattach);
			}

			if(docattach.getAttachType().equals("present")){
				presentList.add(docattach);
			}

			if(docattach.getAttachType().equals("addition")){
				additionList.add(docattach);
			}

			if(docattach.getAttachType().equals("code")){
				codeList.add(docattach);
			}
		}
		List list= assessService.getAssess(docId);
		   assessList = new LinkedList();
		   if(list != null && list.size()>0){
			    AssessMoreInfo am;
			    for(int i = 0; i < list.size();i++){
			     am = new AssessMoreInfo();
			     Object[] object = (Object[])list.get(i);// 每行记录不在是一个对象 而是一个数组
			     int assessId =  (Integer) object[0];
			     String time =  (String)object[1];
			     int rank =  (Integer)object[2];
			     int assessType =  (Integer)object[3];
			     String briefAssess =  (String)object[4];
			     String problem =  (String)object[5];
			     String idea =  (String)object[6];
			     String experiment =  (String)object[7];
			     String contribution =  (String)object[8];
			     String improvement =  (String)object[9];
			     String userName =  (String)object[10];
			     String title =  (String)object[11];

			     // 重新封装在一个javabean里面
			     am.setAssessId(assessId);
			     am.setTime(time);
			     am.setRank(rank);
			     am.setAssessType(assessType);
			     am.setBriefAssess(briefAssess);
			     am.setProblem(problem);
			     am.setIdea(idea);
			     am.setExperiment(experiment);
			     am.setContribution(contribution);
			     am.setImprovement(improvement);
			     am.setUserName(userName);
			     am.setTitle(title);
			     assessList.add(am); // 最终封装在list中 传到前台。
			    }
		   }
		int sumRank=0;int count=0;
		for(int i=0;i<assessList.size();i++){
			if(assessList.get(i).getRank()!=0){
				sumRank=sumRank+assessList.get(i).getRank();
				count++;
			}
		}
		if(count!=0){sumRank=sumRank/count;}
		
		rank=sumRank;
		//System.out.println(AdocId);
	//	System.out.println(type);

		return "success";
	}
	public String docDelete() throws Exception {
		int result = docAddService.docDelete(docId);
		return "success";
	}
	public void setDocAddService(DocAddService DocAddService) {
		this.docAddService = DocAddService;
	}
	public AssessService getAssessService() {
		return assessService;
	}

	public void setAssessService(AssessService assessService) {
		this.assessService = assessService;
	}

	public Assess getAssess() {
		return assess;
	}

	public void setAssess(Assess assess) {
		this.assess = assess;
	}

	public List<AssessMoreInfo> getAssessList() {
		return assessList;
	}

	public void setAssessList(List<AssessMoreInfo> assessList) {
		this.assessList = assessList;
	}


	public void setType(String type) {
		this.type = type;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public void setPages(String pages) {
		this.pages = pages;
	}

	public void setDocAbstract(String docAbstract) {
		this.docAbstract = docAbstract;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setUrl(String url) {
		this.url = url;
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


	/**
	 * 返回上传文件保存的位置
	 * 
	 * @return
	 * @throws Exception
	 */
	public String getSavePath() throws Exception {
		return ServletActionContext.getServletContext().getRealPath(savePath);
		
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}

	public String getUrl() {
		return url;
	}


	public void setDocattach(DocAttach docattach) {
		this.docattach = docattach;
	}

	public DocAttach getDocattach() {
		return docattach;
	}

	public void setDocattachList(List<DocAttach> docattachList) {
		this.docattachList = docattachList;
	}

	public List<DocAttach> getDocattachList() {
		return docattachList;
	}

	public int getDocId() {
		return docId;
	}

	public void setDocId(int docId) {
		this.docId = docId;
	}

	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}

	public String getAttachName() {
		return attachName;
	}

	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}

	public String getAttachAddress() {
		return attachAddress;
	}

	public void setAttachAddress(String attachAddress) {
		this.attachAddress = attachAddress;
	}

	public DocAddService getDocAddService() {
		return docAddService;
	}

	public String getType() {
		return type;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublisher() {
		return publisher;
	}

	public String getKey() {
		return key;
	}

	public String getTitle() {
		return title;
	}

	public int getYear() {
		return year;
	}

	public String getPages() {
		return pages;
	}

	public String getDocAbstract() {
		return docAbstract;
	}

	public String getAttachType() {
		return attachType;
	}
	public String getBriefAssess() {
		return briefAssess;
	}

	public void setBriefAssess(String briefAssess) {
		this.briefAssess = briefAssess;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getIdea() {
		return idea;
	}

	public void setIdea(String idea) {
		this.idea = idea;
	}

	public String getExperiment() {
		return experiment;
	}

	public void setExperiment(String experiment) {
		this.experiment = experiment;
	}

	public String getContribution() {
		return contribution;
	}

	public void setContribution(String contribution) {
		this.contribution = contribution;
	}

	public String getImprovement() {
		return improvement;
	}

	public void setImprovement(String improvement) {
		this.improvement = improvement;
	}

	public int getRadio1() {
		return radio1;
	}

	public void setRadio1(int radio1) {
		this.radio1 = radio1;
	}

	public int getRadio2() {
		return radio2;
	}

	public void setRadio2(int radio2) {
		this.radio2 = radio2;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	public int getAssessId() {
		return assessId;
	}

	public void setAssessId(int assessId) {
		this.assessId = assessId;
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

	public int getAssessType() {
		return assessType;
	}

	public void setAssessType(int assessType) {
		this.assessType = assessType;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public File[] getPaperA() {
		return paperA;
	}

	public void setPaperA(File[] paperA) {
		this.paperA = paperA;
	}

	public File[] getPptA() {
		return pptA;
	}

	public void setPptA(File[] pptA) {
		this.pptA = pptA;
	}

	public File[] getPosterA() {
		return posterA;
	}

	public void setPosterA(File[] posterA) {
		this.posterA = posterA;
	}

	public File[] getPresentA() {
		return presentA;
	}

	public void setPresentA(File[] presentA) {
		this.presentA = presentA;
	}

	public File[] getAdditionA() {
		return additionA;
	}

	public void setAdditionA(File[] additionA) {
		this.additionA = additionA;
	}

	public File[] getCodeA() {
		return codeA;
	}

	public void setCodeA(File[] codeA) {
		this.codeA = codeA;
	}

	public String[] getPaperAFileName() {
		return paperAFileName;
	}

	public void setPaperAFileName(String[] paperAFileName) {
		this.paperAFileName = paperAFileName;
	}

	public String[] getPaperAContentType() {
		return paperAContentType;
	}

	public void setPaperAContentType(String[] paperAContentType) {
		this.paperAContentType = paperAContentType;
	}

	public String[] getPptAFileName() {
		return pptAFileName;
	}

	public void setPptAFileName(String[] pptAFileName) {
		this.pptAFileName = pptAFileName;
	}

	public String[] getPptAContentType() {
		return pptAContentType;
	}

	public void setPptAContentType(String[] pptAContentType) {
		this.pptAContentType = pptAContentType;
	}

	public String[] getPosterAFileName() {
		return posterAFileName;
	}

	public void setPosterAFileName(String[] posterAFileName) {
		this.posterAFileName = posterAFileName;
	}

	public String[] getPosterAContentType() {
		return posterAContentType;
	}

	public void setPosterAContentType(String[] posterAContentType) {
		this.posterAContentType = posterAContentType;
	}

	public String[] getPresentAFileName() {
		return presentAFileName;
	}

	public void setPresentAFileName(String[] presentAFileName) {
		this.presentAFileName = presentAFileName;
	}

	public String[] getPresentAContentType() {
		return presentAContentType;
	}

	public void setPresentAContentType(String[] presentAContentType) {
		this.presentAContentType = presentAContentType;
	}

	public String[] getAdditionAFileName() {
		return additionAFileName;
	}

	public void setAdditionAFileName(String[] additionAFileName) {
		this.additionAFileName = additionAFileName;
	}

	public String[] getAdditionAContentType() {
		return additionAContentType;
	}

	public void setAdditionAContentType(String[] additionAContentType) {
		this.additionAContentType = additionAContentType;
	}

	public String[] getCodeAFileName() {
		return codeAFileName;
	}

	public void setCodeAFileName(String[] codeAFileName) {
		this.codeAFileName = codeAFileName;
	}

	public String[] getCodeAContentType() {
		return codeAContentType;
	}

	public void setCodeAContentType(String[] codeAContentType) {
		this.codeAContentType = codeAContentType;
	}
	public void setPaperList(List<DocAttach> paperList) {
		this.paperList = paperList;
	}



	public List<DocAttach> getPptList() {
		return pptList;
	}



	public void setPptList(List<DocAttach> pptList) {
		this.pptList = pptList;
	}



	public List<DocAttach> getPosterList() {
		return posterList;
	}



	public void setPosterList(List<DocAttach> posterList) {
		this.posterList = posterList;
	}



	public List<DocAttach> getPresentList() {
		return presentList;
	}



	public void setPresentList(List<DocAttach> presentList) {
		this.presentList = presentList;
	}



	public List<DocAttach> getAdditionList() {
		return additionList;
	}



	public void setAdditionList(List<DocAttach> additionList) {
		this.additionList = additionList;
	}



	public List<DocAttach> getCodeList() {
		return codeList;
	}


	public List<DocAttach> getPaperList() {
		return paperList;
	}

	public void setCodeList(List<DocAttach> codeList) {
		this.codeList = codeList;
	}
	public String[] getContent() {
		return content;
	}
	public void setContent(String[] content) {
		this.content = content;
	}
	public int[] getContentId() {
		return contentId;
	}
	public void setContentId(int[] contentId) {
		this.contentId = contentId;
	}
	public Map<String, String> getContentMap() {
		return contentMap;
	}
	public void setContentMap(Map<String, String> contentMap) {
		this.contentMap = contentMap;
	}

	public List<String> getTypeList() {
		return typeList;
	}
	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}
	public List<Map<String, String>> getMetaMaps() {
		return metaMaps;
	}
	public void setMetaMaps(List<Map<String, String>> metaMaps) {
		this.metaMaps = metaMaps;
	}
	public Map<String, String> getTushuMap() {
		return tushuMap;
	}
	public void setTushuMap(Map<String, String> tushuMap) {
		this.tushuMap = tushuMap;
	}
	public Map<String, String> getTushuzhangjieMap() {
		return tushuzhangjieMap;
	}
	public void setTushuzhangjieMap(Map<String, String> tushuzhangjieMap) {
		this.tushuzhangjieMap = tushuzhangjieMap;
	}


}
