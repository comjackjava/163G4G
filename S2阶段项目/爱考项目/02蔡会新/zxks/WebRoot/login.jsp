<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>在线考试系统</title>
		<style type="text/css">
td {
	font-size: 12px;
	color: #007AB5;
}

form {
	margin: 1px;
	padding: 1px;
}

input {
	border: 0px;
	height: 26px;
	color: #007AB5;
}

body {
	background-repeat: no-repeat;
	background-color: #9CDCF9;
	background-position: 0px 0px;
}
</style>
	</head>
	<body>
		<table width="681" border="0" align="center" cellpadding="0"
			cellspacing="0" style="margin-top: 120px">
			<tr>
				<td width="353" height="259" align="center" valign="bottom"
					background="/zxks/images/login_1.jpg">
					<table width="90%" border="0" cellspacing="3" cellpadding="0">
						<tr>
							<td align="right" valign="bottom" style="color: #05B8E4">
								&nbsp;
							</td>
						</tr>
					</table>
				</td>
				<td width="195" background="/zxks/images/login_2.jpg">
					<form action="/zxks/user/userAction!login" method="post">
						<table width="190" height="106" border="0" align="center"
							cellpadding="2" cellspacing="0">
							<tr>
								<td height="50" colspan="2" align="left">
									&nbsp;
								</td>
							</tr>
							<tr>
								<td width="60" height="30" align="right">
									用户名
								</td>
								<td>
									<input type="text"
										style="background: url(/zxks/images/login_6.gif) repeat-x; border: solid 1px #27B3FE; height: 20px; width: 100px; background-color: #FFFFFF"
										id="txtname" name="username" size="14" />
								</td>
							</tr>
							<tr>
								<td height="30" width="60" align="right">
									密码
								</td>
								<td>
									<input type="password"
										style="background: url(/zxks/images/login_6.gif) repeat-x; border: solid 1px #27B3FE; height: 20px; width: 100px; background-color: #FFFFFF"
										id="txtpwd" name="password" size="14" />
								</td>
							</tr>
							<tr>
								<td height="30" width="60" align="right">
									角色
								</td>
								<td>
									<select name="role" style="width: 100px">
										<option value="2">
											学生
										</option>
										<option value="1">
											讲师
										</option>
										<option value="0">
											管理员
										</option>
									</select>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<input type="submit"   id="btnsubmit"
										style="background: url(/zxks/images/login_5.gif) no-repeat; width: 72px;"
										value=" 登  陆 " />
									<input type="reset" name="Submit"
										style="background: url(/zxks/images/login_5.gif) no-repeat; width: 72px;"
										value=" 重  置 " />
								</td>
							</tr>
							<tr>
								<td height="5" colspan="2" style="text-align: center;">
									<font color="red"><s:property value="message"/></font>
								</td>
							</tr>
							<tr>
								<td height="5" colspan="2">
								</td>
							</tr>
						</table>
					</form>
				</td>
				<td width="133" background="/zxks/images/login_3.gif">
					&nbsp;
				</td>
			</tr>
			<tr>
				<td height="161" colspan="3" background="/zxks/images/login_4.gif">
				</td>
			</tr>
		</table>
	</body>
</html>

<script type="text/javascript" language="javascript">
    function IsValid() {
        if (Trim($("txtname").value) == "") {
            alert("用户名不能为空！");
            $("txtname").focus();
            return false;
        }
        if (Trim($("txtpwd").value) == "") {
            alert("密码不能为空！");
            $("txtpwd").focus();
            return false;
        }
        return true;
    }
    function $(objId) {
        return document.getElementById(objId);
    }
    function Trim(str) {
        return str.replace(/^\s+|\s+$/g, "");
    }
</script>
