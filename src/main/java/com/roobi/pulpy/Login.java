package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 PrintWriter out=response.getWriter();
		ServletContext servletContext = request.getSession().getServletContext();
		String contextPath = servletContext.getRealPath("/");
		out.println("<br/>File system context path (in TestServlet): " + contextPath);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.setHeader("Content-Type","text/html; charset=UTF-8");
	      PrintWriter out=response.getWriter();
		String user=request.getParameter("app1");
		String pass=request.getParameter("app2");
		if(user.equals("mind")&& pass.equals("mind"))
		{
			//response.sendRedirect("firstauth.jsp");
		}
		else
		{
			out.println("<html><h1><center><font color='green'>Oops..!! Enter correct username, password..!!</font></center></h2><html>");
		   //  response.setHeader("Refresh", "1; URL=Login.jsp");
		}
		ServletContext servletContext = getServletContext();
		String contextPath = servletContext.getRealPath("/");
		out.println("<br/>File system context path (in TestServlet): " + contextPath);
	}

}
