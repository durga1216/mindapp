<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="js/jquery-latest.js"></script>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Mind Pulpy</title>
    <link rel="shortcut icon" href="favicon.ico"/>
    <%
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
    %>
    <%--<script src="js/getkey.js"></script>--%>

    <%
        String u = (String) request.getSession().getAttribute("user");
        String respo = (String) request.getSession().getAttribute("xml1");
        respo = respo.replaceAll("\"", "'");
        String q = (String) session.getAttribute("q");
        if (u != null) {
            // System.out.println("user != null");
            // out.print("Welcome "+u);
        } else {
            // System.out.println("user == null");
            response.sendRedirect("logout.jsp");
        }
    %>
    <script>
        var num = 0;
        function addParam() {
            //console.log("inside");
            num = num + 1;
            var contentID = document.getElementById('content');
            var newTBDiv = document.createElement('div');
            newTBDiv.setAttribute('id', 'strText' + num);
            //var root = "event";
            //var root = $('#parnode').val();
            var root=document.getElementById('parnode').value;
            //console.log("fsdfasdf"+root);
            if(root==''){
                alert("Please Enter the Parent node");
            }
            var data = "<%=respo%>";//'<xx><name><fn>susee</fn><ln>susi</ln></name></xx>';//$('#cmt').val();
            var dvdata = "<input type='text' placeholder='Label(Give any name)' name='x" + num + "'><select name='xv" + num + "'><option value='dummy'>Select the node</option>";
            $(data).find(root).first().find("*").each(function () {
                var v = $(this).prop("tagName");
                var parents = $(this).parents();
                var p = [];
                p.push(v);
                var splice = 0;
                $(parents).each(function (i) {
                    if ($(this).prop("tagName") == root.toUpperCase())
                        splice = i;
                    p.push($(this).prop("tagName"));
                });
                p.splice(splice + 1);
                p.reverse();
                if ($(this).children().first().prop("nodeType") != 1)
                    log(p.join("/"));
            });
            dvdata = dvdata + "</select><br><br>";
            function log(v) {
                dvdata = dvdata + "<option value='" + v + "'>" + v + "</option>";
            }

            newTBDiv.innerHTML = dvdata;
            contentID.appendChild(newTBDiv);
        }
        function removeParam() {
            var contentID = document.getElementById('content');
            contentID.removeChild(document.getElementById('strText' + num));
            num = num - 1;
        }
    </script>
    <style>
        body {
            background-color: #FF9900;
        }

        .head {
            color: #FFFFFF;
            font-family: verdana;
            font-size: 40px;
            margin-top: 50px;
        }

        #pa {
            font-family: verdana;
            font-size: 20px;
            color: #FFFFFF;
            margin-left: 100px;

        }

        input[type="text"] {
            color: #FF9900;
            font-size: 17px;
            background-color: #FFFFFF;
            margin-left: 70px;
            font-family: verdana;
            width: 250px;
            padding: 3px;
            border-radius: 3px;
        }

        select {
            color: #FF9900;
            font-size: 17px;
            background-color: #FFFFFF;
            margin-left: 70px;
            font-family: verdana;
            width: 250px;
            padding: 3px;
            border-radius: 3px;
        }

        input[type="submit"] {
            color: #FFFFFF;
            font-size: 20px;
            background-color: #FF9900;
            font-family: verdana;
            width: 140px;
            height: 50px;
            border: solid 2px;
            border-color: #FFFFFF;
            border-radius: 50px;
            padding: 10px;
        }

        .heading {
            font-family: verdana;
            font-size: 20px;
            font-weight: bold;
            color: #FF9900;
            width: 25%;
            height: 30%;
            background-color: #FFFFFF;
            border: solid 2px;
            border-color: #FF9900;
            border-radius: 25px;
            padding: 15px;
        }

        #indiv {
            color: #FFFFFF;
        }

        #na {
            margin-top: 0;
            color: #FFFFFF;
            font-size: 15px;
            font-family: verdana;
            text-align: right;
        }

        #eg {
            float: left;
            margin-left: 20px;
            width: 40%;
        }

        #eg1 {
            font-size: 15px;
            width: 55%;
            color: #ffffff;
            float: left;
        }

        table {
            border: none;
        }

        td {
            color: #ffffff;
            font-size: 15px;
        }

        #hlt {
            color: #ffffff;
            font-size: 15px;
            box-shadow: 2px 2px 5px 1px black;
            border-radius: 3px;
        }

        #fff {
            width: 1300px;
            height: relative;
        }

        #see {
            text-decoration: none;
        }
    </style>

