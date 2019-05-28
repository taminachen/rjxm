<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>需求审核</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/css/bootstrap.css" />

<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>



<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/css/bootstrap.css">

<style type="text/css">
<!--
.STYLE1 {
	font-size: x-large
}
-->
</style>
</head>
<body>
	<div class="container-fulid">
		<div class="col-md-12">
			<h1 align="center">网络审核</h1>
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-10">
	<form name="form1" method="post" action="${pageContext.request.contextPath }/ReportServlet?method=selectReportList">
		<p align="center">
		<div class="col-md-10">
			<div class="col-md-5">
				<input type="text" name="platformID" class="form-control"
					placeholder="点击输入平台编号">
			</div>
			<div class="col-md-5">
				<input class="btn btn-primary" type="submit" name="Submit"
					value="点击查询">
			</div>
		</div>
		<c:if test="${param.status.status('1')}">
			<div class="alert alert-danger" role="alert">
				<div align="center">抱歉，查询不到</div>
			</div>
		</c:if>
	</form>
	<p>&nbsp;</p>
	<div class="col-md-1"></div>
	<div class="col-md-1"></div>
		<div class="col-md-1"></div>
		<div class="col-md-10">
		<table class="table table-striped">
			<tr>
				<td>平台编号</td>
				<td>平台名称</td>
				<td>批准文号</td>
				<td></td>
			</tr>
			<c:if test="${reportBeans!=null }">
			
			<c:forEach items="${reportBeans }" var="item" varStatus="status">
			<c:if test="${item.status==1||item.status==2}">
				<div class="alert alert-danger" role="alert">
					<div align="center">该信息已经审核</div>
				</div>
			</c:if>
			<c:if test="${item.status==0}">
				<tr>
					<td>${item.platformID }</td>
					<td>${item.platformName }</td>
					<td>${item.approvalNumber }</td>
					<td><a
						href="${pageContext.request.contextPath }/ReportServlet?method=reportDetails&platformID=${item.platformID }">去审核</a></td>
				</tr>
			</c:if>
			</c:forEach>
		</c:if>
	</table>
		<div class="col-md-1"></div>
		<div class="col-md-12"></div>
	</div>
</div>
		<div class="col-md-1"></div>
		<div class="col-md-12"></div>
	</div>
	<p>&nbsp;</p>
</body>

</html>