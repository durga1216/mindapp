package com.roobi.pulpy;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthConstants;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.scribe.model.OAuthConstants;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class OauthLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public OauthLoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String apilabel=request.getParameter("o1");String apikey=request.getParameter("ov1");String apiseclabel =request.getParameter("o2");String apisecvalue=request.getParameter("ov2");
	String scope_label=request.getParameter("o3");String scope_value=request.getParameter("ov3");String aurl=request.getParameter("o4");
	String tokenurl=request.getParameter("o5");String tlabel=request.getParameter("o6");String treplace=request.getParameter("o7");
	String el=request.getParameter("o8");String ev=request.getParameter("ov8");
	HttpSession session=request.getSession(true);
    session.setAttribute("cname", apilabel);
    session.setAttribute("ckey", apikey);
    session.setAttribute("csecname", apiseclabel);
    session.setAttribute("cseckey", apisecvalue);
    session.setAttribute("sname", scope_label);
    session.setAttribute("svalue", scope_value);
    session.setAttribute("aurl", aurl);
    session.setAttribute("tokenurl", tokenurl);
    session.setAttribute("tlabel", tlabel);
    session.setAttribute("treplace", treplace);
    session.setAttribute("el", el);
    session.setAttribute("ev", ev);
    if(scope_label.equals(null))
    response.sendRedirect(aurl+"?redirect_uri=https://mind-inputs.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="+apikey);
    else
    response.sendRedirect(aurl+"?redirect_uri=https://mind-inputs.rhcloud.com/OauthCallBackServlet&response_type=code&client_id="+apikey+"&"+scope_label+"="+scope_value);

	
}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
