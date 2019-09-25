<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<form modelAttribute="user" action="registerProcess" method="post">
		
			<input type="text" name="userName" placeholder="User Name"><br>
			<input type="text" name="password"  placeholder="Password"><br>
			<input type="text" name="mailID"  placeholder="Email Id"><br>
			<input type="text" name="contactNumber"  placeholder="Contact Number"><br>
			<input type="submit"><br><br>
			<a href="login.jsp">Login</a>
		
		
		</form>


</body>
</html>