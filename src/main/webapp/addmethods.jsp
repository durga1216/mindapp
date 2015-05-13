<%--
  Created by IntelliJ IDEA.
  User: susee
  Date: 21/4/15
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oauth MashUP</title>
    <script>
        var intTextBox = 0;
        function addmethod() {
            intTextBox = intTextBox + 1;
            var contentID = document.getElementById('content');
            var newTBDiv = document.createElement('div');
            newTBDiv.setAttribute('id', 'strText' + intTextBox);
            newTBDiv.innerHTML = "<table frame='box' style='padding: 10px;background:#ff7700 ;border-radius: 5px;border-color: #ffffdd'><tr><td><div class='head3'>Method #" + intTextBox + "</div></td></tr><tr><td><select name='masmeth" + intTextBox + "'><option value='GET'>GET</option><option value='POST'>POST</option><option value='PUT'>PUT</option><option value='DELETE'>DELETE</option></select></td><td><input type='text' name='masurl" + intTextBox + "' placeholder='Method Url'><br></td></tr><tr><td class='span1'><br><div class='head3'>Add your parameters</div></td><td><br><textarea placeholder='Eg : filter=name&sortby=company' rows='6' cols='50' name='mastext" + intTextBox + "'></textarea></td></tr></table><br>";
            contentID.appendChild(newTBDiv);
        }

        function removemethod() {
            var contentID = document.getElementById('content');
            contentID.removeChild(document.getElementById('strText' + intTextBox));
            intTextBox = intTextBox - 1;
        }
        var headnum = 0;
        function addParent() {
            headnum = headnum + 1;
            var contentID = document.getElementById('headcontent');
            var newTBDiv = document.createElement('div');
            newTBDiv.setAttribute('id', 'strhead' + headnum);
            newTBDiv.innerHTML = "<input style='width:300px;' type='text' id='h" + headnum + "'    name='h" + headnum + "' placeholder='Header_Label'/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input style='width:300px;' type='text' id='hv" + headnum + " ' name='hv" + headnum + "' placeholder='Header_Value'/><br><br>";
            contentID.appendChild(newTBDiv);
        }
        function removeParent() {
            var contentID = document.getElementById('headcontent');
            contentID.removeChild(document.getElementById('strhead' + headnum));
            headnum = headnum - 1;
        }
    </script>
    <style>
        body {
            background: #FF9900
        }

        h2 {
            text-align: center;
            color: #FFFFFF;
        }

        input[type="file"] {
            color: #FFFFFF;
            font-size: 16px;
        }

        input[type="text"] {
            width: 500px;
            height: 30px;
            font-family: verdana;
            font-size: 18px;
            background: #ffffff;
            border-radius: 3px;
            color: #696969;
            padding-left: 5px;
        }

        select {
            color: #696969;
            width: 100px;
            -webkit-appearance: none;
            -moz-appearance: none;
            appearance: none;
            padding: 5px;
            font-family: verdana;
            font-size: 16px;
            height: 30px;
            border-radius: 3px;
            background: #ffffff;
        }

        select.sel1 {
            color: #696969;
            -webkit-appearance: none;
            -moz-appearance: none;
            appearance: none;
            padding: 5px;
            width: 300px;
            font-family: verdana;
            font-size: 16px;
            height: 30px;
            border-radius: 4px;
            background: #ffffff;
        }

        table {
            margin-left: 100px;
            table-layout: fixed;
        }

        .head2 {
            font-size: 18px;
            margin-right: 20px;
            color: #FFFFFF;
            font-family: verdana;
            font-style: inherit;
        }

        .head3 {
            font-size: 17px;
            margin-right: 20px;
            color: #FFFFFF;
            font-family: verdana;
            font-style: inherit;
        }

        .link1 {
            text-decoration: none;
            background: #d3d3d3;
            border-radius: 3px;
            padding: 5px;
            color: white;
            font-weight: bold;
            font-size: 16px;
            font-family: verdana;
            margin-left: 30px;
            border: 1px solid gray;
        }

        tr.trspan1 td {
            padding-top: 20px;
        }

        td.span1 {
            word-wrap: break-word;
            max-width: 130px;
            vertical-align: top;
        }

        td.span2 {
            word-wrap: break-word;
            max-width: 200px;
            vertical-align: top;
        }

        input[type="submit"] {
            text-decoration: none;
            background: #48B33D;
            border-radius: 3px;
            padding: 5px;
            width: 100px;
            font-family: verdana;
            color: #FFFFFF;
            font-weight: bold;
            font-size: 18px;
            margin-left: 30px;
            border: 1px solid #48B33D;
            align-self: center;
        }
    </style>
</head>
<body><br>

<h2>Add Methods to Mindpulpy Console</h2><br>

<form action="#" method="post">
    <table>
        <tr>
            <td class="span2">
                <div class="head2">App Name :</div>
            </td>
            <td><input type="text" placeholder="Enter your app name" name="appName"></td>
        </tr>
        <tr>
        <tr class="trspan1">
            <td>
                <div class="head2">Base Url :</div>
            </td>
            <td><input type="text" placeholder="Enter your Base Url" name="baseUrl"></td>
        </tr>
        <tr class="trspan1">
            <td class="span2">
                <div class="head2">Import Swagger Documentation :</div>
            </td>
            <td><input type="file" name="doc"></td>
        </tr>
        <tr class="trspan1">
            <td class="span2">
                <div class="head2">Choose Your Authentication :</div>
            </td>
            <td><select name="authen" class="sel1">
                <option value="noauth">No Authentication</option>
                <option value="apikey">API key Authentication</option>
                <option value="basic">Basic Authentication</option>
            </select></td>
        </tr>
        <tr class="trspan1">
            <td class="span2">
                <div class="head2">Add Your Headers :</div>
            </td>
            <td><a class="link1" style="background: #48B33D;border-color:#48B33D " href="javascript:addParent()">Add
                Header</a>
                <a class="link1" style="background: #D11717;border-color:#D11717" href="javascript:removeParent()">Remove
                    Header</a></td>
        </tr>
        <tr class="trspan1">
            <td></td>
            <td>
                <div id="headcontent"></div>
            </td>
        </tr>
        <tr class="">
            <td class="span2">
                <div class="head2">Add Your Methods :</div>
            </td>
            <td><a class="link1" style="background: #48B33D;border-color:#48B33D " href="javascript:addmethod()">Add
                Method</a>
                <a class="link1" style="background: #D11717;border-color:#D11717" href="javascript:removemethod()">Remove
                    Method</a></td>
        </tr>
    </table>
    <br>

    <div id="content"></div>
    <br><br>
    <center><input type="submit" value="Save"></center>
</form>
</body>
</html>
