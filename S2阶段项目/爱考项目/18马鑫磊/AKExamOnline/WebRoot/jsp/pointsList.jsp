<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib  prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'pointsList.jsp' starting page</title>
    
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
  		<table width="100%" align="center" id="marginTop" border="1"

			bordercolor="#eee" cellspacing="0.5">

			<tr>

				<th><font>序号</font></th>

				<th><font>类型</font></th>

				<th width="300"><font>题目内容</font></th>

				<th><font>选项A</font></th>

				<th><font>选项B</font></th>

				<th><font>选项C</font></th>

				<th><font>选项D</font></th>

				<th><font>答案</font></th>

				<th><font>难度</font></th>

				<th><font>对应章节</font></th>

			</tr>
    <s:iterator  value="paper.writtenTests" var="writtenQuestion" status="status"> 
    	<tr>

					<td> <s:property value="#status.count"/> </td>

					<td> <s:property value="#writtenQuestion.qtype"/> </td>

					<td> <s:property value="#writtenQuestion.qtitle"/> </td>

					<td> <s:property value="#writtenQuestion.optionA"/> </td>

					<td> <s:property value="#writtenQuestion.optionB"/> </td>

					<td> <s:property value="#writtenQuestion.optionC"/> </td>

					<td> <s:property value="#writtenQuestion.optionD"/> </td>

					<td> <s:property value="#writtenQuestion.answer"/> </td>

					<td> <s:property value="#writtenQuestion.degree"/> </td>

					<td> <s:property value="#writtenQuestion.chapter"/> </td>
				</tr>
    	
    </s:iterator>
    </table>
  </body>
</html>
