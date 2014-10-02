<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mind Pulpy</title>
<script src="js/jquery-latest.js"></script>
	 <%response.setHeader("Cache-Control", "no-cache");
    response.setHeader("Cache-Control", "no-store");
    response.setHeader("Pragma", "no-cache");
    response.setDateHeader("Expires", 0);%>

<link rel="shortcut icon" href="favicon.ico" />
<style>
body{
background-color:#FF9900;
}
.head{
    color:#FFFFFF;
    font-family:verdana;
    font-size:40px;}
    h3{
    color:#FFFFFF;
    font-family:verdana;
    }
    .con{
    color:#FFFFFF;
    font-family:verdana;
    font-size:25px;
    }
    #pa{
    color:#FFFFFF;
    font-family:verdana;
    font-size:20px;
    }
    #indiv{color:#FFFFFF;
}
a{color:#FF9900;}

#pa a{color:#FF9900;
padding:10px;
background-color:#ffffff;
border-radius:15px;
border: solid 2px #EBE6D3;
box-shadow:2px 2px 5px 1px #000000;
text-decoration:none;
}
#na{
margin-top:0;
color:#FFFFFF;
font-size:15px;
font-family:verdana;
text-align:right;}
input[type="button"]{

color:#FFFFFF;
font-size:15px;
background-color:#FF9900;
margin-left:20px;
font-family:verdana;
width:120px;
height:40px;
border:solid 2px;
border-color:#FFFFFF;
border-radius:20px;
padding:10px;
}
#dis{
margin-left:15px;
color:#FFFFFF;
font-size:20px;
font-family:verdana;
text-align:left;}
sup { vertical-align: 3.5ex; 
padding:2px;
font-size:15px;
background-color:blue;
color:#ffffff;
box-shadow:2px 2px 5px 1px #000;
border-radius:5px;}
#blanket {
   background-color:#000;
   opacity: 0.65;
   *background:none;
   position:absolute;
   z-index: 9001;
   top:0px;
   left:0px;
   width:100%;
}

#popUpDiv {
	position:absolute;
	background-color:#ff9900;
	width:400px;
	height:400px;
	border:3px solid #ff9900;
	z-index: 9002;
	border-radius:10px;
	box-shadow:3px 3px 10px 2px #000;

}

#popUpDiv { a position:relative; top:20px; left:20px}
</style>
<script type="text/javascript">
function toggle(div_id) {
	var el = document.getElementById(div_id);
	if ( el.style.display == 'none' ) {	el.style.display = 'block';}
	else {el.style.display = 'none';}
}
function blanket_size(popUpDivVar) {
	if (typeof window.innerWidth != 'undefined') {
		viewportheight = window.innerHeight;
	} else {
		viewportheight = document.documentElement.clientHeight;
	}
	if ((viewportheight > document.body.parentNode.scrollHeight) && (viewportheight > document.body.parentNode.clientHeight)) {
		blanket_height = viewportheight;
	} else {
		if (document.body.parentNode.clientHeight > document.body.parentNode.scrollHeight) {
			blanket_height = document.body.parentNode.clientHeight;
		} else {
			blanket_height = document.body.parentNode.scrollHeight;
		}
	}
	var blanket = document.getElementById('blanket');
	blanket.style.height = blanket_height + 'px';
	var popUpDiv = document.getElementById(popUpDivVar);
	popUpDiv_height=blanket_height/2-200;//200 is half popup's height
	popUpDiv.style.top = popUpDiv_height + 'px';
}
function window_pos(popUpDivVar) {
	if (typeof window.innerWidth != 'undefined') {
		viewportwidth = window.innerHeight;
	} else {
		viewportwidth = document.documentElement.clientHeight;
	}
	if ((viewportwidth > document.body.parentNode.scrollWidth) && (viewportwidth > document.body.parentNode.clientWidth)) {
		window_width = viewportwidth;
	} else {
		if (document.body.parentNode.clientWidth > document.body.parentNode.scrollWidth) {
			window_width = document.body.parentNode.clientWidth;
		} else {
			window_width = document.body.parentNode.scrollWidth;
		}
	}
	var popUpDiv = document.getElementById(popUpDivVar);
	window_width=window_width/2-200;//200 is half popup's width
	popUpDiv.style.left = window_width + 'px';
}
function popup(windowname) {
	blanket_size(windowname);
        window_pos(windowname);
	toggle('blanket');
	toggle(windowname);		
}
</script>
<script type="text/javascript">
function load(){
	window.open("http://www.youtube.com/channel/UCc0XVG8gFmFMi1jh_hj0sQA", '_blank');
	
}
function load4(){
	window.open("https://bridge-minddotss.rhcloud.com/index.jsp", '_blank');
	
}
function load5(){
	window.open("https://bridge-minddotss.rhcloud.com/title.jsp", '_blank');
	
}
function load1(){
	window.open("<%=request.getContextPath()%>/Viewapi?category=Search", '_blank');
	
}
</script>
</head>
<body>
<%String u = (String) request.getSession().getAttribute("user");
    if (u != null ) {
   // System.out.println("user != null");
   // out.print("Welcome "+u);
    }else{
   // System.out.println("user == null");
    response.sendRedirect("logout.jsp");
    }%>
<div id=na><%=session.getAttribute("mail")%> &nbsp;|&nbsp;<a id="indiv" href='ApiDoc.jsp'>API Documentation</a>&nbsp;|&nbsp;<a id='indiv' href = 'mobile_client.jsp'> API Console</a>&nbsp;|&nbsp;<a id='indiv' href='<%=request.getContextPath()%>/ApiPulpy'>API Usage</a>&nbsp;|&nbsp;<a id='indiv' href='logout.jsp'> Sign Out </a></div>

<br><br><div class="head"><center>Mind Pulpy</center></h2></div><br>
<div id="blanket" style="display:none;"></div>
	<div id="popUpDiv" style="display:none;">
	<a style='font-size:20px;color:#000;float:right;'href="" onclick="popup('popUpDiv')" >close<img style='height:20px;width:20px'alt="close" src="images/close.png"></a><br><br>
	<br><br><div class=con><center>Choose Your Plan</center></div><br><br><br>
	<center><div id=pa><a href="firstauth.jsp?q=single">Single Configuration</a></div></center><br><br><br><br><br>
	<center><div id=pa><a href="firstauth.jsp?q=mashup">Multiple/Mashup Configuration</a></div></center>
	</div>
<div class='suc'><center><h3>Login Sucess!!</h3></center></div>
<br><br><div class='con'><center>Get Started From Here</center></div><br><br>
<center><div id='pa'><a href="javascript:popup('popUpDiv')" id="link">Create New Application Here</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='<%=request.getContextPath()%>/EditPulpy' >Edit Your Application Here</a></div></center><br><br>
<center><div id='pa' style="margin-left:50px;"><a href="javascript:load5()" >Built your Own Connectors</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:load4()">Mind Pulpy Connectors</a><sup> Hot.! Try it.! </sup></div></center><br><br><br>
<center><div id='pa'><a href='prebuiltapi.jsp'> PreBuild APPs Here</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:load()">YouTube Link For Help</a></div></center><br><br>
<center><div id='pa'><a href='https://mindtools-inputs.rhcloud.com/login.jsp'>Apps Builder Here</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:load1()">API Gallery</a><sup> 500+ Api's </sup></div></center><br><br><br>

</body>

</html>