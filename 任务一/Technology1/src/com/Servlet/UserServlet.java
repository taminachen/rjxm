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
	 * ��¼
	 * @throws UnsupportedEncodingException 
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
			System.out.println("�û�����"+username+"���룺"+password);
			UserBean userBean=new UserBean();
			UserDao userDao=new UserDao();
			boolean flag=userDao.checkReg(username);
			if(flag){//��¼ʧ�ܣ�username������
				response.sendRedirect(request.getContextPath()+"/login.jsp?status=1");	//������
			}else{
				//username����
				userBean=userDao.check(username,password);
				if(userBean!=null){//������ȷ
					System.out.println("������ȷ");
					if(userBean.getStatus()==0)
					{//����Ա
						System.out.println("�û�����"+username+"���룺"+userBean.getPassword()+"��ݣ�"+userBean.getStatus());
						request.getSession().setAttribute("userBean",userBean);	
						response.sendRedirect(request.getContextPath()+"/first/index.jsp");
					}else{
						//�����û�
						System.out.println("�û�����"+username+"���룺"+userBean.getPassword()+"��ݣ�"+userBean.getStatus());
						request.getSession().setAttribute("userBean",userBean);
						response.sendRedirect(request.getContextPath()+"/mainInterface/index.jsp");
					}
					
				}else{//���벻��ȷ
					System.out.println("�������");
					response.sendRedirect(request.getContextPath()+"/login.jsp?status=2");
				}
			}
	}
	
	
	/**
	 * ע��
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
		if(flag){//�����ڣ�ע��ɹ�
			
			userDao.addUser(userBean);
			response.sendRedirect("register.jsp?status=0");
		}else{//���ڣ�ע��ʧ��
			response.sendRedirect("register.jsp?status=1");
		}
		
		
	}
	
	
	/**
	 * �˳���¼
	 */
	private void end(HttpServletRequest request,HttpServletResponse response)throws
	ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		//�û���¼֮��,servlet��request.getSession()����ʽ�������û��ĵ�¼��Ϣ
			//Ȼ��ʹ��request.getSession().invalidate()��ע���û���Ϣ
		request.getSession().invalidate();
			
			//���ˣ��û�����ȫ�˳���¼������Ϣ��ע���ˣ���ʱ������ת�ص���¼ҳ��
		response.sendRedirect(request.getContextPath()+"/login.jsp");
		}
	
	/**
	 * �޸�����
	 */
	private void updatePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");//ԭ����
		String p1=request.getParameter("P1");
		String p2=request.getParameter("P2");
		
		if(!p1.equals(password)){
			response.sendRedirect(request.getContextPath()+"/my/myPass.jsp?status=0");
		}else{
			UserDao userDao=new UserDao();
			boolean flag=userDao.update(username,p2);

			
			if(flag){
				//�޸ĳɹ�
				response.sendRedirect(request.getContextPath()+"/my/myPass.jsp?status=1");
			}else{
				//�޸�ʧ��
				response.sendRedirect(request.getContextPath()+"/my/myPass.jsp?status=2");
			}
			
		}
	}
	
	/**
	 * �޸�����
	 */
	private void chongzhiPassword(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		request.setCharacterEncoding("utf-8");
		String username=request.getParameter("username");
		String password=request.getParameter("password");//ԭ����
		UserDao userDao=new UserDao();
		boolean flag=userDao.update(username,password);
		response.sendRedirect(request.getContextPath()+"/user/userList.jsp");
	}
	
	
	/**
	 * Ȩ�޹���֮ǰ���û��б�
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
	 * �����ɫ
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
	 * �û����� ֮�û��б�
	 */
	private void userList(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("utf-8");
		UserDao userDao=new UserDao();
		List<UserBean> userBeans = userDao.getByStatusB();
		
		request.setAttribute("userBeans", userBeans);
		request.getRequestDispatcher("user/userList.jsp").forward(request, response);
		
		
		
		
	}
	
}
