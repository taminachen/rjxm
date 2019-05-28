<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>河北省创新年报平台信息</title>
<style type="text/css">
body {
	background-color: #DCF0FC;
}
<!--
.STYLE1 {
	font-size: x-large
}
-->
</style>
<script
	src="${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css">
<script
	src="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</head>
<body onload='document.getElementById("name").focus();'>
		<div class="container-fulid">
		<div class="col-md-12">
			<h1 align="center">平台信息</h1>
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-10">
		<c:if test="${reportBeans!=null }">
			<table class="table table-striped">
				<tr>
					<td width="113">平台编号</td>
					<td width="162">平台名称</td>
					<td width="206">批准文号</td>
					<td width="206">审核状态</td>
					<td width="206">操作</td>
				</tr>
				<c:forEach items="${reportBeans }" var="item" varStatus="status">
					<tr>
						<td>${item.platformID }</td>
						<td>${item.platformName }</td>
						<td>${item.approvalNumber }</td>
						<td>
							<c:if test="${item.status==0 }">还未审核</c:if> 	<!-- 未通过可以进行修改 --> 
							<c:if test="${item.status==1 }">已通过网络审核</c:if>
							<c:if test="${item.status==2 }">已退回</c:if>
						</td>
						<td>
						<a
						href="${pageContext.request.contextPath }/my/reportDetail.jsp?platformID=${item.platformID }">查看详情</a>
						</td>
					</tr>
				</c:forEach>
			</table>

		</c:if>

		<p>&nbsp;</p>


</div>
		<div class="col-md-1"></div>
		<div class="col-md-12"></div>
	</div>
	<script
		src="${pageContext.request.contextPath}/static/js/jquery-1.12.1.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/js/bootstrap.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/jquery.validate.js"
		type="text/javascript"></script>
	<script
		src="${pageContext.request.contextPath}/static/js/myValidate.js"
		type="text/javascript"></script>
</body>

</html>