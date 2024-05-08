<%@page import="Bank.Model.Registor"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!List<Registor> lst;%>
	<%
	if (!session.isNew()) {
		lst = (List<Registor>) session.getAttribute("Reglst");
		Registor r = lst.get(0);
	%>
	<h3>
		Welcome
		<%=r.getCust_name()%></h3>
	<%
	}
	%>
	<a href="LoginView.jsp">Login</a>
</body>
</html>