
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/common.css" type="text/css" />
		<title>后台管理系统</title>

		<script language="javascript">

        function showtime() {
            var ary = new Array(
						"星期日",
						"星期一",
						"星期二",
						"星期三",
						"星期四",
						"星期五",
						"星期六");
            time = new Date();
            syear = time.getYear();
            var years=parseInt(syear);
            if(years<200){
               years+=1900;
            }
            smonth = time.getMonth() + 1;
            sday = time.getDate();
            sweek = time.getDay();
            h = time.getHours();
            m = time.getMinutes();
            s = time.getSeconds();
            var sminute;
            if (m < 10)
                sminute = "0" + m;
            else
                sminute = m;
            
            document.getElementById("tip").innerHTML = " " + years + "年" + smonth + "月" + sday + "日 " + ary[sweek] + " " + h + ":" + sminute;
            setTimeout("showtime()", 1000);
        }
        
        function  logout(){
        	var res = window
			.open(
					"../index.jsp",
					"window");
        }
        
        function closes(){
        		   if (confirm("确定退出系统？"))
        		    {
        		     window.opener=null
        		     window.parent.close();
        		    }
        }
    </script>

	</head>
	<body onload="showtime()">
		<form id="form1">
			<div class="header_content">
				<div class="logo">
				</div>
				<div class="right_nav">
					<div class="text_left">
						<ul class="nav_list">
							<li>
								<img src="../images/direct.gif" width="8" height="21" />
								<span style="font-size: 20px">在线考试管理系统</span>
							</li>
						</ul>
					</div>
					<div class="text_right">
						<ul class="nav_return">
							<li>
								<span id="tip"></span>
							</li>
							<li>
								[
								<a href="javascript:logout();">注销</a>
								]
							</li>
							<li>
								[
								<a href="javascript:closes();">退出系统</a>
								]
							</li>
						</ul>
					</div>
				</div>
			</div>
		</form>
	</body>
</html>
