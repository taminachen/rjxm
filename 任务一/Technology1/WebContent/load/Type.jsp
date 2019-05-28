<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css" />
<title>分类检索</title>

<script type="text/javascript">
	function check() {
		var num = document.getElementById("num");
		if (num.value == "1") {
			if (document.getElementById('q0').value == "") {
				alert("系统友情提示首项查询条件不能为空");
				thisform.q0.focus();
				return false;
			}
		}
		if (num.value == "2") {
			if (document.getElementById('q0').value == "") {
				alert("系统友情提示首项查询条件不能为空");
				thisform.q0.focus();
				return false;
			} else {
				if (document.getElementById('q1').value == "") {
					alert("系统友情提示第二项查询条件不能为空");
					thisform.q1.focus();
					return false;
				}
			}
		}
		if (num.value == "3") {
			if (document.getElementById('q0').value == "") {
				alert("系统友情提示首项查询条件不能为空");
				thisform.q0.focus();
				return false;
			}
			if (document.getElementById('q1').value == "") {
				alert("系统友情提示第二项查询条件不能为空");
				thisform.q1.focus();
				return false;
			}
			if (document.getElementById('q2').value == "") {
				alert("系统友情提示第三项查询条件不能为空");
				thisform.q2.focus();
				return false;
			}
		}
	}
</script>

<script type="text/javascript">
	function addRow() {
		var obj = document.getElementById("num");
		var t = document.getElementById("sTable");
		if (t.rows.length >3) {
			alert("系统友情提示最多只能有3个条件");
			return;
		}
		var strId = (t.rows.length-1);

		//创建与或非
		var e = document.createElement("select");
		e.name = "logic" + strId;
		e.id = "logic" + strId;
		e.size = 1;
		e.options[0] = new Option("并且", "AND");
		e.options[1] = new Option("或者", "OR");
		e.options[2] = new Option("不含", "NOT");

		//创建新的选项--第一个之后的
		var e2 = document.createElement("select");
		e2.name = "sType" + strId;
		e2.id = "sType" + strId;
		e2.size = 1;
		e2.options[0] = new Option("平台编号", "platformID");// Title CreatorId AddDate
		e2.options[1] = new Option("平台名称", "platformName");
		e2.options[2] = new Option("批准文号", "approvalNumber");
		e2.options[3] = new Option("技术领域", "technicalField");
		e2.options[4] = new Option("依托单位名称", "nameOfDependentUnit");
		e2.options[5] = new Option("法人代表姓名", "nameOfLegalRepresentative");
		e2.options[6] = new Option("主任姓名", "directorName");
		e2.options[7] = new Option("邮编", "ZipCode");
		// 检索：

		//创建新的输入框
		var q1 = document.createElement("input");
		q1.type = "text";
		q1.size = 50;
		q1.maxlength = 60;
		q1.name = "q" + strId;
		q1.id = "q" + strId;

		var row = t.insertRow(t.rows.length);
		var c0 = row.insertCell(0);
		c0.appendChild(e);

		var c1 = row.insertCell(1);
		c1.appendChild(e2);
		c1.appendChild(q1);
		obj.value = parseInt(obj.value) + 1; //查询框的数量

	}

	function removeRow() {
		var obj = document.getElementById("num");
		tr = document.getElementById("sTable").rows;
		if (tr.length > 1) {
			var row = tr[tr.length - 1];
			if (row.parentNode)
				row.parentNode.removeChild(row);
			obj.value = parseInt(obj.value) - 1;
		}
	}
</script>


<script
	src="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/js/bootstrap.js"
	type="text/javascript"></script>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css" />
</head>
<body>


	<!--  需求编号、技术需求名称   新需求 -->

	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<form name="thisform" method="post"
					style="vertical-align: middle; text-align: center; margin-top: 20px;"
					onsubmit="return check();"
					action="${pageContext.request.contextPath }/ReportServlet?method=ZongHeChaXun">
					<table style="text-align: center;" width=740; id="sTable" name="sTable">

						<input type="hidden" id="num" name="num" value="1" />

						<tr>
							<th scope="col" colspan="6">
								<h3 align="left">平台信息列表</h3>
							</th>
						</tr>
						<tr id="row1">
							<td style="width: 60px;"><a href="#" onclick="addRow()"
								style="text-decoration: none;">+</a> <a href="#"
								onclick="removeRow()" style="text-decoration: none;">-</a></td>
							<td>
								<select name="sType0" size="1">
										<option value="platformID">平台编号</option>
										<option value="platformName">平台名称</option>
										<option value="approvalNumber">批准文号</option>
										<option value="technicalField">技术领域</option>
										<option value="nameOfDependentUnit">依托单位名称</option>
										<option value="nameOfLegalRepresentative">法人代表姓名</option>
										<option value="directorName">主任姓名</option>
										<option value="ZipCode">邮编</option>
								</select>
								<input type="text" size="50" maxlength="80" name="q0" id="q0">
								<input type="submit" class="submit" value="&nbsp;查&nbsp;询&nbsp;"size="30">
							</td>
						</tr>
						</tbody>
					</table>
				</form>

			</div>
			<hr class="divider">
		</div>

		<div class="row-fluid">
			<div class="col-md-1 "></div>
			<div class="col-md-9 ">
				<table class="table table-striped"
					style="width: 1002px; vertical-align: middle; text-align: center;">
					<tr>
						<td>平台编号</td>
						<td>平台名称</td>
						<td>批准年月</td>
						<td>批准文号</td>
						<td>技术领域</td>
						<td>平台级别</td>

						<td align="center" colspan="1">操作</td>

					</tr>
					<!-- forEach遍历出adminBeans -->
					<c:forEach items="${chaxun }" var="item" varStatus="status">
						<!-- varStatus="status"是什么-->
						<tr>
							<td>${item.platformID }</td>
							<td>${item.platformName }</td>
							<td>${item.approvalTime }</td>
							<td>${item.approvalNumber }</td>
							<td>${item.technicalField }</td>
							<td>${item.platformLevel }</td>
							<td>
								<c:if test="${item.status==0 }"><a href="${pageContext.request.contextPath}/ReportServlet?method=reportDetails&platformID=${item.platformID }">详情/审核</a></c:if> 	<!-- 未通过可以进行修改 --> 
								<c:if test="${item.status==1 }">已通过网络审核</c:if>
								<c:if test="${item.status==2 }">已退回</c:if>
							</td>
						</tr>

					</c:forEach>
				</table>
				<c:if test="${param.status.equals('1')}">
					<script type="text/javascript">
						alert("查无此问卷");
					</script>
				</c:if>
				<c:if test="${param.status.equals('2')}">
					<script type="text/javascript">
						alert("请填写查询依据");
					</script>
				</c:if>
				<c:if test="${param.status.equals('0')}">
					<script type="text/javascript">
						alert("有结果");
					</script>
				</c:if>
			</div>
		</div>
		</div>
</body>
</html>