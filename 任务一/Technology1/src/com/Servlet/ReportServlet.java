package com.Servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.Dao.ReportDao;
import com.Bean.ReportBean;
import com.Bean.TongJiBean;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/ReportServlet")
public class ReportServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReportServlet() {
		super();
		// TODO Auto-generated constructor stub
	}
  
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String method = request.getParameter("method");
		if("preType".equals(method)){
			preType(request,response);
		}else if("getNextYJ".equals(method)){
			getNextYJ(request,response);
		}else if("getNextEJ".equals(method)){
			getNextEJ(request,response);
		}else if("getNextSJ".equals(method)){
			getNextSJ(request,response);
		}else if("getList".equals(method)){
			getList(request,response);
		}else if("getListYJ".equals(method)){
			getListYJ(request,response);
		}else if("getListEJ".equals(method)){
			getListEJ(request,response);
		}else if("getListSJ".equals(method)){
			getListSJ(request,response);
		}else if ("reportDetails".equals(method)) {
			reportDetails(request, response);
		}else if("ZongHeChaXun".equals(method)){
			ZongHeChaXun(request,response);
		}else if("myList".equals(method)){
			System.out.println("nsnjcsjd");
			myList(request,response);//�ҵ������ʾ�
		}else if ("reportList".equals(method)) {
			reportList(request, response);
		}else if ("selectReportList".equals(method)) {
			selectReportList(request, response);
		}else if("check".equals(method)){
			check(request,response);//������˵�״̬
		}else if("tongji".equals(method)){
			tongji(request,response);
		}
}
	/**
	 * ��������������ݿ��ж������Ƽ�����͵ļ���
	 */
	private void preType(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("ת��preType������");
		ReportDao reportDao = new ReportDao();
		List<String> menleihangyes = reportDao.getMenLei();
		
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(menleihangyes));
		out.flush();
		out.close();
		
	}
	
	/**
	 * �ڶ��������񾭼���ҵ����ĵ�һ�������ʾ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getNextYJ(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//@RequestMapping(value="/abc",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8"});
		System.out.println("ת��getNext������");
		ReportDao reportDao = new ReportDao();
		String type=request.getParameter("id");
		
		System.out.println("����Ϊ:"+type);
		System.out.println("getNextYJ");
		List<String> NEXTs=new ArrayList<String>();
		NEXTs = reportDao.getYijihangye(type);//��һ��
		System.out.println(NEXTs.get(0));
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(NEXTs));
		out.flush();
		out.close();
	}
	
	/**
	 * �����������񾭼���ҵ����ĵڶ��������ʾ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getNextEJ(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("getNextEJ");
		//@RequestMapping(value="/abc",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8"});
		//System.out.println("ת��getNext������");
		ReportDao reportDao = new ReportDao();
		String type=request.getParameter("id");
		
		System.out.println("����Ϊ:"+type);
		List<String> NEXTs=new ArrayList<String>();
		
			NEXTs = reportDao.getErjihangye(type);//�ڶ���
			
		//System.out.println(NEXTs.toString());
		
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(NEXTs));
		out.flush();
		out.close();
	}
	
	/**
	 * ���ļ������񾭼���ҵ����ĵ����������ʾ
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void getNextSJ(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		System.out.println("getNextSJ");
		//@RequestMapping(value="/abc",method=RequestMethod.POST,produces = {"application/json;charset=UTF-8"});
		//System.out.println("ת��getNext������");
		ReportDao reportDao = new ReportDao();
		String type=request.getParameter("id");
		
		System.out.println("����Ϊ:"+type);
		List<String> NEXTs=new ArrayList<String>();
		
			NEXTs = reportDao.getSanjihangye(type);//������
			
		//System.out.println(NEXTs.toString());
		
		PrintWriter out = response.getWriter();
		out.print(JSON.toJSONString(NEXTs));
		out.flush();
		out.close();
	}
	
	
	/**�����ѯ
	 * ���б�鿴������Ϣ
	 */
	private void getList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String NEXT=request.getParameter("id");
		System.out.println("�õ�����������ҵ��Ϣ"+NEXT);
		System.out.println("getList");
		ReportDao reportDao = new ReportDao();
		
		
		List<ReportBean> reportBeans = reportDao.getList(NEXT);

			
		request.setAttribute("reportBeans", reportBeans);
		request.getRequestDispatcher("type/reportList.jsp").forward(request, response);
	}
	
	
	/**
	 * ���񾭼���ҵ����
	 *
	 */
	//�õ�һ����ҵ���������ƽ̨��Ϣ
	private void getListYJ(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("getListYJ");
		String NEXT=request.getParameter("id");
		System.out.println("�õ�����һ����ҵ��Ϣ"+NEXT);
		ReportDao reportDao = new ReportDao();
		
		
		List<ReportBean> reportBeans = reportDao.getListYJ(NEXT);

			
		request.setAttribute("reportBeans", reportBeans);
		request.getRequestDispatcher("type/reportList.jsp").forward(request, response);
	}
	
	//�õ�����ָ����������ƽ̨��Ϣ
	private void getListEJ(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String NEXT=request.getParameter("id");
		System.out.println("getNextEJ");
		String parent=request.getParameter("parentId");
		
		System.out.println("�õ����ж�����ҵ��Ϣ"+NEXT);
		ReportDao reportDao = new ReportDao();
		
		
		List<ReportBean> reportBeans = reportDao.getListEJ(NEXT,parent);

			
		request.setAttribute("reportBeans", reportBeans);
		request.getRequestDispatcher("type/reportList.jsp").forward(request, response);
	}
	
	//�õ�����ָ����������ƽ̨��Ϣ
	private void getListSJ(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String NEXT=request.getParameter("id");
		System.out.println("getNextSJ");
		String parent=request.getParameter("parentId");
		
		System.out.println("�õ�����������ҵ��Ϣ"+NEXT);
		ReportDao reportDao = new ReportDao();
		
		List<ReportBean> reportBeans = reportDao.getListSJ(NEXT,parent);
	
		request.setAttribute("reportBeans", reportBeans);
		request.getRequestDispatcher("type/reportList.jsp").forward(request, response);
	}
	
	
	/**
	 * ������Ϣ
	 */
	private void reportDetails(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String platformID = request.getParameter("platformID");

		ReportBean reportBean = new ReportBean();
		ReportDao reportDao = new ReportDao();

		reportBean = reportDao.loadReport(platformID);
		request.setAttribute("reportBean", reportBean);
		
		request.getRequestDispatcher("check/reportDetails.jsp").forward(request, response);
	}
	
	
	/*
	 * �ۺϼ���
	 * 
	 */
	private void ZongHeChaXun(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String num = request.getParameter("num");// ��ѯ���ݵĸ���

		// "logic" + strId; ����
		// "sType" + strId; ����
		// "q" + strId; �����

		// ����
		String q0 = null;
		String q1 = null;
		String q2 = null;
		String logic1 = null;
		String logic2 = null;
		String sType0 = null;
		String sType1 = null;
		String sType2 = null;
		if (request.getParameter("q0") != null) {
			q0 = request.getParameter("q0");
			sType0 = request.getParameter("sType0");
		}
		if (request.getParameter("q1") != null) {
			q1 = request.getParameter("q1");
			logic1 = request.getParameter("logic1");
			sType1 = request.getParameter("sType1");
		}
		if (request.getParameter("q2") != null) {
			q2 = request.getParameter("q2");
			logic2 = request.getParameter("logic2");
			sType2 = request.getParameter("sType2");
		}

		ReportDao reportDao = new ReportDao();
		
		List<ReportBean> chaxun = reportDao.ZongHeJianSuo(num, sType0, q0, logic1, sType1, q1, logic2, sType2, q2);
		
		request.getSession().setAttribute("chaxun", chaxun);
		if (chaxun.size() != 0) {
				request.getRequestDispatcher("/load/Type.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/load/Type.jsp?status=1");
		}

	}
	
	
	/**
	 * ���б�鿴�û��Լ������������Ϣ
	 */
	private void myList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String platformID=request.getParameter("platformId");
		System.out.println("ת���ҵ��������Servlet��");
		ReportDao reportDao = new ReportDao();
		List<ReportBean> reportBeans = reportDao.getByPlatformId(platformID);
		request.setAttribute("reportBeans", reportBeans);
		request.getRequestDispatcher("my/myList.jsp").forward(request, response);
	}
	 
	/**
	 * ���б�鿴������Ϣ���������
	 */
	private void reportList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ReportDao reportDao = new ReportDao();
		List<ReportBean> reportBeans = reportDao.getListNo();

		request.setAttribute("reportBeans", reportBeans);
		request.getRequestDispatcher("check/reportList.jsp").forward(request, response);
	}
	
	/**
	 * ��������������
	 */
	private void selectReportList(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String platformID = request.getParameter("platformID");

		ReportDao reportDao = new ReportDao();
		List<ReportBean> reportBeans = reportDao.getByPlatformId(platformID);
		
		if (reportBeans != null) {
			request.setAttribute("reportBeans", reportBeans);
			request.getRequestDispatcher("check/reportList.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("check/reportList.jsp?status=1").forward(request, response);
		}
	}
	
	/**
	 * ������˵�״̬
	 */
	private void check(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
	
		String platformID = request.getParameter("platformID");
		int status=Integer.parseInt(request.getParameter("status"));
		ReportDao reportDao = new ReportDao();
		if(status==1){
			reportDao.updateStatus(platformID,status,"��");
		}else{
			String suggestion=request.getParameter("suggestion");
			reportDao.updateStatus(platformID,status,suggestion);
		}//�ɹ�
		
		
		request.getRequestDispatcher("check/reportDetails.jsp?status=1").forward(request, response);//��˳ɹ�
		

	}

	
	/**
	 * ͼ��ͳ��
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
		protected void tongji(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
		{
			request.setCharacterEncoding("utf-8");
			ReportDao reportDao=new ReportDao();
			TongJiBean tongjibean=reportDao.tongji();
			tongjibean.setWeishenhe1(tongjibean.jiussuan(tongjibean.getWeishenhe(), tongjibean.getZong()));
			tongjibean.setShenhe1(tongjibean.jiussuan(tongjibean.getShenhe(), tongjibean.getZong()));
			tongjibean.setTongguo1(tongjibean.jiussuan(tongjibean.getTongguo(), tongjibean.getZong()));
			tongjibean.setTuihui1(tongjibean.jiussuan(tongjibean.getTuihui(), tongjibean.getZong()));
			
			request.setAttribute("tongjibean", tongjibean);
			request.getRequestDispatcher("jquery-css3-vote-bar-150326231418/tongji.jsp").forward(request, response);
		}
		
		
		
}
