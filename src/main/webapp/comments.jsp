<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>MindPulpy</title>
<link rel="shortcut icon" href="favicon.ico" />
<style type="text/css">
 body{background-color:#FF9900;}
input[type="button"]{

color:#FFFFFF;
font-size:15px;
background-color:#FF9900;
font-family:verdana;
margin-left:1150px;
width:150px;
height:50px;
border:solid 2px;
border-color:#FFFFFF;
border-radius:20px;
padding:10px;
}
</style>
</head>
 <script type="text/javascript">
function add()
{
	window.location="index.jsp";
	}
</script>
<body>
  <div id="disqus_thread"></div>
    <script type="text/javascript">
        /* * * CONFIGURATION VARIABLES: EDIT BEFORE PASTING INTO YOUR WEBPAGE * * */
        var disqus_shortname = 'mindpulpy'; // required: replace example with your forum shortname

        /* * * DON'T EDIT BELOW THIS LINE * * */
        (function() {
            var dsq = document.createElement('script'); dsq.type = 'text/javascript'; dsq.async = true;
            dsq.src = '//' + disqus_shortname + '.disqus.com/embed.js';
            (document.getElementsByTagName('head')[0] || document.getElementsByTagName('body')[0]).appendChild(dsq);
        })();
    </script>
    <noscript><a href="http://disqus.com/?ref_noscript"></a></noscript>
    <a href="http://disqus.com" class="dsq-brlink">c<span class="logo-disqus"></span></a><br><br><br><br><br>
    
    
   <input type="button" name="b2" value="back" Onclick="add()">
   
</body>
</html>