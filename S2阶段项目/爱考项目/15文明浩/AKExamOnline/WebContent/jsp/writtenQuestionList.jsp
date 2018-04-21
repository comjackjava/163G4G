<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>试卷详情</title>
<style type="text/css">
span {
	display: none;
}
th {
	background-color: #666;
}
td{
	text-align: center;
}
font {
	color: #fff;
}
#marginTop {
	margin-top: 20px;
}
.margRight {
	margin-right: 10px;
}
</style>
<script type="text/javascript">
	function showAddQuestion() {
		var width = (screen.width - 500) / 2;
		var height = (screen.height - 500) / 2;
		var res = window
				.open(
						"../../jsp/addWrittenQuestion.jsp",
						"window",
						"width=500px,height=500px,top="
								+ height
								+ ", left="
								+ width
								+ ", toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
	}
	function showUpdateQuestion(qid) {
		var width = (screen.width - 500) / 2;
		var height = (screen.height - 500) / 2;
		var res = window
				.open(
						"jsp/updateQuestion.jsp?qid=" + qid,
						"window",
						"width=500px,height=500px,top="
								+ height
								+ ", left="
								+ width
								+ ", toolbar=no, menubar=no, scrollbars=no, resizable=no, location=no, status=no");
	}
	function showMsg() {
		alert("不实现!");
	}
</script>
</head>
<body>
	<div>
		<h3 align="center">${course.csName }笔试试题列表</h3>
		<br /> <input type="button" value="添加试题" onclick="showAddQuestion();"
			style="float: left;margin-right: 20px;">
		<form
			action=""
			method="post" enctype="multipart/form-data"
			style="float: left;margin-right: 20px;">
			<input type="file" name="file"> <input type="submit"
				value="导入">
		</form>
		<a href="../../file/Template.xls"><input type="button"
			value="下载试题模板"></a>
		<font style="color: red;">仅支持Excel2003版本</font>
	</div>
	<fieldset id="marginTop">
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
				<th><font>操作</font></th>
			</tr>
			<s:iterator value="pageBean.Items" var="writtenQuestion" status="status">
				<tr>
					<td> <s:property value="#status.count"/> </td>
					<td> <s:property value="#writtenQuestion.qtype"/> </td>
					<td> <s:property value="#writtenQuestion.qtitle"/> </td>
					<td> <s:property value="#writtenQuestion.optionA"/> </td>
					<td> <s:property value="#writtenQuestion.optionB"/> </td>
					<td> <s:property value="#writtenQuestion.optionC"/> </td>
					<td> <s:property value="#writtenQuestion.optionD"/> </td>
					<td> <s:property value="#writtenQuestion.answer"/> </td>
					<td> <s:property value="#writtenQuestion.degress"/> </td>
					<td> <s:property value="#writtenQuestion.chapter"/> </td>
					<td> 
						<a href='javascript:showMsg()'>编辑</a>
						<a href='javascript:showMsg()'>删除</a>
					</td>
				</tr>
			</s:iterator>
		</table>
		<div align="right" id="marginTop">
			第${pageBean.currentIndex }页， 共<s:property value="pageBean.getTotalPage()"/>页&nbsp;&nbsp;
			<a
				href="question/question_getWrittenList?course.csId=${course.csId }&course.csName=${course.csName}&pageIndex=1">首页</a>&nbsp;
			<a
				href="question/question_getWrittenList?course.csId=${course.csId }&course.csName=${course.csName}&pageIndex=${pageBean.preIndex }">上一页</a>&nbsp;
			<a
				href="question/question_getWrittenList?course.csId=${course.csId }&course.csName=${course.csName}&pageIndex=${pageBean.nextIndex }">下一页</a>&nbsp;
			<a
				href="question/question_getWrittenList?course.csId=${course.csId }&course.csName=${course.csName}&pageIndex=${pageBean.totalPage }">末页</a>
		</div>
	</fieldset>
</body>
</html>