<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateWrittenQuestion.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	.marginLayout{
	  margin:10px;
	}
	input{
	margin:5px;
	}
	td{
	margin:5px;
	padding:5px;
	}
	.textWidth{
	width:200px;
	}
	</style>
	<script type="text/javascript">
	var options=document.getElementsByName("writtenQuestion.answer");
	var answer=${writtenQuestion.answer};
	
	function setDefaultType(){
		for (i = 0; i < options.length; i++) {
			options[i].setAttribute("type","radio");
		}
		
	}
	
	function setDefaultoption(){
		
	}
	
	function checkData(){
		var v1=document.getElementById("optionA");
		var v2=document.getElementById("optionB");
		var v3=document.getElementById("optionC");
		var v4=document.getElementById("optionD");
		var v6=document.getElementById("chapter");
		if (v1.value!=""&& v2.value!=""&& v3.value!=""
			&& v4.value!=""&& v6.value!="") {
			document.getElementById("formAddQuestion").submit();
		}
	
	}
	
	</script>
  </head>
  
  <body>
    This is my JSP page. <br>
  </body>
</html>
