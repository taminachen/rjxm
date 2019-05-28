<%@page import="com.Dao.ReportDao" %>
<%@page import="com.Bean.ReportBean" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>审核信息</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css" />

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

.STYLE2 {
	color: #FF0000
}
-->
</style>
<script language="JavaScript">
	function sele() {
		document.getElementById("tr").style.display = "none";
		document.getElementById("tr2").style.display = "none";
	}
	function sele2() {
		document.getElementById("tr").style.display = "";
		document.getElementById("tr2").style.display = "";
	}
</script>
</head>
<body>
<%
	String platformID = request.getParameter("platformID");
	ReportBean reportBean = new ReportBean();
	ReportDao reportDao = new ReportDao();
	reportBean = reportDao.loadReport(platformID);
	request.setAttribute("reportBean", reportBean);
%>
	<div class="container-fulid">
		<div class="col-md-12">
			<h1 align="center">平台详细内容</h1>
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-10">
	<form id="form1" name="form1" method="post">
<div>
	<table class="table table-bordered" class="table table-bordered" width="800" border="1">
		<tr>
			<td width="150">平台名称</td>
			<td>${reportBean.getPlatformName() }</td>
			<td width="150">平台编号</td>
			<td>${reportBean.getPlatformID() }</td>
		</tr>
	</table>
</div>
<div>
	<table class="table table-bordered" width="800" border="1">
		<tr>
			<td width="150">批准年月</td>
			<td>${reportBean.getApprovalTime() }</td>
			<td width="150">批准文号</td>
			<td>${reportBean.getApprovalNumber() }</td>
		</tr>
	</table>
</div>
<div>
	<table class="table table-bordered" width="800" border="1">
		<tr>
			<td width="150">技术领域</td>
			<td>${reportBean.getTechnicalField() }</td>
		</tr>
	</table>
</div>
<div>
	<table class="table table-bordered" width="800" border="1">
		<tr>
			<td width="150">平台级别</td>
			<td >${reportBean.getPlatformLevel() }</td>
			<td>所在市县（区）</td>
			<td>${reportBean.getCityAndCountry() }</td>
		</tr>
	</table>
</div>
<div>
	<table class="table table-bordered" width="800" border="1">
		<tr>
			<td rowspan="3" width="150">平台组织形态</td>
			<td rowspan="2">${reportBean.getOrginationForm() }</td>
			<td rowspan="3">单位建设情况</td>
			<td colspan="2">${reportBean.getGongJian() }</td>
		</tr>
		<tr>
			<td>京津冀共建</td>
			<td>${reportBean.getJingJinJi() }</td>
		</tr>
	</table>
</div>
<div>
	<table class="table table-bordered" width="800" border="1">
		<tr>
			<td width="150">服务的主要国民经济行业</td>
			<td>${reportBean.getMlhangye()}&nbsp;${reportBean.getYjhangye()}&nbsp;${reportBean.getEjhangye()}&nbsp;${reportBean.getSjhangye()}</td>
		</tr>
	</table>
</div>
<div>
	<table class="table table-bordered" width="800" border="1">
		<tr>
			<td width="150">所属主要学科</td>
			<td>${reportBean.getYjxueke()}&nbsp;${reportBean.getEjxueke()}&nbsp;${reportBean.getSjxueke()}</td>
		</tr>
	</table>
</div>
<div>
	<table class="table table-bordered" width="800" border="1">
		<tr>
			<td width="150">依托单位名称</td>
			<td>${reportBean.getNameOfDependentUnit() }</td>
			<td>依托单位组织机构代码(社会信用代码)</td>
			<td>${reportBean.getOrganizationCode() }</td>
		</tr>
	</table>
</div>
<div>
	<table class="table table-bordered" width="800" border="1">
		<tr>
			<td width="150">依托单位法人代表姓名</td>
			<td>${reportBean.getNameOfLegalRepresentative() }</td>
			<td width="150">办公电话</td>
			<td>${reportBean.getOfficePhone() }</td>
		</tr>
	</table>
</div>
<div>
	<table class="table table-bordered" width="800" border="1">
		<tr>
			<td width="150">依托单位类型</td>
			<td>${reportBean.getTypeOfDependentUnit() }</td>
		</tr>
	</table>
</div>
<div>
	<table class="table table-bordered" width="800" border="1">
		<tr>
			<td width="150px">共建单位</td>
			  <td width="650" colspan="22" id="org">${reportBean.getBuildUnit() }</td>
		</tr>
	</table>
</div>
<div>
	<table class="table table-bordered" width="800" border="1">
		<tr>
			<td rowspan="3" width="150">平台主任（院长 ）</td>
			<td>姓名</td>
			<td>${reportBean.getDirectorName() }</td>
			<td>性别</td>
			<td>${reportBean.getDirectorSex() }</td>
			<td>出生年月</td>
			<td>${reportBean.getDirectorBirth() }</td>
			<td>职称 </td>
			<td>${reportBean.getDirectorTitle() }</td>
		</tr>
		<tr>
			<td>所学专业</td>
			<td>${reportBean.getDirectorProfession() }</td>
			<td>学历 </td>
			<td>${reportBean.getDirectorXueLi() }</td>
			<td colspan="3">学位</td>
			<td>${reportBean.getDirectorXueWei() }</td>
		</tr>
		<tr>
			<td>办公电话</td>
			<td>${reportBean.getDirectorOfficePhone() }</td>
			<td>手机  </td>
			<td>${reportBean.getDirectorPhone() }</td>
			<td colspan="3">E-mail</td>
			<td>${reportBean.getDirectorEmail() }</td>
		</tr>
	</table>
</div>
<div>
	<table class="table table-bordered" width="800" border="1">
		<tr>
			<td width="150">平台网站名称</td>
			<td>${reportBean.getNameOfPlatformWebsite() }</td>
			<td width="150">网址</td>
			<td>${reportBean.getUrl() }</td>
		</tr>
	</table>
</div>
<div>
	<table class="table table-bordered" width="800" border="1">
		<tr>
			<td width="150">平台通讯地址</td>
			<td>${reportBean.getPlatformAddress() }</td>
			<td width="150">邮编 </td>
			<td>${reportBean.getZipCode()}</td>
		</tr>
		</table>
</div>
</form>
	</div>
		<div class="col-md-1"></div>
		<div class="col-md-12"></div>
	</div>
</body>

</html>