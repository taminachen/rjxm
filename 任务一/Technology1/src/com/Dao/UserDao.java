package com.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Bean.UserBean;
import com.Util.DBUtil;

public class UserDao {

	//����û�
	@SuppressWarnings("resource")
	public void addUser(UserBean user) {
	//������Ӷ���
	Connection connection = DBUtil.getConnection();
	//׼��sql���
	String sql="select count(*) from user where platformId=?";
	//������䴫�����
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	try {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,user.getPlatformId());
		//���ս����
		resultSet=preparedStatement.executeQuery();
		sql = "insert into user(username,password,platformName,platformId,approvalTime,approvalNumber,technicalField,status) values (?,?,?,?,?,?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, user.getUsername());
		preparedStatement.setString(2, user.getPassword());
		preparedStatement.setString(3, user.getPlatformName());
		preparedStatement.setString(4, user.getPlatformId());
		preparedStatement.setString(5, user.getApprovalTime());
		preparedStatement.setString(6, user.getApprovalNumber());
		preparedStatement.setString(7, user.getTechnicalField());
		preparedStatement.setInt(8, user.getStatus());
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
	
	/**
	 * Ȩ�޹���
	 */
	public void up(String username,int status){
		 String sql="update user set status="+status+" where username='"+username+"'";
		 Connection connection=DBUtil.getConnection();
		 PreparedStatement preparedStatement=null;
		 try{
			 preparedStatement = connection.prepareStatement(sql);
			 preparedStatement.executeUpdate();
		 }catch(Exception e){
		 e.printStackTrace();
		 }finally{
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		 } 
		
	}
	
	/**
	 * ��ȡ�û���Ϣ�б�
	 */
	public List<UserBean> getByStatusB(){
		String sql="select * from user where status!='3'";
		Connection connection=DBUtil.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		List<UserBean> userBeans=new ArrayList<UserBean>();
		try{
			preparedStatement = connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			UserBean userBean=null;
			
			while(resultSet.next()){
				userBean=new UserBean();
				userBean.setUsername(resultSet.getString("username"));
				userBean.setPassword(resultSet.getString("password"));
				userBean.setPlatformId(resultSet.getString("platformID"));
				userBean.setPlatformName(resultSet.getString("platformName"));
				userBean.setApprovalNumber(resultSet.getString("approvalNumber"));
				userBean.setApprovalTime(resultSet.getString("approvalTime"));
				userBean.setTechnicalField(resultSet.getString("technicalField"));
				userBean.setStatus(resultSet.getInt("status"));
				
				userBeans.add(userBean);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return userBeans;
	}
	
	
	/**
	 * ��ȡ�û���Ϣ�б�
	 */
	public List<UserBean> get(){
		String sql="select * from user";
		Connection connection=DBUtil.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		List<UserBean> userBeans=new ArrayList<UserBean>();
		try{
			preparedStatement = connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			UserBean userBean=null;
			
			while(resultSet.next()){
				userBean=new UserBean();
				userBean.setUsername(resultSet.getString("username"));
				userBean.setPassword(resultSet.getString("password"));
				userBean.setPlatformId(resultSet.getString("platformID"));
				userBean.setPlatformName(resultSet.getString("platformName"));
				userBean.setApprovalNumber(resultSet.getString("approvalNumber"));
				userBean.setApprovalTime(resultSet.getString("approvalTime"));
				userBean.setTechnicalField(resultSet.getString("technicalField"));
				userBean.setStatus(resultSet.getInt("status"));
				
				userBeans.add(userBean);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return userBeans;
	}

	/**
	 * �ж��Ƿ񱻷����ɫ
	 */
	public int checkF(String username){
		String sql="select * from user where username='"+username+"'";
		int flag=0;
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()) {
				flag=resultSet.getInt("status");
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return flag;
		
	}
	
	
	/**
	 * �޸�����
	 * 
	 * @param id
	 * @return
	 */
	 public boolean update(String username,String password){ 
		 String sql="update user set password='"+password+"' where username='"+username+"'";
		 Connection connection=DBUtil.getConnection(); 
		 PreparedStatement preparedStatement=null;
		 boolean flag = false; 
		 int count = 0; 
		 try {
			 preparedStatement = connection.prepareStatement(sql);
			 count=preparedStatement.executeUpdate();
			 }catch(Exception e){
				 e.printStackTrace();
				 }finally{
					 DBUtil.close(preparedStatement);
					 DBUtil.close(connection);
					 } 
		 if (count>0) { flag = true; }
		 return flag;
		 }
	 
	//ɾ���û�
	public void deleteUser(UserBean user) {
		
	}
	
	//�޸��û�
	public void updateUser(UserBean user) {
		
	}
	
	//��ѯ�û�
	public UserBean loadUser(String username) {
		Connection connection = DBUtil.getConnection();
		//׼��sql���
		String sql = "select * from user  where username = ?";
		//������䴫�����
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		UserBean userBean=null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				userBean=new UserBean();
				userBean.setUsername(resultSet.getString("username"));
				userBean.setPassword(resultSet.getString("password"));
				userBean.setPlatformId(resultSet.getString("platformID"));
				userBean.setPlatformName(resultSet.getString("platformName"));
				userBean.setApprovalNumber(resultSet.getString("approvalNumber"));
				userBean.setApprovalTime(resultSet.getString("approvalTime"));
				userBean.setTechnicalField(resultSet.getString("technicalField"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return userBean;
		
	}
	
	/**
	 * �ж��Ƿ����
	 * 
	 * @param name
	 * @return
	 */
	public boolean checkReg(String username) {
		// ����һ��ʼ����ע�ᣬ�����ֵ��Ϊtrue
		boolean flag = true;
		// ��ѯ�û��Ƿ��Ѵ���
		Connection connection = DBUtil.getConnection();
		String sql ="select username from user";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (username.equals(resultSet.getString("username"))) {
					// admin���ݱ����Ѵ��ڴ��˺���˵��������ע�ᣬ�����ֵ��Ϊfalse
					flag = false;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return flag;
	}
	
	/**
	 * ��¼��֤
	 */
	public UserBean check(String username, String password) {
		Connection connection = DBUtil.getConnection();
		String sql ="select * from user where username=?";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		UserBean userBean = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				if (password.equals(resultSet.getString("password"))) {
					userBean=new UserBean();
					userBean.setUsername(resultSet.getString("username"));
					userBean.setPassword(resultSet.getString("password"));
					userBean.setPlatformId(resultSet.getString("platformId"));
					userBean.setPlatformName(resultSet.getString("platformName"));
					userBean.setApprovalNumber(resultSet.getString("approvalNumber"));
					userBean.setApprovalTime(resultSet.getString("approvalTime"));
					userBean.setTechnicalField(resultSet.getString("technicalField"));
					userBean.setStatus(resultSet.getInt("status"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return userBean;
	}
	
	
	/**
	 * ��ȡ�û���Ϣ�б�
	 */
	public List<UserBean> getByStatus(){
		String sql="select * from user where status!='0'";
		Connection connection = DBUtil.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		List<UserBean> userBeans=new ArrayList<UserBean>();
		try{
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			UserBean userBean=null;
			
			while(resultSet.next()){
				userBean=new UserBean();
				userBean.setUsername(resultSet.getString("username"));
				userBean.setPassword(resultSet.getString("password"));
				userBean.setPlatformId(resultSet.getString("platformId"));
				userBean.setPlatformName(resultSet.getString("platformName"));
				userBean.setApprovalNumber(resultSet.getString("approvalNumber"));
				userBean.setApprovalTime(resultSet.getString("approvalTime"));
				userBean.setTechnicalField(resultSet.getString("technicalField"));
				userBean.setStatus(resultSet.getInt("status"));
				
				userBeans.add(userBean);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
		return userBeans;
	}

	
}
