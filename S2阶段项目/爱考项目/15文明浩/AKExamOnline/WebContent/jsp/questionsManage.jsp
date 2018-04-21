	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.group {
	text-align: center;
	width: 200px;
	height: 60px;
	margin: 10px 10px;
	float: left;
	border: solid 1px black;
	padding: 5px;
}
</style>
</head>

<body>
	<!-- 
		1，theme='simple' 不使用主题，水平排列 
		2，s:if判断记录当前查询条件
	-->
	<s:form action="/question/question_getCourseInfo" method="post" theme="simple">
		<s:if test="major != null && major != '' ">
			<s:select name="major" list="{'SCME','SCCE'}" value="major"></s:select>
		</s:if>
		<s:else>
			<s:select name="major" list="{'SCME','SCCE'}" value="'SCME'"></s:select>
		</s:else>
		<s:if test="stage != null && stage != '' ">
			<s:select name="stage" list="{'G1','G2','G3'}" value="stage" ></s:select>
		</s:if>
		<s:else>
			<s:select name="stage" list="{'G1','G2','G3'}" value="'G1'" ></s:select>
		</s:else>
		<s:submit value="查询"></s:submit>
	</s:form>
	
	<s:iterator value="listCourses" var="course">
		<div align="center" class="group">
			${course.csName }&nbsp;&nbsp;${course.stage }
			<br />
			<a href="../jsp/developing.jsp" target="manFrame">
				机试题:
				<s:property value="#course.machineTests.size()"/>
			</a>
			<br>
			<a href="question/question_getWrittenList?course.csId=${course.csId }&course.csName=${course.csName}" target="manFrame">
				笔试题:<s:property value="#course.writtenTests.size()"/>
			</a>
		</div>
	</s:iterator>
</body>	
</html>