package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Bean.ReportBean;
import com.Bean.TongJiBean;
import com.Util.DBUtil;
import com.Util.StringUtil;


public class ReportDao {
	//����û�
	@SuppressWarnings("resource")
	public void addReport(ReportBean report) {
	//������Ӷ���
	Connection connection = DBUtil.getConnection();
	//׼��sql���
	String sql="select count(*) from report where platformId=?";
	//������䴫�����
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	try {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,report.getPlatformID());
		//���ս����
		resultSet=preparedStatement.executeQuery();
		sql = "insert into report(platformID,platformName,approvalTime,approvalNumber,technicalField,platformLevel,cityAndCountry,orginationForm,gongJian,jingJinJi,mlhangye,yjhangye,ejhangye,sjhangye,yjxueke,ejxueke,sjxueke,nameOfDependentUnit,organizationCode,nameOfLegalRepresentative,officePhone,typeOfDependentUnit,buildUnit,directorName,directorSex,directorBirth,directorTitle,directorProfession,directorXueLi,directorXueWei,directorOfficePhone,directorPhone,directorEmail,nameOfPlatformWebsite,url,platformAddress,ZipCode,status,suggestion) value (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, report.getPlatformID());
		preparedStatement.setString(2, report.getPlatformName());
		preparedStatement.setString(3, report.getApprovalTime());
		preparedStatement.setString(4, report.getApprovalNumber());
		preparedStatement.setString(5, report.getTechnicalField());
		preparedStatement.setString(6, report.getPlatformLevel());
		preparedStatement.setString(7, report.getCityAndCountry());
		preparedStatement.setString(8, report.getOrginationForm());
		preparedStatement.setString(9, report.getGongJian());
		preparedStatement.setString(10, report.getJingJinJi());
		preparedStatement.setString(11, report.getMlhangye());
		preparedStatement.setString(12, report.getYjhangye());
		preparedStatement.setString(13, report.getEjhangye());
		preparedStatement.setString(14, report.getSjhangye());
		preparedStatement.setString(15, report.getYjxueke());
		preparedStatement.setString(16, report.getEjxueke());
		preparedStatement.setString(17, report.getSjxueke());
		preparedStatement.setString(18, report.getNameOfDependentUnit());
		preparedStatement.setString(19, report.getOrganizationCode());
		preparedStatement.setString(20, report.getNameOfLegalRepresentative());
		preparedStatement.setString(21, report.getOfficePhone());
		preparedStatement.setString(22, report.getTypeOfDependentUnit());
		preparedStatement.setString(23,report.getBuildUnit());
		preparedStatement.setString(24, report.getDirectorName());
		preparedStatement.setString(25, report.getDirectorSex());
		preparedStatement.setString(26, report.getDirectorBirth());
		preparedStatement.setString(27, report.getDirectorTitle());
		preparedStatement.setString(28, report.getDirectorProfession());
		preparedStatement.setString(29, report.getDirectorXueLi());
		preparedStatement.setString(30, report.getDirectorXueWei());
		preparedStatement.setString(31, report.getDirectorOfficePhone());
		preparedStatement.setString(32, report.getDirectorPhone());
		preparedStatement.setString(33, report.getDirectorEmail());
		preparedStatement.setString(34, report.getNameOfPlatformWebsite());
		preparedStatement.setString(35, report.getUrl());
		preparedStatement.setString(36, report.getPlatformAddress());
		preparedStatement.setString(37, report.getZipCode());
		preparedStatement.setInt(38, report.getStatus());
		preparedStatement.setString(39,report.getSuggestion());
		
		System.out.println(report.getStatus());
		preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			//�ر���Դ
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
	}
	
	//ɾ������
	public void deleteReport(ReportBean report) {
		
	}
	
	//�޸��û�
	public void updateReport(ReportBean report) {
		
	}

