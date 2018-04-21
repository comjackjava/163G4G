<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>随机组卷</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jQuery.js"></script>
<style type="text/css">
tr {
	margin: 10px;
}

td {
	margin: 10px;
}
</style>
<script type="text/javascript">
var radioEasyMax,radioNormalMax,radioDiffMax,cbEasyMax,cbNormalMax,cbDiffMax;

function getCourses() {
	var url = "${basePath}course/course_getCourses2Json.action";
	var majorValue = $("#majorSelect").val();
	var stageValue = $("#stageSelect").val();
	 $.getJSON(url,
			 {
		 		'course.major':majorValue,
		 		'course.stage':stageValue
			 },
			 function(data){
		    	//alert(JSON.stringify(data));
		    	$("#csId").empty();
		    	$("#csId").append("<option value=''>请选择</option>");
		    	$.each(data, function(i,course){
		    		$("#csId").append("<option value='"+course.csId+"'>"+course.csName+"</option>");
		    	});
			}
	);
}

//TODO 获取当前科目的最大题目数
function getQuestionMaxNum() {
	
}

//TODO 更新总题数和每题分数
function getQuestionTotal() {
	
}
</script>
</head>

<body>
	<form action="paper/paper_createByRandom" method="post">
		<table align="center" width="80%" height="80%">
			<tr>
				<td style="text-align: right;">方向：</td>
				<td>
					<s:select id="majorSelect" list="#{'':'请选择','SCME':'SCME','SCCE':'SCCE'}" 
						name="majorSelect" onchange="getCourses()" theme="simple" /> 
					阶段: 
					<s:select id="stageSelect" list="#{'':'请选择','G1':'G1','G2':'G2','G3':'G3'}"
						name="stageSelect" onchange="getCourses()" theme="simple" /> 
					科目: 
					<s:select list="{}" name="course.csId" id="csId" theme="simple" headerKey=""
						headerValue="请选择" onchange="getQuestionMaxNum()"/> 
					<font color="red">*</font>
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">标题：</td>
				<td>
					<input type="text" name="paper.pname" size="45">
					<font color="red">*</font>
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">总分：</td>
				<td><input type="text" name="paper.ptotalScore">分<font
					color="red">*</font></td>
			</tr>
			<tr>
				<td style="text-align: right;">考试时长：</td>
				<td><input type="text" name="paper.ptime">分钟<font color="red">*</font>
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">单选题：</td>
				<td>
					简单<input type="text" name="radioEasy" size="2" onchange="getQuestionTotal()"> 
					一般<input type="text" name="radioNormal" size="2"> 
					困难<input type="text" name="radioDiff" size="2">
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">多选题：</td>
				<td>
					简单<input type="text" name="cbEasy" size="2">
					一般<input type="text" name="cbNormal" size="2"> 
					困难<input type="text" name="cbDiff" size="2">
				</td>
			</tr>
			<tr>
				<td style="text-align: right;">总题数：</td>
				<td><input type="text" name="paper.qtotal"></td>
			</tr>
			<tr>
				<td style="text-align: right;">每题分数：</td>
				<td><input type="text" name="paper.qscore"></td>
			</tr>
			<tr>
				<td style="text-align: center;" colspan="2">
					<input type="submit" value="创建试卷"> 
					<input type="reset" value="取消">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
