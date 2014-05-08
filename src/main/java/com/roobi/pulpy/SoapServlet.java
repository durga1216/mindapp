package com.roobi.pulpy;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SoapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SoapServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		PrintWriter out1=response.getWriter();
//String SOAPUrl="http://www.ezzylearning.com/services/CountryInformationService.asmx/GetCountries";
	//String SOAPUrl = "http://www.webservicex.net/LondonGoldFix.asmx/GetLondonGoldAndSilverFix";
		String SOAPUrl="http://www.webservicex.net/globalweather.asmx/GetCitiesByCountry";
		String SOAPAction = "";
		URL url = new URL(SOAPUrl);
		URLConnection connection = url.openConnection();
		HttpURLConnection httpConn = (HttpURLConnection) connection;
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
	//	String request1="<?xml version='1.0' encoding='utf-8'?><soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'><soap:Body><GetLondonGoldAndSilverFix xmlns='http://www.webservicex.net' /></soap:Body></soap:Envelope>";
	
		//String request1 = "<?xml version=\'1.0\' encoding=\'UTF-8\'?><soapenv:Envelope xmlns:soapenv=\'http://schemas.xmlsoap.org/soap/envelope/\' xmlns:xsd=\'http://www.w3.org/2001/XMLSchema\' xmlns:xsi=\'http://www.w3.org/2001/XMLSchema-instance\'> <soapenv:Body>  <getAvailability xmlns=\'http://avail.flight.arzoo.com\'>  <Request xmlns=\'\'>Origin&gt;BOM&lt;/Origin&gt;&lt;Destination&gt;BLR&lt;/Destination&gt;&lt;DepartDate&gt;2014-03-15&lt;/DepartDate&gt;&lt;ReturnDate&gt;2014-03-20&lt;/ReturnDate&gt;&lt;AdultPax&gt;1&lt;/AdultPax&gt;&lt;ChildPax&gt;0&lt;/ChildPax&gt;&lt;InfantPax&gt;0&lt;/InfantPax&gt;&lt;Currency&gt;INR&lt;/Currency&gt;&lt;Clientid&gt;77743613&lt;/Clientid&gt;&lt;Clientpassword&gt;*8DC945BE945EF739F56B6A5B5C5A48440B006F7A&lt;/Clientpassword&gt;&lt;Clienttype&gt;ArzooFWS1.1&lt;/Clienttype&gt;&lt;Preferredclass&gt;E&lt;/Preferredclass&gt;&lt;mode&gt;ONE&lt;/mode&gt;&lt;PreferredAirline&gt;AI,G8,IC,6E,9W,S2,IT,9H,I7,SG&lt;/PreferredAirline&gt;    </Request>  </getAvailability></soapenv:Body></soapenv:Envelope>";
	    String request1="<?xml version='1.0' encoding='utf-8'?><soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'><soap:Body><GetCitiesByCountry xmlns='http://www.webserviceX.NET'><CountryName>india</CountryName></GetCitiesByCountry></soap:Body></soap:Envelope>";
	//	String request1="<?xml version='1.0' encoding='utf-8'?><soap:Envelope xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'><soap:Body><GetCountries xmlns='http://www.ezzylearning.com/services/CountryInformationService.asmx' /></soap:Body></soap:Envelope>";
		copy(request1, bout);
		
		byte[] b = bout.toByteArray();
		
		httpConn.setRequestProperty("Content-Length", String.valueOf(b.length));
		httpConn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
		httpConn.setRequestProperty("SOAPAction", SOAPAction);
		
		httpConn.setRequestMethod("POST");
		httpConn.setDoOutput(true);
		httpConn.setDoInput(true);
		OutputStream out = httpConn.getOutputStream();
		out.write(b);
		out.close();
		
		InputStreamReader isr = new InputStreamReader(httpConn.getInputStream());
		BufferedReader in = new BufferedReader(isr);

		String inputLine;
		String str=null;
		StringBuffer strbfr = new StringBuffer();
		while ((inputLine = in.readLine()) != null) {
			strbfr.append(inputLine);
			 str=strbfr.toString();

		}
		
		
		out1.println( str);

	}
	public static void copy(String a_inputstr, OutputStream out) throws IOException {
		// do not allow other threads to read from the
		// input or write to the output while copying is
		// taking place
		synchronized (out) {
			byte[] buffer = a_inputstr.getBytes();
			int bytesRead = buffer.length;//      in.read(buffer);
			out.write(buffer, 0, bytesRead);
		}
	}
}
