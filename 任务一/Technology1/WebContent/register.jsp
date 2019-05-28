<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>用户注册</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/static/bootstrap-3.3.5-dist/css/bootstrap.css" />

<style type="text/css">

.code {
	background-image: url(code.jpg);
	font-family: Arial;
	font-style: italic;
	color: Red;
	border: 0;
	padding: 2px 3px;
	letter-spacing: 3px;
	font-weight: bolder;
}

.unchanged {
	border: 0;
}

.STYLE1 {
	color: #FF0000
}
</style>
<script type="text/javascript">
	function check(){
		if (document.getElementById('username').value == "") {
			alert("用户名为空！");
			return false;
		}
		if (document.getElementById('passowrd2').value == "") {
			alert("再次输入的密码为空！");
			return false;
		}
		if (document.getElementById('passowrd').value != document.getElementById('passowrd2').value) {
			alert("两次输入的密码为空！");
			return false;
		}
		if (document.getElementById('code').value == "") {
			alert("机构代码为空！");
			return false;
		}
		if (document.getElementById('name').value == "") {
			alert("姓名为空！");
			return false;
		}
		if (document.getElementById('id_number').value == "") {
			alert("身份证为空！");
			return false;
		}
		
	} 
	
	function focusNextInput(thisInput){
        var inputs = document.getElementsByTagName("input");
        for(var i = 0;i<inputs.length;i++){
          // 如果是最后一个，则焦点回到第一个
          if(i==(inputs.length-1)){
            inputs[0].focus();
            break;
          }else if(thisInput == inputs[i]){
            inputs[i+1].focus();
            break;
          }
        }
    }  

	/*-------------------------------------------------------------------------------------*/
</script>
</head>
<body>
	<div class="row-fluid">
		<div class="col-md-3"></div>
		<p>&nbsp;</p>
		<div class="col-md-6">
			<form role="form" method="post" class="form-horizontal" action="${pageContext.request.contextPath }/UserServlet?method=register"
				id="checkForm">
				<!-- param表示从表单中获取status-状态值 -->
				<c:if test="${param.status.equals('0')}">
					<div class='alert alert-success' role='alert'><a href="login.jsp">注册成功!点击返回登录界面。</a></div>
				</c:if>
				<c:if test="${param.status.equals('1')}">
					<div class="alert alert-danger" role="alert"><a href="login.jsp">注册失败，用户已存在！点击返回登录界面。</a></div>
				</c:if>

				
				<div class="form-group">
					<label class="col-md-3 control-label" for="username"><span
						class="STYLE1">*</span>用户名</label>
					<div class="col-md-9">
						<input class="form-control" name="username" type="text"
							id="username" placeholder="用户名" onkeypress="if(event.keyCode==13) focusNextInput(this);" autofocus />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-3 control-label" for="password"><span
						class="STYLE1">*</span>用户密码</label>
					<div class="col-md-9">
						<input type="password" name="password" class="form-control"
							id="inputPassword" onkeypress="if(event.keyCode==13) focusNextInput(this);" placeholder="用户密码" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label" for="password2"><span
						class="STYLE1">*</span>确认用户密码</label>
					<div class="col-md-9">
						<input type="password" name="password2" class="form-control"
							id="password2" onkeypress="if(event.keyCode==13) focusNextInput(this);" placeholder="确认用户密码" />
					</div>
				</div>
				
				<div class="form-group">
					<label class="col-md-3 control-label" for="platformId"><span
						class="STYLE1">*</span>平台编号</label>
					<div class="col-md-9">
						<input class="form-control" name="platformId" type="text" id="platformId"
							placeholder="平台编号" onkeypress="if(event.keyCode==13) focusNextInput(this);"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label" for="platformName"><span
						class="STYLE1">*</span>平台名称</label>
					<div class="col-md-9">
							<input name="platformName" id="platformName" class="form-control" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label" for="approvalTime"><span
						class="STYLE1">*</span>批准时间</label>
					<div class="col-md-9">
						<input class="form-control" name="approvalTime" type="text"
							id="approvalTime" placeholder="批准时间" onkeypress="if(event.keyCode==13) focusNextInput(this);"/>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label" for="approvalNumber">批准文号</label>
					<div class="col-md-9">
						<input type="text" name="approvalNumber"onkeypress="if(event.keyCode==13) focusNextInput(this);" />
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-3 control-label" for="technicalField">技术领域</label>
					<div class="col-md-9">
						<input class="form-control" name="technicalField" type="text" id="technicalField"
							placeholder="技术领域" onkeypress="if(event.keyCode==13) focusNextInput(this);"/>
					</div>
				</div>
				<div class="form-group"></div>
				<div class="form-group">
					<div class="col-md-offset-3 col-md-9">
						<button type="submit" class="btn btn-primary btn-block" onClick="return check()">确认注册</button>
						
						<input type="reset" class="btn btn-primary btn-block" value="取消" onclick="javascript:window.location='login.jsp';" />
					</div>
				</div>


			</form>
		</div>
		<div class="col-md-3"></div>
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