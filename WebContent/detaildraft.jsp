<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
        function handler(t){
      //document.getElementById("bod").value=t;
    //  "aaa.do?str="+str+"&str2="+str2+"&str3="str3
      var bod=t;
           //   alert(t);
      
      document.detailform.action="updateDetail.action?assessId=<s:property value="assess.assessId"/>"+"&bod="+bod;
      document.detailform.submit();
      
      } 
  </script>
  <style type="text/css">
       .eg {width:400px;float:left;clear:both;font-size: 16px; height:20px;}
       .eg0{margin: 0px 0 20px 0px; height:20px;width:200px;}
       .eg2{margin: 0px 0 20px 0px;  font-size:10px;line-height:14pt}
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
		 <form id="detailform" name="detailform" method="post" >
              <p>文件评分
                <input type="radio" name="radio1" id="rank6" value=1 />
                1分
  <input type="radio" name="radio1" id="rank7" value=2 />
                2分
  <input type="radio" name="radio1" id="rank8" value=3 />
                3分
  <input type="radio" name="radio1" id="rank9" value=4 />
                4分
  <input type="radio" name="radio1" id="rank10" value=5 />
                5分
                <label for="problem"></label>
              </p>
               <div>
              <div class="eg">要解决的问题：</div>      
             <textarea name="problem" id="problem" cols="60" rows="3" >${assess.problem}</textarea>
             <div class="eg">主要思路：</div>      
             <textarea name="idea" id="idea" cols="60" rows="3" >${assess.idea}</textarea>
             <div class="eg">实验结果：</div>      
             <textarea name="experiment" id="problem" cols="60" rows="3" >${assess.experiment}</textarea>
             <div class="eg">已有贡献：</div>      
             <textarea name="contribution" id="contribution" cols="60" rows="3" >${assess.contribution}</textarea>
             <div class="eg">可改进的地方：</div>      
             <textarea name="improvement" id="improvement" cols="60" rows="3" >${assess.improvement}</textarea>
             
                </div>
                  <p  class="date4">
                    <input type="submit" name="submit" id="submit" value="发表" onclick="handler(0)"/>
                    <input type="submit" name="cancel" id="cancel" value="保存" onclick="handler(1)"/>
                  </p>
                </form>
              </div>  </div>
              <div class="idea"></div>
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
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&amp;web_id=155540' type="text/javascript" charset='gb2312'></script></div>
</body>
</html>