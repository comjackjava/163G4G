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
    
    <title>试卷列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
	body{
		font-size: 12px;
	}
	a{
		text-decoration: none;
		color:black;
	}
	#contentTable{   
		border-collapse:collapse;
		width: 1000px;
		text-align: center;
		font-size: 14px;   
	}
	#contentTalbe tr th{
		background-color: #666666;
		color: white;
	}   
	#contentTable tr td{   
		border:1px solid #cccccc;   
	} 
	#page{
		width:1000px;
		text-align: right;
	}
	#dialogTable{
		font-size:16px;
	}
	</style>
	<link rel="stylesheet" href="/zxks/css/jquery-ui.css"/>
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
	<%-- <script type="text/javascript" src="/zxks/js/jQuery.js"></script>
	<script type="text/javascript" src="/zxks/js/jquery-ui.js"></script> --%>
	<script type="text/javascript">
		$(function(){
			//为专业绑定选项改变事件，实现下拉列表联动
			$("#major,#stage").change(function(){
				var mid = $("#major").val();
				var sid = $("#stage").val();
				$.get("/zxks/examination/examinationAction!selCourse?mid="+mid+"&sid="+sid,
						function(resultText,state){
							var courses = resultText.courses;
							$("#course_select").empty();
							$("#course_select").append( $("<option value=0>请选择课程</option>"));
							for(var i=0;i<courses.length;i++){
								var c = courses[i];
								$("#course_select").append( $("<option value="+c.cid+">"+c.cname+"</option>"));
							}
				});
			});
			
		});
		
	</script>
  </head>
  
  <body>
 	<div>
 		<div>
 			<form action="/zxks/examination/examinationAction!selExaminationOption?p=1" method="post">
 			专业：<s:select list="majors" headerKey="0" headerValue="请选择专业" listKey="mid" listValue="mname" id="major"></s:select>
  		  	阶段：<s:select list="stages" headerKey="0" headerValue="请选择阶段" listKey="sid" listValue="sname" id="stage"></s:select>
  		  	课程：<select name="examination.cid" id="course_select">
  		  			<option value=0>请选择课程</option>
  		  		</select>
  		  	考试类型：<select name="examination.etype">
  		  				<option value="0">请选择</option>
  		  				<option value="1">笔试</option>
  		  				<option value="2">机试</option>
  		  			</select>
  		  	状态：<select name="examination.estate">
  		  			<option value="0">请选择</option>
  		  			<option value="1">未开考</option>
  		  			<option value="2">考试中</option>
  		  			<option value="3">考试结束</option>
  		  		</select>
  		  	<input type="submit" value="查询"/>
  		  	</form>
 		</div>
 		<div>
 			<input id="addButton" type="button" value="随机组卷"/>
 			<input type="button" value="选题组卷"/>
 			<input type="button" value="上机考试"/>
 			<hr>
 		</div>
 		<div>
 			<table id="contentTable">
 				<tr>
 					<th>编号</th>
 					<th>类别</th>
 					<th>科目</th>
 					<th>标题</th>
 					<th>考试班级</th>
 					<th>考试时长</th>
 					<th>状态</th>
 					<th>操作</th>
 				</tr>
 				<s:iterator value="pageBean.list" var="examination">
 					<tr>
 						<td><s:property value="#examination.eid"/></td>
 						<td><s:property value="#examination.etype==1?'笔试':'机试'"/></td>
 						<td><s:property value="#examination.course.cname"/></td>
 						<td><s:property value="#examination.ename"/></td>
 						<td>
 							<s:iterator value="#examination.classes" var="class">
 								<s:property value="#class.cname"/>&nbsp;
 							</s:iterator>
 						</td>
 						<td><s:property value="#examination.etime"/></td>
 						<td>
 							<s:if test="#examination.estate==1">
 								未开考
 							</s:if>
 							<s:elseif test="#examination.estate==2">
 								考试中
 							</s:elseif>
 							<s:else>
 								考试结束
 							</s:else>
 						</td>
 						<td>
 							<s:if test="#examination.estate==1">
 								<a href="#">删除</a>
 								<a href="#">开始考试</a>
 								<a href="#">查看试题</a>
 							</s:if>
 							<s:elseif test="#examination.estate==2">
 								<a href="#">结束考试</a>
 								<a href="#">查看试题</a>
 							</s:elseif>
 							<s:else>
 								<a href="#">查看成绩</a>
 								<a href="#">查看试题</a>
 							</s:else>
 						</td>
 					</tr>
 				</s:iterator>
 			</table>
 		</div>
 		<div id="page">
 			<s:if test="examination==null"><!-- 不是条件查询 -->
	 			第<s:property value="pageBean.p"/>页,共<s:property value="pageBean.pageTotal"/>页
	 			<a href="/zxks/examination/examinationAction!showExamination?p=1">首页</a> 
	 			<a href="/zxks/examination/examinationAction!showExamination?p=<s:property value="pageBean.p-1<=0?1:pageBean.p-1"/>">上一页</a> 
	 			<a href="/zxks/examination/examinationAction!showExamination?p=<s:property value="pageBean.p+1>=pageBean.pageTotal?pageBean.pageTotal:pageBean.p+1"/>">下一页</a> 
	 			<a href="/zxks/examination/examinationAction!showExamination?p=<s:property value="pageBean.pageTotal"/>">末页</a> 
 			</s:if>
 			<s:else>
 				第<s:property value="pageBean.p"/>页,共<s:property value="pageBean.pageTotal"/>页
	 			<a href="/zxks/examination/examinationAction!selExaminationOption?examination.cid=<s:property value="examination.cid"/>
	 			&examination.etype=<s:property value="examination.etype"/>&examination.estate=<s:property value="examination.estate"/>&p=1">首页</a> 
	 			<a href="/zxks/examination/examinationAction!selExaminationOption?examination.cid=<s:property value="examination.cid"/>
	 			&examination.etype=<s:property value="examination.etype"/>&examination.estate=<s:property value="examination.estate"/>&p=<s:property value="pageBean.p-1<=0?1:pageBean.p-1"/>">上一页</a> 
	 			<a href="/zxks/examination/examinationAction!selExaminationOption?examination.cid=<s:property value="examination.cid"/>
	 			&examination.etype=<s:property value="examination.etype"/>&examination.estate=<s:property value="examination.estate"/>&p=<s:property value="pageBean.p+1>=pageBean.pageTotal?pageBean.pageTotal:pageBean.p+1"/>">下一页</a> 
	 			<a href="/zxks/examination/examinationAction!selExaminationOption?examination.cid=<s:property value="examination.cid"/>
	 			&examination.etype=<s:property value="examination.etype"/>&examination.estate=<s:property value="examination.estate"/>&p=<s:property value="pageBean.pageTotal"/>">末页</a> 
 			</s:else>
 		</div>
 	</div>
  </body>
</html>
