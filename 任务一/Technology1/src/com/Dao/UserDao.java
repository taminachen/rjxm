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

	//添加用户
	@SuppressWarnings("resource")
	public void addUser(UserBean user) {
	//获得连接对象
	Connection connection = DBUtil.getConnection();
	//准备sql语句
	String sql="select count(*) from user where platformId=?";
	//创建语句传输对象
	PreparedStatement preparedStatement=null;
	ResultSet resultSet=null;
	try {
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1,user.getPlatformId());
		//接收结果集
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
			//关闭资源
			DBUtil.close(resultSet);
			DBUtil.close(preparedStatement);
			DBUtil.close(connection);
		}
	}
	
	/**
	 * 权限管理
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
	 * 获取用户信息列表
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
	 * 获取用户信息列表
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
	 * 判断是否被分配角色
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
	 * 修改密码
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
	 
	//删除用户
	public void deleteUser(UserBean user) {
		
	}
	
	//修改用户
	public void updateUser(UserBean user) {
		
	}
	
	//查询用户
	public UserBean loadUser(String username) {
		Connection connection = DBUtil.getConnection();
		//准备sql语句
		String sql = "select * from user  where username = ?";
		//创建语句传输对象
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
	 * 判断是否存在
	 * 
	 * @param name
	 * @return
	 */
	public boolean checkReg(String username) {
		// 假设一开始允许注册，将标记值记为true
		boolean flag = true;
		// 查询用户是否已存在
		Connection connection = DBUtil.getConnection();
		String sql ="select username from user";
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				if (username.equals(resultSet.getString("username"))) {
					// admin数据表中已存在此账号则说明不允许注册，将标记值记为false
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
	 * 登录验证
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
	 * 获取用户信息列表
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
