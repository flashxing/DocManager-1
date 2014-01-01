package com.docmanager.action;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class DownloadAction extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fileName;// 初始的通过param指定的文件名属性 set get



	public String getDownloadFileName() throws UnsupportedEncodingException {
		   String fileName=ServletActionContext.getRequest().getParameter("fileName");
		 //  System.out.println(fileName);
		   String downFileName = fileName;

		//    downFileName = java.net.URLEncoder.encode(downFileName, "UTF-8"); // 这句很重要，不然文件名为乱码    
	//	 downFileName = new String(downFileName.getBytes("utf-8"), "ISO-8859-1");
			System.out.println(downFileName);
		   return downFileName;
		}

	public InputStream getDownloadFile() throws UnsupportedEncodingException {
		//ServletActionContext.getRequest().setCharacterEncoding("UTF-8");


       String name=this.getDownloadFileName();
       String realPath="/attachment/"+name;

       InputStream in=ServletActionContext.getServletContext().getResourceAsStream(realPath);

       if(null==in){
    	    System.out.println("Can not find a java.io.InputStream ");   
    	   }
    	   return ServletActionContext.getServletContext().getResourceAsStream(realPath);
    	}
  
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) throws UnsupportedEncodingException {
		this.fileName = fileName;
	}
	@Override
	public String execute(){
        return "success";
}


}
