<%@page import="com.Bean.UserBean" %>
<%@page import="com.Dao.UserDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>填报信息</title>
<style type="text/css">
	body {
	background-color: #DCF0FC;
	}
</style>
<script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="../js/StandardIndustrialClassificationCodes.js"></script>
</head>
<body>
<form action="addInfoInput.jsp" method="post">
<%
UserBean userBean=(UserBean)request.getSession().getAttribute("userBean");
%>

<div>
	<table width="800" border="1">
		<tr>
			<td width="150">平台名称</td>
			<td>
			
				<input type="text" size="20" name="platformName" value="<%=userBean.getPlatformName()%>">
			</td>
			<td width="150">平台编号</td>
			<td><input type="text" size="20" name="platformId" value="<%=userBean.getPlatformId()%>">
			</td>
		</tr>
	</table>
</div>
<div>
	<table width="800" border="1">
		<tr>
			<td width="150">批准年月</td>
			<td><input type="text" size="20" name="approvalTime" value="<%=userBean.getApprovalTime()%>"></td>
			<td width="150">批准文号</td>
			<td><input type="text" size="20" name="approvalNumber" value="<%=userBean.getApprovalNumber()%>"></td>
		</tr>
	</table>
</div>
<div>
	<table width="800" border="1">
		<tr>
			<td width="150">技术领域</td>
			<td><input type="text" size="80" name="technicalField"></td>
		</tr>
	</table>
</div>
<div>
	<table width="800" border="1">
		<tr>
			<td width="150">平台级别</td>
			<td >		
			     <input type="radio" name="platformLevel" value="国家级" checked>国家级&nbsp;
			     <input type="radio" name="platformLevel" value="省级">省级 &nbsp;
    		</td>
			<td>所在市县（区）</td>
			<td>
				<div class="control-group">
					<div class="controls">
					<select id="selProvince" name="province"></select>
					<select id="selCity" name="city"></select>
					<select id="selDist" name="district"></select>
					</div>
					<script src="../js/china.js"></script>
					<script type="text/javascript">
                                new oMenu('selProvince', 'selCity', 'selDist');
							</script>	
			</td>
		</tr>
	</table>
</div>
<script type="text/javascript">
function selectone(){
	 if(document.getElementById("1").checked)
		 {
		 	document.getElementById("2").disabled = true;
		 	document.getElementById("3").disabled = true;
		 	document.getElementById("4").disabled=true;
		 	document.getElementById("5").disabled=true;
		 }
	 else
		 {
		 	document.getElementById("2").disabled = false;
		 	document.getElementById("3").disabled =false;
		 	document.getElementById("4").disabled=false;
		 	document.getElementById("5").disabled=false;
		 }
}
function selecttwo(){
	if(document.getElementById("2").checked)
		{
			document.getElementById("1").disabled = true;
		}
	else
		document.getElementById("1").disabled = false;
}
</script>
<div>
	<table width="800" border="1">
		<tr>
			<td rowspan="3" width="150">平台组织形态</td>
			<td rowspan="3"> <input type="checkbox" name="orginationForm" value="内设机构相对独立(无法人资格)" id="1" onclick="selectone()" chencked>内设机构相对独立(无法人资格)&nbsp;</td>
			<td rowspan="2">
				<table>
					<tr>
						<td rowspan="3">
							<input type="checkbox" name="orginationForm" value="独立法人" id="2" onclick="selecttwo()">独立法人
						</td>
						<td>
							<input type="radio" name="orginationForm" value="企业法人" id="3">企业法人
						</td>
					</tr>
					<tr>
						<td><input type="radio" name="orginationForm" value="事业法人" id="4">事业法人</td>
					</tr>
					<tr>
						<td>
						<input type="radio" name="orginationForm" value="社团法人" id="5">社团法人
						</td>
					</tr>
				</table>
			</td>
			<td colspan="2">
				<table>
					<tr>
						<td><INPUT type="radio" name="gongJian" value="多单位 联合共建" checked>多单位 联合共建</td>
					</tr>
					<tr>
						<td><INPUT type="radio" name="gongJian" value="依托单位独立建设">依托单位独立建设</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>京津冀共建</td>
			<td>
				<INPUT type="radio" name="jingJinJi" value="是" checked>是&nbsp;
				<INPUT type="radio" name="jingJinJi" value="否">否&nbsp;
			</td>
		</tr>
	</table>
</div>
<div>
	<table width="800" border="1">
		<tr>
			<td width="150">服务的主要国民经济行业</td>
			<td>
				<p>
					门类：<select style="width: 100px;" id="category" lay-filter="category" name="category" ><option></option></select>
    				大类<select style="width: 100px;" id="division"  lay-filter="division" name="division"><option></option></select>
					中类：<select style="width: 100px;" id="group" lay-filter="group" name="group"><option></option></select>
					小类：<select style="width: 100px;" id="section" lay-filter="section" name="section" ><option></option></select>
    			</p>
			</td>
		</tr>
	</table>
</div>
<div>
	<table width="800" border="1">
		<tr>
			<td width="150">所属主要学科</td>
			<td>
				<div class="control-group">
					<div class="controls">
					<select id="selYJxueke" name="subject1"></select>
					<select id="selEJxueke" name="subject2"></select>
					<select id="selSJxueke" name="subject3"></select>
					</div>
					<script src="../js/subject.js"></script>
					<script type="text/javascript">
                                new oMenu('selYJxueke', 'selEJxueke', 'selSJxueke');
							</script>	
			</td>
		</tr>
	</table>
