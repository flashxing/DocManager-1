<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>文献管理系统</title>
<meta name="Keywords" content="" />
<meta name="Description" content="" />
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="screen" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<script src="http://www.see-source.com/bootstrap/js/jquery.js" type="text/javascript"></script>
<script src="http://www.see-source.com/bootstrap/js/bootstrap-tab.js"  type="text/javascript"></script>
        <script>
        $(function () {
            $("#tabs1 a").click(function (e) {
                $(this).tab('show');
            });
        });
        
        function myfun(){
        var type="${doc.type}";        
        //alert("this window.onload");
        if(type=="期刊")
        {
        document.getElementById("doc_info").innerHTML=
         " <p><strong>类型 </strong><s:property value="doc.type" />"
		+" <strong >作者</strong> <s:property value="doc.author"/> "
	    +"  <strong >年份</strong> <s:property value="doc.year"/> "
	   	+" <strong >页数</strong> <s:property value="doc.pages"/></p>"
	    +" <p><strong >DOI</strong> <s:property value="doc.DOI"/> "
	    + "<strong >期刊名</strong> <s:property value="doc.publisher"/> "
	   	+ "<strong >卷</strong> <s:property value="doc.volume"/> "
	    + "<strong >期</strong> <s:property value="doc.issue"/></p> "
         +"  <p><strong>摘要</strong><s:property value="doc.docAbstract" /></p>"
         +"  <p><strong>关键字</strong><s:property value="doc.key" /></p>"
         +"  <p><strong>URL</strong> <a href='#'><s:property value="doc.url" /></a></p> ";
        }
        if(type=="图书")
        {
        document.getElementById("doc_info").innerHTML=
        " <p><strong>类型 </strong><s:property value="doc.type" />"
		+" <strong >作者</strong> <s:property value="doc.author"/> "
	    +"  <strong >年份</strong> <s:property value="doc.year"/> "
	   	+" <strong >页数</strong> <s:property value="doc.pages"/></p>"
	   	
	    +"<p><strong >ISBN</strong> <s:property value="doc.ISBN"/> "
	    + "<strong >出版社</strong> <s:property value="doc.publisher"/> "
	   	+ "<strong >编辑</strong> <s:property value="doc.editor"/></p> "
	   	 +"  <p><strong>摘要</strong><s:property value="doc.docAbstract" /></p>"
         +"  <p><strong>关键字</strong><s:property value="doc.key" /></p>"
         +"  <p><strong>URL</strong> <a href='#'><s:property value="doc.url" /></a></p> ";
        }
        if(type=="图书章节")
        {
        document.getElementById("doc_info").innerHTML=
        " <p><strong>类型 </strong><s:property value="doc.type" />"
		+" <strong >作者</strong> <s:property value="doc.author"/> "
	    +"  <strong >年份</strong> <s:property value="doc.year"/> "
	   	+" <strong >页数</strong> <s:property value="doc.pages"/></p>"
        
	   + "<p><strong >图书名</strong> <s:property value="doc.bookName"/>"
	    + "<strong >出版社</strong> <s:property value="doc.publisher"/> "
	   	+ "<strong >编辑</strong> <s:property value="doc.editor"/></p> "
	   	+"  <p><strong>摘要</strong><s:property value="doc.docAbstract" /></p>"
         +"  <p><strong>关键字</strong><s:property value="doc.key" /></p>"
         +"  <p><strong>URL</strong> <a href='#'><s:property value="doc.url" /></a></p> ";
        }
        if(type=="会议")
        {
        document.getElementById("doc_info").innerHTML=
        " <p><strong>类型 </strong><s:property value="doc.type" />"
		+" <strong >作者</strong> <s:property value="doc.author"/> "
	    +"  <strong >年份</strong> <s:property value="doc.year"/> "
	   	+" <strong >页数</strong> <s:property value="doc.pages"/></p>"
        
	   +"<p><strong >DOI</strong> <s:property value="doc.DOI"/> "
	    + "<strong >会议名</strong> <s:property value="doc.publisher"/> "
	   	+ "<strong >会议年份</strong> <s:property value="doc.conferenceYear"/> "
	    + "<strong >会议所在城市</strong> <s:property value="doc.conferenceCity"/></p> "
	   	+"  <p><strong>摘要</strong><s:property value="doc.docAbstract" /></p>"
         +"  <p><strong>关键字</strong><s:property value="doc.key" /></p>"
         +"  <p><strong>URL</strong> <a href='#'><s:property value="doc.url" /></a></p> ";
        }
        if(type=="学位论文")
        {
        document.getElementById("doc_info").innerHTML=
                " <p><strong>类型 </strong><s:property value="doc.type" />"
		+" <strong >作者</strong> <s:property value="doc.author"/> "
	    +"  <strong >年份</strong> <s:property value="doc.year"/> "
	   	+" <strong >页数</strong> <s:property value="doc.pages"/></p>"
        
	   + "<p><strong >学校</strong> <s:property value="doc.school"/> "
	    + "<strong >出版社</strong> <s:property value="doc.publisher"/> </p>"
	    	   	+"  <p><strong>摘要</strong><s:property value="doc.docAbstract" /></p>"
         +"  <p><strong>关键字</strong><s:property value="doc.key" /></p>"
         +"  <p><strong>URL</strong> <a href='#'><s:property value="doc.url" /></a></p> ";
        }
        if(type=="技术报告")
        {
        document.getElementById("doc_info").innerHTML=
        " <p><strong>类型 </strong><s:property value="doc.type" />"
		+" <strong >作者</strong> <s:property value="doc.author"/> "
	    +"  <strong >年份</strong> <s:property value="doc.year"/> "
	   	+" <strong >页数</strong> <s:property value="doc.pages"/></p>"
	    +"<p><strong >出版社</strong> <s:property value="doc.publisher"/></p> "
	    +"  <p><strong>摘要</strong><s:property value="doc.docAbstract" /></p>"
         +"  <p><strong>关键字</strong><s:property value="doc.key" /></p>"
         +"  <p><strong>URL</strong> <a href='#'><s:property value="doc.url" /></a></p> ";
        }
        if(type=="在线资源")
        {
        document.getElementById("doc_info").innerHTML=
        " <p><strong>类型 </strong><s:property value="doc.type" />"
		+" <strong >作者</strong> <s:property value="doc.author"/> "
	    +"  <strong >年份</strong> <s:property value="doc.year"/> "
	   	+" <strong >页数</strong> <s:property value="doc.pages"/></p>"
	    +"<p><strong >出版社</strong> <s:property value="doc.publisher"/></p> "
	    +"  <p><strong>摘要</strong><s:property value="doc.docAbstract" /></p>"
         +"  <p><strong>关键字</strong><s:property value="doc.key" /></p>"
         +"  <p><strong>URL</strong> <a href='#'><s:property value="doc.url" /></a></p> ";
        }
        }
        window.onload=myfun;
        
      function handler(t){
      //document.getElementById("bod").value=t;
      //alert(document.getElementById("bod").value);
    //  "aaa.do?str="+str+"&str2="+str2+"&str3="str3
      var bod=t;
      document.briefForm.action="briefAssess.action?docId=<s:property value="doc.docId"/>"+"&bod="+bod;
      document.briefForm.submit();
      
      } 
      function handler1(t){
      var bod=t;
      document.detailedForm.action="detailedAssess.action?docId=<s:property value="doc.docId"/>"+"&bod="+bod;
      document.detailedForm.submit();
      
      } 
      
        </script>
        
    <style type="text/css">
       .eg {width:120px;float:left;clear:both;font-size: 16px; height:20px}
       .eg0{margin: 0px 0 20px 0px; height:20px;width:200px;}
       .eg2{margin: 0px 0 20px 0px; height:60px;width:250px; font-size:10px;line-height:14pt}
