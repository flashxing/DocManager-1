package com.docmanager.action;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Arrays;  

import com.docmanager.entity.Assess;
import com.docmanager.entity.AssessMoreInfo;
import com.docmanager.entity.Doc;
import com.docmanager.service.DocAddService;
import com.docmanager.service.AssessService;

import com.docmanager.service.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class LoginAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	LoginService loginService;
	String username;
	String password;
	int userId;
	private List<Doc> docList;
	private Doc doc;
	DocAddService docAddService;
	AssessService assessService;



	private List keyList;
	private List<AssessMoreInfo> assessList;

	public String login() throws Exception {
		boolean result = loginService.findUser(username, password);
    	if(result){
    		if(username.equals("admin"))
    			return "admin_success";
    		else{
    			userId=loginService.getUserId(username);
    			docList = docAddService.getAllDocs();
    			sortKey(docList);
    			List list=assessService.getAllAssess();
    			  if(list != null && list.size()>0){
    				   assessList = new LinkedList();
    				    AssessMoreInfo am;
    				    int count=0;
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
    				     if(assessType==0){
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
    				     count++;
    				     }
    				     if(count==10){
    				    	 break;
    				     }
    				    }
    			   }

    			  
    			Map<String, Object> attibutes = ActionContext.getContext().getSession();//记录用户登录信息 
                attibutes.put("userId", userId); 
                attibutes.put("username", username); 
                attibutes.put("password", password);
            	return "success";
            	}
    	}
		else
			return "failure";
	}


	private void sortKey(List<Doc> docList2) {
		// TODO Auto-generated method stub
        Map< String,Integer> map = new HashMap< String,Integer>();  
        for (int i = 0; i < docList.size(); i++) {  
            if (map.containsKey(docList.get(i).getKey())) {  
                map.put(docList.get(i).getKey(), map.get(docList.get(i).getKey())+1);  
            } else {  
                map.put(docList.get(i).getKey(), 1);  
            }  
        }  
        System.out.println("key1"+map.size());

        Set set = map.entrySet() ;
        Map.Entry[] entries = (Map.Entry[]) set.toArray( new Map.Entry[set.size()] ) ;
        Arrays.sort( entries , new Comparator()
        {
         public int compare( Object arg0 , Object arg1 )
         {
          Object key1 = ( (Map.Entry) arg0 ).getValue() ;
          Object key2 = ( (Map.Entry) arg1 ).getValue() ;
          return ( (Comparable) key2 ).compareTo( key1 ) ;
         }
        } ) ;
        // 将倒序后的数据加到返回的LIST中
        keyList = new ArrayList() ;
        for ( int e = 0 ; e < entries.length ; e++ )
        {
         keyList.add(entries[e].getKey() ) ;
        }

	}


	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public String getPassword() {
		return password;
	}
	
	public DocAddService getDocAddService() {
		return docAddService;
	}

	public void setDocAddService(DocAddService docAddService) {
		this.docAddService = docAddService;
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
	
	public List<AssessMoreInfo> getAssessList() {
		return assessList;
	}


	public void setAssessList(List<AssessMoreInfo> assessList) {
		this.assessList = assessList;
	}


	public List getKeyList() {
		return keyList;
	}


	public void setKeyList(List keyList) {
		this.keyList = keyList;
	}
	public AssessService getAssessService() {
		return assessService;
	}


	public void setAssessService(AssessService assessService) {
		this.assessService = assessService;
	}



		
}
