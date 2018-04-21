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
    
    <title>试题列表</title>
    
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
		function editQuestion(){
			
		}
		//编辑试题
		function preEditQuestion(qid){
			//渲染修改窗口
			 /* var dialog = $( "#questionDialog_edit" ).dialog({
			      autoOpen: false,
			      height: 500,
			      width: 400,
			      modal: true,
			      buttons: {
			        "确定": editQuestion,
			        "取消": function() {
			          //this.dialog( "close" );
			        }
			      },
			      close: function() {
			        
			      }
			 });  */
			//发送ajax请求，查询数据
			$.get("/zxks/questionBank/questionBankAction!preEditQuestion?qid="+qid,
					function(result,state){
						if(state=="success"){
							var question = result.question;
							$(":hidden").val(question.qid);
							$(":text[name='cname']").val(question.course.cname);
					        $("textarea").val(question.qname);	//题目名
					        $(":text[name='optiona']").val(question.optiona);	//选项A
					        $(":text[name='optionb']").val(question.optionb);	//选项B
					        $(":text[name='optionc']").val(question.optionc);	//选项C
					        $(":text[name='optiond']").val(question.optiond);	//选项D
					        
					        //$("select[name='qtype']").find("option[text='多选']").attr("selected",true);	//题目类型
					        alert($("#qtype1").val());
					        $("select[name='qtype']").val(question.qtype);
					        $("select[name='difficulty']").val(question.difficulty);
						    $(":text[name='chapter']").val(question.chapter);
					        //答案
					        alert("a");
					        $("#questionDialog_edit :checkbox").attr("checked",false);
					        
					        alert("b");
					        $("#questionDialog_edit :checkbox[name='checkboxa']").attr("checked",true);
					        /* var rt = question.result;
					        for(var i=0;i<rt.length;i++){
					        	var c = rt.charAt(i);
					        	if(c=="A"){
					        		 $("#questionDialog_edit :checkbox[name='checkboxa']").attr("checked",true);
					        	}else if(c=="B"){
					        		 $("#questionDialog_edit :checkbox[name='checkboxb']").attr("checked",true);
					        	}else if(c=="C"){
					        		 $("#questionDialog_edit :checkbox[name='checkboxc']").attr("checked",true);
					        	}else{
					        		 $("#questionDialog_edit :checkbox[name='checkboxd']").attr("checked",true);
					        	};
					        }; */
					       /*  dialog.dialog("open"); */

						};
						
			});
		}
		$(function(){
			var cname = '<s:property value="cname"/>';
			var cid = '<s:property value="cid"/>';
			/* $(":text[name='cname']").val(cname);
			var dialog = $( "#questionDialog" ).dialog({
			      autoOpen: false,
			      height: 500,
			      width: 400,
			      modal: true,
			      buttons: {
			        "确定": addQuestion,
			        "取消": function() {
			          //this.dialog( "close" );
			        }
			      },
			      close: function() {
			        
			      }
			 });
			 //添加试题
			 function addQuestion() {
			       var qtype = $("select[name='qtype']").val();	//题目类型
			       var qname = $("textarea").val();	//题目名
			       var optiona = $(":text[name='optiona']").val();	//选项A
			       var optionb = $(":text[name='optionb']").val();	//选项B
			       var optionc = $(":text[name='optionc']").val();	//选项C
			       var optiond = $(":text[name='optiond']").val();	//选项D
			       var result = "";
			       $(":checkbox:checked").each(function(){
			    	   result = result + $(this).val();
			       });
			       var difficulty = $("select[name='difficulty']").val();	//难度
			       var chapter = $(":text[name='chapter']").val();
			 	   $.post("/zxks/questionBank/questionBankAction!addQuestion",{
			 		   "question.qname":qname, 
			 		   "question.qtype":qtype,
			 		   "question.optiona":optiona,
			 		  "question.optionb":optionb,
			 		   "question.optionc":optionc,
			 		   "question.optiond":optiond,
			 		   "question.result":result,
			 		  "question.difficulty":difficulty,
			 		   "question.chapter":chapter,
			 		   "question.cid":cid
			 	   },function(resultText,status){
			 		  if(status=="success"){
			 			  alert("添加成功！");
			 			  dialog.dialog("close");
			 		  } 
			 	   });
			 }
			$("#addButton").click(function(){
				dialog.dialog("open");
			});
			 */
		});
		
	</script>
  </head>
  
  <body>
 	<div>
 		<div>
 			<input id="addButton" type="button" value="添加试题"/>
 			<input type="file" value="选择文件"/>
 			<input type="button" value="导入"/>
 			<input type="button" value="下载考试试题模板"/>
 			<hr>
 		</div>
 		<div>
 			<table id="contentTable">
 				<tr>
 					<th>编号</th>
 					<th>类型</th>
 					<th>题目内容</th>
 					<th>选项A</th>
 					<th>选项B</th>
 					<th>选项C</th>
 					<th>选项D</th>
 					<th>答案</th>
 					<th>难度</th>
 					<th>对应章节</th>
 					<th>操作</th>
 				</tr>
 				<s:iterator value="pageBean.list" var="question">
 					<tr>
 						<td><s:property value="#question.qid"/></td>
 						<td><s:property value="#question.qtype==1?'单选':'多选'"/></td>
 						<td><s:property value="#question.qname"/></td>
 						<td><s:property value="#question.optiona"/></td>
 						<td><s:property value="#question.optionb"/></td>
 						<td><s:property value="#question.optionc"/></td>
 						<td><s:property value="#question.optiond"/></td>
 						<td><s:property value="#question.result"/></td>
 						<td>
 							<s:if test="#question.difficulty==1">
 								简单
 							</s:if>
 							<s:elseif test="#question.difficulty==2">
 								一般
 							</s:elseif>
 							<s:else>
 								困难
 							</s:else>
 						</td>
 						<td><s:property value="#question.chapter"/></td>
 						<td>
 							<a href='javascript:preEditQuestion(<s:property value="#question.qid"/>)'>编辑</a>
 							<a href="/zxks/questionBank/questionBankAction!delQuestion?qid=<s:property value="#question.qid"/>">删除</a>
 						</td>
 					</tr>
 				</s:iterator>
 			</table>
 		</div>
 		<div id="page">
 			第<s:property value="pageBean.p"/>页,共<s:property value="pageBean.pageTotal"/>页
 			<a href="/zxks/questionBank/questionBankAction!showQuestion?p=1&qtype=0&cid=<s:property value="cid"/>">首页</a> 
 			<a href="/zxks/questionBank/questionBankAction!showQuestion?p=<s:property value="pageBean.p-1<=0?1:pageBean.p-1"/>&qtype=0&cid=<s:property value="cid"/>">上一页</a> 
 			<a href="/zxks/questionBank/questionBankAction!showQuestion?p=<s:property value="pageBean.p+1>=pageBean.pageTotal?pageBean.pageTotal:pageBean.p+1"/>&qtype=0&cid=<s:property value="cid"/>">下一页</a> 
 			<a href="/zxks/questionBank/questionBankAction!showQuestion?p=<s:property value="pageBean.pageTotal"/>&qtype=0&cid=<s:property value="cid"/>">末页</a> 
 		</div>
 	</div>
 	<%-- <div id="questionDialog" title="添加试题">
 		<form>
 			<table id="dialogTable" border=1>
 				<tr>
 					<td>科目名称:</td>
 					<td><input type="text" name="cname" disabled="disabled"/></td>
 				</tr>
 				<tr>
 					<td>类型:</td>
 					<td>
 						<select name="qtype">
 							<option value="1">单选</option>
 							<option value="2">多选</option>
 						</select>
 					</td>
 				</tr>
 				<tr>
 					<td>题目内容:</td>
 					<td>
 						<textarea rows="7" cols="30" name="qname"></textarea>
 					</td>
 				</tr>
 				<tr>
 					<td rowspan="4">选项:</td>
 					<td>
 						<input type="checkbox" value="A"/>A
 						<input type="text" name="optiona"/>
 					</td>
 				</tr>
 				<tr>
 					<td>
 						<input type="checkbox" value="B"/>B
 						<input type="text" name="optionb"/>
 					</td>
 				</tr>
 				<tr>
 					<td>
 						<input type="checkbox" value="C"/>C
 						<input type="text" name="optionc"/>
 					</td>
 				</tr>
 				<tr>
 					<td>
 						<input type="checkbox" value="D"/>D
 						<input type="text" name="optiond"/>
 					</td>
 				</tr>
 				<tr>
 					<td>难度:</td>
 					<td>
 						<select name="difficulty">
 							<option value="1">简单</option>
 							<option value="2">一般</option>
 							<option value="3">困难</option>
 						</select>
 					</td>
 				</tr>
 				<tr>
 					<td>章节:</td>
 					<td>
 						<input type="text" name="chapter"/>
 					</td>
 				</tr>
 			</table>
 		</form>
 	</div> --%>
 	<!-- 编辑对话框 -->
 	<div id="questionDialog_edit" title="编辑试题">
 		<form>
 			<input type="hidden" name="qid"/>
 			<table id="dialogTable" border=1>
 				<tr>
 					<td>科目名称:</td>
 					<td><input type="text" name="cname" disabled="disabled"/></td>
 				</tr>
 				<tr>
 					<td>类型:</td>
 					<td>
 						<select id="qtype1" name="qtype">
 							<option value="1">单选</option>
 							<option value="2">多选</option>
 						</select>
 					</td>
 				</tr>
 				<tr>
 					<td>题目内容:</td>
 					<td>
 						<textarea rows="7" cols="30" name="qname"></textarea>
 					</td>
 				</tr>
 				<tr>
 					<td rowspan="4">选项:</td>
 					<td>
 						<input type="checkbox" name="checkboxa" value="A"/>A
 						<input type="text" name="optiona"/>
 					</td>
 				</tr>
 				<tr>
 					<td>
 						<input type="checkbox" name="checkboxb" value="B"/>B
 						<input type="text" name="optionb"/>
 					</td>
 				</tr>
 				<tr>
 					<td>
 						<input type="checkbox" name="checkboxc" value="C"/>C
 						<input type="text" name="optionc"/>
 					</td>
 				</tr>
 				<tr>
 					<td>
 						<input type="checkbox" name="checkboxd" value="D"/>D
 						<input type="text" name="optiond"/>
 					</td>
 				</tr>
 				<tr>
 					<td>难度:</td>
 					<td>
 						<select name="difficulty">
 							<option value="1">简单</option>
 							<option value="2">一般</option>
 							<option value="3">困难</option>
 						</select>
 					</td>
 				</tr>
 				<tr>
 					<td>章节:</td>
 					<td>
 						<input type="text" name="chapter"/>
 					</td>
 				</tr>
 			</table>
 		</form>
 	</div>
  </body>
</html>
