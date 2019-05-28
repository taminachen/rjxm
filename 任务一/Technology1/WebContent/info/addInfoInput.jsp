<%@ page import="com.Bean.ReportBean" %>
<%@ page import="com.Dao.ReportDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>传递参数</title>
</head>
<body>
<%
String platformName=new String((request.getParameter("platformName")).getBytes("ISO-8859-1"),"UTF-8");
String platformId=new String((request.getParameter("platformId")).getBytes("ISO-8859-1"),"UTF-8");
String approvalTime=new String((request.getParameter("approvalTime")).getBytes("ISO-8859-1"),"UTF-8");
String approvalNumber=new String((request.getParameter("approvalNumber")).getBytes("ISO-8859-1"),"UTF-8");
String technicalField=new String((request.getParameter("technicalField")).getBytes("ISO-8859-1"),"UTF-8");


/*String country_grade=request.getParameter("country_grade");
String province_grade=request.getParameter("province_grade");
String platformLevel=null;
if(country_grade==null&&province_grade!=null)
	platformLevel=province_grade;
else
	platformLevel=country_grade;
*/
String platformLevel=new String((request.getParameter("platformLevel")).getBytes("ISO-8859-1"),"UTF-8");
System.out.println(platformLevel);
String province=new String((request.getParameter("province")).getBytes("ISO-8859-1"),"UTF-8");
String city=new String((request.getParameter("city")).getBytes("ISO-8859-1"),"UTF-8");
String district=new String((request.getParameter("district")).getBytes("ISO-8859-1"),"UTF-8");
String cityAndCountry=province+city+district;
System.out.println(cityAndCountry);


String orginationForm=new String((request.getParameter("orginationForm")).getBytes("ISO-8859-1"),"UTF-8");
System.out.println(orginationForm);
String gongJian=new String((request.getParameter("gongJian")).getBytes("ISO-8859-1"),"UTF-8");
String jingJinJi=new String((request.getParameter("jingJinJi")).getBytes("ISO-8859-1"),"UTF-8");

//服务的国民经济行业
String mlhangye=new String((request.getParameter("category")).getBytes("ISO-8859-1"),"UTF-8");
String yjhangye=new String((request.getParameter("division")).getBytes("ISO-8859-1"),"UTF-8");
String ejhangye=new String((request.getParameter("group")).getBytes("ISO-8859-1"),"UTF-8");
String sjhangye=new String((request.getParameter("section")).getBytes("ISO-8859-1"),"UTF-8");

//所属的主要学科
String yjxueke=new String((request.getParameter("subject1")).getBytes("ISO-8859-1"),"UTF-8");
String ejxueke=new String((request.getParameter("subject2")).getBytes("ISO-8859-1"),"UTF-8");
String sjxueke=new String((request.getParameter("subject3")).getBytes("ISO-8859-1"),"UTF-8");

String nameOfDependentUnit=new String((request.getParameter("nameOfDependentUnit")).getBytes("ISO-8859-1"),"UTF-8");
String organizationCode=new String((request.getParameter("organizationCode")).getBytes("ISO-8859-1"),"UTF-8");
String nameOfLegalRepresentative=new String((request.getParameter("nameOfLegalRepresentative")).getBytes("ISO-8859-1"),"UTF-8");
String officePhone=new String((request.getParameter("officePhone")).getBytes("ISO-8859-1"),"UTF-8");
String typeOfDependentUnit=new String((request.getParameter("typeOfDependentUnit")).getBytes("ISO-8859-1"),"UTF-8");
String buildUnit=new String((request.getParameter("buildUnit")).getBytes("ISO-8859-1"),"UTF-8");
String directorName=new String((request.getParameter("directorName")).getBytes("ISO-8859-1"),"UTF-8");
String directorSex=new String((request.getParameter("directorSex")).getBytes("ISO-8859-1"),"UTF-8");
String directorBirth=new String((request.getParameter("directorBirth")).getBytes("ISO-8859-1"),"UTF-8");
String directorTitle=new String((request.getParameter("directorTitle")).getBytes("ISO-8859-1"),"UTF-8");
String directorProfession=new String((request.getParameter("directorProfession")).getBytes("ISO-8859-1"),"UTF-8");
String directorXueLi=new String((request.getParameter("directorXueLi")).getBytes("ISO-8859-1"),"UTF-8");
String directorXueWei=new String((request.getParameter("directorXueWei")).getBytes("ISO-8859-1"),"UTF-8");
String directorOfficePhone=new String((request.getParameter("directorOfficePhone")).getBytes("ISO-8859-1"),"UTF-8");
String directorPhone=new String((request.getParameter("directorPhone")).getBytes("ISO-8859-1"),"UTF-8");
String directorEmail=new String((request.getParameter("directorEmail")).getBytes("ISO-8859-1"),"UTF-8");
String nameOfPlatformWebsite=new String((request.getParameter("nameOfPlatformWebsite")).getBytes("ISO-8859-1"),"UTF-8");
String url=new String((request.getParameter("url")).getBytes("ISO-8859-1"),"UTF-8");
String platformAddress=new String((request.getParameter("platformAddress")).getBytes("ISO-8859-1"),"UTF-8");
String ZipCode=new String((request.getParameter("ZipCode")).getBytes("ISO-8859-1"),"UTF-8");

ReportBean report=new ReportBean();

report.setPlatformID(platformId);
report.setPlatformName(platformName);
report.setApprovalTime(approvalTime);
report.setApprovalNumber(approvalNumber);
report.setTechnicalField(technicalField);
report.setPlatformLevel(platformLevel);
report.setCityAndCountry(cityAndCountry);
report.setOrginationForm(orginationForm);
report.setGongJian(gongJian);
report.setJingJinJi(jingJinJi);
report.setMlhangye(mlhangye);
report.setYjhangye(yjhangye);
report.setEjhangye(ejhangye);
report.setSjhangye(sjhangye);
report.setYjxueke(yjxueke);
report.setEjxueke(ejxueke);
report.setSjxueke(sjxueke);

report.setNameOfDependentUnit(nameOfDependentUnit);
report.setOrganizationCode(organizationCode);
report.setNameOfLegalRepresentative(nameOfLegalRepresentative);
report.setOfficePhone(officePhone);
report.setTypeOfDependentUnit(typeOfDependentUnit);
report.setBuildUnit(buildUnit);
report.setDirectorName(directorName);
report.setDirectorSex(directorSex);
report.setDirectorBirth(directorBirth);
report.setDirectorTitle(directorTitle);
report.setDirectorProfession(directorProfession);
report.setDirectorXueLi(directorXueLi);
report.setDirectorXueWei(directorXueWei);
report.setDirectorOfficePhone(directorOfficePhone);
report.setDirectorPhone(directorPhone);
report.setDirectorEmail(directorEmail);
report.setNameOfPlatformWebsite(nameOfPlatformWebsite);
report.setPlatformAddress(url);
report.setUrl(platformAddress);
report.setZipCode(ZipCode);
report.setStatus(0);
report.setSuggestion(null);

ReportDao reportDao=new ReportDao();
reportDao.addReport(report);
%>
</body>
</html>