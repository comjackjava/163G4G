<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>题库管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	table{
		width:1200px;
		border-spacing: 30px;
	}
	table td{
		border:1px solid black;
		width: 230px;
		height:150px;
		text-align:center;
		font-size:14px;
		color:#666666;
	}
	a{
		text-decoration: none
	}
	</style>
	<script type="text/javascript" src="/zxks/js/jQuery.js"></script>
	<script type="text/javascript">
	//文档加载完毕执行
	$(function(){
  		$("#major,#stage").change(function(){
  			var major = $("#major").val();
  			var stage = $("#stage").val();
  			$.get("/zxks/questionBank/questionBankAction!showQuestionBank?mid="+major+"&sid="+stage,
  					function(result,status){
  					if(status == "success"){
  						var obj = eval("("+result+")");
  						var list = obj.courseQuestions;
  						var size = list.length;
  						var bu = 5-size%5;
  						var row = Math.floor(size/5)+1;
  						$("#course").empty();
  						var index = 0;
  						//以每行四个科目进行排列
  						for(var i=1;i<=row;i++){
  							var $tr = $("<tr></tr>");
  							for(var j=1;j<=5;j++){
  								if(index>=size){
  									break;
  								}
  								var course = list[index];
  								var $td = $("<td></td>");
  	  							$td.html("科目："+course.cname+"<br><a href='/zxks/questionBank/questionBankAction!showQuestion?p=1&qtype=0&cname="+course.cname+"&cid="+course.cid+"'>笔试数</a>："+course.bss+"<br>机试数："+course.jss);
  	  							$tr.append($td);
  	  							index++;
  							}
  							 $("#course").append($tr);
  						}
  						//补齐
  						for(var i=1;i<=bu;i++){
  							var $td = $("<td style='border:none'></td>");
  							$("#course tr:last").append($td);
  						}
  					}
  			});
  		});
  	});
	</script>

  </head>
  
  <body>
  <div>
  	<div>
  		  专业：<s:select list="majors" headerKey="0" headerValue="请选择专业" listKey="mid" listValue="mname" id="major"></s:select>
  		  阶段：<s:select list="stages" headerKey="0" headerValue="请选择阶段" listKey="sid" listValue="sname" id="stage"></s:select>
  	</div>
  	<div>
  		<table id="course"></table>
  	</div>
  </div>
  </body>
</html>
