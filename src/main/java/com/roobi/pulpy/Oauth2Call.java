package com.roobi.pulpy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Oauth2Call
 */
@WebServlet("/Oauth2Call")
public class Oauth2Call extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Oauth2Call() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String clientid="602117066571932";
		String clientsecret="e3f27fea902693abd56c01c157d3220d -sec";
		String url="https://graph.facebook.com/oauth/authorize";
		String callback="https://mindapp-pulpy.rhcloud.com/Oauth2Call";
		response.sendRedirect(url+"?redirect_uri="+callback+""+clientid+""+clientsecret);
		
	}

}
