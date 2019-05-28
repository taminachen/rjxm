<%@page import="com.Dao.UserDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改密码</title>
</head>
<body>
<%
String username=request.getParameter("username");
System.out.println(username);
String password=request.getParameter("password");
System.out.println(password);
UserDao userDao=new UserDao();
boolean flag=userDao.update(username,password);
if(flag){
	response.sendRedirect("${pageContext.request.contextPath }/UserServlet?method=userList");
}
else{
	response.sendRedirect("${pageContext.request.contextPath }/UserServlet?method=userList");
}
%>
</body>
</html>