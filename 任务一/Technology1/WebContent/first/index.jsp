<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>河北省科技创新平台年报统计系统后台管理系统</title>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/css/bootstrap.css" />
</head>

<!-- frameset、frame表示简单的三框架页面 -->
<frameset frameborder="no" rows="82px, *">
    <frame src="head.jsp">
	<frameset  cols="285px, *">
		<frame src="left.jsp">
		<frame name="mainAction">   <!-- 规定框架的名称 -->
	</frameset>
</frameset>

</html>