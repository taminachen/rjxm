package com.Servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Bean.UserBean;
import com.Dao.UserDao;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
		if("login".equals(method)){
			login(request,response);
		}else if(("register").equals(method)){
			register(request,response);
		}else if("end".equals(method)){
			end(request,response);
		}else if("updatePassword".equals(method)){
			updatePassword(request,response);
		}else if("fenpeiBefore".equals(method)){
			fenpeiBefore(request,response);
		}else if("addStatus".equals(method)){
			addStatus(request,response);
		}else if("userList".equals(method)){
			userList(request,response);
		}else if("chongzhiPassword".equals(method)){
			chongzhiPassword(request,response);
		}
		
	}
	/**
	 * 登录
	 * @throws UnsupportedEncodingException 
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
			System.out.println("用户名："+username+"密码："+password);
			UserBean userBean=new UserBean();
			UserDao userDao=new UserDao();
			boolean flag=userDao.checkReg(username);
			if(flag){//登录失败，username不存在
				response.sendRedirect(request.getContextPath()+"/login.jsp?status=1");	//不存在
			}else{
				//username存在
				userBean=userDao.check(username,password);
				if(userBean!=null){//密码正确
					System.out.println("密码正确");
					if(userBean.getStatus()==0)
					{//管理员
						System.out.println("用户名："+username+"密码："+userBean.getPassword()+"身份："+userBean.getStatus());
						request.getSession().setAttribute("userBean",userBean);	
						response.sendRedirect(request.getContextPath()+"/first/index.jsp");
					}else{
						//其他用户
						System.out.println("用户名："+username+"密码："+userBean.getPassword()+"身份："+userBean.getStatus());
						request.getSession().setAttribute("userBean",userBean);
						response.sendRedirect(request.getContextPath()+"/mainInterface/index.jsp");
					}
					
				}else{//密码不正确
					System.out.println("密码错误");
					response.sendRedirect(request.getContextPath()+"/login.jsp?status=2");
				}
			}
	}
	
	
	/**
	 * 注册
	 * @throws IOException 
	 */
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String platformName=request.getParameter("platformName");
		String platformId=request.getParameter("platformId");
		String approvalTime=request.getParameter("approvalTime");
		String approvalNumber=request.getParameter("approvalNumber");
		String technicalField=request.getParameter("technicalField");
		String status=request.getParameter("status");
		
		UserBean userBean=new UserBean();
		UserDao userDao=new UserDao();
		
		userBean.setUsername(username);
		userBean.setPassword(password);
		userBean.setPlatformName(platformName);
		userBean.setPlatformId(platformId);
		userBean.setApprovalTime(approvalTime);
		userBean.setApprovalNumber(approvalNumber);
		userBean.setTechnicalField(technicalField);
		userBean.setStatus(2);
		
		boolean flag=userDao.checkReg(username);
		System.out.println(flag);
		if(flag){//不存在，注册成功
			
			userDao.addUser(userBean);
			response.sendRedirect("register.jsp?status=0");
		}else{//存在，注册失败
			response.sendRedirect("register.jsp?status=1");
		}
		
		
	}
	
	
	/**
	 * 退出登录
	 */
	private void end(HttpServletRequest request,HttpServletResponse response)throws
	ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		//用户登录之后,servlet用request.getSession()的形式保存了用户的登录信息
			//然后使用request.getSession().invalidate()来注销用户信息
		request.getSession().invalidate();
			
			//至此，用户已完全退出登录——信息都注销了，此时我们跳转回到登录页面
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
	
	/**
	 * 修改密码
	 */
	private void updatePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");//原密码
		String p1=request.getParameter("P1");
		String p2=request.getParameter("P2");
		
		if(!p1.equals(password)){
			response.sendRedirect(request.getContextPath()+"/my/myPass.jsp?status=0");
		}else{
			UserDao userDao=new UserDao();
			boolean flag=userDao.update(username,p2);

			
			if(flag){
				//修改成功
				response.sendRedirect(request.getContextPath()+"/my/myPass.jsp?status=1");
			}else{
				//修改失败
				response.sendRedirect(request.getContextPath()+"/my/myPass.jsp?status=2");
			}
			
		}
	}
	
	/**
	 * 修改密码
	 */
	private void chongzhiPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");//原密码
		UserDao userDao=new UserDao();
		boolean flag=userDao.update(username,password);
		response.sendRedirect(request.getContextPath()+"/user/userList.jsp");
	}
	
	
	/**
	 * 权限管理之前的用户列表
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void fenpeiBefore(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		UserDao userDao=new UserDao();
		List<UserBean> userBeans = userDao.getByStatus();
		
		request.setAttribute("userBeans", userBeans);
		request.getRequestDispatcher("user/fenpei.jsp").forward(request, response);
		
	}
	
	/**
	 * 赋予角色
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void addStatus(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		int status=Integer.parseInt(request.getParameter("status"));
		System.out.println("username:"+username+"    status:"+status);
		UserDao userDao=new UserDao();
		
		userDao.up(username,status);
		
		fenpeiBefore(request,response);
	
	}
	
	/**
	 * 用户管理 之用户列表
	 */
	private void userList(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		UserDao userDao=new UserDao();
		List<UserBean> userBeans = userDao.getByStatusB();
		
		request.setAttribute("userBeans", userBeans);
		request.getRequestDispatcher("user/userList.jsp").forward(request, response);
		
		
		
		
	}
	
}
