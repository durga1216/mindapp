<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mpulpy</title>
</head>
<script type="text/javascript">
function ff_activate(){
	window.location="http://fotoflexer.com/API/API_Loader_v1_01.php?ff_image_url=http://fotoflexer.com/samples/moon.jpg&ff_callback_url=http://fotoflexer.com/API/callbackTest.php&ff_cancel_url=http://fotoflexer.com&ff_lang=en-US";
}
</script>

<body>
<form onsubmit="return demo()">
<a href="javascript:void(0);" onclick="ff_activate();">Edit Image</a>
<input type="submit">
</form>
</body>
</html>
<?php

$image = $_GET['http://fotoflexer.com/samples/moon.jpg'];
copy($image,"/path/to/images/image.jpg");
?>