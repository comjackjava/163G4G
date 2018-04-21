<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <link rel="stylesheet" href="css/common.css" type="text/css" />


    <script type="text/javascript">
        //默认显示第一个
        var preClassName = "left_nav_0";
        function list_sub_detail(Id, item) {
            if (preClassName != "") {
                getObject(preClassName).className = "left_back"
            }
            if (getObject(Id).className == "left_back") {
                getObject(Id).className = "left_back_onclick";
                outlookbar.getbyitem(item);
                preClassName = Id
            }
        }
        function getObject(objectId) {
            if (document.getElementById && document.getElementById(objectId)) {
                return document.getElementById(objectId)
            }
            else if (document.all && document.all(objectId)) {
                return document.all(objectId)
            }
            else if (document.layers && document.layers[objectId]) {
                return document.layers[objectId]
            }
            else {
                return false
            }
        }
        function outlook() {
            this.titlelist = new Array();
            this.itemlist = new Array();
            this.addtitle = addtitle;
            this.additem = additem;
            this.getbytitle = getbytitle;
            this.getbyitem = getbyitem;
            this.getdefaultnav = getdefaultnav
        }
        function theitem(intitle, insort, inkey, inisdefault) {
            this.sortname = insort;
            this.key = inkey;
            this.title = intitle;
            this.isdefault = inisdefault
        }
        function addtitle(intitle, sortname, inisdefault) {
            outlookbar.itemlist[outlookbar.titlelist.length] = new Array();
            outlookbar.titlelist[outlookbar.titlelist.length] = new theitem(intitle, sortname, 0, inisdefault);
            return (outlookbar.titlelist.length - 1)
        }
        function additem(intitle, parentid, inkey) {
            if (parentid >= 0 && parentid <= outlookbar.titlelist.length) {
                insort = "item_" + parentid;
                outlookbar.itemlist[parentid][outlookbar.itemlist[parentid].length] = new theitem(intitle, insort, inkey, 0);
                return (outlookbar.itemlist[parentid].length - 1)
            }
            else
                additem = -1
        }
        function getdefaultnav(sortname) {
            var output = "";
            var i = 0;
            if (outlookbar.titlelist[i].isdefault == 1 && outlookbar.titlelist[i].sortname == sortname) {
                output += "<div class=list_tilte id=sub_sort_" + i + " onclick=\"hideorshow('sub_detail_" + i + "')\">";
                output += "<span>" + outlookbar.titlelist[i].title + "</span>";
                output += "</div>";
                output += "<div class=list_detail id=sub_detail_" + i + "><ul>";
                for (j = 0; j < outlookbar.itemlist[i].length; j++) {
                    output += "<li id=" + outlookbar.itemlist[i][j].sortname + j + " onclick=\"changeframe('" + outlookbar.itemlist[i][j].title + "', '" + outlookbar.titlelist[i].title + "', '" + outlookbar.itemlist[i][j].key + "')\"><a href=#>" + outlookbar.itemlist[i][j].title + "</a></li>"
                }
                output += "</ul></div>"
            }
            getObject('right_main_nav').innerHTML = output
        }
        function getbytitle(sortname) {
            var output = "<ul>";
            for (i = 0; i < outlookbar.titlelist.length; i++) {
                if (outlookbar.titlelist[i].sortname == sortname) {
                    var classname = "left_back" + (i == 0 ? "_onclick" : "");
                    output += "<li id=left_nav_" + i + " onclick=\"list_sub_detail(id, '" + outlookbar.titlelist[i].title + "')\" class=" + classname + ">" + outlookbar.titlelist[i].title + "</li>"
                }
            }
            output += "</ul>";
            getObject('left_main_nav').innerHTML = output
        }
        function getbyitem(item) {
            var output = "";
            for (i = 0; i < outlookbar.titlelist.length; i++) {
                if (outlookbar.titlelist[i].title == item) {
                    output = "<div class=list_tilte id=sub_sort_" + i + " onclick=\"hideorshow('sub_detail_" + i + "')\">";
                    output += "<span>" + outlookbar.titlelist[i].title + "</span>";
                    output += "</div>";
                    output += "<div class=list_detail id=sub_detail_" + i + " style='display:block;'><ul>";
                    for (j = 0; j < outlookbar.itemlist[i].length; j++) {
                        output += "<li id=" + outlookbar.itemlist[i][j].sortname + "_" + j + " onclick=\"changeframe('" + outlookbar.itemlist[i][j].title + "', '" + outlookbar.titlelist[i].title + "', '" + outlookbar.itemlist[i][j].key + "')\"><a href=#>" + outlookbar.itemlist[i][j].title + "</a></li>"
                    }
                    output += "</ul></div>"
                }
            }
            getObject('right_main_nav').innerHTML = output
        }
        function changeframe(item, sortname, src) {
            if (item != "" && sortname != "") {
                window.top.frames['mainFrame'].getObject('show_text').innerHTML = sortname + "  <img src=images/slide.gif broder=0 />  " + item
            }
            if (src != "") {
                window.top.frames['manFrame'].location = src
            }
        }
        function hideorshow(divid) {
            subsortid = "sub_sort_" + divid.substring(11);
            if (getObject(divid).style.display == "none") {
                getObject(divid).style.display = "block";
                getObject(subsortid).className = "list_tilte"
            }
            else {
                getObject(divid).style.display = "none";
                getObject(subsortid).className = "list_tilte_onclick"
            }
        }
        function initinav(sortname) {
            outlookbar.getdefaultnav(sortname);
            outlookbar.getbytitle(sortname);
        }
        var outlookbar = new outlook();
        
        var t;
        
        
        t = outlookbar.addtitle('后台功能', '后台管理', 1);
        
        outlookbar.additem('教师信息管理', t, '../Articles.aspx?yewu=' + encodeURI("关于公司"));
        outlookbar.additem('班级信息管理', t, '../Operations.aspx');
        outlookbar.additem('学生信息管理', t, '../AirModels.aspx');
        outlookbar.additem('题库展示', t, '/zxks/questionBank/questionBankAction!selMajorStage'); 
		outlookbar.additem('试卷管理', t, '/zxks/examination/examinationAction!showExamination?p=1');
        outlookbar.additem('成绩管理', t, '../AirModels.aspx');
        outlookbar.additem('新闻中心', t, '../news.aspx');
        outlookbar.additem('修改密码', t, '../news.aspx');

        t = outlookbar.addtitle('基本设置', '后台管理', 2);
        outlookbar.additem('专业设置', t, '../Articles.aspx?yewu=' + encodeURI("关于公司"));
        outlookbar.additem('设置学费', t, '../Operations.aspx');
        outlookbar.additem('科目管理', t, '../AirModels.aspx');
        outlookbar.additem('宿舍管理', t, '../news.aspx');


    </script>

</head>
<body onload="initinav('后台管理');">
    <div id="left_content">
        <div id="user_info">
            欢迎您，<strong>管理员</strong>
        </div>
        <div id="main_nav">
            <div id="left_main_nav">
            </div>
            <div id="right_main_nav">
            </div>
        </div>
    </div>
</body>
</html>
