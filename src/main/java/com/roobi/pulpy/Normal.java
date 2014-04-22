package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Normal {
	public static void main(String args[]) throws Exception{
		URL url = new URL( "http://localhost:8080/MindPulpy/NormalServlet&t1=?" ); 
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream())); 
		String line = in.readLine(); 

		System.out.println( line );	

		in.close(); 
	}

}