</head>
<body>
<div id=na><%=session.getAttribute("mail")%> &nbsp;|<a id="indiv" href='ApiDoc.jsp'>API Documentation</a>&nbsp;|&nbsp;&nbsp;<a
        id='indiv' href='mobile_client.jsp'> API Console </a>&nbsp;|&nbsp;<a id='indiv'
                                                                             href='<%=request.getContextPath()%>/ApiPulpy'>API
    Usage</a>&nbsp;|&nbsp;<a id='indiv' href='logout.jsp'> Sign Out </a></div>
<div class="head">
    <center>Mind Pulpy</center>
    </h2></div>
<br>

<form action="AuthPulpy1" method="post" onsubmit="return validateForm()">
    <center>
        <div class="heading">M-Pulpy XML Structure</div>
    </center>
    <br>
    <center><h2><a id='pa' href="javascript:load()">Click here to Load_Xml</a></h2></center>
    <br><br>

    <div id='fff'>
        <div id=eg>
            <table>
                <tr>
                    <td>Eg:</td>
                    <td id=hlt>parant tag</td>
                    <td></td>
                    <td id=hlt>&nbsp;&nbsp;details/name/@id</td>
                </tr>
                <tr>
                    <td>&lt root &gt</td>
                    <td>&lt event &gt</td>
                    <td>&lt details &gt</td>
                    <td>&lt name id=123 ref=nms &gt</td>
                    <td>&lt /name &gt</td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>&lt city &gt chennai &lt /city &gt</td>
                    <td id=hlt>details/city</td>
                    <td></td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td>&lt /details &gt</td>
                    <td>&lt /event &gt</td>
                </tr>
                <tr>
                    <td></td>
                    <td></td>
                    <td>&nbsp;&nbsp;&lt Date &gt</td>
                    <td>12-12&lt /Date &gt</td>
                    <td id=hlt>&nbsp;&nbsp;&nbsp;&nbsp;Date</td>
                </tr>
                <tr>
                    <td></td>
                    <td>&lt event &gt....</td>
                    <td>&lt /event &gt</td>
                    <td></td>
                </tr>
                <tr>
                    <td></td>
                    <td>&lt event &gt....</td>
                    <td>&lt /event &gt</td>
                    <td></td>
                </tr>
                <tr>
                    <td>&lt /root &gt</td>
                </tr>
                <tr>
                    <td><a id=see href='javascript:load1()'>See More..</a></td>
                    <td><a id=see href="javascript:load2()">Dev</a></td>
                </tr>
            </table>
        </div>
        <div id=eg1><input type="text" name="xr" id="parnode" value="" placeholder="Parent_Tag(Refer Eg)"><br>
            <br><br>
            <center><a id='pa' href="javascript:addParam()">Add_XML_Tags</a>
                <a id='pa' href="javascript:removeParam()">Remove_XML_Tags</a></center>
            <br>
            <br>
            <center>
                <div id="content"></div>
            </center>
            <br><br><br><br></div>
    </div>
    <div id=fff>
        <center><% if (q.equals("mashup")) { %><input type="submit" value="Continue" name="submit">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%} %><input
                type="submit" value="Finish" name="submit"></center>
    </div>
</form>

<script type="text/javascript">
    function load() {
        window.open("<%=request.getContextPath()%>/XmlConvert", "tese", "toolbar=no, menubar=no,location=no, directories=no, status=no, scrollbars=yes, resizable=yes, top=500, left=500, width=400, height=400");
    }
    function load2() {
        window.open("<%=request.getContextPath()%>/Fgtpass", "tese", "toolbar=no, menubar=no,location=no, directories=no, status=no, scrollbars=yes, resizable=yes, top=500, left=500, width=400, height=400");
    }
    function load1() {
        window.open("images/exml.JPG", '_blank');
    }
    function validateForm() {
        var x = confirm("Confirm submit?");
        if (x == true) {
            return true;
        }
        else {
            return false;
        }
    }
</script>
</body>
</html>