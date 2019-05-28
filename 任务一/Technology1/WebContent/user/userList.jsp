<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户管理</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/css/bootstrap.css" />
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">



<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/bootstrap-3.3.5-dist/js/bootstrap.js"></script>
<style type="text/css">
<!--
.STYLE1 {
	font-size: x-large
}
-->
</style>
<script type="text/javascript">	


	function ch() {
		alert("重置完毕！");
	}
	
</script>
</head>
<body>
	<div class="container-fulid">
		<div class="col-md-12">
			<h1 align="center">用户管理</h1>
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-10">
			<p>&nbsp;</p>
			<c:if test="${userBeans!=null }">
				<div class="col-md-13">
					<table class="table table-striped">
						<tr>
							<td>用户名</td>
							<td>平台编号</td>
							<td>平台名称</td>
							<td>角色</td>
							<td>密码</td>
							<td>重置密码</td>
							<td></td>
						</tr>
						<c:forEach items="${userBeans }" var="item" varStatus="status">
							<form name="form1" method="post" action="${pageContext.request.contextPath }/user/updatePassword.jsp?username=${item.username}">
								<tr>
									<td>${item.username }</td>
									<td>${item.platformId }</td>
									<td>${item.platformName }</td>
									<td><c:if test="${item.status==0}">管理员</c:if> <c:if
											test="${item.status==1}">网络审核员</c:if> <c:if
											test="${item.status==2}">注册用户</c:if> <c:if
											test="${item.status==3}">此用户还未通过审核</c:if></td>
									<td>${item.password }</td>
									<td><input id="password" name="password" type="password"
										class="form-control" value="${item.password }"></td>
									<td><input class="btn btn-info" type="submit"
										onClick="ch()" value="确认重置"></td>
								</tr>
							</form>
						</c:forEach>
						
					</table>
				</div>
			</c:if>
		</div>
	</div>

	<p>&nbsp;</p>
</body>

</html>