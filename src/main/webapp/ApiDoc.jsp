<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mind Pulpy</title>
<link rel="shortcut icon" href="favicon.ico" />

</head>
<style>
body{background-color:#FF9900;}
.head{
    color:#FFFFFF;
    font-family:verdana;
    font-size:35px;}
p,h2,h3,ul{
color:#ffffff;
margin-left:350px;
margin-right:250px;
}
table{
border:1px solid white;
border-size:1px;
width:800px;
margin-left:400px;
color:#ffffff;
padding:10px;
}
a{
color:#ffffff;
font-weight:bold;
}
img{
height:70px;
width:200px;
}
#hed{
color:#ffffff;
margin-left:100px;
font-size:50px;
}
</style>
<header>
<br><div id="hed"><img src="images/log.png">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;API Documentation</div><br>
</header>
<hr>
<body>
<h2>Introduction</h2><br>
<p>You can use REST services to integrate backend cloud services that support RESTful APIs. Like any other service, REST services usually have inputs and outputs, and must be set up within Mind Pulpy</p>
<p>Creating a service consists of:</p>
<ul style="list-style-type:number">
<li>Entering the service URL.</li>
<li>Entering the AppID.</li>
<li>Defining the request parameters (the input).</li>
<li>Defining the response parameters (the output).</li></ul><br>
<h2>Quickstart</h2>
<p>If you’re new to Mind Pulpy, please try these  <a href="mobile_client.jsp">Developer console</a>..<br><br>
And If you’re new to App Development, Building Your First App here: please try these  <a href="https://mindtools-inputs.rhcloud.com/index.jsp">Code Generator</a>.</p><br>
<h2>Request</h2>
<h3>For Single Configuration</h3>
<ul style="list-style-type:number">
<li>method: POST</li>
<li>URL:    https://mindapp-pulpy.rhcloud.com/AuthXmlPulpy</li><li>AppID: Get from After Successful Configuration</li>
<li>parameters: Give parameters as p1,p2,p3... etc for what you want to search</li>
<li>Examples:<ul style="margin-left:80px;"><li>appid=MPAPP_0001</li><li>p1=chennai</li><li>p2=events</li></ul></ul>
<p>For JAVA:</p>
<table>
<tr><td>HttpPost httpPost = new HttpPost("https://mindapp-pulpy.rhcloud.com/AuthXmlPulpy");</td></tr>
<tr><td>nameValuePair.add(new BasicNameValuePair("appid","MPAPP_0001"));</td></tr>
<tr><td>nameValuePair.add(new BasicNameValuePair("p1","chennai"));</td></tr>
<tr><td>nameValuePair.add(new BasicNameValuePair("p2","events"));</td></tr>
<tr><td>httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));</td></tr>
</table>
<p>For JavaScript:</p>
<table>
<tr><td>var xhr = new XMLHttpRequest();</td></tr>
<tr><td>xhr.open('POST', 'https://mindapp-pulpy.rhcloud.com/AuthXmlPulpy', true);</td></tr>
<tr><td>data.append('appid', 'MPAPP_0001');</td></tr>
<tr><td>data.append('p1', 'chennai');</td></tr>
<tr><td>data.append('p2', 'events');</td></tr>
<tr><td>xhr.send(data);</td></tr>
</table>
<br>
<h3>For Mashup Configuration</h3>
<ul style="list-style-type:number">
<li>method: POST</li>
<li>URL:    https://mindapp-pulpy.rhcloud.com/CommonXmlPulpy</li><li>AppID: Get from After Successful Configuration</li>
<li>parameters: Give second configuration parameters as p1,p2,p3... etc for what you want to search</li>
<li>parameters: Give third configuration parameters as pa1,pa2,pa3... etc for what you want to search</li>
<li>Example:</li><ul style="margin-left:80px;"><li>appid=MPAPP_0001</li><li>p1=chennai</li><li>p2=events</li><li>pa1=bangalore</li><li>pa2=images</li></ul></ul>
<p>For JAVA:</p>
<table>
<tr><td>HttpPost httpPost = new HttpPost("https://mindapp-pulpy.rhcloud.com/CommonXmlPulpy");</td></tr>
<tr><td>nameValuePair.add(new BasicNameValuePair("appid","MPAPP_0001"));</td></tr>
<tr><td>nameValuePair.add(new BasicNameValuePair("p1","chennai"));</td></tr>
<tr><td>nameValuePair.add(new BasicNameValuePair("p2","events"));</td></tr>
<tr><td>nameValuePair.add(new BasicNameValuePair("pa1","bangalore"));</td></tr>
<tr><td>nameValuePair.add(new BasicNameValuePair("pa2","images"));</td></tr>
<tr><td>httpPost.setEntity(new UrlEncodedFormEntity(nameValuePair));</td></tr>
</table>
<br>
<h2>Response</h2>
<ul style="list-style-type:number">
<li>Format:XML</li><li>Parent Tag:MPULPY</li><li>Root tag:root</li><li>Result: Result will be in a, b, c.... tags</li><li>Example:</li>
</ul>
<p>Response XML:</p>
<table>
<tr><td>&lt;Mpulpy&gt;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&lt;root&gt;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;a&gt;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;result of a</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/a&gt;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;b&gt;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;result of b</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&lt;/b&gt;</td></tr>
<tr><td>&nbsp;&nbsp;&nbsp;&lt;/root&gt;</td></tr>
<tr><td>&lt;/Mpulpy&gt;</td></tr>
</table>

</body>
</html>