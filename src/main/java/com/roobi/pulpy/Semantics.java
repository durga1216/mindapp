package com.roobi.pulpy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONSerializer;
import net.sf.json.xml.XMLSerializer;
import oauth.signpost.exception.OAuthCommunicationException;
import oauth.signpost.exception.OAuthExpectationFailedException;
import oauth.signpost.exception.OAuthMessageSignerException;

import com.semantics3.api.Products;

import org.json.JSONObject;


/**
 * Servlet implementation class Semantics
 */
@WebServlet("/Semantics")
public class Semantics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Semantics() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a1=request.getParameter("a1");
		String a2=request.getParameter("a2");
		String a3=request.getParameter("p1");
		String a4=request.getParameter("p2");
		PrintWriter out=response.getWriter();
		//response.setHeader("Content-Type","text/xml; charset=UTF-8");
		try {
			Products products = new Products(
					a1,
					a2
				);
			products
			.field( "cat_id", a3 )	
			.field( "brand", a4 );
			JSONObject results;	
			results = products.get();
			String strcon=results.toString(1);
			
	            out.println(strcon);
		} catch (Exception e) {
			out.println(e);
		}
	}
}
