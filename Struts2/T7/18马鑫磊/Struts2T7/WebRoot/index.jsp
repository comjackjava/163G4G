<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!-- 
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
   		<s:form action="file!upload" enctype="multipart/form-data" method="post">
   			<s:textfield name="username" lable="用户名" ></s:textfield>
   			<s:file name="uploadfile" lable="选择上传的文件">(上传txt,doc,rtf格式文档，大小不超过5MB字节)</s:file>
   			<s:submit value="确定"></s:submit>
   		</s:form>
   		<s:fielderror></s:fielderror>
   		<s:actionerror/>
  </body>
</html>