	//��ѯ�û�
	public ReportBean loadReport(String platformID) {
		Connection connection = DBUtil.getConnection();
		//׼��sql���
		String sql = "select * from report where platformID = ?";
		//������䴫�����
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ReportBean report=null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, platformID);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				report=new ReportBean();
				report.setPlatformID(resultSet.getString("platformID"));
				report.setPlatformName(resultSet.getString("platformName"));
				report.setApprovalTime(resultSet.getString("approvalTime"));
				report.setApprovalNumber(resultSet.getString("approvalNumber"));
				report.setTechnicalField(resultSet.getString("technicalField"));
				report.setPlatformLevel(resultSet.getString("platformLevel"));
				report.setCityAndCountry(resultSet.getString("cityAndCountry"));
				report.setOrginationForm(resultSet.getString("orginationForm"));
				report.setGongJian(resultSet.getString("gongJian"));
				report.setJingJinJi(resultSet.getString("jingJinJi"));
				report.setMlhangye(resultSet.getString("mlhangye"));
				report.setYjhangye(resultSet.getString("yjhangye"));
				report.setEjhangye(resultSet.getString("ejhangye"));
				report.setSjhangye(resultSet.getString("sjhangye"));
				report.setYjxueke(resultSet.getString("yjxueke"));
				report.setEjxueke(resultSet.getString("ejxueke"));
				report.setSjxueke(resultSet.getString("sjxueke"));
				report.setNameOfDependentUnit(resultSet.getString("nameOfDependentUnit"));
				report.setOrganizationCode(resultSet.getString("organizationCode"));
				report.setNameOfLegalRepresentative(resultSet.getString("nameOfLegalRepresentative"));
				report.setOfficePhone(resultSet.getString("officePhone"));
				report.setTypeOfDependentUnit(resultSet.getString("typeOfDependentUnit"));
				report.setBuildUnit(resultSet.getString("buildUnit"));
				report.setDirectorName(resultSet.getString("directorName"));
				report.setDirectorSex(resultSet.getString("directorSex"));
				report.setDirectorBirth(resultSet.getString("directorBirth"));
				report.setDirectorTitle(resultSet.getString("directorTitle"));
				report.setDirectorProfession(resultSet.getString("directorProfession"));
				report.setDirectorXueLi(resultSet.getString("directorXueLi"));
				report.setDirectorXueWei(resultSet.getString("directorXueWei"));
				report.setDirectorOfficePhone(resultSet.getString("directorOfficePhone"));
				report.setDirectorPhone(resultSet.getString("directorPhone"));
				report.setDirectorEmail(resultSet.getString("directorEmail"));
				report.setNameOfPlatformWebsite(resultSet.getString("nameOfPlatformWebsite"));
				report.setUrl(resultSet.getString("url"));
				report.setPlatformAddress(resultSet.getString("platformAddress"));
				report.setZipCode(resultSet.getString("ZipCode"));
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBUtil.close(resultSet);
				DBUtil.close(preparedStatement);
				DBUtil.close(connection);
			}
			return report;
			
		}
	
	//��ʾ���񾭼���ҵ����
	public List<String> getMenLei(){
		String sql="select distinct mlhangye from report";
		Connection connection=DBUtil.getConnection();
		Statement statement=null;
		ResultSet resultSet = null;
		List<String> menleihangyes=new ArrayList<String>();
		try{
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			String menleihangye=null;
			while(resultSet.next()){
				menleihangye=resultSet.getString("mlhangye");
				menleihangyes.add(menleihangye);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		return menleihangyes;
	}
	
	/*��ʾ���񾭼���ҵ��һ��*/
	public List<String> getYijihangye(String type){
		String sql="select distinct yjhangye from report where mlhangye='"+type+"'";
		Connection connection=DBUtil.getConnection();
		Statement statement=null;
		ResultSet resultSet = null;
		List<String> yijihangyes=new ArrayList<String>();
		try{
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			String yijihangye=null;
			while(resultSet.next()){
				yijihangye=resultSet.getString("yjhangye");
				yijihangyes.add(yijihangye);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		return yijihangyes;
	}
	
	/*��ʾ���񾭼÷���ڶ���*/
	public List<String> getErjihangye(String type){
		String sql="select distinct ejhangye from report where yjhangye='"+type+"'";
		Connection connection=DBUtil.getConnection();
		Statement statement=null;
		ResultSet resultSet = null;
		List<String> erjihangyes=new ArrayList<String>();
		try{
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			String erjihangye=null;
			while(resultSet.next()){
				erjihangye=resultSet.getString("ejhangye");
				//System.out.println(XKFL);
				erjihangyes.add(erjihangye);
				}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		
		return erjihangyes;
	}
	
	/*��ʾ���񾭼���ҵ���������*/
	public List<String> getSanjihangye(String type){
		String sql="select distinct sjhangye from report where ejhangye='"+type+"'";
		Connection connection=DBUtil.getConnection();
		Statement statement=null;
		ResultSet resultSet = null;
		List<String> sjhangyes=new ArrayList<String>();
		try{
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			String erjihangye=null;
			while(resultSet.next()){
				erjihangye=resultSet.getString("sjhangye");
				sjhangyes.add(erjihangye);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		
		return sjhangyes;
	}
	
	
	//�б���ʽ��ʾƽ̨��Ϣ
	public List<ReportBean> getList(String next){
		String sql="select * from report where mlhangye='"+next+"'";
		Connection connection=DBUtil.getConnection();
		Statement statement=null;
		ResultSet resultSet = null;
		List<ReportBean> reports=new ArrayList<ReportBean>();
		try{
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			ReportBean report=null;
			while(resultSet.next()){
				report=new ReportBean();
				report.setPlatformID(resultSet.getString("platformID"));
				report.setPlatformName(resultSet.getString("platformName"));
				report.setApprovalTime(resultSet.getString("approvalTime"));
				report.setApprovalNumber(resultSet.getString("approvalNumber"));
				report.setTechnicalField(resultSet.getString("technicalField"));
				report.setPlatformLevel(resultSet.getString("platformLevel"));
				report.setCityAndCountry(resultSet.getString("cityAndCountry"));
				report.setOrginationForm(resultSet.getString("orginationForm"));
				report.setGongJian(resultSet.getString("gongJian"));
				report.setJingJinJi(resultSet.getString("jingJinJi"));
				report.setMlhangye(resultSet.getString("mlhangye"));
				report.setYjhangye(resultSet.getString("yjhangye"));
				report.setEjhangye(resultSet.getString("ejhangye"));
				report.setSjhangye(resultSet.getString("sjhangye"));
				report.setYjxueke(resultSet.getString("yjxueke"));
				report.setEjxueke(resultSet.getString("ejxueke"));
				report.setSjxueke(resultSet.getString("sjxueke"));
				report.setNameOfDependentUnit(resultSet.getString("nameOfDependentUnit"));
				report.setOrganizationCode(resultSet.getString("organizationCode"));
				report.setNameOfLegalRepresentative(resultSet.getString("nameOfLegalRepresentative"));
				report.setOfficePhone(resultSet.getString("officePhone"));
				report.setTypeOfDependentUnit(resultSet.getString("typeOfDependentUnit"));
				report.setBuildUnit(resultSet.getString("buildUnit"));
				report.setDirectorName(resultSet.getString("directorName"));
				report.setDirectorSex(resultSet.getString("directorSex"));
				report.setDirectorBirth(resultSet.getString("directorBirth"));
				report.setDirectorTitle(resultSet.getString("directorTitle"));
				report.setDirectorProfession(resultSet.getString("directorProfession"));
				report.setDirectorXueLi(resultSet.getString("directorXueLi"));
				report.setDirectorXueWei(resultSet.getString("directorXueWei"));
				report.setDirectorOfficePhone(resultSet.getString("directorOfficePhone"));
				report.setDirectorPhone(resultSet.getString("directorPhone"));
				report.setDirectorEmail(resultSet.getString("directorEmail"));
				report.setNameOfPlatformWebsite(resultSet.getString("nameOfPlatformWebsite"));
				report.setUrl(resultSet.getString("url"));
				report.setPlatformAddress(resultSet.getString("platformAddress"));
				report.setZipCode(resultSet.getString("zipCode"));
				report.setStatus(resultSet.getInt("status"));
				
				reports.add(report);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		return reports;
	}
	

	public List<ReportBean> getListYJ(String next){
		String sql="select * from report where yjhangye='"+next+"'";
		Connection connection=DBUtil.getConnection();
		Statement statement=null;
		ResultSet resultSet = null;
		List<ReportBean> reports=new ArrayList<ReportBean>();
		try{
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			ReportBean report=null;
			while(resultSet.next()){
				report=new ReportBean();
				report.setPlatformID(resultSet.getString("platformID"));
				report.setPlatformName(resultSet.getString("platformName"));
				report.setApprovalTime(resultSet.getString("approvalTime"));
				report.setApprovalNumber(resultSet.getString("approvalNumber"));
				report.setTechnicalField(resultSet.getString("technicalField"));
				report.setPlatformLevel(resultSet.getString("platformLevel"));
				report.setCityAndCountry(resultSet.getString("cityAndCountry"));
				report.setOrginationForm(resultSet.getString("orginationForm"));
				report.setGongJian(resultSet.getString("gongJian"));
				report.setJingJinJi(resultSet.getString("jingJinJi"));
				report.setMlhangye(resultSet.getString("mlhangye"));
				report.setYjhangye(resultSet.getString("yjhangye"));
				report.setEjhangye(resultSet.getString("ejhangye"));
				report.setSjhangye(resultSet.getString("sjhangye"));
				report.setYjxueke(resultSet.getString("yjxueke"));
				report.setEjxueke(resultSet.getString("ejxueke"));
				report.setSjxueke(resultSet.getString("sjxueke"));
				report.setNameOfDependentUnit(resultSet.getString("nameOfDependentUnit"));
				report.setOrganizationCode(resultSet.getString("organizationCode"));
				report.setNameOfLegalRepresentative(resultSet.getString("nameOfLegalRepresentative"));
				report.setOfficePhone(resultSet.getString("officePhone"));
				report.setTypeOfDependentUnit(resultSet.getString("typeOfDependentUnit"));
				report.setBuildUnit(resultSet.getString("buildUnit"));
				report.setDirectorName(resultSet.getString("directorName"));
				report.setDirectorSex(resultSet.getString("directorSex"));
				report.setDirectorBirth(resultSet.getString("directorBirth"));
				report.setDirectorTitle(resultSet.getString("directorTitle"));
				report.setDirectorProfession(resultSet.getString("directorProfession"));
				report.setDirectorXueLi(resultSet.getString("directorXueLi"));
				report.setDirectorXueWei(resultSet.getString("directorXueWei"));
				report.setDirectorOfficePhone(resultSet.getString("directorOfficePhone"));
				report.setDirectorPhone(resultSet.getString("directorPhone"));
				report.setDirectorEmail(resultSet.getString("directorEmail"));
				report.setNameOfPlatformWebsite(resultSet.getString("nameOfPlatformWebsite"));
				report.setUrl(resultSet.getString("url"));
				report.setPlatformAddress(resultSet.getString("platformAddress"));
				report.setZipCode(resultSet.getString("zipCode"));
				report.setStatus(resultSet.getInt("status"));
				
				reports.add(report);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		return reports;
	}
	
	
	public List<ReportBean> getListEJ(String next,String parent){
		String sql="select * from report where ejhangye='"+next+"' and yjhangye='"+parent+"'";
		Connection connection=DBUtil.getConnection();
		Statement statement=null;
		ResultSet resultSet = null;
		List<ReportBean> reports=new ArrayList<ReportBean>();
		try{
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			ReportBean report=null;
			while(resultSet.next()){
				report=new ReportBean();
				report.setPlatformID(resultSet.getString("platformID"));
				report.setPlatformName(resultSet.getString("platformName"));
				report.setApprovalTime(resultSet.getString("approvalTime"));
				report.setApprovalNumber(resultSet.getString("approvalNumber"));
				report.setTechnicalField(resultSet.getString("technicalField"));
				report.setPlatformLevel(resultSet.getString("platformLevel"));
				report.setCityAndCountry(resultSet.getString("cityAndCountry"));
				report.setOrginationForm(resultSet.getString("orginationForm"));
				report.setGongJian(resultSet.getString("gongJian"));
				report.setJingJinJi(resultSet.getString("jingJinJi"));
				report.setMlhangye(resultSet.getString("mlhangye"));
				report.setYjhangye(resultSet.getString("yjhangye"));
				report.setEjhangye(resultSet.getString("ejhangye"));
				report.setSjhangye(resultSet.getString("sjhangye"));
				report.setYjxueke(resultSet.getString("yjxueke"));
				report.setEjxueke(resultSet.getString("ejxueke"));
				report.setSjxueke(resultSet.getString("sjxueke"));
				report.setNameOfDependentUnit(resultSet.getString("nameOfDependentUnit"));
				report.setOrganizationCode(resultSet.getString("organizationCode"));
				report.setNameOfLegalRepresentative(resultSet.getString("nameOfLegalRepresentative"));
				report.setOfficePhone(resultSet.getString("officePhone"));
				report.setTypeOfDependentUnit(resultSet.getString("typeOfDependentUnit"));
				report.setBuildUnit(resultSet.getString("buildUnit"));
				report.setDirectorName(resultSet.getString("directorName"));
				report.setDirectorSex(resultSet.getString("directorSex"));
				report.setDirectorBirth(resultSet.getString("directorBirth"));
				report.setDirectorTitle(resultSet.getString("directorTitle"));
				report.setDirectorProfession(resultSet.getString("directorProfession"));
				report.setDirectorXueLi(resultSet.getString("directorXueLi"));
				report.setDirectorXueWei(resultSet.getString("directorXueWei"));
				report.setDirectorOfficePhone(resultSet.getString("directorOfficePhone"));
				report.setDirectorPhone(resultSet.getString("directorPhone"));
				report.setDirectorEmail(resultSet.getString("directorEmail"));
				report.setNameOfPlatformWebsite(resultSet.getString("nameOfPlatformWebsite"));
				report.setUrl(resultSet.getString("url"));
				report.setPlatformAddress(resultSet.getString("platformAddress"));
				report.setZipCode(resultSet.getString("zipCode"));
				report.setStatus(resultSet.getInt("status"));
				
				reports.add(report);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		return reports;
	}
	
	public List<ReportBean> getListSJ(String next,String parent){
		String sql="select * from report where sjhangye='"+next+"' and ejhangye='"+parent+"'";
		Connection connection=DBUtil.getConnection();
		Statement statement=null;
		ResultSet resultSet = null;
		List<ReportBean> reportBeans=new ArrayList<ReportBean>();
		try{
			statement=connection.createStatement();
			resultSet=statement.executeQuery(sql);
			ReportBean report=null;
			while(resultSet.next()){
				report=new ReportBean();
				report.setPlatformID(resultSet.getString("platformID"));
				report.setPlatformName(resultSet.getString("platformName"));
				report.setApprovalTime(resultSet.getString("approvalTime"));
				report.setApprovalNumber(resultSet.getString("approvalNumber"));
				report.setTechnicalField(resultSet.getString("technicalField"));
				report.setPlatformLevel(resultSet.getString("platformLevel"));
				report.setCityAndCountry(resultSet.getString("cityAndCountry"));
				report.setOrginationForm(resultSet.getString("orginationForm"));
				report.setGongJian(resultSet.getString("gongJian"));
				report.setJingJinJi(resultSet.getString("jingJinJi"));
				report.setMlhangye(resultSet.getString("mlhangye"));
				report.setYjhangye(resultSet.getString("yjhangye"));
				report.setEjhangye(resultSet.getString("ejhangye"));
				report.setSjhangye(resultSet.getString("sjhangye"));
				report.setYjxueke(resultSet.getString("yjxueke"));
				report.setEjxueke(resultSet.getString("ejxueke"));
				report.setSjxueke(resultSet.getString("sjxueke"));
				report.setNameOfDependentUnit(resultSet.getString("nameOfDependentUnit"));
				report.setOrganizationCode(resultSet.getString("organizationCode"));
				report.setNameOfLegalRepresentative(resultSet.getString("nameOfLegalRepresentative"));
				report.setOfficePhone(resultSet.getString("officePhone"));
				report.setTypeOfDependentUnit(resultSet.getString("typeOfDependentUnit"));
				report.setBuildUnit(resultSet.getString("buildUnit"));
				report.setDirectorName(resultSet.getString("directorName"));
				report.setDirectorSex(resultSet.getString("directorSex"));
				report.setDirectorBirth(resultSet.getString("directorBirth"));
				report.setDirectorTitle(resultSet.getString("directorTitle"));
				report.setDirectorProfession(resultSet.getString("directorProfession"));
				report.setDirectorXueLi(resultSet.getString("directorXueLi"));
				report.setDirectorXueWei(resultSet.getString("directorXueWei"));
				report.setDirectorOfficePhone(resultSet.getString("directorOfficePhone"));
				report.setDirectorPhone(resultSet.getString("directorPhone"));
				report.setDirectorEmail(resultSet.getString("directorEmail"));
				report.setNameOfPlatformWebsite(resultSet.getString("nameOfPlatformWebsite"));
				report.setUrl(resultSet.getString("url"));
				report.setPlatformAddress(resultSet.getString("platformAddress"));
				report.setZipCode(resultSet.getString("zipCode"));
				report.setStatus(resultSet.getInt("status"));
				
				reportBeans.add(report);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(statement);
			DBUtil.close(connection);
		}
		return reportBeans;
	}
	
	//�ۺϼ���
	public  ArrayList<ReportBean> ZongHeJianSuo(String num,String sType0,String q0,String logic1,String sType1,String q1,String logic2,String sType2,String q2 ){
		ArrayList<ReportBean>  list = new ArrayList<ReportBean>();
		String sql = "select * from report";
		Connection connection=DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//ƴ�Ĳ�ѯ���
		//��Ϊֻ��һ�β�ѯ�����ʾ���Բ����ύ��������~~~~~~����ֿ�ָ��
		if(num.equals("1")){
			//ֻ��һ����ѯ����
			sql+=" where "+sType0+" like '%"+q0+"%'";
			}
		if(num.equals("2")){
			//2����ѯ����
			if(logic1.equals("AND")){
				sql+=" where "+sType0+" like '%"+q0+"%' "+logic1+" "+sType1+" like '%"+q1+"%'";
				}
			if(logic1.equals("OR")){
				sql+=" where ("+sType0+" like '%"+q0+"%' "+logic1+" "+sType1+" like '%"+q1+"%')";  
				}
			if(logic1.equals("NOT")){
				sql+=" where "+sType0+" like '%"+q0+"%' "+"and "+sType1+" not like '%"+q1+"%'";
				}
			}
		if(num.equals("3")){
			//3����ѯ����
			if(logic2.equals("AND")){
				if(logic1.equals("AND")){
					sql+=" where "+sType0+" like '%"+q0+"%' "+logic1+" "+sType1+" like '%"+q1+"%' "+logic2+" "+sType2+" like '%"+q2+"%'"; 
					}
				if(logic1.equals("OR")){
			        sql+=" where ("+sType0+" like '%"+q0+"%' "+logic1+" "+sType1+" like '%"+q1+"%' "+logic2+" "+sType2+" like '%"+q2+"%')";
			        }
				if(logic1.equals("NOT")){
			        sql+=" where "+sType0+" like '%"+q0+"%' "+"and "+sType1+" not like '%"+q1+"%'"+" and "+sType2+" not like '%"+q2+"%'";
			        }
				}
			if(logic2.equals("OR")){
				if(logic1.equals("AND")){
					sql+=" where "+sType0+" like '%"+q0+"%' "+logic1+" ("+sType1+" like '%"+q1+"%' "+logic2+" "+sType2+" like '%"+q2+"%' )";  
					}
				if(logic1.equals("OR")){
					sql+=" where ("+sType0+" like '%"+q0+"%' "+logic1+" "+sType1+" like '%"+q1+"%' "+logic2+" "+sType2+" like '%"+q2+"%')";  
					}
				if(logic1.equals("NOT")){
					sql+=" where ("+sType0+" like '%"+q0+"%' "+"and "+sType1+" not like '%"+q1+"%') "+logic2+" "+sType2+" like '%"+q2+"%'";
					}
				}
			if(logic2.equals("NOT")){
				if(logic1.equals("AND")){
					sql+=" where "+sType0+" like '%"+q0+"%' "+logic1+" "+sType1+" like '%"+q1+"%' "+" and "+sType2+" not like '%"+q2+"%'"; 
					}
				if(logic1.equals("OR")){
					sql+=" where ("+sType0+" like '%"+q0+"%' "+logic1+" "+sType1+" like '%"+q1+"%') "+" and "+sType2+" not like '%"+q2+"%'";
					}
				if(logic1.equals("NOT")){
					sql+=" where "+sType0+" like '%"+q0+"%' "+"and "+sType1+" not like '%"+q1+"%'"+" and "+sType2+" not like '%"+q2+"%'";
					}
				}
			}
		System.out.println(sql);
		//SQL������
		ReportBean report=null;
		try{
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				report= new ReportBean();
				report.setPlatformID(resultSet.getString("platformID"));
				report.setPlatformName(resultSet.getString("platformName"));
				report.setApprovalTime(resultSet.getString("approvalTime"));
				report.setApprovalNumber(resultSet.getString("approvalNumber"));
				report.setTechnicalField(resultSet.getString("technicalField"));
				report.setPlatformLevel(resultSet.getString("platformLevel"));
				report.setCityAndCountry(resultSet.getString("cityAndCountry"));
				report.setOrginationForm(resultSet.getString("orginationForm"));
				report.setGongJian(resultSet.getString("gongJian"));
				report.setJingJinJi(resultSet.getString("jingJinJi"));
				report.setMlhangye(resultSet.getString("mlhangye"));
				report.setYjhangye(resultSet.getString("yjhangye"));
				report.setEjhangye(resultSet.getString("ejhangye"));
				report.setSjhangye(resultSet.getString("sjhangye"));
				report.setYjxueke(resultSet.getString("yjxueke"));
				report.setEjxueke(resultSet.getString("ejxueke"));
				report.setSjxueke(resultSet.getString("sjxueke"));
				report.setNameOfDependentUnit(resultSet.getString("nameOfDependentUnit"));
				report.setOrganizationCode(resultSet.getString("organizationCode"));
				report.setNameOfLegalRepresentative(resultSet.getString("nameOfLegalRepresentative"));
				report.setOfficePhone(resultSet.getString("officePhone"));
				report.setTypeOfDependentUnit(resultSet.getString("typeOfDependentUnit"));
				report.setBuildUnit(resultSet.getString("buildUnit"));
				report.setDirectorName(resultSet.getString("directorName"));
				report.setDirectorSex(resultSet.getString("directorSex"));
				report.setDirectorBirth(resultSet.getString("directorBirth"));
				report.setDirectorTitle(resultSet.getString("directorTitle"));
				report.setDirectorProfession(resultSet.getString("directorProfession"));
				report.setDirectorXueLi(resultSet.getString("directorXueLi"));
				report.setDirectorXueWei(resultSet.getString("directorXueWei"));
				report.setDirectorOfficePhone(resultSet.getString("directorOfficePhone"));
				report.setDirectorPhone(resultSet.getString("directorPhone"));
				report.setDirectorEmail(resultSet.getString("directorEmail"));
				report.setNameOfPlatformWebsite(resultSet.getString("nameOfPlatformWebsite"));
				report.setUrl(resultSet.getString("url"));
				report.setPlatformAddress(resultSet.getString("platformAddress"));
				report.setZipCode(resultSet.getString("zipCode"));
				report.setStatus(resultSet.getInt("status"));
							
				list.add(report);
				}
			} catch (Exception e) {
				e.printStackTrace();
				} finally {
					DBUtil.close(resultSet);
					DBUtil.close(preparedStatement);
					DBUtil.close(connection);
					}
		return list;
		}
	
	
	/**
	 * ���б���ʽ��ʾδ��˵�������Ϣ
	 * @return
	 */
	public List<ReportBean> getListNo(){
		String sql="select * from report where status= 0";
		Connection connection=DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<ReportBean> reportBeans=new ArrayList<ReportBean>();
		try{
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			ReportBean report=null;
			while(resultSet.next()){
				report= new ReportBean();
				report.setPlatformID(resultSet.getString("platformID"));
				report.setPlatformName(resultSet.getString("platformName"));
				report.setApprovalTime(resultSet.getString("approvalTime"));
				report.setApprovalNumber(resultSet.getString("approvalNumber"));
				report.setTechnicalField(resultSet.getString("technicalField"));
				report.setPlatformLevel(resultSet.getString("platformLevel"));
				report.setCityAndCountry(resultSet.getString("cityAndCountry"));
				report.setOrginationForm(resultSet.getString("orginationForm"));
				report.setGongJian(resultSet.getString("gongJian"));
				report.setJingJinJi(resultSet.getString("jingJinJi"));
				report.setMlhangye(resultSet.getString("mlhangye"));
				report.setYjhangye(resultSet.getString("yjhangye"));
				report.setEjhangye(resultSet.getString("ejhangye"));
				report.setSjhangye(resultSet.getString("sjhangye"));
				report.setYjxueke(resultSet.getString("yjxueke"));
				report.setEjxueke(resultSet.getString("ejxueke"));
				report.setSjxueke(resultSet.getString("sjxueke"));
				report.setNameOfDependentUnit(resultSet.getString("nameOfDependentUnit"));
				report.setOrganizationCode(resultSet.getString("organizationCode"));
				report.setNameOfLegalRepresentative(resultSet.getString("nameOfLegalRepresentative"));
				report.setOfficePhone(resultSet.getString("officePhone"));
				report.setTypeOfDependentUnit(resultSet.getString("typeOfDependentUnit"));
				report.setBuildUnit(resultSet.getString("buildUnit"));
				report.setDirectorName(resultSet.getString("directorName"));
				report.setDirectorSex(resultSet.getString("directorSex"));
				report.setDirectorBirth(resultSet.getString("directorBirth"));
				report.setDirectorTitle(resultSet.getString("directorTitle"));
				report.setDirectorProfession(resultSet.getString("directorProfession"));
				report.setDirectorXueLi(resultSet.getString("directorXueLi"));
				report.setDirectorXueWei(resultSet.getString("directorXueWei"));
				report.setDirectorOfficePhone(resultSet.getString("directorOfficePhone"));
				report.setDirectorPhone(resultSet.getString("directorPhone"));
				report.setDirectorEmail(resultSet.getString("directorEmail"));
				report.setNameOfPlatformWebsite(resultSet.getString("nameOfPlatformWebsite"));
				report.setUrl(resultSet.getString("url"));
				report.setPlatformAddress(resultSet.getString("platformAddress"));
				report.setZipCode(resultSet.getString("zipCode"));
				report.setStatus(resultSet.getInt("status"));
				
				reportBeans.add(report);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return reportBeans;
	}
	
	/**
	 * ������˵�״̬
	 */
	public boolean updateStatus(String platformID,int status,String suggestion){
		String sql="update report set status='"+status+"',suggestion='"+suggestion+"' where platformID='"+platformID+"'";
		Connection connection=DBUtil.getConnection();
		Statement statement=null;
		boolean flag = false;
		int count = 0;
		try{
			statement=connection.createStatement();
			 count=statement.executeUpdate(sql);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			 DBUtil.close(connection);
			 DBUtil.close(statement);
		}
		 if (count>0) { flag = true; }
		 return flag;
	}
	
	
	public TongJiBean tongji()
	{
		Connection connection=DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		TongJiBean tongjibean=new TongJiBean();
		String sql="";
		try
		{
			sql="select count(*) as s from report where status=0";//δ���
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
			tongjibean.setWeishenhe(StringUtil.StringToInt(resultSet.getString("s")));
			}
			
			
			
			sql="select count(*) as s from report where status!=0";//�����
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
			tongjibean.setShenhe(StringUtil.StringToInt(resultSet.getString("s")));
			}
			
			
			
			sql="select count(*) as s from report where status=1";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
			tongjibean.setTongguo(StringUtil.StringToInt(resultSet.getString("s")));
			}
			
			
			
			sql="select count(*) as s from report where status=2";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			if(resultSet.next())
			{
			tongjibean.setTuihui(StringUtil.StringToInt(resultSet.getString("s")));
			}
		
			
			
			
			tongjibean.setZong();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return tongjibean;
	}
	
	
	
	//����ƽ̨��Ų���ƽ̨��Ϣ�б�
	public List<ReportBean> getByPlatformId(String PlatformID){
		String sql="select * from report where platformId=?";
		Connection connection=DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<ReportBean> reportBeans=new ArrayList<ReportBean>();
		try{
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, PlatformID);
			resultSet = preparedStatement.executeQuery();
			ReportBean report=null;
			while(resultSet.next()){
				report= new ReportBean();
				report.setPlatformID(resultSet.getString("platformID"));
				report.setPlatformName(resultSet.getString("platformName"));
				report.setApprovalTime(resultSet.getString("approvalTime"));
				report.setApprovalNumber(resultSet.getString("approvalNumber"));
				report.setTechnicalField(resultSet.getString("technicalField"));
				report.setPlatformLevel(resultSet.getString("platformLevel"));
				report.setCityAndCountry(resultSet.getString("cityAndCountry"));
				report.setOrginationForm(resultSet.getString("orginationForm"));
				report.setGongJian(resultSet.getString("gongJian"));
				report.setJingJinJi(resultSet.getString("jingJinJi"));
				report.setMlhangye(resultSet.getString("mlhangye"));
				report.setYjhangye(resultSet.getString("yjhangye"));
				report.setEjhangye(resultSet.getString("ejhangye"));
				report.setSjhangye(resultSet.getString("sjhangye"));
				report.setYjxueke(resultSet.getString("yjxueke"));
				report.setEjxueke(resultSet.getString("ejxueke"));
				report.setSjxueke(resultSet.getString("sjxueke"));
				report.setNameOfDependentUnit(resultSet.getString("nameOfDependentUnit"));
				report.setOrganizationCode(resultSet.getString("organizationCode"));
				report.setNameOfLegalRepresentative(resultSet.getString("nameOfLegalRepresentative"));
				report.setOfficePhone(resultSet.getString("officePhone"));
				report.setTypeOfDependentUnit(resultSet.getString("typeOfDependentUnit"));
				report.setBuildUnit(resultSet.getString("buildUnit"));
				report.setDirectorName(resultSet.getString("directorName"));
				report.setDirectorSex(resultSet.getString("directorSex"));
				report.setDirectorBirth(resultSet.getString("directorBirth"));
				report.setDirectorTitle(resultSet.getString("directorTitle"));
				report.setDirectorProfession(resultSet.getString("directorProfession"));
				report.setDirectorXueLi(resultSet.getString("directorXueLi"));
				report.setDirectorXueWei(resultSet.getString("directorXueWei"));
				report.setDirectorOfficePhone(resultSet.getString("directorOfficePhone"));
				report.setDirectorPhone(resultSet.getString("directorPhone"));
				report.setDirectorEmail(resultSet.getString("directorEmail"));
				report.setNameOfPlatformWebsite(resultSet.getString("nameOfPlatformWebsite"));
				report.setUrl(resultSet.getString("url"));
				report.setPlatformAddress(resultSet.getString("platformAddress"));
				report.setZipCode(resultSet.getString("zipCode"));
				report.setStatus(resultSet.getInt("status"));
				
				reportBeans.add(report);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return reportBeans;
	}

}
