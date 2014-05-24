<!DOCTYPE html>
<html>
<body>

<script>
if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  xmlhttp=new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.open("GET","xml/search.xml",false);
xmlhttp.send();
xmlDoc=xmlhttp.responseXML; 

document.write("<center><table border='1'>");
var x=xmlDoc.getElementsByTagName("event");
for (i=0;i<x.length;i++)
  { 
  document.write("<tr><td>");
  document.write(x[i].getElementsByTagName("title")[0].childNodes[0].nodeValue);
  document.write("</td><td>");
  document.write(x[i].getElementsByTagName("venue_name")[0].childNodes[0].nodeValue);
  document.write("</td><td>");
  document.write(x[i].getElementsByTagName("venue_address")[0].childNodes[0].nodeValue);
  document.write("</td><td>");
  document.write(x[i].getElementsByTagName("city_name")[0].childNodes[0].nodeValue);
  document.write("</td></tr>");
  }
document.write("</table>");
</script>

</body>
</html>