</style>
</head>
<body>


<div id="wrapper">

	<div id="header">
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="login.action">首页</a></li>
				<li><a href="getDocs">我的文献</a></li>
				<li><a href="literature_import.jsp">文献录入</a></li>
				<li><a href="statistics.jsp">统计信息</a></li>
				<li><a href="literature_search.jsp">文献查询</a></li>
			</ul>
		</div>
		<!-- end #menu -->
		<div id="search">
			<form method="post" action="simpleSearch.action">
				<fieldset>
				<input type="text" name="title" id="search-text" size="15" />
				<input type="submit" id="search-submit" value="查询" />
				</fieldset>
			</form>
		</div>
		<!-- end #search -->
	</div>
	<!-- end #header -->
	<div id="logo">
		<h1><a href="#">文献管理系统</a></h1>
		<p><em> </em></p>
	</div>
	<hr />
	<!-- end #logo -->
<!-- end #header-wrapper -->

<div id="page">
	<div id="content1">
		<div class="post">
			<h2 class="title1"><s:property value="doc.title" /></h2>
		<form action="docEdit.action?docId=<s:property value="doc.docId" />" method="post" >
			<p class="date1"><input type="submit" name="submit" id="submit" value="编辑" /></p>
			</form>
		<form action="docDelete.action?docId=<s:property value="doc.docId" />" method="post" >
			<p class="date1"><input type="submit" name="submit" id="submit" value="删除" /></p>
			</form>
			
			<div class="entry">
              <div id="doc_info"> </div> 
              
              
                <table class="table"  border="1" width="200">
                <thead>
                 <tr>
                 <th>类型</th>
                 <th>附件名字</th>
                 </tr>
                 </thead>
                 <tbody>
                   <s:iterator id="tmp1" value="docattachList">
                   <tr class="active">
                   <td><s:property value="#tmp1.attachType"/></td>  
                   <td><a href="download?fileName=<s:property value ="#tmp1.attachName" />" name="fileName" ><s:property value="#tmp1.attachName"/></a></td>     
                   </tr>
                   </s:iterator>
                   
                   </tbody>
                </table>
			</div>
		</div>
		<div class="post">
		<div class="span12 entry">
		<p><strong>文献评分：</strong><s:property value="rank"/>星级</p>
                <ul class="nav-tabs nav" id="tabs1">
                    <li class="active"><a href="#tabs-1" name="tabs-1">添加简要评价</a></li>
                    <li><a href="#tabs-2" name="tabs-2">添加详细评价</a></li>
                    <li><a name="tabs-3" href="#tabs-3">查看评价详情</a></li>
                    
                </ul>
		  <div class="tab-content">
              <div class="tab-pane active" id="tabs-1">
              <form id="briefForm" name="briefForm" method="post" >
		      <p>文献评分
                <input type="radio" name="radio1" id="rank1" value=1 />
