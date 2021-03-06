package com.roobi.pulpy;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xmlrpc.XmlRpcSerializer;

/**
 * Servlet implementation class XmlConvert
 */
public class XmlConvert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XmlConvert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Content-Type","text/xml; charset=UTF-8");
		HttpSession session=request.getSession(true);
		String xml=(String)session.getAttribute("xml1");
		//String res=(String)session.getAttribute("res");
	if(xml.equals("XML-RPC")){
			Object token=(Object)session.getAttribute("token");
			Writer writer=new OutputStreamWriter(response.getOutputStream());
		    XmlRpcSerializer.serialize( token, writer );
		    writer.flush();
		}
	else{
		PrintWriter out=response.getWriter();
 		out.println(xml);

	}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
