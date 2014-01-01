<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>文献管理系统</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="css/bootstrap.css" rel="stylesheet">
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body>
<div id="wrapper">

	<div id="header">
		<div id="menu">
			<ul>
				<li class="current_page_item"><a href="login.action">首页</a></li>
				<li><a href="getDocs?userId=<s:property value="#session.userId"/>">我的文献</a></li>
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
	<div id="content">
	<s:iterator id="tmp" value="docList">
		<div class="post">
			<h2 class="title"><s:property value="#tmp.title"/></h2>
			<p class="date"></p>
			<div class="entry">
                <p><strong>作者 </strong><s:property value="#tmp.author"/><strong>出版社 </strong><s:property value="#tmp.publisher"/></p> 
                <p><strong>摘要</strong> <s:property value="#tmp.docAbstract"/> </p>
                <p><strong>关键字</strong> <s:property value="#tmp.key"/></p>
                <p><strong>URL</strong> <a href="#"><s:property value="#tmp.url"/></a></p>
				<p class="links"><a href="getDocById?docId=<s:property value="#tmp.docId"/>" class="permalink">进入文献</a><a href="getDocById?docId=<s:property value="#tmp.docId"/>" class="permalink">查看评价</a></p>
			</div>
		</div>
 </s:iterator>
		
		
	</div>
	<!-- end #content -->
	<div id="sidebar">
		<ul>
			<li>
				<h2>用户</h2>
                  <p>用户：<s:property value="#session.username"/>
                  </p>
                  <p style="padding:30px 0 0 15px"><a href="getDocs"><u>我的文献</u></a>&nbsp;&nbsp;&nbsp;<a href="getDraft"><u>我的草稿</u></a></p>  
                <p>&nbsp;</p>
			</li>
			<li id="calendar">
				<h2>热门标签</h2>
				<div id="calendar_wrap">
				 <s:iterator id="tmp" value="keyList">
				 <a href="searchByTag?tag=<s:property value="#tmp"/>" ><s:property value="#tmp"/></a>
				 &nbsp;&nbsp;
				 </s:iterator>
				
				
				</div>
			</li>
			<li>
				<h2>最新评价</h2>
				<ul>
				<s:iterator id="tmp1" value="assessList">
				    <li><a href="#"><strong><s:property value="#tmp1.title"/></strong></a></li>
					<li><a href="#"><s:property value="#tmp1.userName"/>:<s:property value="#tmp1.briefAssess"/></a></li>
				 </s:iterator>
				
					</ul>
				</li>
		</ul>
	</div>
	<!-- end #sidebar -->
	<div style="clear: both;">&nbsp;</div>
</div>
<!-- end #page -->

<div id="footer">
	<p>Copyright (c) 2013 software.nju.edu.cn. All rights reserved. Design by <a href="#">Group Doc_manager</a>.</p>
</div>
<!-- end #footer -->
</div>
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' type='JavaScript' charset='gb2312'></script></div></body>
</html>