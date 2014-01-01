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
<link href="css/signin.css" rel="stylesheet"/>
        <script>
function addRow1() {
 var tb = document.getElementById("mytableid1");
 var rnum = tb.rows.length+1; 
 var row = tb.insertRow(-1);
 var cell = row.insertCell();
 cell = row.insertCell();
 cell.innerHTML = "<input type='file' name='pptA'>"; 
}
function addRow2() {
 var tb = document.getElementById("mytableid2");
 var rnum = tb.rows.length+1; 
 var row = tb.insertRow(-1);
 var cell = row.insertCell();
 cell = row.insertCell();
 cell.innerHTML = "<input type='file' name='posterA'>"; 
}
function addRow3() {
 var tb = document.getElementById("mytableid3");
 var rnum = tb.rows.length+1; 
 var row = tb.insertRow(-1);
 var cell = row.insertCell();
 cell = row.insertCell();
 cell.innerHTML = "<input type='file' name='presentA'>"; 
}
function addRow4() {
 var tb = document.getElementById("mytableid4");
 var rnum = tb.rows.length+1; 
 var row = tb.insertRow(-1);
 var cell = row.insertCell();
 cell = row.insertCell();
 cell.innerHTML = "<input type='file' name='additionA'>"; 
}
function addRow5() {
 var tb = document.getElementById("mytableid5");
 var rnum = tb.rows.length+1; 
 var row = tb.insertRow(-1);
 var cell = row.insertCell();
 cell = row.insertCell();
 cell.innerHTML = "<input type='file' name='codeA'>"; 
}
        
        function myfun(){
        var type="${doc.type}";  
         if(type=="期刊")
        {
        document.getElementById("doc_info").innerHTML=
        " <p> <input type='hidden' name='type' value='${doc.type}' /></p>"
        +" <p> <input type='hidden' name='time' value='${doc.time}' /></p>"
        
        +" <p><strong >标题</strong> <input type='text' name='title' value='${doc.title}'/></p>"
		+" <p><strong >作者</strong> <input type='text' name='author' value='${doc.author}'/></p>"
	    +" <p> <strong >年份</strong> <input type='text' name='year' value='${doc.year}'/></p>"
	   	+"<p> <strong >页数</strong> <input type='text' name='pages' value='${doc.pages}'/></p>"
	    +" <p><strong >DOI</strong> <input type='text' name='DOI' value='${doc.DOI}'/> </p>"
	    + "<p><strong >期刊名</strong> <input type='text' name='publisher' value='${doc.publisher}'/></p> "
	   	+ "<p><strong >卷</strong><input type='text' name='volume' value='${doc.volume}'/></p>"
	    + "<p><strong >期</strong> <input type='text' name='issue' value='${doc.issue}'/></p> "
         +"  <p><strong>摘要</strong><input type='text' name='docAbstract' value='${doc.docAbstract}'/></p>"
         +"  <p><strong>关键字</strong><input type='text' name='key' value='${doc.key}'/></p>"
         +"  <p><strong>URL</strong> <a href='#'><input type='text' name='url' value='${doc.url}'/></a></p> ";
        
        }
        if(type=="图书")
        {
        document.getElementById("doc_info").innerHTML=
        " <p> <input type='hidden' name='type' value='${doc.type}' /></p>"
        +" <p><strong >标题</strong> <input type='text' name='title' value='${doc.title}'/></p>"
		+" <p><strong >作者</strong> <input type='text' name='author' value='${doc.author}'/></p>"
	    +" <p> <strong >年份</strong> <input type='text' name='year' value='${doc.year}'/> "
	   	+" <strong >页数</strong> <input type='text' name='pages' value='${doc.pages}'/></p>"
	   	
	    +"<p><strong >ISBN</strong> <input type='text' name='ISBN' value='${doc.ISBN}'/></p> "
	    + "<p><strong >出版社</strong> <input type='text' name='publisher' value='${doc.publisher}'/> </p>"
	   	+ "<p><strong >编辑</strong> <input type='text' name='editor' value='${doc.editor}'/></p> "
         +"  <p><strong>摘要</strong><input type='text' name='docAbstract' value='${doc.docAbstract}'/></p>"
         +"  <p><strong>关键字</strong><input type='text' name='key' value='${doc.key}'/></p>"
         +"  <p><strong>URL</strong> <a href='#'><input type='text' name='url' value='${doc.url}'/></a></p> ";
	   	
        }
        if(type=="图书章节")
        {
        document.getElementById("doc_info").innerHTML=
        " <p><input type='hidden' name='type' value='${doc.type}' /></p>"
        +" <p><strong >标题</strong> <input type='text' name='title' value='${doc.title}'/></p>"
		+" <p><strong >作者</strong> <input type='text' name='author' value='${doc.author}'/></p>"
	    +"<p>  <strong >年份</strong> <input type='text' name='year' value='${doc.year}'/></p> "
	   	+" <p><strong >页数</strong> <input type='text' name='pages' value='${doc.pages}'/></p>"
        
	   + "<p><strong >图书名</strong><input type='text' name='bookName' value='${doc.bookName}'/></p>"
	    + "<p><strong >出版社</strong> <input type='text' name='publisher' value='${doc.publisher}'/> </p>"
	   	+ "<p><strong >编辑</strong> <input type='text' name='editor' value='${doc.editor}'/></p> "
         +"  <p><strong>摘要</strong><input type='text' name='docAbstract' value='${doc.docAbstract}'/></p>"
         +"  <p><strong>关键字</strong><input type='text' name='key' value='${doc.key}'/></p>"
         +"  <p><strong>URL</strong> <a href='#'><input type='text' name='url' value='${doc.url}'/></a></p> ";
	   	
        }
        if(type=="会议")
        {
        document.getElementById("doc_info").innerHTML=
        "  <input type='hidden' name='type' value='${doc.type}' /></p>"
        +" <p><strong >标题</strong> <input type='text' name='title' value='${doc.title}'/></p>"
		+" <p><strong >作者</strong> <input type='text' name='author' value='${doc.author}'/></p>"
	    +"  <p><strong >年份</strong> <input type='text' name='year' value='${doc.year}'/></p> "
	   	+" <p><strong >页数</strong> <input type='text' name='pages' value='${doc.pages}'/></p>"
        
	   +"<p><strong >DOI</strong> <input type='text' name='DOI' value='${doc.DOI}'/> </p>"
	    + "<p><strong >会议名</strong> <input type='text' name='publisher' value='${doc.publisher}'/></p> "
	   	+ "<p><strong >会议年份</strong> <input type='text' name='conferenceYear' value='${doc.conferenceYear}'/> </p>"
	    + "<p><strong >会议所在城市</strong><input type='text' name='conferenceCity' value='${doc.conferenceCity}'/></p> "
         +"  <p><strong>摘要</strong><input type='text' name='docAbstract' value='${doc.docAbstract}'/></p>"
         +"  <p><strong>关键字</strong><input type='text' name='key' value='${doc.key}'/></p>"
         +"  <p><strong>URL</strong> <a href='#'><input type='text' name='url' value='${doc.url}'/></a></p> ";
	    
        }
        if(type=="学位论文")
        {
        document.getElementById("doc_info").innerHTML=
        " <p> <input type='hidden' name='type' value='${doc.type}' /></p>"
        +" <p><strong >标题</strong> <input type='text' name='title' value='${doc.title}'/></p>"
		+" <p><strong >作者</strong> <input type='text' name='author' value='${doc.author}'/></p>"
	    +"  <p><strong >年份</strong> <input type='text' name='year' value='${doc.year}'/> </p>"
	   	+"<p> <strong >页数</strong> <input type='text' name='pages' value='${doc.pages}'/></p>"
        
	   + "<p><strong >学校</strong><input type='text' name='school' value='${doc.school}'/> </p>"
	    + "<p><strong >出版社</strong> <input type='text' name='publisher' value='${doc.publisher}'/> </p>"
         +"  <p><strong>摘要</strong><input type='text' name='docAbstract' value='${doc.docAbstract}'/></p>"
         +"  <p><strong>关键字</strong><input type='text' name='key' value='${doc.key}'/></p>"
         +"  <p><strong>URL</strong> <a href='#'><input type='text' name='url' value='${doc.url}'/></a></p> ";
	    
        }
        if(type=="技术报告")
        {
        document.getElementById("doc_info").innerHTML=
        " <p> <input type='hidden' name='type' value='${doc.type}' /></p>"
        +" <p><strong >标题</strong> <input type='text' name='title' value='${doc.title}'/></p>"
		+" <p><strong >作者</strong> <input type='text' name='author' value='${doc.author}'/></p>"
	    +"<p>  <strong >年份</strong> <input type='text' name='year' value='${doc.year}'/></p> "
	   	+"<p> <strong >页数</strong> <input type='text' name='pages' value='${doc.pages}'/></p>"
	    +"<p><strong >出版社</strong><input type='text' name='publisher' value='${doc.publisher}'/> </p> "
         +"  <p><strong>摘要</strong><input type='text' name='docAbstract' value='${doc.docAbstract}'/></p>"
         +"  <p><strong>关键字</strong><input type='text' name='key' value='${doc.key}'/></p>"
         +"  <p><strong>URL</strong> <a href='#'><input type='text' name='url' value='${doc.url}'/></a></p> ";
	    
        }
        if(type=="在线资源")
        {
        document.getElementById("doc_info").innerHTML=
        " <p><input type='hidden' name='type' value='${doc.type}' /></p>"
        +" <p><strong >标题</strong> <input type='text' name='title' value='${doc.title}'/></p>"
		+" <p><strong >作者</strong> <input type='text' name='author' value='${doc.author}'/></p>"
	    +"<p>  <strong >年份</strong> <input type='text' name='year' value='${doc.year}'/> </p>"
	   	+"<p><strong >页数</strong> <input type='text' name='pages' value='${doc.pages}'/></p>"
	    +"<p><strong >出版社</strong><input type='text' name='publisher' value='${doc.publisher}'/> </p> "
         +"  <p><strong>摘要</strong><input type='text' name='docAbstract' value='${doc.docAbstract}'/></p>"
         +"  <p><strong>关键字</strong><input type='text' name='key' value='${doc.key}'/></p>"
         +"  <p><strong>URL</strong> <a href='#'><input type='text' name='url' value='${doc.url}'/></a></p> ";
        }
        
        
        }
        /*用window.onload调用myfun()*/
        window.onload=myfun;
        function delRow(str){
mytableid1.deleteRow(); 
document.formH.hiddenName.value=str;


}
        
        </script>
   <style type="text/css">
       .td-1{width:90px;}
       .td-2{padding: 7px 0 0px 0px;width:90px;vertical-align:top}
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
	<div id="content">
		<div class="post">
			<h2 class="title">文献修改</h2>
			<p class="date">12.10.13</p>
			<div class="entry">
			<form action="updateDoc.action?docId=${doc.docId}" name="formH" method="post" role="formH" ENCTYPE="multipart/form-data">
			
			<div id="doc_info"></div>
               <div>
               <table>
                <tr>
                <td class="td-2">已有论文：</td>   
                <td>
                <table id="mytableid">
                <tr> 
                <s:iterator id="temp" value="paperList">
                <td><input id="deletelist" type="text" value="<s:property value="#temp.attachName"/>"/><input type="file" name="paperA" onchange="this.previousSibling.value=this.value;"/>
                </td>
                </s:iterator>
                </tr>              
                </table>
                </td>
                </tr>
                <tr>
                <td class="td-2">已有幻灯片：</td>   
                <td>
                <table id="mytableid1">
                <s:iterator id="temp" value="pptList">
                <tr>
                <td><input id="deletelist" type="text" value="<s:property value="#temp.attachName"/>"/><input type="hidden"  value="<s:property value="#temp.attachId"/>"/><input type="button" value="删除" onclick="delRow(this.previousSibling.value)"/>
                </td>
                </tr>  
                </s:iterator>
                <tr><td><input  type="button" value="添加幻灯片" onclick="addRow1()"/></td>
                </tr>
                </table>
                </td>
                </tr>
                <tr>
                <td class="td-2">已有海报：</td>   
                <td>
                <table id="mytableid2">
                <s:iterator id="temp" value="posterList">
                <tr>
                <td><input id="deletelist" type="text" value="<s:property value="#temp.attachName"/>"/><input type="button" value="删除"/>
                </td>
                </tr>  
                </s:iterator>
                <tr> 
                <td><input  type="button" value="添加海报" onclick="addRow2()"/></td>
                </tr>              
                </table>
                </td>
                </tr>
                <tr>
                <td class="td-2">已有演示：</td>   
                <td>
                <table id="mytableid3">
                <s:iterator id="temp" value="presentList">
                <tr>
                <td><input id="deletelist" type="text" value="<s:property value="#temp.attachName"/>"/><input type="button" value="删除"/>
                </td>
                </tr>  
                </s:iterator>
                <tr> 
                <td><input  type="button" value="添加演示" onclick="addRow3()"/></td>
                </tr>              
                </table>
                </td>
                </tr>
                <tr>
                <td class="td-2">已有补充：</td>   
                <td>
                <table id="mytableid4">
                <s:iterator id="temp" value="additionList">
                <tr>
                <td><input id="deletelist" type="text" value="<s:property value="#temp.attachName"/>"/><input type="button" value="删除"/>
                </td>
                </tr>  
                </s:iterator>
                <tr> 
                <td><input  type="button" value="添加补充" onclick="addRow4()"/></td>
                </tr>              
                </table>
                </td>
                </tr>
                <tr>
                <td class="td-2">已有代码：</td>   
                <td>
                <table id="mytableid5">
                <s:iterator id="temp" value="codeList">
                <tr>
                <td><input id="deletelist" type="text" value="<s:property value="#temp.attachName"/>"/><input type="button" value="删除"/>
                </td>
                </tr>  
                </s:iterator>
                <tr> 
                <td><input  type="button" value="添加代码" onclick="addRow5()"/></td>
                </tr>              
                </table>
                </td>
                </tr>
                </table>
               	<input type="hidden" name="hiddenName"/>
               
               </div>
				<p><button class="btn-lg btn-primary btn-block" type="submit" >修改</button></p>
		    </form>
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
                <p>用户名: MF1332076</p>
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
								<td>11</td>
								<td>12</td>
								<td>13</td>
								<td>14</td>
								<td>15</td>
								<td>16</td>
							</tr>
							<tr>
								<td>17</td>
								<td>18</td>
								<td  id="today">19</td>
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
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div></body>
</html>