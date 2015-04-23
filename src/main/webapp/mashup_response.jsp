<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Oauth Mashup</title>
  <script src="js/jquery-latest.js"></script>
  <%String appid = (String) request.getSession().getAttribute("appid");
%>
  <script type="text/javascript">
    var appid='<%=appid%>';
    $(document).ready(function(){
        $.ajax({
          type: "GET",
          url: "/OauthmashupPulpy",
          data: {
            appid: appid
          },
          success: function result(data) {
            console.log(data);
            $('#result').append(data);
          },
          error: function (xhr, ajaxOptions, thrownError) {
            alert("errorstatus: " + xhr.status + " ajaxoptions: " + ajaxOptions + " throwError: " + thrownError);
          }
        });
    });
  </script>
</head>
<body>
<br>
<br>
<center>
  <br><h3> Configured Successful..!<br><br>Appid : <%=appid%> ; Please Save your Appid for future use..<br><br>
  Your Mashup response<br></h3>
  <textarea id="result" rows="20" cols="100" name="result"></textarea></center>
</div>
</body>
</html>
