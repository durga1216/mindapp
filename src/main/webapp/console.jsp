<%--
  Created by IntelliJ IDEA.
  User: susee
  Date: 14/5/15
  Time: 6:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Custom Console</title>
    <script src="js/jquery-latest.js"></script>
    <script>
        function show(){
            $(".apicont").slideToggle("slow");
        }
        $(document).ready(function () {
            $.ajax({
                url: 'https://mindapp-pulpy.rhcloud.com/rest/console/mp3',
                type: 'GET',
                success: function (data) {
                    //alert('Data: ' + data);
                    $('#content').append(data);
                    console.log(data);
                },
                error: function (request, error) {
                    alert("Request: " + JSON.stringify(request));
                }
            });
        });
    </script>
    <style>
        h2 {
            align-content: center;
            text-align: center;
        }
        .full{
            margin-left: 150px;
            margin-right: 150px;
        }
        .head {
            border: 1px solid #c3d9ec;
            background: #e7f0f7;
            border-radius: 3px;
            height: 30px;
        }

        .meth {
            background: #0066cc;
            color: white;
            border-radius: 3px;
            padding: 5px;
            text-align: center;
            width: 50px;
            border: 1px solid #0055cc;
            float: left;
        }

        .apname {
            padding: 5px;
            text-align: right;
            float: right;
            margin-right: 20px;
        }

        .path {
            float: left;
            padding: 5px;
            margin-left: 20px;
            height: 30px;
            color: blue;
        }

        .apicont {
            border: 1px solid #c3d9ec;
            background: #e7f0f7;
            border-radius: 3px;
            display: none;
            padding: 10px;
        }

        .head1 {
            margin-left: 20px;
            color: #0088cc;
        }

        table th {
            font-size: 15px;
            color: dimgrey;
            padding: .5em;
        }

        td {
            padding: .5em;
        }

        input[type="button"] {
            padding: 5px;
            background: #d3d3d3;
        }
    </style>
</head>
<body>
<br>
<h2>Sample Testing</h2>
<div class="full">
<div id="content"></div>
    <br>
<div class="head">
    <div class="meth">GET</div>
    <div class="path"><a id="path" href="javascript:show()">/name/susee</a></div>
    <div class="apname">Sample app desc</div>
</div>
<div class="apicont">
    <form action="#">
        <div class="head1">Header</div>
        <hr>
        <table style="padding: 10px;border-collapse: collapse;" border=1 frame=void rules=rows>
            <tr>
                <th>Header Label</th>
                <th>Input</th>
                <th>Example</th>
            </tr>
            <tr>
                <td>Content-type:</td>
                <td><input type="text" name="h1"></td>
                <td>application/json</td>
            </tr>
        </table>
        <br>

        <div class="head1">Parameter</div>
        <hr>
        <table style="padding: 10px;border-collapse: collapse;" border=1 frame=void rules=rows>
            <tr>
                <th>Parameter Label</th>
                <th>Value</th>
                <th>Example</th>
                <th>Description</th>
                <th>Data type</th>
            </tr>
            <tr>
                <td>location:</td>
                <td><input type="text" name="h1"></td>
                <td>chennai</td>
                <td>Enter location</td>
                <th>String</th>
            </tr>
        </table>
        <input type="button" name="sub" value="Try it Out">
    </form>
</div>
    </div>
</body>
</html>
