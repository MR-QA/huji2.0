<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Insert title here</title>
</head>
<body>
<form action="index/login" modelAttribute="user"  method="post">
	<label>�˺ţ�</label><input type="text" name ="userName"/><br>
	<label>���룺</label><input type="password" name="userPass"/><br>
	<input type="reset" value="����"/>
	<input type="submit" value="��¼">
	<a href="index/login">��¼�˺�</a><br>
	${errorMessage }<br>
</form>
</body>
</html>