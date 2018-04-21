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
    
    <title>开始考试</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="js/WdatePicker.js"></script>
	<style type="text/css">
	input {
		margin: 10px;
	}
	table{
		background-color: black;
	}
	td{
		padding:5px 10px;
		text-align: center;
		background-color: white;
	}
	</style>
	</head>
	<script type="text/javascript">
  
	function addTr() {
		var tab = document.getElementById("tab_exam");
		var rows = tab.rows.length;
		var row = tab.insertRow(rows);
		var trNo = row.rowIndex.toString();
		row.id="rid"+trNo;
		var cell = row.insertCell(0);
		cell.innerHTML = "<select name='classes' id='classes"+trNo+"'></select>";
		var cell = row.insertCell(1);
		//placeholder:属性值作为显示提示
		cell.innerHTML = "<input type='text' id='dateTime' name='dateTime' placeholder='yyyy-MM-dd HH:mm' />";
		var cell = row.insertCell(2);
		cell.innerHTML = "<input type='button' value='删除' onclick=\"deleteRow('rid"+trNo+"')\">";
		//设置select标签的数据
		var classes = document.getElementById("classes"+trNo);
		for (var i = 0; i < obj.length; i++) {
			var option = document.createElement("option");
			option.value = obj[i].cId;
			option.text = obj[i].cName;
			try{
				classes.add(option,null);
			}catch(ex){
				classes.add(option);
			}
		}
	}
	function deleteRow(rowId) {
		var tab = document.getElementById("tab_exam");
		var row = document.getElementById(rowId);
		var index = row.rowIndex;//rowIndex属性为tr的索引值，从0开始  
		tab.deleteRow(index);
	}
	//根据得到的行对象得到所在的行数
	function getRowNo(trObj) {  
		var trArr = trObj.parentNode.children; 
		for(var trNo= 0; trNo < trArr.length; trNo++) {  
			if(trObj == trObj.parentNode.children[trNo]) {    
				return trNo; 
			} 
		}
	}
	</script>
	<body>
		<form action="" method="post">
			<div align="center">
				<input type="submit" value="开始考试"> <input type="reset"
					value="取消"> <br> <font>请选择参加考试的班级及开考时间</font>
			</div>
			<table id="tab_exam" align="center" cellspacing="1px" >
				<tr>
					<td>班级</td>
					<td>开考时间</td>
					<td><input type="button" value="添加" onclick="addTr();"></td>
				</tr>
				<tr>
					<td>
						<select name="paperClasses[0].ccode">
							<s:iterator value="listClazz" var="clazz">
								<option value="${clazz.ccode }">${clazz.cname }</option>
							</s:iterator>
						</select>
					</td>
					<td>
						<input type='text' class="Wdate" id='dateTime' name='paperClasses[0].examDate' onfocus="WdatePicker({skin:'whyGreen',dateFmt: 'yyyy-MM-dd HH:mm',lang:'zh-cn', minDate: '%y-%M-%d 08:00}' })"/>
					</td>
					<td>
						<input type='button' value='删除' onclick="deleteRow('')"/>
					</td>
				</tr>
			</table>
		</form>
	</body>
	</html>
