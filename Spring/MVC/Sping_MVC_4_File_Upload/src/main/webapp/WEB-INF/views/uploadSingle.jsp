<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Spring 4 MVC Upload Single File</title>
</head>
<body>
	<form method="POST" action="uploadSingleFile"
		enctype="multipart/form-data">
		<br /> Choose File to Upload: 
			<input type="file" name="file">
			<br /> 
			<br /> 
			<br /> 
			<input type="submit" value="Upload"	style="margin-left: 140px;">
	</form>
</body>
</html>