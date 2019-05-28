<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>分类浏览</title>
<style type="text/css">
body {
	background: #FFFFFF;
	background-color: #DCF0FC;
}

a:link {
	color: #000000;
	text-decoration: none;
}

a:visited {
	color: #000000;
	text-decoration: none;
}

a:hover {
	color: #999999;
	text-decoration: underline;
}

.baizi {
	color: #FFF;
	font-weight: bold;
}

.baizi {
	color: #FFF;
	text-align: center;
	font-size: 14px;
}

.lanzi {
	color: #185C99;
}

tr {
	
}

.zi {
	color: #C0E4FA;
}
</style>
<script
	src="${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"
	type="text/javascript"></script>
<script type="text/javascript">
	/*四级：第三级国民经济行业分类*/
	function checkSJ(obj) {

		var id = obj.id;
		var name = "S" + id;
		var img = "imgId" + id;

		if (document.getElementById(name).style.display == "none") {
			document.getElementById(name).style.display = "";
			document.getElementById(img).src = '../images/minus.gif';
		} else {
			document.getElementById(name).style.display = "none";
			document.getElementById(img).src = '../images/plus.gif';
		}
		//var type = document.getElementById(id).innerText;得到<span>text</span>中text字符串
		//$("#"+name).remove();
		$("#" + name).empty();
		$
				.post(
						"../ReportServlet",
						{
							method : "getNextSJ",
							id : id
						},
						function(data) {
							var content = "";
							if (data != null && data.length > 0) {
								for ( var type in data) {

									content += "<div>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
											+ "<img src='../images/plus.gif'/><a target='mainAction' "
											+ "href='${pageContext.request.contextPath }/ReportServlet?method=getListSJ&id="
											+ data[type]+ "&parentId="+id+"'>"+ data[type]
											+ "</a></div>"

								}
							}
							$("#" + name).append(content);
						}, "json");

	}

	/*三级：第二级级国民经济行业分类*/
	function checkEJ(obj) {

		var id = obj.id;
		var name = "S" + id;
		var img = "imgId" + id;

		if (document.getElementById(name).style.display == "none") {
			document.getElementById(name).style.display = "";
			document.getElementById(img).src = '../images/minus.gif';
		} else {
			document.getElementById(name).style.display = "none";
			document.getElementById(img).src = '../images/plus.gif';
		}
		//var type = document.getElementById(id).innerText;得到<span>text</span>中text字符串
		//$("#"+name).remove();
		$("#" + name).empty();
		$
				.post(
						"../ReportServlet",
						{
							method : "getNextEJ",
							id : id
						},
						function(data) {
							var content = "";
							if (data != null && data.length > 0) {
								for ( var type in data) {

									content += "<div><div><span id='"
											+ data[type]
											+ "' onclick='checkSJ(this)'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src='../images/plus.gif' id='imgId"+data[type]+"'/>"
											+ "<a target='mainAction' href='${pageContext.request.contextPath }/ReportServlet?method=getListEJ&id="
											+ data[type] + "&parentId="+id+"'>" + data[type]
											+ "</a></span>";

									content += "</div><div id='S"+data[type]+"' style='display: none'>";
									/* 循环的二级菜单 */
									/***/
									content += "</div>";

								}
							}
							content += "</div>";
							$("#" + name).append(content);
						}, "json");

	}


	/**
	 *	二级菜单加载	（学科分类第一级  /  国民经济行业第一级）
	 */
	function checkYJ(obj) {

		var id = obj.id;
		var name = "S" + id;
		var img = "imgId" + id;

		if (document.getElementById(name).style.display == "none") {
			document.getElementById(name).style.display = "";
			document.getElementById(img).src = '../images/minus.gif';
		} else {
			document.getElementById(name).style.display = "none";
			document.getElementById(img).src = '../images/plus.gif';
		}
		//var type = document.getElementById(id).innerText;得到<span>text</span>中text字符串
		//$("#"+name).remove();
		$("#" + name).empty();
			//alert(isT(id)+"true");
			//alert("父节点："+id);
			//国民经济行业分类第一级
			$
					.post(
							"../ReportServlet",
							{
								method : "getNextYJ",
								id : id
							},
							function(data) {
								var content = "";
								if (data != null && data.length > 0) {
									for ( var type in data) {
										content += "<div><div><span id='"
											+ data[type]
											+ "' onclick='checkEJ(this)'><img src='../images/plus.gif' id='imgId"+data[type]+"'/>"
											+ "<a target='mainAction' href='${pageContext.request.contextPath }/ReportServlet?method=getListYJ&id="
											+ data[type] + "'>" + data[type]
											+ "</a></span>";
										content += "</div><div id='S"+data[type]+"' style='display: none'>";
										/* 循环的二级菜单 */
										/***/
										content += "</div>";
									}
								}
								content += "</div>";
								$("#" + name).append(content);
							}, "json");
	}

	/**
	 *	页面加载事件，一级菜单加载完毕
	 */
	function pre() {
		//页面加载事件
		$
				.post(
						"../ReportServlet",
						{
							method : "preType"

						},
						function(data) {
							var content = "";
							if (data != null && data.length > 0) {
								for ( var type in data) {
									content += "<div><div><span id='"
											+ data[type]
											+ "' onclick='checkYJ(this)'><img src='../images/plus.gif' id='imgId"+data[type]+"'/>"
											+ "<a target='mainAction' href='${pageContext.request.contextPath }/ReportServlet?method=getList&id="
											+ data[type] + "'>" + data[type]
											+ "</a></span>";
									content += "</div><div id='S"+data[type]+"' style='display: none'>";
									/* 循环的二级菜单 */
									/***/
									content += "</div>";
								}
							}
							content += "</div>";
							$("#types").append(content);
						}, "json");

	}
</script>
</head>
<body onload="pre()">
	<div class="leftMenu">
		<table>
			<tr bgcolor="#3FA0F1">
				<td width="263" height="23" bordercolor="#FFFFFF" bgcolor="#3FA0F1"
					style="height: 14px;"><h3 align="center" class="baizi">分类浏览</h3></td>
			</tr>
		</table>

		<div id="types"></div>
	</div>

</body>
</html>