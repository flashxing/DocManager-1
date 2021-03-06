<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>文献管理系统</title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<link href="style.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript">
function showType(str)
{
var xmlhttp;    
if (str=="")
  {
  document.getElementById("docType").innerHTML="";
  return;
  }
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("docType").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("GET","http://localhost:8080/DocManager/doc_type/"+str+".jsp",true);
xmlhttp.send();
}

function addRow() {
 var tb = document.getElementById("mytableid");
 var rnum = tb.rows.length+1; 
 var row = tb.insertRow();
 var cell = row.insertCell();
 cell = row.insertCell();
 cell.innerHTML = "<input type='file' name='paperA'>"; 
}
function addRow1() {
 var tb = document.getElementById("mytableid1");
 var rnum = tb.rows.length+1; 
 var row = tb.insertRow();
 var cell = row.insertCell();
 cell = row.insertCell();
 cell.innerHTML = "<input type='file' name='pptA'>"; 
}
function addRow2() {
 var tb = document.getElementById("mytableid2");
 var rnum = tb.rows.length+1; 
 var row = tb.insertRow();
 var cell = row.insertCell();
 cell = row.insertCell();
 cell.innerHTML = "<input type='file' name='posterA'>"; 
}
function addRow3() {
 var tb = document.getElementById("mytableid3");
 var rnum = tb.rows.length+1; 
 var row = tb.insertRow();
 var cell = row.insertCell();
 cell = row.insertCell();
 cell.innerHTML = "<input type='file' name='presentA'>"; 
}
function addRow4() {
 var tb = document.getElementById("mytableid4");
 var rnum = tb.rows.length+1; 
 var row = tb.insertRow();
 var cell = row.insertCell();
 cell = row.insertCell();
 cell.innerHTML = "<input type='file' name='additionA'>"; 
}
function addRow5() {
 var tb = document.getElementById("mytableid5");
 var rnum = tb.rows.length+1; 
 var row = tb.insertRow();
 var cell = row.insertCell();
 cell = row.insertCell();
 cell.innerHTML = "<input type='file' name='codeA'>"; 
}

</script>
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
	<div id="content">
		<div class="post">
			<h2 class="title">文献录入</h2>
			<p class="date"></p>	
			<p>&nbsp;</p>		
               <p>
                    <label style="font-weight:bold;">请选择上传文件类型：</label>
                    <select name="type" id="select" onchange="showType(this.value)">
                 <s:iterator id="tmp" value="keyList">
                 
				 </s:iterator>
                    
                      <option selected="selected">类型</option>
                      <option value="book">图书</option>
                      <option value="journal">期刊</option>
                      <option value="book_section">图书章节</option>
                      <option value="conference">会议</option>
                      <option value="thesis">学位论文</option>
                      <option value="report">技术报告</option>
                      <option value="online">在线资源</option>
                    </select>
                </p>
                <div class="entry1" id="docType">
			</div>
		</div>
		<div class="post">
		</div>
		<div class="post">
		</div>
	</div>
	<!-- end #content -->
	<div id="sidebar">
		<ul>
			<li>
				<h2>用户</h2>
                <p>用户名: <s:property value="#session.username"/></p>
                <p style="padding:30px 0 0 15px"><a href="getDocs"><u>我的文献</u></a>&nbsp;&nbsp;&nbsp;<a href="getDraft"><u>我的草稿</u></a></p>  
                
			</li>
			<li id="calendar">
				<h2>Calendar</h2>
				<div id="calendar_wrap">
					<table summary="Calendar">
						<caption>
						December 2013
						</caption>
						<thead>
							<tr>
								<th abbr="Monday" scope="col" title="Monday">M</th>
								<th abbr="Tuesday" scope="col" title="Tuesday">T</th>
								<th abbr="Wednesday" scope="col" title="Wednesday">W</th>
								<th abbr="Thursday" scope="col" title="Thursday">T</th>
								<th abbr="Friday" scope="col" title="Friday">F</th>
								<th abbr="Saturday" scope="col" title="Saturday">S</th>
								<th abbr="Sunday" scope="col" title="Sunday">S</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<td abbr="November" colspan="3" id="prev"><a href="#" title="">&laquo; November</a></td>
								<td class="pad">&nbsp;</td>
								<td abbr="January " colspan="3" id="next"><a href="#" title="">January  &raquo;</a></td>
							</tr>
						</tfoot>
						<tbody>
							<tr>
								<td colspan="5" class="pad">&nbsp;</td>
								<td>1</td>
								<td>2</td>
							</tr>
							<tr>
								<td>3</td>
								<td>4</td>
								<td>5</td>
								<td>6</td>
								<td>7</td>
								<td>8</td>
								<td>9</td>
							</tr>
							<tr>
								<td>10</td>
								<td >11</td>
								<td>12</td>
								<td>13</td>
								<td>14</td>
								<td>15</td>
								<td>16</td>
							</tr>
							<tr>
								<td>17</td>
								<td>18</td>
								<td id="today">19</td>
								<td>20</td>
								<td>21</td>
								<td>22</td>
								<td>23</td>
							</tr>
							<tr>
								<td>24</td>
								<td>25</td>
								<td>26</td>
								<td>27</td>
								<td>28</td>
								<td>29</td>
								<td>30</td>
							</tr>
							<tr>
								<td>31</td>
								<td class="pad" colspan="6">&nbsp;</td>
							</tr>
						</tbody>
					</table>
				</div>
			</li>
			<li>
				<h2>最新评价</h2>
				<ul>
                    <li><a href="#"></a><a href="#"><strong>工作流过程模型挖掘 MF1332075</strong></a></li>
					<li><a href="#">论文很好的阐述了工作流过程挖掘算法的优势和。。。。。。</a></li>
                    <li><a href="#"><strong>分布式文件系统 MF1332077</strong></a></li>
					<li><a href="#">论文中详细描述了分布式分布式文件系统中所关心问题。。。。。。</a></li>
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