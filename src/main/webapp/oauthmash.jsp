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
    var intTextBox=0;
    function addmethod()
    {
      intTextBox = intTextBox + 1;
      var contentID = document.getElementById('content');
      var newTBDiv = document.createElement('div');
      newTBDiv.setAttribute('id','strText'+intTextBox);
      newTBDiv.innerHTML = "<table frame='box' style='padding: 15px;border-radius: 5px'><tr><td><div class='head3'>Method #"+intTextBox+"</div><br></td></tr><tr><td><select name='masmeth"+intTextBox+"'><option value='GET'>GET</option><option value='POST'>POST</option><option value='PUT'>PUT</option><option value='DELETE'>DELETE</option></select></td><td><input type='text' name='masurl"+intTextBox+"' placeholder='Method Url'><br></td></tr><tr><td class='span1'><br><div class='head3'>Add your parameters</div></td><td><br><textarea placeholder='Eg : filter=name&sortby=company' rows='6' cols='50' name='mastext"+intTextBox+"'></textarea></td></tr></table><br>";
      contentID.appendChild(newTBDiv);
    }

    function removemethod(){
      var contentID = document.getElementById('content');
      contentID.removeChild(document.getElementById('strText'+intTextBox));
      intTextBox = intTextBox-1;
    }
  </script>
  <style>
    h2{
      text-align: center;
    }
    input[type="text"]{
      width: 500px;
      height: 30px;
      font-family: verdana;
      font-size: 18px;
      background: #ffffff;
      border-radius: 3px;
      color: black;
      padding-left: 5px;
    }
    select{
      color: black;
      width: 100px;
      font-family: verdana;
      font-size: 16px;
      height: 30px;
      border-radius: 3px;
      background: #ffffff;
    }
    table{
      margin-left: 100px;
      table-layout: fixed;
    }
    .head2{
      font-size: 20px;
      margin-right: 20px;
      font-style: inherit;
    }
    .head3{
      font-size: 17px;
      margin-right: 20px;
      font-style: inherit;
    }
    .link1{
      text-decoration: none;
      background: #d3d3d3;
      border-radius: 3px;
      padding: 5px;
      color: black;
      margin-left: 30px;
      border: 1px solid gray;
    }
    td.span1{
      word-wrap:break-word;
      max-width: 130px;
      vertical-align: top;
    }
    input[type="submit"]{
      text-decoration: none;
      background: #d3d3d3;
      border-radius: 3px;
      padding: 10px;
      color: black;
      margin-left: 30px;
      border: 1px solid gray;
      align-self: center;
    }
  </style>
</head>
<body><br>
  <br><h2>Mashup of same Domain</h2>
<table><tr><td><div class="head2">Dynamically Add your Methods :</div></td>
<td><a class="link1" href="javascript:addmethod()">Add Method</a></td>
  <td><a class="link1" href="javascript:removemethod()">Remove Method</a></td></tr></table><br>
<form action="Oauthmash" method="post">
<div id="content"></div>
  <br><br><center><input type="submit" value="Continue"></center>
  </form>
</body>
</html>
