<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>菜单栏（非管理员）</title>

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
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>

</head>
<body style="margin: 0;">
	<div class="leftMenu">
		<table width="271" border="0" cellpadding="2" cellspacing="2"
			borer="0" style="border-color: white;">
			<tr bgcolor="#3FA0F1">
				<td width="263" height="23" bordercolor="#FFFFFF" bgcolor="#3FA0F1"
					style="height: 14px;"><h3 align="center" class="baizi">系统菜单</h3></td>
			</tr>

<!-- ——————————————————————————————————————————————————————网络审核员—————————————————————————————————————————— -->
			<c:if test="${userBean.status==1 }">
				<!-- 网络审核员		 -->
				<tr bgcolor="#C0E4FA">
					<td height="20" bordercolor="#FFFFFF"><div align="left">
							<span class="zi">此ees</span><img src="../images/lefticon.png" alt=""
								width="10" height="14" align="middle" /><a target="mainAction"
								href="${pageContext.request.contextPath }/ReportServlet?method=reportList">
								网络审核</a>
						</div></td>
				</tr>
				<tr bgcolor="#C0E4FA">
					<td height="20" bordercolor="#FFFFFF"><div align="left">
							<span class="zi">此ees</span><img src="../images/lefticon.png" alt=""
								width="10" height="14" align="middle" /><a target="_blank"
								href="${pageContext.request.contextPath }/type/index.jsp">
								分类浏览</a>
						</div></td>
				</tr>
				<tr bgcolor="#C0E4FA">
					<td height="20" bordercolor="#FFFFFF"><div align="left">
							<span class="zi">此ees</span><img src="../images/lefticon.png" alt=""
								width="10" height="14" align="middle" /><a target="mainAction"
								href="${pageContext.request.contextPath }/load/Type.jsp">
								综合检索</a>
						</div></td>
				</tr>
					<tr bgcolor="#C0E4FA">
					<td height="20" bordercolor="#FFFFFF"><div align="left">
							<span class="zi">此ees</span><img src="../images/lefticon.png" alt=""
								width="10" height="14" align="middle" /><a target="mainAction"
								href="${pageContext.request.contextPath }/ReportServlet?method=tongji">
								图表统计</a>
						</div></td>
				</tr>
				<tr bgcolor="#C0E4FA">
					<td height="20" bordercolor="#FFFFFF"><div align="left">
							<span class="zi">此ees</span><img src="../images/lefticon.png" alt=""
								width="10" height="14" align="middle" /><a target="mainAction"
								href="${pageContext.request.contextPath }/my/myPass.jsp">
								修改密码</a>
						</div></td>
				</tr>
				<tr bgcolor="#C0E4FA">
					<td height="20" bordercolor="#FFFFFF"><div align="left">
							<span class="zi">此ees</span><img src="../images/lefticon.png" alt=""
								width="10" height="14" align="middle" /><a target="_parent"
								href="${pageContext.request.contextPath }/UserServlet?method=end">
								退出登录</a>
						</div></td>
				</tr>
			</c:if>





			<!-- ——————————————————————————————————————————————————————注册用户—————————————————————————————————————————— -->
			<c:if test="${userBean.status==2 }">
				<!-- 注册用户		 -->
				<tr bgcolor="#C0E4FA">
					<td height="20" bordercolor="#FFFFFF"><div align="left">
							<span class="zi">此ees</span><img src="../images/lefticon.png" alt=""
								width="10" height="14" align="middle" /><a target="mainAction"
								href="${pageContext.request.contextPath }/info/addInfo.jsp">需求征集</a>
						</div></td>
				</tr>
				<tr bgcolor="#C0E4FA">
					<td height="20" bordercolor="#FFFFFF"><div align="left">
							<span class="zi">此ees</span><img src="../images/lefticon.png" alt=""
								width="10" height="14" align="middle" /><a target="mainAction"
								href="${pageContext.request.contextPath }/ReportServlet?method=myList&platformId=${userBean.platformId }">
								填报状态</a>
						</div></td>
				</tr>
				<tr bgcolor="#C0E4FA">
					<td height="20" bordercolor="#FFFFFF"><div align="left">
							<span class="zi">此ees</span><img src="../images/lefticon.png" alt=""
								width="10" height="14" align="middle" /><a target="mainAction"
								href="${pageContext.request.contextPath }/my/myPass.jsp">
								修改密码</a>
						</div></td>
				</tr>
				<tr bgcolor="#C0E4FA">
					<td height="20" bordercolor="#FFFFFF"><div align="left">
							<span class="zi">此ees</span><img src="../images/lefticon.png" alt=""
								width="10" height="14" align="middle" /><a target="mainAction"
								href="${pageContext.request.contextPath }/help.jsp"> 帮助文件</a>
						</div></td>
				</tr>
				<tr bgcolor="#C0E4FA">
					<td height="20" bordercolor="#FFFFFF"><div align="left">
							<span class="zi">此ees</span><img src="../images/lefticon.png" alt=""
								width="10" height="14" align="middle" /><a target="_parent"
								href="${pageContext.request.contextPath }/UserServlet?method=end">
								退出登录</a>
						</div></td>
				</tr>
			</c:if>



			<!-- ——————————————————————————————————————————————————————未分配角色，及账号还未被审核—————————————————————————————————————————— -->
			<c:if test="${userBean.status==3}">
				<!-- 管理员		 -->
				<tr bgcolor="#C0E4FA">
					<td height="20" bordercolor="#FFFFFF"><div align="left">
							<span class="zi">此ees</span><img src="../images/lefticon.png" alt=""
								width="10" height="14" align="middle" /> 账户还未审核，暂时无法使用
						</div></td>
				</tr>
				<tr bgcolor="#C0E4FA">
					<td height="20" bordercolor="#FFFFFF"><div align="left">
							<span class="zi">此ees</span><img src="../images/lefticon.png" alt=""
								width="10" height="14" align="middle" /><a target="_parent"
								href="${pageContext.request.contextPath }/UserServlet?method=end">
								退出登录</a>
						</div></td>
				</tr>



			</c:if>

		</table>
	</div>
</body>
</html>