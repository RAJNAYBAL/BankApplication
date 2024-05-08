<%@page import="Bank.Model.Registor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update</title>
<style type="text/css">
form {
	align-items: center;
}
</style>
</head>
<body>

<form action="UpdateData">
	<%!List<Registor> lst;%>

	<%
	if (!session.isNew()) {
		
		lst=(List<Registor>)session.getAttribute("updatelst");
		Registor r=lst.get(0);
		%>


	<input type="text" value=<%=r.getCust_name()%> name="nm"><br>
	<input type="email" value=<%=r.getMail()%>" name="email"><br>
	<input type="text" value=<%=r.getUser_name()%>" name="unm"><br>
	<input type="password" value=<%=r.getPassword()%>" name="pass"><br>
    <input type="submit" value="Update"> 

	<%	
	}
	%>
</form>

</body>
</html>