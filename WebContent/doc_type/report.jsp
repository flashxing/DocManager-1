<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
   <style type="text/css">
       .eg {width:60px;float:left;clear:both;font-size: 16px; height:20px;font-weight:bold;}
       .eg0{margin: 0px 0 20px 0px; height:20px;width:200px;}
       .eg1{margin: 20px 0 20px 0px; height:20px;}
       .eg2{margin: 0px 0 20px 0px; height:40px;width:200px;}
       .eg3{margin: 0px 0 20px 60px; height:40px;width:200px;}
       .eg4{margin: 0px 0 20px 60px; height:40px;}
       .td-1{width:90px;}
       .td-2{padding: 7px 0 0px 0px;width:90px;vertical-align:top}
</style>  </head> 
  <body>
  <form action="docAdd.action" method="post"  enctype="multipart/form-data">
                <div> <input type="hidden" class="eg0" name="type" value="技术报告" /></div>   
                <div><div class="eg">标题</div> <input type="text" class="eg0" name="title"/></div>
                <div><div class="eg">作者</div> <input type="text" class="eg0" name="author"/></div>
                <div><div class="eg">年份</div> <input type="text"  class="eg0" name="year"/></div>
                <div><div class="eg">页数</div> <input type="text"  class="eg0" name="pages"/></div>
                <div><div class="eg">出版社</div> <input type="text"  class="eg0" name="publisher"/></div>
                <div><div class="eg">摘要</div> <input type="text"  class="eg0" name="doc_abstract"/></div>
                <div><div class="eg">关键字</div> <input type="text"  class="eg0" name="key"/></div>
                <div><div class="eg">URL</div> <input type="text"  class="eg0" name="url"/></div>
                 <div><div class="eg">附件</div>                  
                <table>
                <tr>
                <td class="td-2">添加论文：</td>   
                <td>
                <table id="mytableid">
                <tr> 
                <td><input type="file" name="paperA" ></td>
                </tr>              
                </table>
                </td>
                </tr>
                <tr>
                <td class="td-2">添加幻灯片：</td>   
                <td>
                <table id="mytableid1">
                <tr> 
                <td><input type="file" name="pptA" ></td>
                <td><input  type="button" value="添加幻灯片" onclick="addRow1()"/></td>
                </tr>              
                </table>
                </td>
                </tr>
                <tr>
                <td class="td-2">添加海报：</td>   
                <td>
                <table id="mytableid2">
                <tr> 
                <td><input type="file" name="posterA" ></td>
                <td><input  type="button" value="添加海报" onclick="addRow2()"/></td>
                </tr>              
                </table>
                </td>
                </tr>
                <tr>
                <td class="td-2">添加演示：</td>   
                <td>
                <table id="mytableid3">
                <tr> 
                <td><input type="file" name="presentA" ></td>
                <td><input  type="button" value="添加演示" onclick="addRow3()"/></td>
                </tr>              
                </table>
                </td>
                </tr>
                <tr>
                <td class="td-2">添加补充：</td>   
                <td>
                <table id="mytableid4">
                <tr> 
                <td><input type="file" name="additionA" ></td>
                <td><input  type="button" value="添加补充" onclick="addRow4()"/></td>
                </tr>              
                </table>
                </td>
                </tr>
                <tr>
                <td class="td-2">添加代码：</td>   
                <td>
                <table id="mytableid5">
                <tr> 
                <td><input type="file" name="codeA" ></td>
                <td><input  type="button" value="添加代码" onclick="addRow5()"/></td>
                </tr>              
                </table>
                </td>
                </tr>
                </table>
                </div>   
                <div><button class="eg1" type="submit" >录入</button></div>
  </form>
    
  </body>
</html>