</div>
<div>
	<table width="800" border="1">
		<tr>
			<td width="150">依托单位名称</td>
			<td><input type="text" size="20" name="nameOfDependentUnit" ></td>
			<td>依托单位组织机构代码(社会信用代码)</td>
			<td><input type="text" size="20" name="organizationCode"></td>
		</tr>
	</table>
</div>
<div>
	<table width="800" border="1">
		<tr>
			<td width="150">依托单位法人代表姓名</td>
			<td><input type="text" size="20" name="nameOfLegalRepresentative"></td>
			<td width="150">办公电话</td>
			<td><input type="text" size="20" name="officePhone"></td>
		</tr>
	</table>
</div>
<div>
	<table width="800" border="1">
		<tr>
			<td width="150">依托单位类型</td>
			<td>
			<label><input type="radio" value="企业" name="typeOfDependentUnit" checked>企业</label>
			<label><input type="radio" value="科研机构" name="typeOfDependentUnit" >科研机构</label>
			<label><input type="radio" value="高等院校" name="typeOfDependentUnit" >高等院校</label>
			<label><input type="radio" value="检测机构" name="typeOfDependentUnit" >检测机构</label>
			<label><input type="radio" value="医疗机构" name="typeOfDependentUnit" >医疗机构</label>
			<label><input type="radio" value="政府机构" name="typeOfDependentUnit" >政府机构</label>
			<label><input type="radio" value="社团组织" name="typeOfDependentUnit" >社团组织</label>
			<label><input type="radio" value="其他" name="typeOfDependentUnit" >其他 </label>
			</td>
		</tr>
	</table>
</div>
<div>
	<table width="800" border="1">
		<tr>
			<td width="150px">共建单位</td>
			  <td width="650" colspan="22" id="org">
    		<input type="hidden" name="buildUnit" value="3" id="tn" />
    		<%for(int i=0;i<3;i++){
    			String name1="ourdanwei"+(i+1);
    			out.print(i+1);
    		%>
    		<input type="text" name="<%=name1%>"  value="" class="git">
      		<%}%>
      		<input type="button" onclick="add1();" id="btn" value="+" />
      		<script type="text/javascript">
      		var textnumber = parseInt(document.getElementById('tn').value);
			function add1(){
				var n = "ourdanwei"+(++textnumber);
    			var input1 = document.createElement('input');
    			input1.setAttribute('type', 'text');
    			input1.setAttribute('name', n);
    			input1.setAttribute('class', 'git');
    			
    			var x = document.createElement('input');
    			x.setAttribute('type','text');
    			x.setAttribute('readonly',true);
    			x.setAttribute('value',textnumber);
    			x.setAttribute('class','newnumber')
    			
    			
    			var btn1 = document.getElementById("org");
    			var btn = document.getElementById("btn");
    			btn1.insertBefore(input1,btn);
    			btn1.insertBefore(x,input1);
    			
    			var tn = document.getElementById('tn');
    			tn.value = textnumber;
			}
</script>
     </td>
		</tr>
	</table>
</div>
<div>
	<table width="800" border="1">
		<tr>
			<td rowspan="3" width="150">平台主任（院长 ）</td>
			<td>姓名</td>
			<td><input type="text" size="10" name="directorName"></td>
			<td>性别</td>
			<td>
			<input type="radio" name="directorSex" value="男" checked>男
			<input type="radio" name="directorSex" value="女">女
			</td>
			<td>出生年月</td>
			<td><input type="text" size="10" name="directorBirth" ></td>
			<td>职称 </td>
			<td><input type="text" size="10" name="directorTitle"></td>
		</tr>
		<tr>
			<td>所学专业</td>
			<td><input type="text" size="10" name="directorProfession"></td>
			<td>学历 </td>
			<td><input type="text" size="10" name="directorXueLi"></td>
			<td colspan="3">学位</td>
			<td><input type="text" size="10" name="directorXueWei"></td>
		</tr>
		<tr>
			<td>办公电话</td>
			<td><input type="text" size="10" name="directorOfficePhone"></td>
			<td>手机  </td>
			<td><input type="text" size="10" name="directorPhone"></td>
			<td colspan="3">E-mail</td>
			<td><input type="text" size="10" name="directorEmail"></td>
		</tr>
	</table>
</div>
<div>
	<table width="800" border="1">
		<tr>
			<td width="150">平台网站名称</td>
			<td><input type="text" size="10" name="nameOfPlatformWebsite"></td>
			<td width="150">网址</td>
			<td><input type="text" size="10" name="url"></td>
		</tr>
	</table>
</div>
<div>
	<table width="800" border="1">
		<tr>
			<td width="150">平台通讯地址</td>
			<td><input type="text" size="10" name="platformAddress"></td>
			<td width="150">邮编 </td>
			<td><input type="text" size="10" name="ZipCode"></td>
		</tr>
	</table>
</div>
		<input style="width:50px;height:30px;margin-left:320px;margin-top:0px" type="submit" value="提交"  />
 		<input style="width:50px;height:30px;margin-left:320px;margin-top:0px" type="reset"  value="取消"  />
</form>


         <!-- <div class="field">
          <input type="text" id="url1" name="slogo" class="input tips" style="width:25%; float:left;" value="" data-toggle="hover" data-place="right" data-image=""  />
          <input type="button" class="button bg-blue margin-left" id="image1" value="+ 浏览上传" >
        </div>-->
    <script type="text/javascript" src="../js/layui.js" ></script>
    <script type="text/javascript">
    layui.use("form")
    addressInit('category','division','group','section','A 农、林、牧、渔业', '01 农业', '011 谷物种植', '0111 稻谷种植');
	</script>
</body>
</html>