1分
<input type="radio" name="radio1" id="rank2" value=2 />
2分
<input type="radio" name="radio1" id="rank3" value=3 />
3分
<input type="radio" name="radio1" id="rank4" value=4 />
4分
<input type="radio" name="radio1" id="rank5" value=5 />
5分</p>
		      <p>请输入你的评价：</p>
		      <p>
		          <textarea name="briefAssess" id="briefAssess" class="eg2" cols="60" rows="3"></textarea>
	            </p>
		        <p class="date3">
		        
		          <input type="button" name="submit2" id="submit2" value="提交" onclick="handler(0)"/>
		          <input type="button" name="save" id="save" value="保存草稿" onclick="handler(1)"/>
	              <input type="button" name="cancel2" id="cancel2" value="取消" onclick=""/>
		        </p>
		      </form>
		        
		    </div>
		    <div class="tab-pane" id="tabs-2">
		    <form id="detailedForm" name="detailedForm" method="post" >
		    
              <p>文件评分
                <input type="radio" name="radio2" id="rank6" value=1 />
                1分
  <input type="radio" name="radio2" id="rank7" value=2 />
                2分
  <input type="radio" name="radio2" id="rank8" value=3 />
                3分
  <input type="radio" name="radio2" id="rank9" value=4 />
                4分
  <input type="radio" name="radio2" id="rank10" value=5 />
                5分
                <label for="problem"></label>
              </p>
              <div class="problem">
              <div>
              <div class="eg">要解决的问题：</div>      
                  <textarea name="problem" class="eg2" cols="60" rows="3" id="problem"></textarea>
                </div>
               <div>
              <div class="eg">主要思路：</div>  
                  <textarea name="idea" id="idea" class="eg2" cols="60" rows="3"></textarea>
                </div>
                <div>
                <div class="eg">实验结果：</div>
                  <textarea name="experiment" id="experiment" class="eg2" cols="60" rows="3"></textarea>
                </div>
                <div>
                <div class="eg">已有的贡献：</div> 
                  <textarea name="contribution" id="contribution" class="eg2" cols="60" rows="3"></textarea>
                </div>
                <div>
               <div class="eg">可改进的地方：</div>
                  <textarea name="improvement" id="improvement" class="eg2" cols="60" rows="3"></textarea>
                </div>
                  <p  class="date2">
                   <input type="submit" name="submit" id="submit" value="提交" onclick="handler1(0)" />
                    <input type="submit" name="save" id="save" value="保存草稿" onclick="handler1(1)" />
                    <input type="submit" name="cancel" id="cancel" value="取消" onclick=""/>
                  </p>
                </form>
              </div>
              <div class="idea"></div>
	      </div>
	      
	            <div class="tab-pane " id="tabs-3">
	         <p><strong>简要评价</strong></p>   
		     <s:iterator id="tmp2" value="assessList">
		     <script>
		     var type=${tmp2.assessType};
		     if(type==0){
		             document.getElementById("tabs-3").innerHTML+="<p><strong><s:property value="#tmp2.userName"/> </strong>: <s:property value="#tmp2.briefAssess"/> </p> ";
		     }
              </script>    
			 </s:iterator>
			<hr />
			 
		     <p><strong>详细评价</strong></p>   
		     <s:iterator id="tmp3" value="assessList">
		     <script>
		     var type=${tmp3.assessType};
		     if(type==1){
		             document.getElementById("tabs-3").innerHTML+=
		             "<p><strong><s:property value="#tmp3.userName"/> </strong>: <strong>要解决的问题：</strong><s:property value="#tmp3.problem"/> </p>"
		             +"<p> <strong>主要思路：</strong><s:property value="#tmp3.idea"/> </p>"
		             +"<p> <strong>实验结果：</strong><s:property value="#tmp3.experiment"/> </p>"
		             +"<p> <strong>已有的贡献：</strong><s:property value="#tmp3.contribution"/> </p>"
		             +"<p> <strong>可改进的地方：</strong><s:property value="#tmp3.improvement"/> </p>";
		     }
               </script>    
			 </s:iterator>
			 
		    </div>
		    
		    
		  </div>
		</div>
	</div>
	<!-- end #content -->
	<form id="form1" method="post" action="">
	  <p>
	    <label for="tag"></label>
	  </p>
    </form>
	<div style="clear: both;">&nbsp;</div>
</div>
<!-- end #page -->

<div id="footer">
	<p>Copyright (c) 2013 software.nju.edu.cn. All rights reserved. Design by <a href="#">Group Doc_manager</a>.</p>
</div>
<!-- end #footer -->
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&amp;web_id=155540' type="text/javascript" charset='gb2312'></script></div>
</body>
</html>